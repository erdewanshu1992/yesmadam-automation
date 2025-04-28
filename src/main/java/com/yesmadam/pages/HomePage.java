package com.yesmadam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Locators
    private By loginButton = By.id("loginBtn");
    private By searchBar = By.id("searchBox");

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Page-specific actions
    public void clickLoginButton() {
        click(loginButton);
    }

    public void search(String query) {
        sendKeys(searchBar, query);
    }
}

