package au.com.dominos.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseHomePage{

	public HomePage(WebDriver driver) {
		super(driver);
		closeDailySpecialDialog();
	}	
		
	public void closeDailySpecialDialog() {
		List<WebElement> element = driver.findElements(By.className("wobble-wrapper"));
		if (element.size() != 0) {
			System.out.println("Found the specials popup on the landing page");
			driver.findElement(By.id("wobble-close-text")).click();
		}
	}
}
