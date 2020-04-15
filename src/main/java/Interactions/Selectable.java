package Interactions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	/*There are 7 items in selectable container
	 * Store all items in map with element : class
	 * Now iterate with no of items in for eac loop, select one by one element
	 * 	inside for each, extract class before and after click the item and compared it
	 * 	Yet to write -- check other than iterated element no element class is displayed with selected*/
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
	}
	@Test
	public void selectable() {
		
		List<WebElement> list = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		for(WebElement e:list) {
			String bfclick = e.getAttribute("class");
			Assert.assertEquals(bfclick, "ui-widget-content ui-selectee");
			e.click();
			Assert.assertNotEquals(e.getAttribute("class"), bfclick);
			
			
		}
	}
	
	@AfterTest
	public void TearDown() {
		driver.close();
		driver.quit();
	}
}
