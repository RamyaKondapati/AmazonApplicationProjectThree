package POM_Elements;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReusableMethodsFlow {

	WebDriver driver;
	Homepage hp;
	SearchProduct sp;
	Cartpage cp;
	CheckOutpage checkout;
	Accountpage account;
	Categorypage category;
	LanguageSelection ls;
	Amazon_Paypage ap;
	
	public ReusableMethodsFlow(WebDriver driversuper)
	{
		this.driver = driversuper;
		PageFactory.initElements(driver, this);
	}
	
	public void amazonApplication() throws IOException, InterruptedException
	{
		hp = new Homepage(driver);
		sp = new SearchProduct(driver);
		cp = new Cartpage(driver);
		checkout = new CheckOutpage(driver);
		account = new Accountpage(driver);
		category = new Categorypage(driver);
		ls = new LanguageSelection(driver);
		ap = new Amazon_Paypage(driver);
		
		hp.amazonLandingpage();
		sp.searchAnyProduct();
		sp.searchProductsWithFilters();
		cp.verifyCart();
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
