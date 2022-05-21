import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1  {

    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");

        
        WebDriver driver = new FirefoxDriver();

        
        driver.get("https://www.training-support.net");

        String title = driver.getTitle();
  
        System.out.println("Page title is: " + title);

      
        driver.findElement(By.xpath("/html/body/div/div/div/a")).click();

        
        System.out.println("Heading is: " + driver.getTitle());

      
        driver.quit();

    }

}