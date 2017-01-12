package au.com.dominos.tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTestSuite {

	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
		
	}

	@Before
	public void setUp() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get("https://www.dominos.com.au");
	}
}
