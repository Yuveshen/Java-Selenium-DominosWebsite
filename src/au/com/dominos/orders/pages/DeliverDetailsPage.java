package au.com.dominos.orders.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import au.com.dominos.dialogs.DeliveryDetailsDialog;

public class DeliverDetailsPage extends BaseOrdersPage {

	public DeliverDetailsPage(WebDriver driver) {
		super(driver);
	}

	public void setName(String name) {
		driver.findElement(By.id("customer-name")).sendKeys(name);
	}

	public void setPhone(String phone) {
		driver.findElement(By.id("customer-phone")).sendKeys(phone);
	}
	
	public void setEmail(String email) {
		driver.findElement(By.id("customer-email")).sendKeys(email);
	}
	
	public void setUnit(String unit) {
		driver.findElement(By.id("customer-unit-no")).sendKeys(unit);
	}
	
	public void setStreetNumber(String streetNumber) {
		driver.findElement(By.id("customer-street-no")).sendKeys(streetNumber);
	}
	
	public void setStreet(String street) {
		driver.findElement(By.id("customer-street-name")).sendKeys(street);
	}
	
	public void setSuburb(String suburb) {
		driver.findElement(By.id("customer-suburb")).sendKeys(suburb);
	}
	
	public void setPostcode(String postcode) {
		driver.findElement(By.id("customer-postcode")).sendKeys(postcode);
	}

	public void setDeliveryInstructions(String deliveryInstructions) {
		driver.findElement(By.id("customer-delivery-instructions-input")).sendKeys(deliveryInstructions);
	}
	
	public void setDeliveryDetails(String name, String phone, String email, String unit, String streetNumber, String street, String suburb, String postcode, String deliveryInstructions) {
		setName(name);
		setPhone(phone);
		setEmail(email);
		setUnit(unit);
		setStreetNumber(streetNumber);
		setStreet(street);
		setSuburb(suburb);
		setPostcode(postcode);
		setDeliveryInstructions(deliveryInstructions);
	}

	public DeliveryDetailsDialog clickNextButton() {
		driver.findElement(By.id("order-time-button")).click();
		return new DeliveryDetailsDialog(driver);
	}

}
