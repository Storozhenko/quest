package com.sam.quest.dbunit;

import org.dbmaintain.DbMaintainer;
import org.dbmaintain.MainFactory;
import org.dbmaintain.structure.clean.DBCleaner;
import org.dbunit.Assertion;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.transaction.AfterTransaction;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@TestExecutionListeners(
        AbstractDbunitTransactionalJUnit4SpringContextTests.DbunitTestExecutionListener.class)
public abstract class AbstractDbunitTransactionalJUnit4SpringContextTests
        extends AbstractTransactionalJUnit4SpringContextTests {

    /** DBUnit tester */
    private IDatabaseTester databaseTester;
    private String afterDatasetFileName;

    @AfterTransaction
    public void assertAfterTransaction() throws Exception {
        if (databaseTester == null || afterDatasetFileName == null) {
            return;
        }
        IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
        IDataSet expectedDataSet =
                new XmlDataSet(ClassLoader.getSystemResourceAsStream(afterDatasetFileName));
        Assertion.assertEquals(expectedDataSet, databaseDataSet);
        databaseTester.onTearDown();
    }
    /** Listener */
    static class DbunitTestExecutionListener extends AbstractTestExecutionListener {

        protected static DbMaintainer dbMaintainer;
        protected static DBCleaner dbCleaner;
        protected static MainFactory dbMaintainMainFactory;

        protected void initDataBase() throws FileNotFoundException, URISyntaxException, IOException {
            createDBMaintainer().updateDatabase(false);
            createDBCleaner().cleanDatabase();
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

        public void beforeTestMethod(TestContext testContext) throws Exception {
            //dbMaintainer performs scripts
            initDataBase();
            AbstractDbunitTransactionalJUnit4SpringContextTests testInstance = (AbstractDbunitTransactionalJUnit4SpringContextTests) testContext.getTestInstance();
            Method method = testContext.getTestMethod();
            DbunitDataSets annotation = method.getAnnotation(DbunitDataSets.class);
            if (annotation == null) {
                return;
            }
            DataSource dataSource = testContext.getApplicationContext().getBean(DataSource.class);
            IDatabaseTester databaseTester = new DataSourceDatabaseTester(dataSource);
            databaseTester.setDataSet(
                    new XmlDataSet(ClassLoader.getSystemResourceAsStream(annotation.before())));
            databaseTester.setSetUpOperation(DatabaseOperation.INSERT);
            databaseTester.setTearDownOperation(DatabaseOperation.NONE);
            databaseTester.onSetup();
            testInstance.databaseTester = databaseTester;
            testInstance.afterDatasetFileName = annotation.after();
        }
    }
}