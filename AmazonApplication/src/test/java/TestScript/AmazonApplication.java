package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM_Elements.Accountpage;
import POM_Elements.Amazon_Paypage;
import POM_Elements.Cartpage;
import POM_Elements.Categorypage;
import POM_Elements.CheckOutpage;
import POM_Elements.Homepage;
import POM_Elements.LanguageSelection;
import POM_Elements.ReusableMethodsFlow;
import POM_Elements.SearchProduct;



public class AmazonApplication {
	WebDriver driver;
	ReusableMethodsFlow rm;
	Homepage hp;
	Amazon_Paypage ap;
	LanguageSelection ls;
	SearchProduct sp;
	Amazon_Paypage am;
	Accountpage ac;
	CheckOutpage co;
	Categorypage cp;
	Cartpage cart;
	CheckOutpage  checkout;
	Accountpage account;
	Categorypage  category;
	
	@BeforeTest
	public void setupBrowser_And_LaunchUrl() throws IOException {
		// load properties file
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
		props.load(fis);
		// initializing browser
		String browser = props.getProperty("browsername");
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			String downloadFilePath = System.getProperty("user.dir");
			prefs.put("download.default_directory", downloadFilePath);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		// launch Application
		driver.manage().window().maximize();
		String url = props.getProperty("url");
		driver.get(url);
		System.out.println("Application Launched Successfully");
	}

//	@AfterTest
//	public void closeBrowser() {
//		driver.quit();
//		System.out.println("Browser Quit");
//	}
	
//	@Test
//	public void amazonApplication() throws IOException, InterruptedException
//	{
//		rm = new ReusableMethodsFlow(driver);
//		rm.amazonApplication();
//	}

	@Test(priority = 1)
	public void language_country_selection() {
		ls = new LanguageSelection(driver);
		ls.languageChange();
		ls.countryChange();
		
	}

	@Test(priority = 2)
	public void searchAnyProduct() throws IOException, InterruptedException {
		sp = new SearchProduct(driver);
		sp.searchAnyProduct();
		sp.searchProductsWithFilters();	
	}
	@Test(priority = 3)
	public void amazonpay_rewards() throws InterruptedException {
		am = new Amazon_Paypage(driver);
		am.amazonpayrewards();
	}

	@Test(priority = 4)
	public void amazonpay_mobilerecharge() throws InterruptedException, IOException {
		am = new Amazon_Paypage(driver);
		am.mobilerecharge();
	}
	@Test(priority = 5)
	public void amazonpay_amazonpaytravel() throws InterruptedException, IOException {
		am = new Amazon_Paypage(driver);
		am.amazonpaytravel();
	}
	@Test(priority = 6)
	public void checkout() throws InterruptedException, IOException {
		co = new CheckOutpage(driver);
		co.proceedToBuy();
		
	}
	@Test(priority = 6)
	public void account_Orders() throws InterruptedException, IOException {
		ac = new Accountpage(driver);
		ac.hamBurgerMenu();
		ac.ordersAndAddress();
	}
	
	@Test(priority = 7)
	public void productsRelatedCategory() throws InterruptedException, IOException {
		cp = new Categorypage(driver);
		cp.productsRelatedToCategory();
	}
	@Test(priority = 8)
	public void amazon_Cart() throws InterruptedException, IOException {
		hp = new Homepage(driver);
		sp = new SearchProduct(driver);
		cart = new Cartpage(driver);
		checkout = new CheckOutpage(driver);
		account = new Accountpage(driver);
		category = new Categorypage(driver);
		ls = new LanguageSelection(driver);
		ap = new Amazon_Paypage(driver);
		
		hp.amazonLandingpage();
		sp.searchAnyProduct();
		sp.searchProductsWithFilters();
		cart.verifyCart();
		checkout.proceedToBuy();
		account.hamBurgerMenu();
		account.ordersAndAddress();
		category.productsRelatedToCategory();
		ls.languageChange();
		ls.countryChange();
		ap.amazonpayrewards();
		ap.amazonpaytravel();
		ap.mobilerecharge();
	}

	
}
