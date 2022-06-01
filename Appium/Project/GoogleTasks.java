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

public class GoogleTasks {

	AndroidDriver driver;
	
	
	@BeforeClass
	
	public void setup() throws MalformedURLException {
		
		//Desired Capabilities/Options
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UIAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
		options.noReset();
		
		//Server Url
		
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		
		//Driver Initialization
		
		driver = new AndroidDriver(serverURL, options);
		
		
	}
	
	@Test
	
	public void CalcTest() {
		
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        
        
    driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup")).isDisplayed();
    driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup")).isDisplayed();
    driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup")).isDisplayed();
	}
	
	@AfterClass
	
	public void close() {
		
		driver.quit();
	}
	
}
