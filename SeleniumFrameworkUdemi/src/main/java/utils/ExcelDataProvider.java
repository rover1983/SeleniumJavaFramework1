package utils;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	WebDriver driver;
	String testURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test(dataProvider="test1Data")
	public void test1(String login, String password) {
		driver.get(testURL);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("username")).sendKeys(login);
		driver.findElement(By.name("password")).sendKeys(password);
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@DataProvider(name="test1Data")
	public static Object[][] getData () {
		
		String excelDocPath = "/excel/data.xlsx";		
		Object[][]data = testData(excelDocPath, "sheet1");
		return data;
	}
	
	public static Object[][] testData(String ExcelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(ExcelPath, sheetName);
		
		int numberOfRows = excel.getRowCount();
		int numberOfColumns = excel.getColumnCount();
		
		Object[][]excelDataStorage = new Object[numberOfRows-1][numberOfColumns];
		
		for(int i = 1; i < numberOfRows; i++) {			
			for(int j=0;j<numberOfColumns; j++) {
				
				String cellData = excel.getCellData(i, j);	
				excelDataStorage[i-1][j]=cellData;					
			}
		}	
		return excelDataStorage;
	}

}
