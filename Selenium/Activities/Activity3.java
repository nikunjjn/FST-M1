import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	    
		WebDriver driver= new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		System.out.println("Title is :" +driver.getTitle());
		
		WebElement firstName=driver.findElement(By.id("firstName"));
		WebElement lastName=driver.findElement(By.id("lastName"));
		WebElement email=driver.findElement(By.id("email"));
		WebElement contactNumber=driver.findElement(By.id("number"));
		
		firstName.sendKeys("test");
		lastName.sendKeys("test");
		email.sendKeys("test1234@gmail.com");
		contactNumber.sendKeys("918909864");
		 driver.findElement(By.cssSelector(".ui.green.button")).click();
		driver.close();

	}

}
