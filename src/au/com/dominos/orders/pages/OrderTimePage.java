package au.com.dominos.orders.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import au.com.dominos.dialogs.TodaysOnlineDealsDialog;

public class OrderTimePage extends BaseOrdersPage{

	public OrderTimePage(WebDriver driver) {
		super(driver);
	}

	public TodaysOnlineDealsDialog clickAsapButton() {
		driver.findElement(By.id("asap")).click();
		return new TodaysOnlineDealsDialog(driver);
	}
	
	public TodaysOnlineDealsDialog clickNextButon() {
		driver.findElement(By.id("start-order-button")).click();
		return new TodaysOnlineDealsDialog(driver);
	}

	public boolean getIsStoreCurrentlClosed() {
		if (driver.findElements(By.className("closed-text")).size() != 0) { 
			return true;
		}else	
			return false; 
	}

	public void setOrderTime(String orderTime) {
		driver.findElement(By.name("orderTime")).sendKeys(orderTime);	
	}


}
