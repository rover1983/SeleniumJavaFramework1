package demo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluenWaitDemo {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		test();
	}
	
	
	public static void test() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Meo");
		
		
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)
		       .pollingEvery(5, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       WebElement linkElement= driver.findElement(By.linkText("Miclyn Express Offshore"));
		     if(linkElement.isEnabled()) {
		    	 System.out.println("Element found");
		    	 
		     }
		     return linkElement;
		     }
		   });
		   
		   foo.click();

		
		
		driver.close();
		driver.quit();
	}
	

}
