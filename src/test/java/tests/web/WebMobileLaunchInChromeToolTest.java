package tests.web;

import base.BaseTest;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class WebMobileLaunchInChromeToolTest extends BaseTest {

    @Test
    public void launchChromeWithMobileEmulation() {
        // This test assumes:
        //   platform=web
        //   browser=chrome_devtool_mobile
        //   deviceName set in config.properties

        String deviceName = ConfigReader.getProperty("deviceName");
        System.out.println("▶️ Launching Chrome in mobile-emulation mode for: " + deviceName);

        // BaseTest.setup() will have already:
        //  • called DriverFactory.initWebDriver("chrome_devtool_mobile")
        //  • passed in the deviceName via ChromeOptions
        //  • navigated to the URL from config.properties

        // Verify we’re on the right page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("yesmadam.com"),
                "Expected to be on YesMadam site");

        // Print out the emulated window size
        Dimension size = driver.manage().window().getSize();
        System.out.println("Emulated viewport size: "
                + size.getWidth() + "×" + size.getHeight());

        // (Optional) you could assert on size if you know expected dimensions:
        // Assert.assertEquals(size.getWidth(), 430);
        // Assert.assertEquals(size.getHeight(), 932);
    }
}














//package tests.web;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//import java.util.Map;
//
//public class WebMobileLaunchInChromeToolTest {
//    public static void main(String[] args) {
//        System.out.println("Browser Options");
//        WebDriverManager.chromedriver().setup();
//
//        ChromeOptions options = new ChromeOptions ();
//        options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone 14 Pro Max"));
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().setSize(new Dimension(430, 932));
//        driver.navigate().to("https://www.yesmadam.com/delhi-at-home-services");
//
//        // driver.quit();
//        System.out.println("Browser is closed..");
//    }
//}
