


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;



public class Activity11_2 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");

    	 WebDriver driver = new FirefoxDriver();
         
    	 driver.get("https://www.training-support.net/selenium/javascript-alerts");
  
         driver.findElement(By.cssSelector("button#confirm")).click();
  
         Alert confirmAlert = driver.switchTo().alert();
  
         String alertText = confirmAlert.getText();
         System.out.println("Alert text is: " + alertText);
  
         confirmAlert.accept();
  
      
        driver.quit();
    }
}