package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initWebDriver(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();

        } else if (browser.equalsIgnoreCase("mobile_chrome")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "Pixel 5");
            caps.setCapability("platformName", "Android");
            caps.setCapability("browserName", "Chrome");
            return new RemoteWebDriver(new URL("http://localhost:4723/"), caps);

        } else if (browser.equalsIgnoreCase("chrome_devtool_mobile")) {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone 14 Pro Max"));
            return new ChromeDriver(options);

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static WebDriver initAndroidDriver() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("deviceName", "Pixel 5");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appPackage", "yesmadamservices.app.com.yesmadamservices");
        cap.setCapability("appActivity", "yesmadamservices.app.com.yesmadamservices.MainActivity");
        cap.setCapability("noReset", true);

        return new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), cap);
    }
}













//package base;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class DriverFactory {
//
//    public static WebDriver initWebDriver(String browser) throws MalformedURLException {
//        if (browser.equalsIgnoreCase("chrome")) {
//            return new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("mobile_chrome")) {
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("deviceName", "Pixel 5");
//            caps.setCapability("platformName", "Android");
//            caps.setCapability("browserName", "Chrome");
//            return new RemoteWebDriver(new URL("http://localhost:4723/"), caps);
//        } else {
//            throw new IllegalArgumentException("Unsupported browser: " + browser);
//        }
//    }
//
//    public static WebDriver initAndroidDriver() throws MalformedURLException {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("automationName", "UiAutomator2");
//        cap.setCapability("deviceName", "Pixel 5");
//        cap.setCapability("platformName", "Android");
//        cap.setCapability("appPackage", "yesmadamservices.app.com.yesmadamservices");
//        cap.setCapability("appActivity", "yesmadamservices.app.com.yesmadamservices.MainActivity");
//        cap.setCapability("noReset", true);
//
//        return new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), cap);
//    }
//}



















//package base;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Reporter;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//
//public class DriverFactory {
//    public WebDriver driver;
//
//    @BeforeTest
//    public void installationSetUpForNativeApp() throws MalformedURLException, InterruptedException {
//
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("automationName","UiAutomator2");
//        cap.setCapability("appPackage", "yesmadamservices.app.com.yesmadamservices");
//        cap.setCapability("appActivity", "yesmadamservices.app.com.yesmadamservices.MainActivity");
//        cap.setCapability("noReset", true);
//
//        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"),cap);
//        System.out.println("\u001B[33m Customer App is open now =>>: Good luck Dewanshu....👍😍🧚‍♀️ \u001B[0m");
//        Reporter.log("Customer App is now open:");
//        System.out.println("Tests are starting!");
//        Thread.sleep(2000);
//
//    }
//
//    @AfterClass
//    public void teardown() {
//
//        System.out.println("Tests are ending!");
//    }
//
//}
