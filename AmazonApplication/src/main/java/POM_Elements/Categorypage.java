package POM_Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.BaseAbstractMethods;
import UtilitiesPackage.ReuseMethods;

public class Categorypage extends BaseAbstractMethods {
	WebDriver driver;
	ReuseMethods rc;
	public Categorypage(WebDriver driversuper)
	{
		super(driversuper);
		this.driver = driversuper;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Baby']") WebElement babyCategory_NavMain;
	@FindBy(xpath="//a[text()='Fashion']") WebElement fashionCategory_NavMain;
	@FindBy(xpath="(//div[@class='nav-left'])[2]") WebElement category_DD;
	
	public LanguageSelection  productsRelatedToCategory()
	{
		rc = new ReuseMethods(driver);
		waitForElementToBeClickable(babyCategory_NavMain,30).click();
		// Get the text of the search dropdown description
        String descriptionText = category_DD.getText();

        // Verify if the description reflects the selected category
        if (descriptionText.contains("Baby")) {
            System.out.println("Search dropdown description reflects the selected category.");
        } else {
            System.out.println("Search dropdown description does not reflect the selected category.");
        }
        waitForElementToBeClickable(fashionCategory_NavMain,30).click();

        if (descriptionText.contains("Amazon Fashion")) {
            System.out.println("Search dropdown description reflects the selected category.");
        } else {
            System.out.println("Search dropdown description does not reflect the selected category.");
        }
        
		System.out.println("------productsRelatedToCategory-------"); 
		LanguageSelection ls = new LanguageSelection(driver);
		return ls;
	}
}
