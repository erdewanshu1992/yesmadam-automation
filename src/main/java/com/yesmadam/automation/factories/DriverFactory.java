package com.yesmadam.automation.factories;

import com.yesmadam.automation.drivers.ChromeDriverFactory;
import com.yesmadam.automation.drivers.AndroidDriverFactory;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver initWebDriver(String platform, String browser) {
        if ("web".equalsIgnoreCase(platform)) {
            if ("chrome".equalsIgnoreCase(browser)) {
                return new ChromeDriverFactory().createChromeDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } else if ("mobile".equalsIgnoreCase(platform)) {
            return new AndroidDriverFactory().createAndroidDriver();
        } else {
            throw new RuntimeException("Unsupported platform: " + platform);
        }
    }
}
