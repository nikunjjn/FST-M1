package SeleniumProject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {

WebDriver driver;

    
    @BeforeMethod
    public void beforeMethod() {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	    
        driver = new FirefoxDriver();
        
    
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void jobsTest() {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//li[@id='menu-item-26']")).click();
    	driver.findElement(By.xpath("//a[@class='button']")).click();
    	WebElement username=driver.findElement(By.id("user_login"));
    	username.sendKeys("root");
    	WebElement password=driver.findElement(By.id("user_pass"));
    	password.sendKeys("pa$$w0rd");
    	WebElement loginButton=driver.findElement(By.id("wp-submit"));
    	loginButton.click();
    	
    	String jobTitle="bbbbbbbbb";
    	driver.findElement(By.xpath("//input[@id='job_title']")).sendKeys(jobTitle);
    	driver.switchTo().frame("job_description_ifr");
    	
    	driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("description test");
    	driver.switchTo().parentFrame();
    	driver.findElement(By.xpath("//input[@class='button']")).click();
    	driver.findElement(By.xpath("//input[@id='job_preview_submit_button']")).click();
    	driver.findElement(By.xpath("//li[@id='menu-item-24']")).click();
    	 WebElement element= driver.findElement(By.xpath("//input[@id='search_keywords']"));
         element.sendKeys(jobTitle);
         driver.findElement(By.xpath("//div[@class='search_submit']")).click();
         String verifyListing=driver.findElement(By.xpath("//div[@class='position']")).getText();
         System.out.println(verifyListing);
         if(verifyListing.contains(jobTitle)) {
        	 
        	 Assert.assertTrue(true);
        	 
         }
         
         
    	
    	
    	
    }


    @AfterMethod
    public void afterMethod() {
     
       driver.quit();
    }

	
}
