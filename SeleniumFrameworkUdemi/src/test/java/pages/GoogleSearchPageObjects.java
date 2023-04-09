package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver;
	
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	By textbox_search = By.name("q");
	By popup_cookies = By.id("L2AGLb");
	By button_search = By.name("btnK");
	
	public void clickCookiesAcceptButton() {
		driver.findElement(popup_cookies).click();
	}
	
	public void setTextInSearchbox(String searchText) {
		driver.findElement(textbox_search).sendKeys(searchText);
	}
	
	public void clickEnterKey() {
		driver.findElement(textbox_search).sendKeys(Keys.ENTER);
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).click();
	}

}
