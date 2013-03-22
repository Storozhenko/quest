package com.sam.quest;

import com.sam.quest.command.*;
import com.sam.quest.dbunit.AbstractDbunitTransactionalJUnit4SpringContextTests;
import com.sam.quest.dbunit.DbunitDataSets;
import com.sam.quest.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/testLogicApplicationContext.xml"})
public class CRUDTest extends AbstractDbunitTransactionalJUnit4SpringContextTests {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private Users user;

    @Test
    @Rollback(true)
    @DbunitDataSets(before = "BeforeDataSet.xml",
                    after = "AfterDataSet.xml")
    @DirtiesContext
    public void testInsert() {
        try {
            Users newuser = new Users();
            newuser.setUsername("newtest");
            newuser.setPassword("newtest");
            newuser.setUserType("ROLE_ADMIN");
            new InsertCommand(newuser).execute(hibernateTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Rollback(true)
    @DbunitDataSets(before = "BeforeDataSet.xml",
            after = "AfterDataSet.xml")
    @DirtiesContext
    public void testUpdate() {
        try {
            user.setUsername("newtest");
            user.setPassword("newtest");
            new UpdateCommand(user).execute(hibernateTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Rollback(true)
    @DbunitDataSets(before = "BeforeDataSet.xml",
            after = "AfterDataSet.xml")
    @DirtiesContext
    public void testRead() {
        try {
            Users newuser = new FindCommand<Users>(user.getUserId(), new Users()).execute(hibernateTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Rollback(true)
    @DbunitDataSets(before = "BeforeDataSet.xml",
            after = "AfterDataSet.xml")
    @DirtiesContext
    public void testDelete() {
        try {
            Users testuser = new FindCommand<Users>("from Users where username = 'test'").execute(hibernateTemplate);
            new DeleteCommand(testuser).execute(hibernateTemplate);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}