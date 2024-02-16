package POM_Elements;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.BaseAbstractMethods;
import UtilitiesPackage.ReuseMethods;

public class Accountpage extends BaseAbstractMethods {
	WebDriver driver;
	ReuseMethods rc;
	public Accountpage(WebDriver driversuper)
	{
		super(driversuper);
		this.driver = driversuper;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="") WebElement proceedToCheckOut;
	@FindBy(xpath="//a[@id='nav-hamburger-menu']") WebElement hamBurgerMenu;
	@FindBy(xpath="//a[@class='hmenu-item']//div[text()='Mobiles, Computers']") WebElement shopByCategory;
	@FindBy(xpath="//li[@class='hmenu-separator']//following::a[text()='Your Account']") WebElement yourAccount;
	@FindBy(xpath="//div[@id='nav-search-dropdown-card']") WebElement searchDDByCategory;
	@FindBy(xpath="//div[@class='a-row a-spacing-base']") WebElement yourAccountHeader;
	@FindBy(xpath="//span[text()='Track, return, or buy things again']") WebElement yourOrders;
	@FindBy(xpath="//a[contains(text(),'Invoice')]")WebElement invoice;
	@FindBy(xpath="//*[@id=\"a-popover-content-1\"]/ul/li[2]/span/a")WebElement invoiceDownload;
	
	@FindBy(xpath="//li[@role='tab']//a[text()='Buy Again']")WebElement buyAgainTab;
	@FindBy(xpath="(//input[@name='submit.addToCart'])[1]")WebElement bapAddToCart;
	@FindBy(xpath="(//img[@id='atc-stepper-add-button'])[1]") WebElement addBtnPlus;
	@FindBy(xpath="(//img[@id='atc-stepper-remove-button'])[1]") WebElement removeBtnMinus;
	@FindBy(xpath="//span[text()=' Your Account ']") WebElement returnToYourAcct;

	public void hamBurgerMenu() throws InterruptedException, IOException
	{
		rc = new ReuseMethods(driver);
//		CheckOutpage c = new CheckOutpage(driver);
//		c.proceedToBuy();
		System.out.println("------BackToHomeFromFooterLogo-------"); 
		waitForElementToBeClickable(hamBurgerMenu,40).click();
		//waitForElementToBeClickable(shopByCategory,30).click();
		scrollToElementBeforeClicking(yourAccount);
		
		waitForElementToBeClickable(yourAccount,30).click();
		rc.verify_SingleText_Visibility(yourAccountHeader, "Your Account");
		System.out.println("------hamBurgerMenu-------");
		
     }
	public Categorypage ordersAndAddress()
	{
		waitForElementToBeClickable(yourOrders,30).click();
		try {
			waitForElementToBeClickable(invoice,30).click();
			waitForElementToBeClickable(invoiceDownload,60).click();
			driver.navigate().back();
			
		}catch(Exception e)
		{
			System.out.println("---Exception Occured In Invoice---");
		}
		waitForElementToBeClickable(buyAgainTab,30).click();
		waitForElementToBeClickable(bapAddToCart,40).click();
		waitForElementToBeClickable(addBtnPlus,30).click();
		waitForElementToBeClickable(removeBtnMinus,30).click();
		waitForElementToBeClickable(removeBtnMinus,30).click();
		waitForElementToBeClickable(returnToYourAcct,30).click();
		System.out.println("------ordersAndAddress-------");	
		Categorypage category = new Categorypage(driver);
		return category;
	}
}
