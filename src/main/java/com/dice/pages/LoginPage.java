package com.dice.pages;

import com.dice.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject<LoginPage> {
    private static final String URL = "https://www.dice.com/dashboard/login";

    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signInButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//span[@data-automation-id='login-failure-help-message']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        getPage(URL);
    }

    public void fillUpEmailAndPassword(String email, String password) {
        System.out.println("Filling up email and password");
        type(email, emailField);
        type(password,passwordField);

    }

    public ProfilePage pushSingInButton() {
        System.out.println("Clicking on Sign in Button");
        click(signInButton);
        return new ProfilePage(driver);
    }

    public String getLoginErrorMessage() {
        waitForVisibilityOf(errorMessage,10);
        return getText(errorMessage);
    }
}
