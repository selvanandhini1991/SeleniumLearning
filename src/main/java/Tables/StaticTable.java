package Tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-table/");
		driver.manage().window().maximize();
		
		WebElement Table = driver.findElement(By.xpath("//div[@class='demo-frame']/table"));
		if(Table.isDisplayed()) {
		int Cols = driver.findElements(By.xpath("//div[@class='demo-frame']/table//tbody/tr")).size();
		int rows = driver.findElements(By.xpath("//div[@class='demo-frame']/table//tbody/tr[1]/td")).size();
		
		System.out.println(" Columns "+ Cols+ "\n Rows "+ rows);
		}
		
		//print second row td and second row 3rd column value
		WebElement SecondRowThread = driver.findElement(By.xpath("//div[@class='demo-frame']/table//tbody/tr[2]/th"));
		System.out.println("Second row thread : "+ SecondRowThread.getText());
		WebElement ThirdCellValue = driver.findElement(By.xpath("//div[@class='demo-frame']/table//tbody/tr[2]/td[3]"));
		System.out.println("Second row thrid cell value "+ ThirdCellValue.getText());
		driver.quit();
	}

}
