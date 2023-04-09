package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		WebDriver driver =  new ChromeDriver();
		
		//driver.get("http://seleniumhq.org");
		
		driver.get("http://google.com");
		driver.findElement(By.id("L2AGLb")).click();
		
		
		
		driver.close();
	}
}
