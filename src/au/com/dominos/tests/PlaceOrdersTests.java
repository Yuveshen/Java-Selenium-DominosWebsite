package au.com.dominos.tests;

import org.junit.Assert;
import org.junit.Test;

import au.com.dominos.dialogs.DeliveryDetailsDialog;
import au.com.dominos.dialogs.TodaysOnlineDealsDialog;
import au.com.dominos.orders.pages.DeliverDetailsPage;
import au.com.dominos.orders.pages.DeliverySearchResultsPage;
import au.com.dominos.orders.pages.OnlineOrderingPage;
import au.com.dominos.orders.pages.OrderTimePage;
import au.com.dominos.orders.pages.ProductMenuPage;
import au.com.dominos.pages.HomePage;
import au.com.dominos.pages.OurMenuPage;
import au.com.dominos.products.CompareByName;
import au.com.dominos.products.Product;


public class PlaceOrdersTests extends BaseTestSuite {
	

	private String name = "Yuveshen";
	private String phone = "0434998234";
	private String email = "yuveshen@company.com";
	private String unit = "";
	private String streetNumber = "26";
	private String street = "Primula St";
	private String suburb = "Lindfield";
	private String postcode = "2070";
	private String deliveryInstructions = "Leave it at the door";
	private String address = streetNumber+" "+street;

	@Test
	public void verifyPizzaOrderCartForDelivery() throws Exception {
		String pizzaName = "Supreme";
		String orderType = "delivery";
		String itexpectedCartTotal = "20.95";
		
		TodaysOnlineDealsDialog todaysOnlineDealsDialog;
		HomePage homePage = new HomePage(driver);
		OurMenuPage ourMenuPage = homePage.clickOurMenuLink();
		Product pizza = ourMenuPage.getProduct(new CompareByName(pizzaName));    
		pizza.clickOrderNowButton();
		
		OnlineOrderingPage onlineOrderingPage = new OnlineOrderingPage(driver);
		Assert.assertEquals("No order placed", "ONLINE ORDERING", onlineOrderingPage.getPageTitle());
		DeliverDetailsPage deliveryDetailsPage = onlineOrderingPage.clickOrderType(orderType);
		deliveryDetailsPage.setDeliveryDetails(name, phone, email, unit, streetNumber, street, suburb, postcode, deliveryInstructions);
		DeliveryDetailsDialog deliveryDetailsDialog = deliveryDetailsPage.clickNextButton();
		
		DeliverySearchResultsPage deliverySearchResultsPage = deliveryDetailsDialog.clickNoButton();
		OrderTimePage orderTimePage = deliverySearchResultsPage.clickAddressButton(address);
		
		if (orderTimePage.getIsStoreCurrentlClosed()){
			orderTimePage.setOrderTime("02:00 PM");
			todaysOnlineDealsDialog = orderTimePage.clickNextButon();	
		}else {
			todaysOnlineDealsDialog = orderTimePage.clickAsapButton(); 	
		}
		
		ProductMenuPage productMenuPage = todaysOnlineDealsDialog.clickNoThanksButton();	
		Assert.assertEquals("Cart total not as expected", itexpectedCartTotal, productMenuPage.getCartTotal());
	}

}
