


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;



public class Activity10_2 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");

    	 WebDriver driver = new FirefoxDriver();
         
    	 Actions actions = new Actions(driver);
         String pressedKeyText;
  
         driver.get("https://www.training-support.net/selenium/input-events");
         WebElement pressedKey = driver.findElement(By.id("keyPressed"));
   
         Action actionSequence1 = actions.sendKeys("S").build();
         actionSequence1.perform();
         pressedKeyText = pressedKey.getText();
         System.out.println("Pressed key is: " + pressedKeyText);
  
         Action actionSequence2 = actions
                 .keyDown(Keys.CONTROL)
                 .sendKeys("a")
                 .sendKeys("c")
                 .keyUp(Keys.CONTROL)
                 .build();
         actionSequence2.perform();
         pressedKeyText = pressedKey.getText();
         System.out.println("Pressed key is: " + pressedKeyText);
        //driver.quit();
    }
}