package com.sam.quest;

import com.sam.quest.command.*;
import com.sam.quest.dbunit.AbstractDbunitTransactionalJUnit4SpringContextTests;
import com.sam.quest.dbunit.DbunitDataSets;
import com.sam.quest.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test/testLogicApplicationContext.xml"})
public class AppTest extends AbstractDbunitTransactionalJUnit4SpringContextTests {

    @Autowired
    TransactionalPerformer trPerformer;
    @Autowired
    Users user;


    @Test
    @Rollback(true)
    @DbunitDataSets(before = "test/BeforeDataSet.xml",
                    after = "test/AfterDataSet.xml")
    @DirtiesContext
    public void testCRUD() {
        try {
            trPerformer.executeCommand(new UpdateCommand(user));
            user = (Users)trPerformer.executeCommand(new FindCommand<Users>(1, new Users()));
            user = new Users();
            user.setUsername("newtest");
            user.setPassword("newtest");
            user.setUserType("ROLE_ADMIN");
            trPerformer.executeCommand(new InsertCommand(user));
            user = (Users)trPerformer.executeCommand(new FindCommand<Users>("from Users where username = 'newtest'"));
            trPerformer.executeCommand(new DeleteCommand(user));
            trPerformer.executeCommand(new InsertCommand(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}