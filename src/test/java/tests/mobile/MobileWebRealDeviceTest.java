package tests.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class MobileWebRealDeviceTest {

    private AndroidDriver<MobileElement> driver;


    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = getDesiredCapabilities();

        // Initialize AndroidDriver and assign it to the class-level driver field
        driver = new AndroidDriver<MobileElement>(
                new URL("http://localhost:4723/"), caps);

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // Open the desired URL
        driver.get("https://www.yesmadam.com/delhi-at-home-services");
        // Hide the keyboard
        driver.hideKeyboard();
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        String chromeDriverPath = "/opt/homebrew/bin/chromedriver";

        // Set up Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability("chromedriverExecutable", chromeDriverPath);

        // Set Chrome options to open in incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        caps.setCapability(ChromeOptions.CAPABILITY, options);
        return caps;
    }


    @Test(priority = 0, enabled = true)
    public void testMainCat() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement mc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@text, 'Salon At Home')])[1]")));
        mc.click();

    }

    @Test(priority = 1, enabled = true)
    public void testSubCat() throws InterruptedException {
        WebElement sc = driver.findElement(By.xpath("(//*[@text=\"Weekday Offers\"])[1]"));
        sc.click();
        Thread.sleep(5000);
    }

    @Test(priority = 2, enabled = true)
    public void testAddToCart () throws InterruptedException {
        WebElement addToCart = driver.findElement(By.xpath("(//*[@text=\"ADD\"])[1]"));
        addToCart.click();
        Thread.sleep(5000);
    }

    @Test(priority = 3, enabled = true)
    public void testViewCart () throws InterruptedException {
        WebElement viewCart = driver.findElement(By.xpath("(//*[@text=\"VIEW CART\"])[1]"));
        viewCart.click();
        Thread.sleep(5000);
    }

    @Test(priority = 4, enabled = true)
    public void testLoginBtn () throws InterruptedException {
        WebElement loginBtn = driver.findElement(By.xpath("(//*[@text=\"LOGIN\"])[1]"));
        loginBtn.click();
        Thread.sleep(5000);
    }

    @Test(priority = 5, enabled = true)
    public void testMobileNoSet () throws InterruptedException {
        WebElement setMobNo = driver.findElement(By.xpath("(//*[@text=\"LOGIN\"])[1]"));
        setMobNo.sendKeys("9855566677");
        Thread.sleep(2000);
        WebElement loginBtn = driver.findElement(By.xpath("(//*[@text=\"CONTINUE\"])[1]"));
        loginBtn.click();
        Thread.sleep(2000);

        WebElement otpEnter = driver.findElement(By.xpath("//android.app.Dialog[@resource-id=\"radix-:r19:\"]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText"));
        otpEnter.sendKeys("2222");
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        try {
            // Wait for 10 seconds before closing the browser
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Bugs" + e);
        } finally {
            if (driver != null) {
                // driver.quit();
            }
        }
    }
}
