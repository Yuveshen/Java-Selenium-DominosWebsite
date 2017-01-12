package au.com.dominos.tests;

import org.junit.Assert;
import org.junit.Test;

import au.com.dominos.orders.pages.OnlineOrderingPage;
import au.com.dominos.pages.HomePage;
import au.com.dominos.pages.OurMenuPage;
import au.com.dominos.products.CompareByKilojoules;
import au.com.dominos.products.CompareByName;
import au.com.dominos.products.Product;


public class OurMenuPageTests extends BaseTestSuite {
	
	@Test
	public void orderPizzaByName() throws Exception {
		HomePage homePage = new HomePage(driver);
		OurMenuPage ourMenuPage = homePage.clickOurMenuLink();
		Product pizza = ourMenuPage.getProduct(new CompareByName("Rustic Chicken and Bacon"));    
		pizza.clickOrderNowButton();
		
		OnlineOrderingPage onlineOrderingPage = new OnlineOrderingPage(driver);
		String pageTitle = onlineOrderingPage.getPageTitle();
		System.out.print(pageTitle);
		Assert.assertEquals("No order placed", "ONLINE ORDERING", pageTitle);

	}
	
	@Test
	public void orderPizzaByKilojoules() throws Exception {
		HomePage homePage = new HomePage(driver);
		OurMenuPage ourMenuPage = homePage.clickOurMenuLink();
		Product pizza = ourMenuPage.getProduct(new CompareByKilojoules(5240));        
		pizza.clickOrderNowButton();
		
		OnlineOrderingPage onlineOrderingPage = new OnlineOrderingPage(driver);
		String pageTitle = onlineOrderingPage.getPageTitle();
		Assert.assertEquals("No order placed", "ONLINE ORDERING", pageTitle);

	}
	
	@Test
	public void orderSideByName() throws Exception {
		HomePage homePage = new HomePage(driver);
		OurMenuPage ourMenuPage = homePage.clickOurMenuLink();
		ourMenuPage.clickProductMenu("Sides");
		Product side = ourMenuPage.getProduct(new CompareByName("Garlic Bread"));
		side.clickOrderNowButton();
		
		OnlineOrderingPage onlineOrderingPage = new OnlineOrderingPage(driver);
		String pageTitle = onlineOrderingPage.getPageTitle();
		Assert.assertEquals("No order placed", "ONLINE ORDERING", pageTitle);
	}

	@Test
	public void orderDesertByName() throws Exception {
		HomePage homePage = new HomePage(driver);
		OurMenuPage ourMenuPage = homePage.clickOurMenuLink();
		ourMenuPage.clickProductMenu("Desserts");
		Product dessert = ourMenuPage.getProduct(new CompareByName("Belgian Choc Lava Cake"));
		dessert.clickOrderNowButton();
		
		OnlineOrderingPage onlineOrderingPage = new OnlineOrderingPage(driver);
		String pageTitle = onlineOrderingPage.getPageTitle();
		Assert.assertEquals("No order placed", "ONLINE ORDERING", pageTitle);
	}
}
