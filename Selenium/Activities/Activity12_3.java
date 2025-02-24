


import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Activity12_3 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");

    	 WebDriver driver = new FirefoxDriver();
         
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         Actions builder = new Actions(driver);
        
         driver.get("https://www.training-support.net/selenium/popups");
         
         WebElement button = driver.findElement(By.xpath("//button[contains(@class, 'orange')]"));
         
         builder.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();
         String tooltipText = button.getAttribute("data-tooltip");
         System.out.println("Tooltip text: " + tooltipText);
        
         button.click();
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
         
         driver.findElement(By.id("username")).sendKeys("admin");
         driver.findElement(By.id("password")).sendKeys("password");
         driver.findElement(By.xpath("//button[text()='Log in']")).click();
         
         String message = driver.findElement(By.id("action-confirmation")).getText();
         System.out.println(message);
  
        driver.quit();
    }
}