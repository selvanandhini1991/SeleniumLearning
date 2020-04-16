package WindowsHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

/*switching to iframess in 3 ways 1. by name/id , 2. webelement and 3 by index*/

public class IFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),'IFrame practice page')]")).click();
		Thread.sleep(5000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("no of frames in the page "+ size);
		
		//switch to frame1 by id
		//driver.switchTo().frame("IF1");
		//switch using  webelement
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='IF1']")));
		System.out.println("after frame switching");
		Thread.sleep(2000);
		//sibling
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//(By.xpath("//li[contains(class,'menu-item-21576 first')]/ancestor::ul[@class='sub-nav level-arrows-on']/following-sibling::li"));
		System.out.println("Links count in frame 1 is "+ links.size());
		
		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='sidebar']")).isDisplayed(), true);
		
		//switch to frame 2 by name
		driver.switchTo().frame("iframe2");
		Assert.assertEquals(driver.findElement(By.id("logo-events")).isDisplayed(), true);
		
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[contains(text(),'Automation practice form')]")).click();
		Thread.sleep(1000);
		
		driver.quit();

	}

}
