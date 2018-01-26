package com.dice;

import com.dice.base.BaseTest;
import com.dice.base.CsvDataProvider;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedPageTitle = "Seeker Dashboard - Profile";
        String correctProfileName  = "Danis Dandis";

        // Open dice login page https://www.dice.com/dashboard/login
        loginPage.openLoginPage();

        // Fillup email and password
        loginPage.fillUpEmailAndPassword("dand6381@gmail.com","qwertye6");

        // push Sign in button and wait for profile page to load
        ProfilePage profilePage = loginPage.pushSingInButton();
        profilePage.waitForProfilePageToLoad();

        // Verifiaction
        // - Verify title page correct - Create Profile
        System.out.println("Verifications");
        String actualTitle = profilePage.getTitle();
        Assert.assertTrue(expectedPageTitle.equals(actualTitle), "Page Title is not expected.\nExpected: " + expectedPageTitle + "\nActual:" + actualTitle + ".");

        // - Verify correct load page
        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName),"Profile name is not expected.");


    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void negativeLoginTest(Map<String, String> testData) {
        String expectedErrorMessage = "Email and/or password incorrect.";
        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        System.out.println("Test No #" + testNumber + " for " + description + " Where\nEmail: " + email + "\nPassword: " + password);

        LoginPage loginPage = new LoginPage(driver);

        // Open dice login page https://www.dice.com/dashboard/login
        loginPage.openLoginPage();

        // Fillup email and password
        loginPage.fillUpEmailAndPassword(email,password);

        // push Sign in button and wait for profile page to load
        loginPage.pushSingInButton();

        String errorMessage = loginPage.getLoginErrorMessage();

        Assert.assertTrue(errorMessage.contains(expectedErrorMessage), "Error message in not expected:" + expectedErrorMessage + "\nActual:" + errorMessage + ".");
    }


}
