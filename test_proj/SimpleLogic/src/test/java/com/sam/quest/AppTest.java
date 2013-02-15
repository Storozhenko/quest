package com.sam.quest;

import com.sam.quest.dao.factory.*;
import com.sam.quest.dao.hibernate.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.sam.quest.dao.*;
import com.sam.quest.entity.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AppTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( AppTest.class );
    }

    public void testApp() throws Exception {
        DAOFactory jdbcForm = new JDBCDAOFormFactory();
        DAOFactory jdbcUser = new JDBCDAOUserFactory();
        DAOFactory hib = new HiberDAOFactory();

        MultiDAO<Users> userdao = jdbcUser.getDAO();
        MultiDAO<Users> userhib = hib.getDAO();
        MultiDAO<Forms> formdao = jdbcForm.getDAO();
        MultiDAO<Forms> formhib = hib.getDAO();
        MultiDAO<AnswForms> answhib = hib.getDAO();

        Users user = new Users();
        user.setUsername("test");
        user.setPassword("test");
        user.setUserType("admin");
        user.setUserLang("eng");
        user.setUserId(new Long(1));

        assertTrue(userdao.updateRecord(user));
        //user.setUsername("admin");
        //user.setPassword("test");
        //assertTrue(userhib.insertUser(user));

        user = userhib.findRecord(1, new Users());
        Date date = new Date(System.currentTimeMillis());
        Forms form = new Forms();
        form.setFormName("form");
        form.setUserId(user);
        form.setFormDate(date);
        form.setFormId(new Long(1));
        assertTrue(formdao.updateRecord(form));

        TransactionalPerformer fms = new TransactionalPerformer<Forms>();
        fms.executeCommand(new UpdateCommand<Forms>(form));
        TransactionalPerformer fm = new TransactionalPerformer<List <Forms>>();
        form = formdao.findRecord(1, new Forms());
        assertTrue(formhib.updateRecord(form));
        List <Forms> list  = (ArrayList<Forms>)fm.executeCommand(new GetListCommand<ArrayList<Forms>>(new ArrayList<Forms>(), new Forms()));

        Timestamp time = new Timestamp(System.currentTimeMillis());
        AnswForms answ = new AnswForms();
        answ.setFormId(form);
        answ.setUserId(user);
        answ.setAnswDatetime(time);
        assertTrue(answhib.insertRecord(answ));
    }
}
