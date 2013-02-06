package com.sam.quest;

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
        user.setPassword("test");
        user.setUser_type("user");
        user.setUser_lang("eng");
        assertTrue(userdao.deleteUser(user));
    }
}
