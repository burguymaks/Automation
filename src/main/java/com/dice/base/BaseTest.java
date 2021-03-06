package com.dice.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters ({ "browser" })
    @BeforeMethod
    public void methodSetUp(String browser) {
        System.out.println("Method set up");
        driver = BrowserFactory.getDriver(browser);

    }

    @AfterMethod
    public void methodTearDown() {
        System.out.println("Method tear down");
        driver.quit();
    }
}
