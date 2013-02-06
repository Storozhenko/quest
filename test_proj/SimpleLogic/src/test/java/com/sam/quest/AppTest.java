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
        DAOFactory fact = new DAOFactory();
        HiberDAOFactory hibfact = fact.getFactory(1);
        UserDAO userdao = hibfact.getUserDAO();
        Users user = new Users();
        user.setUsername("test");
        user.setPassword("test");
        user.setType("user");
        user.setLang("eng");
        boolean res = userdao.insertUser();
        assertTrue(res);
    }
}
