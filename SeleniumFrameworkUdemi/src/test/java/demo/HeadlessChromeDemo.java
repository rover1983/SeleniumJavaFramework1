package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDemo {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		WebDriverManager.firefoxdriver().setup();
		
		FirefoxOptions chromeOptions = new FirefoxOptions();
        chromeOptions.addArguments("--headless");
        
        WebDriver driver = new FirefoxDriver(chromeOptions);
	
		driver.get("http://youtube.com"); 
		String title = driver.getTitle();
		
		System.out.println("The title of the tab is: "+title);
		
	}

}
