package com.yesmadam.automation.drivers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class AndroidDriverFactory {

    public AndroidDriver createAndroidDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 5");
        capabilities.setCapability("platformName", "Android");
        // Set additional capabilities
        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Android driver", e);
        }
    }
}
