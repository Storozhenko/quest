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
import org.dbmaintain.DbMaintainer;
import org.dbmaintain.MainFactory;
import org.dbmaintain.structure.clean.DBCleaner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/logicApplicationContext.xml"})
public class AppTest extends AbstractDbunitTransactionalJUnit4SpringContextTests {

    @Autowired
    TransactionalPerformer trPerformer;
    @Autowired
    Users user;

    protected static DbMaintainer dbMaintainer;
    protected static DBCleaner dbCleaner;
    protected static MainFactory dbMaintainMainFactory;


    protected void initDataBase() throws FileNotFoundException, URISyntaxException, IOException {
        createDBMaintainer().updateDatabase(false);
        //createDBCleaner().cleanDatabase();
    }

    private MainFactory createDBMaintainMainFactory() throws URISyntaxException, FileNotFoundException, IOException {
        if (dbMaintainMainFactory == null) {
            URI resource = ClassLoader.getSystemClassLoader().getResource("dbmaintain.test.properties").toURI();
            File file = new File(resource);
            Properties properties = new Properties();
            properties.load(new FileInputStream(file));
            dbMaintainMainFactory = new MainFactory(properties);
        }
        return dbMaintainMainFactory;
    }

    private DBCleaner createDBCleaner() throws FileNotFoundException, URISyntaxException, IOException {
        createDBMaintainMainFactory();
        dbCleaner = dbMaintainMainFactory.createDBCleaner();
        return dbCleaner;
    }

    private DbMaintainer createDBMaintainer() throws FileNotFoundException, URISyntaxException, IOException {
        createDBMaintainMainFactory();
        dbMaintainer = dbMaintainMainFactory.createDbMaintainer();
        return dbMaintainer;
    }


    @Test
    @Rollback(true)
    @DbunitDataSets(before = "BeforeDataSet.xml", after = "AfterDataSet.xml")
    @DirtiesContext
    public void testCRUD() {
        try {
            initDataBase();
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