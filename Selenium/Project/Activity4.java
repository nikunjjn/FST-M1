package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {

WebDriver driver;

    
    @BeforeMethod
    public void beforeMethod() {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	    
        driver = new FirefoxDriver();
    
        driver.get("https://alchemy.hguy.co/jobs");
    }

    @Test
    public void headingTest() {
  
        String secondHeading = driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]")).getText();
        String expectedHeading = "Quia quis non";
     
        System.out.println("Page second heading is: " + secondHeading);
           
      Assert.assertEquals(expectedHeading, secondHeading);
      
      if(secondHeading.equals(expectedHeading)) {
    	  
    	  driver.quit();
      }
   
    }

  

	
}
