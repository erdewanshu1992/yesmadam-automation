package com.yesmadam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Common action: click
    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    // Common action: send keys
    public void sendKeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    // Common action: get text
    public String getText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    // Common wait for element visible
    public void waitForElementToBeVisible(By locator, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

