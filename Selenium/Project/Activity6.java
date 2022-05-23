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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity6 {

WebDriver driver;

    
    @BeforeMethod
    public void beforeMethod() {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	    
        driver = new FirefoxDriver();
        
    
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void jobsTest() {
    	
    	driver.findElement(By.xpath("//li[@id='menu-item-24']")).click();
        WebElement element= driver.findElement(By.xpath("//input[@id='search_keywords']"));
        element.sendKeys("Banking");
        element.sendKeys(Keys.TAB);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement listing = driver.findElement(By.xpath("//span[contains(text(),'Search completed')]"));
        listing.isDisplayed();
        driver.findElement(By.xpath("//ul[@class='job_listings']")).isDisplayed();
        driver.findElement(By.xpath("//ul[@class='job_listings']/li[2]")).click();
        driver.findElement(By.xpath("//input[@class='application_button button']")).click();
       String email= driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
       System.out.println("Email is :" +email);
    }


    @AfterMethod
    public void afterMethod() {
     
       driver.quit();
    }

	
}
