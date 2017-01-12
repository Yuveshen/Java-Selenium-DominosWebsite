package au.com.dominos.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import au.com.dominos.products.Product;
import au.com.dominos.strategies.ICompareStrategy;

public class OurMenuPage extends BaseHomePage {

	public OurMenuPage(WebDriver driver) {
		super(driver);
	}

	public void clickProductMenu(String productMenuLink) throws Exception {
		getProductMenuName(productMenuLink).click();
	}
	
	public WebElement getProductMenuName(String productMenuLink) throws Exception {
		productMenuLink = productMenuLink.toUpperCase();
		List<WebElement> productMenu = driver.findElements(By.cssSelector(".product-menu li"));
		for (WebElement product : productMenu) {
			if (product.getText().equals(productMenuLink)) {
				return product;
			}
		}	
		throw new Exception("Product Menu not found");	
	}

	public Product getProduct(ICompareStrategy productStrategy) throws Exception {
		List<WebElement> productList = driver.findElements(By.className("product-container"));
		for (WebElement product : productList) {
			Product selectedProduct = new Product(product);
			if (productStrategy.CompareProduct(selectedProduct)) {
				//Actions action = new Actions(driver);
				//action.moveToElement(product).build().perform();
				new Actions(driver).moveToElement(product).perform(); //both work
				return selectedProduct;
			}
		}
		throw new Exception("Product not found");	
	}
}



/*	public Pizza getPizzaByName(String pizzaName) throws Exception {
	pizzaName = pizzaName.toUpperCase();
	List<WebElement> pizzaList = driver.findElements(By.className("product-container"));
	for (WebElement pizza : pizzaList) {
		Pizza selectedPizza = new Pizza(pizza);
		if (selectedPizza.getName().equals(pizzaName)) {
			return selectedPizza;
		}
	}
	throw new Exception("Product not found");	
}

public Pizza getPizzaByKilojoules(int kilojoules) throws Exception {
	List<WebElement> pizzaList = driver.findElements(By.className("product-container"));
	for (WebElement pizza : pizzaList) {
		Pizza selectedPizza = new Pizza(pizza);
		if (selectedPizza.getKilojoules() == kilojoules) {
			return selectedPizza;
		}
	}
	throw new Exception("Product not found");	
}	*/