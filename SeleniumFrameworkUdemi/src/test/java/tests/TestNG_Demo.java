package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class TestNG_Demo {
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
	}
	
	/*
	@Test
	public void basicFitOpen() {		
		
		driver.get("https://www.basic-fit.com/fr-fr/home");
		driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
		driver.findElement(By.linkText("S'inscrire")).click();
		
		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div[2]/div[3]/a[1]")).click();
		

		
	
	}
	
	*/
	
	@Test
	public void googleSearch() {		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		driver.get("http://google.com");
		searchPageObj.clickCookiesAcceptButton();
		searchPageObj.setTextInSearchbox("Morain Lake");
		searchPageObj.clickEnterKey();		
	}
	
	@Test
	public void openEbay() {		
		driver.get("http://ebay.com");	
	}
	
	@Test
	public void openYoutube() {
		driver.get("http://youtube.com");	
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	


}
