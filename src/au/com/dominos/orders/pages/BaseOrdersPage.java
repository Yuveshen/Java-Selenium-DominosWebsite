package au.com.dominos.orders.pages;

import org.openqa.selenium.WebDriver;

public abstract class BaseOrdersPage {

	protected WebDriver driver;
	
	public BaseOrdersPage(WebDriver driver) {
		this.driver = driver;
	}
}
