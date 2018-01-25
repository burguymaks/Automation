package com.dice;

import com.dice.base.BaseTest;
import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        // Open dice login page https://www.dice.com/dashboard/login
        loginPage.openLoginPage();

        // Fillup email and password
        loginPage.fillUpEmailAndPassword("dand6381@gmail.com","qwertye6");

        // push Sign in button and wait for profile page to load
        ProfilePage profilePage = loginPage.pushSingInButton();
        profilePage.waitForProfilePageToLoad();

        // Verifiaction
        // - Verify title page correct - Create Profile
        // - Verify correct load page


    }



}
