package Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*How to invoke browser without having binary files(.exe files) using webdrivermanager*/

public class WebDriverManagerInvoke {

	@Test(enabled = true)
	public void invokechromeBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.get("https://app.hubspot.com/login");
//		driver.quit();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement un = driver.findElement(By.xpath("//input[@name='username']"));
		un.click();
		driver.switchTo().activeElement().sendKeys("snandhini2810");
	}

	@Test(enabled = true)
	public void invokeFireFoxDriver() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.instagram.com/");
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("snandhini2810");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement un = driver.findElement(By.xpath("//input[@name='username']"));
		un.click();
		driver.switchTo().activeElement().sendKeys("snandhini2810");
//		driver.quit();

	}

	@Test(enabled = false)
	public void invokeIEDriver() {
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://app.hubspot.com/login");
	}

	@Test(enabled = false)
	public void invokeEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://app.hubspot.com/login");
	}

}
