package au.com.dominos.orders.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlineOrderingPage  extends BaseOrdersPage{

	public OnlineOrderingPage(WebDriver driver) {
		super(driver);
	}

	public String getPageTitle() {
		return driver.findElement(By.id("page_title")).getText();
	}
	
	public DeliverDetailsPage clickOrderType(String orderType) {
		//quick deliver pickup
		driver.findElement(By.id(orderType)).click();
		return new DeliverDetailsPage(driver);
	}

}
