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

public class Activity4 {

	AndroidDriver driver=null;
	WebDriverWait wait;
	
	@BeforeClass
	
	public void setup() throws MalformedURLException {
		
		//Desired Capabilities/Options
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UIAutomator2");
		options.setAppPackage("com.samsung.android.app.contacts");
		options.setAppActivity("com.samsung.android.contacts.contactslist.PeopleActivity");
		options.noReset();
		
		//Server Url
		
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		
		//Driver Initialization
		
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		
	}
	
	@Test
	
	public void ContactTest() {
		
		
       wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Create contact")));
 
        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();
 
       wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.samsung.android.app.contacts:id/nameEdit")));
 
        WebElement Name = driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/nameEdit"));
        Name.sendKeys("Test");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Phone']")).click();
        WebElement phoneNumber = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']"));
        phoneNumber.sendKeys("9999999999");
 
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Save']")).click();
 
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.samsung.android.app.contacts:id/card_container")));
 
        WebElement mobileCard = driver.findElement(AppiumBy.id("com.samsung.android.app.contacts:id/card_container"));
        Assert.assertTrue(mobileCard.isDisplayed());
 
        String contactName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Test']")).getText();
        Assert.assertEquals(contactName, "Test");
    }
		
	
	
	@AfterClass
	
	public void close() {
		
		driver.quit();
	}
	
}
