package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {

WebDriver driver;

    
    @BeforeMethod
    public void beforeMethod() {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	    
        driver = new FirefoxDriver();
    
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void urlHeader() {

        WebElement image =driver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']"));
     
        System.out.println("Header Image url is: " + image.getAttribute("src"));
   
    }

    @AfterMethod
    public void afterMethod() {
     
        driver.quit();
    }

	
}
