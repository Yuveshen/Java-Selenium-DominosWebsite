package au.com.dominos.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
	
	WebElement element;
	
	public Product(WebElement element) {
		this.element = element;
	}

	public String getName() {
		return element.findElement(By.className("menu-entry")).getText();	
	}

	public int getKilojoules() {
		return Integer.parseInt(element.findElement(By.className("kjs")).getText().replace("kJ^", ""));
	}
	
	public void clickOrderNowButton() {
		element.findElement(By.className("btn")).click();
	}
}
