package POM_Elements;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilitiesPackage.BaseAbstractMethods;
import UtilitiesPackage.ReuseMethods;

public class Cartpage extends BaseAbstractMethods {
	WebDriver driver;
	ReuseMethods rc;
	public Cartpage(WebDriver driversuper)
	{
		super(driversuper);
		this.driver = driversuper;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[@id='nav-cart']") WebElement cartBtn;
	@FindBy(xpath="//select[@name='quantity']") WebElement quantity;
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']") WebElement proceedToCheckOut;
	@FindBy(xpath="//div[@class='a-column a-span8']") WebElement checkOutHeader;

	
	public CheckOutpage verifyCart() throws IOException, InterruptedException
	{
		rc = new ReuseMethods(driver);
//		SearchProduct sp = new SearchProduct(driver);
//		sp.searchAnyProduct();
//		sp.searchProductsWithFilters();
		scrollToElementBeforeClicking(cartBtn);
		waitForElementToBeClickable(cartBtn,40).click();
		driver.navigate().refresh();
		rc.verifyTitle("Amazon.in Shopping Cart");
		visibilityOfElementLocated(quantity,30);
		// Get the current quantity
        int actQuantity = Integer.parseInt(quantity.getAttribute("value"));
        System.out.println("Initial Quantity ----> "+actQuantity);
		Select qty = new Select(quantity);
		qty.selectByVisibleText("2");
		visibilityOfElementLocated(quantity,30);
		int currentQuantity = Integer.parseInt(quantity.getAttribute("value"));
		assert currentQuantity > 1 : "Quantity is not increased";
		
		System.out.println("------verifyCart-------");
		
		CheckOutpage checkout = new CheckOutpage(driver);
		return checkout;
	}

	
}
