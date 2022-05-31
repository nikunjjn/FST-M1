package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

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

public class Activity6 {

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
	
	public void ChromeTest() throws InterruptedException {
		
        driver.get("https://www.training-support.net/selenium/lazy-loading");
        Thread.sleep(5000);
        
        WebElement pageLoaded = driver.findElement(AppiumBy.className("android.widget.TextView"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Lazy Loading']")));
        List<WebElement> numberOfImages = driver.findElements(AppiumBy.xpath("//android.view.View/android.view.View/android.widget.Image"));
        System.out.println("Number of image shown currently: " + numberOfImages.size());
 
        Assert.assertEquals(numberOfImages.size(), 3);
        driver.findElement(AppiumBy.androidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));

        numberOfImages = driver.findElements(AppiumBy.xpath("//android.view.View/android.view.View/android.widget.Image"));
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        Assert.assertEquals(numberOfImages.size(), 3);
       
		
	}
	
	@AfterClass
	
	public void close() {
		
		driver.quit();
	}
	
}
