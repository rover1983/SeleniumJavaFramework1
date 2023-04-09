package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	private static WebDriver driver;
	
	public static void main(String[]args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get("http://google.com");
		
		GoogleSearchPage.popup_cookies(driver).click();
		GoogleSearchPage.textbook_search(driver).sendKeys("G-wagon");
		GoogleSearchPage.textbook_search(driver).sendKeys(Keys.RETURN);
		
		
		
	}

}
