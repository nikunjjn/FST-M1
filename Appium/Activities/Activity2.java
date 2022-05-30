package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

	AndroidDriver driver=null;
	WebDriverWait wait;
	
	@BeforeClass
	
	public void setup() throws MalformedURLException {
		
		//Desired Capabilities/Options
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UIAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		//Server Url
		
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		
		//Driver Initialization
		
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
	}
	
	@Test
	
	public void ChromeTest() {
		
        driver.get("https://www.training-support.net/");
        
       String heading= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();
       System.out.println("Heading is :" +heading);
       driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='About Us']")).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")));
       String headingSecond= driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
       System.out.println("Second Heading is :" +headingSecond);
       
		
	}
	
	@AfterClass
	
	public void close() {
		
		driver.quit();
	}
	
}
