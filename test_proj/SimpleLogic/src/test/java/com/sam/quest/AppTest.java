package com.sam.quest;

import com.sam.quest.command.TransactionalPerformer;
import com.sam.quest.command.UpdateCommand;
import com.sam.quest.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
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
public class AppTest {

    @Autowired
    TransactionalPerformer trPerformer;

    @Test
    public void testCRUD() {
        Users user = new Users();
        user.setUsername("test");
        user.setPassword("test");
        user.setUserType("ROLE_ADMIN");
        user.setUserLang("eng");
        user.setUserId(new Long(1));
        try {
            trPerformer.executeCommand(new UpdateCommand(user));
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void testLogin() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/quest/");
        WebElement element = driver.findElement(By.ById.id("loginLink"));
        element.click();
        element = driver.findElement(By.ById.id("j_username"));
        element.sendKeys("test");
        element = driver.findElement(By.ById.id("j_password"));
        element.sendKeys("test");
        element = driver.findElement(By.ById.id("loginOK"));
        element.click();
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }

}