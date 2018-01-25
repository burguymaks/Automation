package com.dice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void methodSetUp() {
        System.out.println("Method set up");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void methodTearDown() {
        System.out.println("Method tear down");
        driver.quit();
    }
}
