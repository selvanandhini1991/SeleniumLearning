package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*How to invoke browser without having binary files(.exe files) using webdrivermanager*/

public class WebDriverManagerInvoke {
	
	@Test
	public void invokechromeBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.quit();
	}
	
	@Test
	public void invokeFireFoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://app.hubspot.com/login");
		driver.quit();
		
	}
	
	@Test
	public void invokeIEDriver() {
		WebDriverManager.iedriver().setup();
		WebDriver driver =new InternetExplorerDriver();
		driver.get("https://app.hubspot.com/login");
	}
	
	@Test
	public void invokeEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://app.hubspot.com/login");
	}

}
