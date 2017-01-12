package au.com.dominos.orders.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliverySearchResultsPage extends BaseOrdersPage {

	public DeliverySearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getAddress(String address) throws Exception{
		address = address.toUpperCase();
		List<WebElement> addressList = driver.findElements(By.cssSelector(".search-results #search-items"));
		for (WebElement addressSearch : addressList) {
			if (addressSearch.getText().contains(address)) {
				return addressSearch;
			}
		}
		throw new Exception("Address not found in search results");	
	}
	
	public OrderTimePage clickAddressButton(String address) throws Exception {
		getAddress(address).click();
		return new OrderTimePage(driver);
	}
}
