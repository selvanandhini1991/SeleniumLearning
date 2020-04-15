package Interactions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sortable {

	public static void main(String[] args) {
		// direct method for drag n drop for sortable
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/sortable/");
		WebElement container  = driver.findElement(By.id("sortable"));
		List<WebElement> list = container.findElements(By.tagName("li"));
		WebElement target = list.get(0);
		WebElement dest   = list.get(3);
		
		Actions action = new Actions(driver);
		
		//first click target and hold move to destination ,give move to offset and release
		
		/*********************************************/
		action.click(target)
			.clickAndHold()
			.moveToElement(dest).moveByOffset(0, 10)
			.release().build().perform();
		/*********************************************/
		
		//for more understanding refer 
		//https://www.vinsguru.com/selenium-webdriver-automating-custom-controls-jquery-sortable-elements/

	}

}
