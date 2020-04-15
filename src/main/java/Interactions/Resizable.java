package Interactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		// resize text area 
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		method1(driver);
		driver.quit();
	}

	private static void method1(WebDriver driver) throws InterruptedException {
		WebElement corner_resize_icon = 
		driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		
		Actions action = new Actions(driver);
		//resize to big
		
		action.dragAndDropBy(corner_resize_icon, 50, 50).build().perform();
		action.sendKeys(Keys.ENTER);
	
		Thread.sleep(1000);
		
		action.dragAndDropBy(corner_resize_icon, -10, -10).build().perform();
		
	}

}
