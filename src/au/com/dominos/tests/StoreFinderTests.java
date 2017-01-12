package au.com.dominos.tests;

import org.junit.Assert;
import org.junit.Test;

import au.com.dominos.pages.HomePage;
import au.com.dominos.pages.StoreFinderPage;

public class StoreFinderTests extends BaseTestSuite {

	@Test
	public void searchStoreWithValidPostcodeReturnResults() {
		int expectedSearchRestults = 2;
		HomePage homePage = new HomePage(driver);
		StoreFinderPage storeFinderPage = homePage.clickStoreFinder();
		storeFinderPage.setPostcode("2070");
		storeFinderPage.clickSearchButton();
		Assert.assertEquals("Incorrect search results", expectedSearchRestults, storeFinderPage.getSearchResults().size());
		System.out.println(storeFinderPage.getSearchResults().size());	
	}
	
	@Test
	public void searchStoreWithInValidPostcodeReturnNoResults() {
		HomePage homePage = new HomePage(driver);
		StoreFinderPage storeFinderPage = homePage.clickStoreFinder();
		storeFinderPage.setPostcode("1111");
		storeFinderPage.clickSearchButton();
		Assert.assertEquals("Incorrect search results", 0, storeFinderPage.getSearchResults().size());
		Assert.assertEquals("Check no results returned", "Your search term returned no matching results.", storeFinderPage.getTextNoResultsFound());
	}
}
