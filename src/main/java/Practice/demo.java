package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {
	public static String componentname = "rose";

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://localhost:4502/aem/start.html");
//		System.out.println(driver.getTitle());

//	}
	
	@BeforeTest
	public void beforemethod() {
		System.out.println("AM inside before" +componentname);
	}
	
	@AfterTest
	public void teardown() {
		System.out.println("am inside teardown "+ componentname);
	}

}
