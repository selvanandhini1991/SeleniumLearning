package ToolTip;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltips {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Scenario 1: Tooltip is implemented using the "title" attribute
		
		driver.get("http://demo.guru99.com/test/social-icon.html");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		
		List<WebElement> icons = driver.findElements(By.xpath("//div[@class='soc-ico show-round']/a"));
		String[] texts = {"Mail","Google+","YouTube","Github","Facebook","Rss"};
		for(WebElement e:icons) {
			action.moveToElement(e).build().perform();
			String expectedtxt ="";
			for(String str:texts) {
				if(e.getAttribute("title").equals(str)) {
					expectedtxt = str;
					Assert.assertEquals(e.getAttribute("title"), expectedtxt);
					//System.out.println("title "+ e.getAttribute("title") + " " + expectedtxt);
				}
			}	
		}
		
		//Scenario 2: JQuery Plugin
		
		driver.get("http://demo.guru99.com/test/tooltip.html");
		Thread.sleep(5000);
		WebElement download = driver.findElement(By.id("download_now"));
		String expectedlink = "What's new in 3.2";
		Actions builder = new Actions(driver);
		
		builder.clickAndHold().moveToElement(download);
		builder.moveToElement(download).build().perform();
		
		WebElement tooltip = driver.findElement(By.xpath("//div[@class='tooltip']/a"));
		String actualtext = tooltip.getText();
		System.out.println(actualtext);
		Assert.assertEquals(actualtext, expectedlink);
		
		driver.quit();
	}

}
