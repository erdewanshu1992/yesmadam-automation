package com.yesmadam.automation.tests;

import com.yesmadam.pages.HomePage;
import com.yesmadam.tests.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        super.setup(); // Initialize the driver and open the URL
        homePage = new HomePage(driver); // Initialize the page object
    }

    @Test
    public void testLoginButton() {
        homePage.clickLoginButton(); // Using the page object method
        // Additional assertions here
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}
