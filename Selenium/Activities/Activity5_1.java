import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
 
        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());
 
        driver.findElement(By.id("toggleCheckbox")).click();
 
        System.out.println("The checkbox Input is displayed: " + checkboxInput.isDisplayed());
 
        driver.quit();
    }
}