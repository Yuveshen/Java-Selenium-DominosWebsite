package au.com.dominos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseHomePage {

	protected WebDriver driver;
	private WebDriverWait wait;
	
	public BaseHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public OurMenuPage clickOurMenuLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Menu"))).click();
		return new OurMenuPage(driver);
	}
	
	public StoreFinderPage clickStoreFinder() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("StoreFinder"))).click();
		return new StoreFinderPage(driver);
	}
}
