package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {

	AndroidDriver driver=null;
	WebDriverWait wait;
	
	@BeforeClass
	
	public void setup() throws MalformedURLException {
		
		//Desired Capabilities/Options
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UIAutomator2");
		options.setAppPackage("com.samsung.android.messaging");
		options.setAppActivity("com.android.mms.ui.ConversationComposer");
		options.noReset();
		
		//Server Url
		
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		
		//Driver Initialization
		
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test
	
	public void ContactTest() {
		
		
       wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Compose new message")));
 
        driver.findElement(AppiumBy.accessibilityId("Compose new message")).click();
 
       wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.messaging:id/composer_title")));
 
        WebElement Name = driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/recipients_editor_to"));
        Name.sendKeys("9999999999");
        driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/message_edit_text")).click();
        WebElement message = driver.findElement(AppiumBy.id("com.samsung.android.messaging:id/message_edit_text"));
        message.sendKeys("Hello from Appium");
 
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='SIM card 1 Send']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("android:id/parentPanel")));
        driver.findElement(AppiumBy.id("android:id/button2")).click();
 
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Hello from Appium']")));
 
        WebElement mobileCard = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Hello from Appium']"));
        Assert.assertTrue(mobileCard.isDisplayed());
    }
		
	
	
	@AfterClass
	
	public void close() {
		
		driver.quit();
	}
	
}
