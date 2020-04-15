package WindowsHandling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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

public class SwitchWindows {
	public static WebDriver driver;
	
	@BeforeTest
	public static void DriverSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//aside[2]//ul[1]//li[1]//a[1]")).click();//go to "Automation Practice Switch Windows" link
		
	}
	
	@Test(enabled=false)
	public static void newWindow() throws InterruptedException {
		WebElement browserWindows = driver.findElement(By.xpath("//strong[contains(text(),'Browser Windows')]"));
		Assert.assertEquals(browserWindows.isDisplayed(), true);
		
		WebElement newWindowEle = driver.findElement(By.xpath("//button[@id='button1' or contains(text(),'New Browser Window')]"));
		
		
		//windows handling
		//1.open 3 windows
		for(int i=1;i<=2;i++) {
			newWindowEle.click();
			Thread.sleep(5000);
		}
		
		//2.Now along with parent window there are 2 more child windows
		String parentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		
		
		//3.1 swtich to particular window
		String[] array = allwindows.toArray(new String[allwindows.size()]);
		driver.switchTo().window(array[1]);
		driver.get("https://www.javacodeexamples.com/java-switch-quiz-online-test");
		driver.switchTo().window(array[0]);
		driver.get("https://www.google.com/");
		
		driver.switchTo().defaultContent();
		
		//3.2 curr	ent focus window is parent, switch focus to child window
		Iterator<String> itr = allwindows.iterator();
		while(itr.hasNext()) {
			String childwindow = itr.next();
			
			if(!parentWindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				System.out.println(driver.switchTo().window(childwindow).getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		
	}
	
	@Test(enabled=false)
	public static void WindowMessage() throws InterruptedException {
		WebElement windowMessage = driver.findElement(By.xpath("//button[contains(text(),'New Message Window')]"));
		String parentWindow = driver.getWindowHandle();
		windowMessage.click();
		Thread.sleep(3000);
		Set<String> handles = driver.getWindowHandles();
		
		System.out.println(handles);
		
		for(String handle:driver.getWindowHandles()) {
			if(!parentWindow.equals(handle)) {
				driver.switchTo().window(handle);
//				String text =driver.findElement(By.xpath("/html[1]/body[1]")).getText();
//				System.out.println(text);
				driver.close();	

			}
			
		}
		driver.switchTo().window(parentWindow);
		//driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
				
	}
	
	@Test(enabled=false)
	public static void newWindowTab() throws InterruptedException {
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[contains(text(),'New Browser Tab')]")).click();
		Thread.sleep(2000);
		
		//ctrl + tab to go to next tab right
		//ctrl + shift + tab go to next tab left
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    WebElement container = driver.findElement(By.xpath("//div[@class='wpb_column vc_column_container vc_col-sm-12']"));
	    List<WebElement> courses = container.findElements(By.xpath("//div[contains(@class,'wpb_wrapper')]//h2/span"));
	    for(WebElement ele:courses) {
	    	System.out.println(ele.getText());
	    }
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	    System.out.println(driver.getTitle());
	}
	
	@Test
	public static void AlertBox() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='alert']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	@AfterTest
	public static void TearDown() {
		driver.quit();
	}

}
