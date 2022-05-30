package Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {

	AndroidDriver driver;
	
	
	@BeforeClass
	
	public void setup() throws MalformedURLException {
		
		//Desired Capabilities/Options
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UIAutomator2");
		options.setAppPackage("com.sec.android.app.popupcalculator");
		options.setAppActivity(".Calculator");
		options.noReset();
		
		//Server Url
		
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		
		//Driver Initialization
		
		driver = new AndroidDriver(serverURL, options);
		
		
	}
	
	@Test
	
	public void CalcTest() {
		
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.accessibilityId("Plus")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_02")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_09")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Equal']")).click();

        String result = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        System.out.println(result);

        Assert.assertEquals(result, "40");
		
	}
	
	@AfterClass
	
	public void close() {
		
		driver.quit();
	}
	
}
