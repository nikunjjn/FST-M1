

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity7_1 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");

    	 WebDriver driver = new FirefoxDriver();
         
         //Open browser
         driver.get("https://training-support.net/selenium/dynamic-attributes");
     
         WebElement userName = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
         WebElement password = driver.findElement(By.xpath("//input[contains(@class, 'password')]"));
  
         userName.sendKeys("admin");
         password.sendKeys("password");
  
         driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
 
         String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
         System.out.println("Login message: " + loginMessage);
        driver.quit();
    }
}