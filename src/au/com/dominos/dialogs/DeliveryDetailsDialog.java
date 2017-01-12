package au.com.dominos.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.dominos.orders.pages.DeliverySearchResultsPage;

public class DeliveryDetailsDialog {

	private WebDriver driver;
	private WebElement element;
	
	public DeliveryDetailsDialog(WebDriver driver) {
		this.driver = driver;
		element = driver.findElement(By.className("modal-content"));
	}

	public DeliverySearchResultsPage clickNoButton() {
		element.findElement(By.id("no-button")).click();
		return new DeliverySearchResultsPage(driver);
	}
}
