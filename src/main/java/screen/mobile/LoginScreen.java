package screen.mobile;

import actions.IScreenActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginScreen implements IScreenActions {
    private final WebDriver driver;

    @FindBy(xpath ="//*[@resource-id=\"mobileNumber\"]") private WebElement mobileElement;

    @FindBy(xpath = "//*[@text=\"Continue\"]") private WebElement continueBtn;

    @FindBy(xpath = "(//android.widget.FrameLayout[@resource-id='android:id/content']//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]//android.view.ViewGroup/android.widget.EditText)") private WebElement otpElement;



    public LoginScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Override
    public void login(String phoneNumber, String otp) {
        if (phoneNumber == null || otp == null || phoneNumber.isEmpty() || otp.isEmpty()) {
            System.out.println("Invalid data: Missing phone number or OTP");
            return;
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
            mobileElement.sendKeys(phoneNumber);

            wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();

            // Instead of sending OTP directly to one field, use the proper method:
            enterOTP(otp);

            System.out.println("LoggedIn");

        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
            Assert.fail("Login failed: " + e.getMessage());
        }
    }



    public void enterOTP(String otp) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        // Step 1: Wait for the first OTP input and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.EditText)[1]"))).click();
        Thread.sleep(500);  // Small delay to make sure the field is ready

        // Step 2: Hide the keyboard (if necessary)
        try {
            ((AndroidDriver<?>) driver).hideKeyboard();
            System.out.println("Keyboard hidden successfully after clicking first input.");
        } catch (Exception e) {
            System.out.println("Keyboard already hidden or not open.");
        }

        Thread.sleep(800); // Allow time for the screen to stabilize

        // Step 3: Enter OTP digits one by one
        char[] otpDigits = otp.toCharArray();
        for (int i = 0; i < otpDigits.length; i++) {
            try {
                // Wait for each OTP input field to be clickable and interact with it
                WebElement otpInputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                        "(//android.widget.FrameLayout[@resource-id='android:id/content']//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]//android.view.ViewGroup/android.widget.EditText)[" + (i + 1) + "]"
                )));
                otpInputField.click();
                Thread.sleep(300);  // Small delay before entering the next digit
                otpInputField.sendKeys(String.valueOf(otpDigits[i]));
                System.out.println("Entering OTP digit: " + otpDigits[i]);
                Thread.sleep(300);  // Small delay after entering a digit
            } catch (StaleElementReferenceException stale) {
                // If the element becomes stale, retry finding it
                System.out.println("Retrying due to stale element at index: " + i);
                WebElement otpInputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                        "(//android.widget.FrameLayout[@resource-id='android:id/content']//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]//android.view.ViewGroup/android.widget.EditText)[" + (i + 1) + "]"
                )));
                otpInputField.click();
                Thread.sleep(300);
                otpInputField.sendKeys(String.valueOf(otpDigits[i]));
            }
        }
    }




}
