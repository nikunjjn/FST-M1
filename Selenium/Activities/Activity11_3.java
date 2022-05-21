


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;



public class Activity11_3 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");

    	 WebDriver driver = new FirefoxDriver();
         
    	 driver.get("https://www.training-support.net/selenium/javascript-alerts");
    
         System.out.println("Page title is: " + driver.getTitle());
  
         driver.findElement(By.cssSelector("button#prompt")).click();
  
         Alert promptAlert = driver.switchTo().alert();
  
         String alertText = promptAlert.getText();
         System.out.println("Alert text is: " + alertText);
  
         promptAlert.sendKeys("Awesome!");
 
         promptAlert.accept();
      
        driver.quit();
    }
}