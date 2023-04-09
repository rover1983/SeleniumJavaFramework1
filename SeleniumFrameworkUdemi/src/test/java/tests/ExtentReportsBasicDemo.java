package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtentReportsBasicDemo {
	
	ExtentReports extentReports;
	ExtentSparkReporter  sparkReporter;
	ExtentTest test;
	
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		sparkReporter = new ExtentSparkReporter("extentReports.html"); 
		
		// Create report and attach reporter to it
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
	}
	
	@BeforeMethod
	public void config() {
		//DesiredCapabilities desiredCap = new DesiredCapabilities();
		//desiredCap.setCapability("ignoreProtectedModeSettings", true);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void googleSearchWithExtRep() {
		// Creates a toggle for the given test, adds all log events under it
		test = extentReports.createTest("Google search test", "Test to validate google search");
		
		driver.get("http://google.com");
		test.log(Status.INFO, "This step demonstrates usage of log(status, details)");
		test.info("This step demonstrates usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@Test
	public void googleSearchWithExtRepoprt() {
		// Creates a toggle for the given test, adds all log events under it
		test = extentReports.createTest("Google search test", "Test to validate google search");
		
		test.log(Status.INFO, "This step demonstrates usage of log(status, details)");
		test.info("This step demonstrates usage of info(details)");
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@AfterSuite
	public void trr() {
		extentReports.flush();
	}
		
		
		
		
	
}



























