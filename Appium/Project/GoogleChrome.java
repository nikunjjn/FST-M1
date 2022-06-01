package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class GoogleChrome {

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
	
	@SuppressWarnings("deprecation")
	@Test
	
	public void ChromeTest() throws InterruptedException {
		try {
        driver.get("https://www.training-support.net/selenium");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"To-Do List\").instance(0))";
        driver.findElement(AppiumBy.androidUIAutomator(scrollElement)).click();


        driver.findElement(AppiumBy.xpath("//android.view.View/android.view.View/android.widget.EditText")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View/android.view.View/android.widget.EditText")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View/android.view.View/android.widget.EditText")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View/android.view.View/android.view.View[3]/android.widget.TextView[2]")).click();
		}
        catch(Exception e) {
        Assert.fail();
         System.out.println("Test case is failed");
        }
		
	}
	
	@AfterClass
	
	public void close() {
		
		driver.quit();
	}
	
}
