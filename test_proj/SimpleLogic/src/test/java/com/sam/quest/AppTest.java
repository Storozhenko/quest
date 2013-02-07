package com.sam.quest;

import com.sam.quest.dao.factory.DAOFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.sam.quest.dao.*;
import com.sam.quest.entity.*;
import java.util.Date;

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
        UserDAO userdao = jdbcFact.getUserDAO();
        UserDAO userhib = hibFact.getUserDAO();
        FormDAO formdao = jdbcFact.getFormDAO();
        FormDAO formhib = hibFact.getFormDAO();

        Users user = new Users();
        user.setUsername("test");
        user.setPassword("new");
        user.setUserType("admin");
        user.setUserLang("eng");
        user.setUserId(new Long(1));
        assertTrue(userdao.updateUser(user));

        user.setUsername("admin");
        user.setPassword("test");
        assertTrue(userhib.insertUser(user));

        user = userhib.findUser(1);
        Date date = new Date(System.currentTimeMillis());
        Forms form = new Forms();
        form.setFormName("form");
        form.setUserId(user);
        form.setFormDate(date);
        form.setFormId(new Long(1));
        assertTrue(formdao.updateForm(form));

        form = formdao.findForm(1);
        assertTrue(formhib.updateForm(form));
    }
}
