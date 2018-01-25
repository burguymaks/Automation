package com.dice.pages;

import com.dice.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject<ProfilePage> {
    private By editProfileButton = By.xpath("//div[@class='fileUpload btn btn-primary btn-lg']");
    private By advancedSearchButton = By.xpath("//div[@id='switch-view-wrapper']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void waitForProfilePageToLoad() {
        waitForVisibilityOf(editProfileButton);
        waitForVisibilityOf(advancedSearchButton, 10);

    }
}
