package Driver;

/*Traditional method for invoking the browsers*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Method1 {
	
	@Test(enabled=true)
	public void invokeChromeBrowser() {
		
		//get current working directory
		System.out.println(System.getProperty("user.dir"));
		//C:\Users\s.subramaniam\eclipse-workspace\SeleniumFunctions
		
		// System Property for browser
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		
		 // Instantiate a ChromeDriver class.       
	    WebDriver driver=new ChromeDriver(); 
	    
	    //launch browser
	    driver.navigate().to("http://www.javatpoint.com/");
	    
	  //Maximize the browser  
        driver.manage().window().maximize(); 
        
        //implicit wait
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        //get title
        System.out.println(driver.getTitle());
        
        driver.quit();
	}
	
	@Test(enabled=true)
	public void invokeFireFoxBrowser() {
		System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.javatpoint.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test(enabled=false)
	public void invokeIEBrowser() {
		System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.javatpoint.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	
}
