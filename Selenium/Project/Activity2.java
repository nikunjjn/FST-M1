package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

WebDriver driver;

    
    @BeforeMethod
    public void beforeMethod() {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	    
        driver = new FirefoxDriver();
    
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void headingTest() {
  
        String heading = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
        String expectedHeading = "Welcome to Alchemy Jobs";
     
        System.out.println("Page heading is: " + heading);
           
      Assert.assertEquals(expectedHeading, heading);
      
      if(heading.equals(expectedHeading)) {
    	  
    	  driver.quit();
      }
   
    }

  

	
}
