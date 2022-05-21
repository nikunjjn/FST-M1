import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        
        driver.get("https://www.training-support.net/selenium/simple-form");

        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));

        firstName.sendKeys("Nikunj");
        lastName.sendKeys("Jain");

        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("test123@example.com");

        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("1234567890");

        driver.findElement(By.xpath("//textarea")).sendKeys("This is my message");

        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();
    }
}