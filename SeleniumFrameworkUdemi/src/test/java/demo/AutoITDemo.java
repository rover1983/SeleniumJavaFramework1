package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		testAutoITFileUpload();
	}
	
	public static void testAutoITFileUpload() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");
		String title = driver.getTitle().toString();
		System.out.println("Title is: "+title+".");
		
		Thread.sleep(4000);		
	   
	    // When an input is not clickable
	    Actions builder = new Actions(driver);
	    builder.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().build().perform();
	    
	    // Use AutoIT compiled file to upload a file from PC	    
		try {			
			Runtime.getRuntime().exec("C:\\Users\\User\\Documents\\FileUploadScript.exe");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Test Successfuly ended");		
	}
}
