package POM_Elements;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.BaseAbstractMethods;
import UtilitiesPackage.ReuseMethods;

public class CheckOutpage extends BaseAbstractMethods {
	WebDriver driver;
	ReuseMethods rc;
	
	public CheckOutpage(WebDriver driversuper)
	{
		super(driversuper);
		this.driver = driversuper;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='proceedToRetailCheckout']") WebElement proceedToCheckOut;
	@FindBy(xpath="//div[@class='a-row address-row list-address-selected']") WebElement selectAnyOneAddress;
	@FindBy(xpath="//a[@aria-label='Amazon India Home']") WebElement amazonFooterLogo;

	public Accountpage proceedToBuy() throws IOException, InterruptedException
	{
		rc = new ReuseMethods(driver);
//		Cartpage cart = new Cartpage(driver);
//		cart.verifyCart();
		waitForElementToBeClickable(proceedToCheckOut,30).click();
		waitForElementToBeClickable(selectAnyOneAddress,30).click();
		System.out.println("------proceedToCheckOut-------"); 
		driver.navigate().back();
		scrollToElementBeforeClicking(amazonFooterLogo);
		waitForElementToBeClickable(amazonFooterLogo,50).click();
		
		System.out.println("------proceedToBuy-------");
		Accountpage ap = new Accountpage(driver);
		return ap;
	}
}
