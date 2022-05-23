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

public class Activity9 {

WebDriver driver;

    
    @BeforeMethod
    public void beforeMethod() {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	    
        driver = new FirefoxDriver();
        
    
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test
    public void loginTest() {
    	
    	WebElement username=driver.findElement(By.id("user_login"));
    	username.sendKeys("root");
    	WebElement password=driver.findElement(By.id("user_pass"));
    	password.sendKeys("pa$$w0rd");
    	WebElement loginButton=driver.findElement(By.id("wp-submit"));
    	loginButton.click();
       String title= driver.getTitle();
       System.out.println("Title is :" +title);
        Assert.assertEquals("Dashboard ‹ Alchemy Jobs — WordPress", title);
        driver.findElement(By.xpath("//*[@id='menu-posts-job_listing']/a/div[3]")).click();
        driver.findElement(By.xpath("//*[@class='page-title-action']")).click();
        driver.findElement(By.id("post-title-0")).sendKeys("TESTPOSITION");
        driver.findElement(By.xpath("//*[@id='editor']/div/div/div[1]/div/div[1]/div/div[2]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id='editor']/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
        //Published
        driver.findElement(By.xpath("//*[@id='editor']/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div")).isDisplayed();
        
    }


    @AfterMethod
    public void afterMethod() {
     
      driver.quit();
    }

	
}
