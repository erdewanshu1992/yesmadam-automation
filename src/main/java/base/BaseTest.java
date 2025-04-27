package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.net.MalformedURLException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        String platform = ConfigReader.getProperty("platform");  // 'web' or 'mobile'
        String browser = ConfigReader.getProperty("browser");

        if (platform.equalsIgnoreCase("web")) {
            driver = DriverFactory.initWebDriver(browser);
            String url = ConfigReader.getProperty("url");
            if (url != null && !url.isEmpty()) {
                driver.get(url);
            } else {
                throw new RuntimeException("URL missing in config.properties");
            }
        } else if (platform.equalsIgnoreCase("mobile")) {
            driver = DriverFactory.initAndroidDriver();
            System.out.println("Good luck Dewanshu....👍😍🧚‍♀️");
        } else {
            throw new RuntimeException("Unsupported platform: " + platform);
        }

        System.out.println("Tests are starting!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Tests are ending!");
        }
    }
}














//package base;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import utils.ConfigReader;
//
//import java.net.MalformedURLException;
//
//public class BaseTest {
//
//    protected WebDriver driver;
//
//    @BeforeMethod
//    public void setup() throws MalformedURLException {
//        String platform = ConfigReader.getProperty("platform");  // 'web' or 'mobile'
//        String browser = ConfigReader.getProperty("browser");
//
//        if (platform.equalsIgnoreCase("web")) {
//            driver = DriverFactory.initWebDriver(browser);
//            String url = ConfigReader.getProperty("url");
//            if (url != null && !url.isEmpty()) {
//                driver.get(url);
//            } else {
//                throw new RuntimeException("URL missing in config.properties");
//            }
//        } else if (platform.equalsIgnoreCase("mobile")) {
//            driver = DriverFactory.initAndroidDriver();
//            System.out.println("\u001B[33m Customer App is open now =>>: Good luck Dewanshu....👍😍🧚‍♀️ \u001B[0m");
//        } else {
//            throw new RuntimeException("Unsupported platform: " + platform);
//        }
//
//        System.out.println("Tests are starting!");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            System.out.println("Tests are ending!");
//        }
//    }
//}
