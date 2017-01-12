package au.com.dominos.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddSidesOfferDialog {
	
	public WebDriver driver;
	private WebElement element;
	
	public AddSidesOfferDialog(WebDriver driver) {
		this.driver = driver;
		element = driver.findElement(By.className("offer-products"));
	}

	public void clickNoThanksButton() {
		element.findElement(By.className("at-not")).click();
	}

}
