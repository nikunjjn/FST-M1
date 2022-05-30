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

public class Activity3 {

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
	
	public void CalculatorTest() {
		//5+9
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.accessibilityId("Plus")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_09")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Equal']")).click();
        String result1 = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        System.out.println(result1);
        Assert.assertEquals(result1, "14");
        
        //10-5
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.accessibilityId("Minus")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Equal']")).click();
        String result2 = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        System.out.println(result2);
        Assert.assertEquals(result2, "5");
        
        //5*100
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.accessibilityId("Multiplication")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_01")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Equal']")).click();
        String result3 = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        System.out.println(result3);
        Assert.assertEquals(result3, "500");
        
        
        
       //50/2
        driver.findElement(AppiumBy.id("calc_keypad_btn_05")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_00")).click();
        driver.findElement(AppiumBy.accessibilityId("Division")).click();
        driver.findElement(AppiumBy.id("calc_keypad_btn_02")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Equal']")).click();
        String result4 = driver.findElement(AppiumBy.id("calc_edt_formula")).getText();
        System.out.println(result4);
        Assert.assertEquals(result4, "25");
	}
	
	@AfterClass
	
	public void close() {
		
		driver.quit();
	}
	
}
