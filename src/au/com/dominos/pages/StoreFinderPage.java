package au.com.dominos.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StoreFinderPage extends BaseHomePage {

	public StoreFinderPage(WebDriver driver) {
		super(driver);
	}

	public void setPostcode(String postcode) {
		driver.findElement(By.id("SearchCriteria")).sendKeys(postcode);
	}

	public List<WebElement> getSearchResults() {
		List<WebElement> elements = driver.findElements(By.className("store-information"));
		return elements;
	}

	public void clickSearchButton() {
		driver.findElement(By.className("search")).click();	
	}

	public String getTextNoResultsFound() {
		return driver.findElement(By.id("no-search-results")).getText();
	}
}
