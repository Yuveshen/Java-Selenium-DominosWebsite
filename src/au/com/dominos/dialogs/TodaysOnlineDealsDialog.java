
package au.com.dominos.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import au.com.dominos.orders.pages.ProductMenuPage;

public class TodaysOnlineDealsDialog {

	protected WebDriver driver;
	WebElement element;
	
	public TodaysOnlineDealsDialog(WebDriver driver) {
		this.driver = driver;
		element = driver.findElement(By.cssSelector(".voucher-selection .modal-content"));
	}
	
	public ProductMenuPage clickNoThanksButton() {
		element.findElement(By.className("close")).click();
		return new ProductMenuPage(driver);
	}
}
