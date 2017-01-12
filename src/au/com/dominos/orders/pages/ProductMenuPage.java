package au.com.dominos.orders.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.dominos.dialogs.AddSidesOfferDialog;

public class ProductMenuPage extends BaseOrdersPage{

	public ProductMenuPage(WebDriver driver) {
		super(driver);
	}

	public AddSidesOfferDialog clickMenuLink(String menuLink) {
		WebElement element = driver.findElement(By.id("order-navigation"));
		element.findElement(By.id("Menu"+menuLink)).click();
		return new AddSidesOfferDialog(driver);
	}

	public String getCartTotal() {		
		WebElement cartElement = driver.findElement(By.className("basket"));
		return cartElement.findElement(By.className("total-amount")).getText().replace("$", "");
	}
}
