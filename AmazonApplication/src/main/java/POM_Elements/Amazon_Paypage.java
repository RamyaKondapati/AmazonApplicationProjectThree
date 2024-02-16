package POM_Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.BaseAbstractMethods;
import UtilitiesPackage.ReuseMethods;

public class Amazon_Paypage extends BaseAbstractMethods {

	WebDriver driver;
	Properties props;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public Amazon_Paypage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-hamburger-menu")
	WebElement hamburgerclick;

	@FindBy(xpath = "//div[text()='Audible Audiobooks']/parent::a")
	WebElement audiobooks;

	@FindBy(xpath = "(//a[text()='Amazon Pay'])[2]")
	WebElement amazonpay;

	@FindBy(xpath = "//span[text()='Rewards']")
	WebElement rewards;

	@FindBy(xpath = "//a[@id='a-autoid-1-announce']")
	WebElement signintounlockbutton;

	@FindBy(xpath = "//span[@class='a-size-extra-large show-cashback-earned']")
	WebElement cashbackearned;

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement hoveraccountlist;

	@FindBy(xpath = "//span[text()='Sign Out']")
	WebElement signout;

	@FindBy(xpath = "//span[text()='Mobile Recharge']")
	WebElement mobilerecharge;

	@FindBy(xpath = "//input[@id='mobileNumberTextInputId']")
	WebElement mobilenum;

	@FindBy(xpath = "//a[@id='operatorCircleLink']")
	WebElement EditOperator;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-radio'])[5]")
	WebElement jiooperator;
	@FindBy(xpath = "(//i[@class='a-icon a-icon-radio'])[5]")
	WebElement airteloperator;

	@FindBy(xpath = "(//i[@class='a-icon a-icon-radio'])[8]")
	WebElement telanganacicle;

	@FindBy(xpath = "(//a[@class='a-popover-trigger a-declarative'])[2]")
	WebElement viewplans;

	@FindBy(xpath = "//input[@value='Popular~19~NA~Active plan~1015084~KOMPARIFY']")
	WebElement popularplan;

	@FindBy(xpath = "//button[@id='buyButtonNative']")
	WebElement continuebutton;

	@FindBy(xpath = "//div[@id='errorMessageTextInputId']")
	WebElement errormessage;

	@FindBy(xpath = "//span[text()='Travel and insurance']")
	WebElement travelandinsurance;

	@FindBy(xpath = "//span[text()='Trains']")
	WebElement trains;

	@FindBy(xpath = "(//span[@class='sizeLarge colorBase _9dfe85c4'])[1]")
	WebElement fromstation;

	@FindBy(xpath = "(//span[@class='sizeLarge colorBase _9dfe85c4'])[2]")
	WebElement tostation;

	@FindBy(xpath = "//input[@id='input-searchText']")
	WebElement entercity;

	@FindBy(xpath = "(//div[@class='_90aa3c07 a407febf _6078df67'])[3]")
	WebElement selectfromstation;

	@FindBy(xpath = "(//div[@class='_90aa3c07 a407febf _6078df67'])[2]")
	WebElement selecttostation;

	@FindBy(xpath = "//i[@class='d726bd8f _4d2636f0']")
	WebElement aconlybox;

	@FindBy(xpath = "//button[@class='_7e41f983 bba41d3c  _50baedd0  _9d9d5808']")
	WebElement findtrains;

	@FindBy(xpath = "//div[@class='_4e0ac60f fc52d6e7 ad23ce76']")
	WebElement trainsDisplay;

	@FindBy(xpath = "(//div[@class='_4e0ac60f da4b5834 null ad23ce76'])[2]")
	WebElement selectdate;

	@FindBy(xpath = "(//span[@class='db14b3bc'])[30]")
	WebElement date;

	public void amazonpayrewards() {
		implicitwaitMethod();

		try {

			hamburgerclick.click();
			scrollToElementBeforeClicking(audiobooks);

			amazonpay.click();
			rewards.click();
			signintounlockbutton.click();
			SignIn_SignOut_Page signIn_Out_Up = new SignIn_SignOut_Page(driver);
			signIn_Out_Up.signinMethod();

			String cashback = cashbackearned.getText();
			System.out.println(cashback);
			hoverAnyElement(hoveraccountlist);
			signout.click();
			Thread.sleep(3000);
		//	driver.close();
			String url = props.getProperty("url");
			driver.get(url);
			System.out.println("testcase5------> amazonpayrewards successfully");
		} catch (Exception e) {
			System.out.println("Exception occured in amazonpayrewards execution");
		}

	}

	public void mobilerecharge() throws IOException {
		implicitwaitMethod();

		try {
			hamburgerclick.click();
			scrollToElementBeforeClicking(audiobooks);
			amazonpay.click();
			mobilerecharge.click();
			SignIn_SignOut_Page signIn_Out_Up = new SignIn_SignOut_Page(driver);
			signIn_Out_Up.signinMethod();
			
			props = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
			props.load(fis);
			
			String mobilenumber = props.getProperty("mobileNumber");
			Thread.sleep(3000);
			mobilenum.sendKeys(mobilenumber);
			EditOperator.click();
		//	waitForElementToBeClickable(jiooperator, 30).click();
			airteloperator.click();
			telanganacicle.click();
			viewplans.click();
			popularplan.click();
			continuebutton.click();

//			String errormsg = "This is not a valid Prepaid Jio mobile number. Please select 'Edit' to change operator.";
//			ReuseMethods rc = new ReuseMethods(driver);
//			rc.verify_SingleText_Visibility(errormessage, errormsg);
//
//			hoverAnyElement(hoveraccountlist);
//			signout.click();
			String url = props.getProperty("url");
			driver.get(url);

			System.out.println("testcase6------> mobilerecharge");
		} catch (Exception e) {
			System.out.println("Exception occured in mobilerecharge execution");
		}

	}

	public void amazonpaytravel() throws IOException {
		implicitwaitMethod();
		props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
		props.load(fis);
		try {
			hamburgerclick.click();
			scrollToElementBeforeClicking(audiobooks);
			

			amazonpay.click();
			scrollToElementBeforeClicking(travelandinsurance);
		
			trains.click();
			SignIn_SignOut_Page signIn_Out_Up = new SignIn_SignOut_Page(driver);
			signIn_Out_Up.sign_In_Continue();

			fromstation.click();
			String fromcity = props.getProperty("fromcity");
			entercity.sendKeys(fromcity);
			selectfromstation.click();

			tostation.click();
			String Tocity = props.getProperty("Tocity");
			entercity.sendKeys(Tocity);
			selecttostation.click();

			selectdate.click();
			date.click();

			aconlybox.click();
			findtrains.click();

			ReuseMethods rc = new ReuseMethods(driver);
			rc.elementAvailable(trainsDisplay, true);

			System.out.println("testcase11------> executed successfully");
		}

		catch (Exception e) {
			System.out.println("Exception occured in testcase11 execution");
		}
	}

}
