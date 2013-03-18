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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/testLogicApplicationContext.xml"})
public class AppTest extends AbstractDbunitTransactionalJUnit4SpringContextTests {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private Users user;

    @Test
    @Rollback(true)
    @DbunitDataSets(before = "BeforeDataSet.xml",
                    after = "AfterDataSet.xml")
    @DirtiesContext
    public void testCRUD() {
        try {
            new UpdateCommand(user).execute(hibernateTemplate);
            user = new FindCommand<Users>(1, new Users()).execute(hibernateTemplate);
            user = new Users();
            user.setUsername("newtest");
            user.setPassword("newtest");
            user.setUserType("ROLE_ADMIN");
            new InsertCommand(user).execute(hibernateTemplate);
            user = new FindCommand<Users>("from Users where username = 'newtest'").execute(hibernateTemplate);
            new DeleteCommand(user).execute(hibernateTemplate);
            new InsertCommand(user).execute(hibernateTemplate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}