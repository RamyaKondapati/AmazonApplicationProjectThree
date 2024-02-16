package POM_Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import UtilitiesPackage.BaseAbstractMethods;
import UtilitiesPackage.ReuseMethods;

public class SearchProduct extends BaseAbstractMethods {
	WebDriver driver;
	ReuseMethods rc;
	public SearchProduct(WebDriver driversuper)
	{
		super(driversuper);
		this.driver = driversuper;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="twotabsearchtextbox") WebElement searchTabTb;
	@FindBy(id="nav-search-submit-button") WebElement searchBtn;
	@FindBy(className="s-suggestion-container") List<WebElement> suggestions;
	@FindBy(xpath="//div[@class='a-section']") List<WebElement> searchedRelatedResults;
	@FindBy(id="s-result-sort-select") WebElement sortBySelect;
	@FindBy(xpath="//input[@id='low-price']") WebElement setMinPrice;
	@FindBy(xpath="//input[@id='high-price']") WebElement setMaxPrice;
	@FindBy(xpath="//*[@id=\"p_36/price-range\"]/span/span/form/span[3]/span/input") WebElement priceRangeGoBtn;
	@FindBy(xpath="//span[contains(text(),'Vivo')]") WebElement brandCheckBox;
	@FindBy(xpath="(//input[@type='checkbox'])[3]") WebElement brandCb;
	@FindBy(xpath="//span[contains(text(),'Eligible for Pay On Delivery')]") WebElement cod;
	@FindBy(xpath="//div[@data-component-type='s-search-result']") List<WebElement> searchFilterResults;
	@FindBy(className="span.a-text-bold") WebElement productCategory;
	@FindBy(xpath="//span[text()='Any Price']") WebElement anyPrice;
	@FindBy(xpath="//span[text()='Colour']//following::div[2]")WebElement colorSort;
	@FindBy(xpath="(//*[@id=\"filters\"]/ul[15]//span/li)[2]")WebElement screenSize;
	@FindBy(xpath="//div[@class='sg-col-inner']//span[@class='rush-component']//img") WebElement productDetailsLink;
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")WebElement productTitle;
	@FindBy(xpath="//span[@id='productTitle']") WebElement productTitleInNewWindow;
	@FindBy(xpath="//*[@id=\"add-to-cart-button\"]") WebElement addToCartButton;
	@FindBy(xpath="//div[@class='a-fixed-left-grid']") WebElement addedToCart;
	@FindBy(xpath="") WebElement s;
	
	
	
	public void searchAnyProduct() throws IOException, InterruptedException {
		rc = new ReuseMethods(driver);
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
		props.load(fis);
		
	waitForElementToBeClickable(searchTabTb,30).click();
	String searchItems = props.getProperty("searchtext");
	searchTabTb.sendKeys(searchItems);
    // Verify that search suggestions are not empty
   // Assert.assertTrue(suggestions.isEmpty(), "Search suggestions are not empty");

    // Verify the search suggestions contain the expected keyword
    boolean containsSearchItem = false;
    for (WebElement suggestion : suggestions) {
        if (suggestion.getText().toLowerCase().contains("mobile")) {
        	containsSearchItem = true;
            break;
        }
    }
  
  // Assert.assertFalse(containsSearchItem, "Search suggestions contain searchItems");
    waitForElementToBeClickable(searchBtn,30).click();
   // Assert.assertTrue(searchedRelatedResults.size() > 0, "No search results found for "+searchItems);
    
    System.out.println("------searchAnyProduct-------");
}
	public Cartpage searchProductsWithFilters() throws InterruptedException
	{
		
		scrollToElementBeforeClicking(setMinPrice);
		setMinPrice.sendKeys("10,000");
		scrollToElementBeforeClicking(setMaxPrice);
		setMaxPrice.sendKeys("20,000");
		Thread.sleep(2000);
		scrollToElementBeforeClicking(priceRangeGoBtn);
		waitForElementToBeClickable(priceRangeGoBtn,30).click();
		Select sortBy = new Select(sortBySelect);
		sortBy.selectByIndex(1);
		Thread.sleep(2000);
		scrollToElementBeforeClicking(anyPrice);
		waitForElementToBeClickable(anyPrice,40).click();
		
//		scrollToElementBeforeClicking(brandCheckBox);
//		waitForElementToBeClickable(brandCheckBox,40).click();
//		scrollToElementBeforeClicking(brandCb);
//		waitForElementToBeClickable(brandCb,40).click();
//		scrollToElementBeforeClicking(cod);
//		waitForElementToBeClickable(cod,40).click();
//		scrollToElementBeforeClicking(colorSort);
//		waitForElementToBeClickable(colorSort,40).click();
		Thread.sleep(2000);
//		scrollToElementBeforeClicking(screenSize);
//		waitForElementToBeClickable(screenSize,40).click();
//		Thread.sleep(2000);

		System.out.println("------searchProductsWithFilters-------");	
		
		scrollToElementBeforeClicking(productDetailsLink);
		String productTitleText = productTitle.getText();
		waitForElementToBeClickable(productDetailsLink,40).click();
		//Get handles of allWindows
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		//Switch to new Window
		for(String windowHandle:allWindowHandles)
		{
			if(!windowHandle.equals(mainWindowHandle))
			{
			  driver.switchTo().window(windowHandle);
			  break;
			}
		}
		String productTitleTextInNewWindow = productTitleInNewWindow.getText();
	    Assert.assertEquals(productTitleText,productTitleTextInNewWindow);
		
		System.out.println("------productDetailsPage-------");
		scrollToElementBeforeClicking(addToCartButton);
		waitForElementToBeClickable(addToCartButton,40).click();
		//rc.verifySingleElementVisibility(addedToCart);
		//rc.verifyMultipleElementsVisibility(addedToCart);
		driver.switchTo().window(mainWindowHandle);
		System.out.println("------addProductToCart-------");	
		
		Cartpage cp = new Cartpage(driver);
		return cp;
	}

}