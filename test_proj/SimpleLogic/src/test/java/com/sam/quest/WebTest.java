package com.sam.quest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTest {

    @Test
    public void testLogin() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "proxy.sam-solutions.net");
        profile.setPreference("network.proxy.http_port", 8080);
        profile.setPreference("network.proxy.no_proxies_on", "sc0181");
        WebDriver driver = new FirefoxDriver(profile);
        driver.get("http://sc0181:8080/quest/");
        WebElement element = driver.findElement(By.ById.id("j_username"));
        element.sendKeys("test");
        element = driver.findElement(By.ById.id("j_password"));
        element.sendKeys("test");
        element = driver.findElement(By.ById.id("loginSubmit"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().equals("quest");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}