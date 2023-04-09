package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitsDemo {	
	
	public static void seleniumWaits() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		//  Wait for entire session
		  
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		// Wait for specific web element
		 
		WebDriverWait wdWait = new WebDriverWait(driver, 5);
		WebElement element = wdWait.until(ExpectedConditions.elementToBeClickable(By.name("submit")));
		element.click();
		
	}

}
