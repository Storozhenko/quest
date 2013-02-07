package com.sam.quest;

import com.sam.quest.dao.factory.DAOFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.sam.quest.dao.*;
import com.sam.quest.entity.*;
import java.util.Date;
import java.sql.Timestamp;

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

    public void testApp() {
        DAOFactory jdbcFact = DAOFactory.getFactory(DAOFactory.JDBC);
        DAOFactory hibFact = DAOFactory.getFactory(DAOFactory.HIBERNATE);

        MultiDAO<Users> userdao = jdbcFact.getUserDAO();
        MultiDAO<Users> userhib = hibFact.getMultiDAO();
        MultiDAO<Forms> formdao = jdbcFact.getFormDAO();
        MultiDAO<Forms> formhib = hibFact.getFormDAO();
        MultiDAO<AnswForms> answhib = hibFact.getMultiDAO();

        Users user = new Users();
        user.setUsername("test");
        user.setPassword("new");
        user.setUserType("admin");
        user.setUserLang("eng");
        user.setUserId(new Long(1));
        assertTrue(userdao.updateRecord(user));

        user.setUsername("admin");
        user.setPassword("test");
        //assertTrue(userhib.insertUser(user));

        user = userhib.findRecord(1, new Users());
        Date date = new Date(System.currentTimeMillis());
        Forms form = new Forms();
        form.setFormName("form");
        form.setUserId(user);
        form.setFormDate(date);
        form.setFormId(new Long(1));
        assertTrue(formdao.updateRecord(form));

        form = formdao.findRecord(1, new Forms());
        assertTrue(formhib.updateRecord(form));

        Timestamp time = new Timestamp(System.currentTimeMillis());
        AnswForms answ = new AnswForms();
        answ.setFormId(form);
        answ.setUserId(user);
        answ.setAnswDatetime(time);
        assertTrue(answhib.insertRecord(answ));
    }
}
