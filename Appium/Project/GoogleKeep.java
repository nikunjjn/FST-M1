package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class GoogleKeep {

	AndroidDriver driver;
	
	
	@BeforeClass
	
	public void setup() throws MalformedURLException {
		
		//Desired Capabilities/Options
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UIAutomator2");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();
		
		//Server Url
		
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		
		//Driver Initialization
		
		driver = new AndroidDriver(serverURL, options);
		
		
	}
	
	@Test
	
	public void CalcTest() {
		
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Note']")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Title']")).sendKeys("Description Google Keep");
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
       
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Keep']")).isDisplayed();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Description Google Keep']")).isDisplayed();
        
	}
	
	@AfterClass
	
	public void close() {
		
		driver.quit();
	}
	
}
