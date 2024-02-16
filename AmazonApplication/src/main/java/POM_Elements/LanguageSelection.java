package POM_Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilitiesPackage.BaseAbstractMethods;
import UtilitiesPackage.ReuseMethods;

public class LanguageSelection extends BaseAbstractMethods {
	WebDriver driver;
	ReuseMethods rc;

	public LanguageSelection(WebDriver driversuper) {
		super(driversuper);
		this.driver = driversuper;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='icp-nav-flyout']")
	WebElement country_Lang;

	@FindBy(xpath = "(//span[text()='తెలుగు'])[1]")
	WebElement teluguLang;
	@FindBy(xpath = "(//div[@class='icp-mkt-change-lnk'])[1]")
	WebElement changeCountry_region;
	@FindBy(xpath = "//select[@id='icp-dropdown']")
	WebElement country_regionWebsite;
	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement goToWebsiteBtn;
	@FindBy(xpath = "//span[@id='icp-cancel-button']")
	WebElement cancelBtn;
	@FindBy(xpath = "//span[@class='icp-nav-link-inner']")
	WebElement teluguToUs;
	@FindBy(xpath="//a[@id='icp-dropdown_17']")WebElement us;
	@FindBy(xpath="(//span[text()='English'])[1]") WebElement englishLang;

	public void languageChange() {
		rc = new ReuseMethods(driver);
		hoverAnyElement(country_Lang);
		waitForElementToBeClickable(teluguLang, 30).click();
		System.out.println("------TeluguLanguageSelected-------");
	}

	public void countryChange() {
		driver.navigate().refresh();
		rc = new ReuseMethods(driver);
		visibilityOfElementLocated(teluguToUs, 30);
		hoverAnyElement(teluguToUs);
		waitForElementToBeClickable(changeCountry_region, 30).click();
		Select c_r_websiteDD = new Select(country_regionWebsite);
		c_r_websiteDD.selectByIndex(17);
		visibilityOfElementLocated(us,30);
		waitForElementToBeClickable(us, 30).click();
		waitForElementToBeClickable(goToWebsiteBtn, 30).click();
		// Switch to the newtab
		String curWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(curWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("'opened in newTab with Title : '" + driver.getTitle());
				break;
			}
		}
	//	rc.verifyUrl("https://www.amazon.com/?ref_=icp_country_from_in");
		driver.switchTo().window(curWindow);
		waitForElementToBeClickable(cancelBtn, 30).click();

		System.out.println("------countryChange-------");
		hoverAnyElement(country_Lang);
		waitForElementToBeClickable(englishLang, 30).click();
		System.out.println("------EnglishLanguageSelected-------");
	}
}
