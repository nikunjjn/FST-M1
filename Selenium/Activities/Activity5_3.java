import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://training-support.net/selenium/dynamic-controls");
  
        WebElement textInput = driver.findElement(By.xpath("//input[@type='text']"));
 
        System.out.println("The checkbox is selected: " + textInput.isEnabled());
 
        driver.findElement(By.id("toggleInput")).click();
 
        System.out.println("The checkbox is selected: " + textInput.isEnabled());
 
        driver.quit();
    }
}