package com.sam.quest;

import com.sam.quest.dao.factory.DAOFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.sam.quest.dao.*;
import com.sam.quest.entity.*;

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
        UserDAO userdao = jdbcFact.getUserDAO();
        Users user = new Users();
        user.setUsername("test");
        user.setPassword("new");
        user.setUserType("admin");
        user.setUserLang("eng");
        assertTrue(userdao.updateUser(user));
    }
}
