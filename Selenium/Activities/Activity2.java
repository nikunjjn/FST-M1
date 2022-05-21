import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
	
	public static void main(String []args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\0032GZ744\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	    
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.training-support.net");
		System.out.println("Title is :" +driver.getTitle());
		
		WebElement idLocator=driver.findElement(By.id("about-link"));
		System.out.println("Text :" +idLocator.getText());
		WebElement classNameLocator=driver.findElement(By.className("green"));
		System.out.println("Text :" +classNameLocator.getText());
		WebElement linkTextLocator=driver.findElement(By.linkText("About Us"));
		System.out.println("Text :" +linkTextLocator.getText());
		WebElement cssSelectorLocator=driver.findElement(By.cssSelector(".green"));
		System.out.println("Text :" +cssSelectorLocator.getText());
		driver.close();
		
	}

}
