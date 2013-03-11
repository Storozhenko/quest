package com.sam.quest;

import com.sam.quest.command.*;
import com.sam.quest.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/logicApplicationContext.xml"})
public class AppTest extends AbstractDbunitTransactionalJUnit4SpringContextTests {

    @Autowired
    TransactionalPerformer trPerformer;

    @Test
    @Rollback(true)
    @DbunitDataSets(before = "BeforeDataSet.xml", after = "AfterDataSet.xml")
    @DirtiesContext
    public void testCRUD() {
        Users user = new Users();
        user.setUsername("test");
        user.setPassword("test");
        user.setUserType("ROLE_ADMIN");
        user.setUserLang("en");
        user.setUserId(new Long(1));
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
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void testLogin() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "proxy.sam-solutions.net");
        profile.setPreference("network.proxy.http_port", 8080);
        profile.setPreference("network.proxy.no_proxies_on", "sc0181");
        WebDriver driver = new FirefoxDriver(profile);
        driver.get("http://sc0181:8080/quest/");
        WebElement element = driver.findElement(By.ById.id("loginLink"));
        element.click();
        element = driver.findElement(By.ById.id("j_username"));
        element.sendKeys("test");
        element = driver.findElement(By.ById.id("j_password"));
        element.sendKeys("test");
        element = driver.findElement(By.ById.id("loginSubmit"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().equals("quest");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

}