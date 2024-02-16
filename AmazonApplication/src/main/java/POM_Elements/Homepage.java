package POM_Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import UtilitiesPackage.BaseAbstractMethods;
import UtilitiesPackage.ReuseMethods;


public class Homepage extends BaseAbstractMethods{
	
	WebDriver driver;
	ReuseMethods rc;
	public Homepage(WebDriver driversuper)
	{
		super(driversuper);
		this.driver = driversuper;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@id='pageContent']//following::img") WebElement imagesFinding;
	@FindBy(xpath="(//a[@data-nav-role='signin'])[1]") WebElement helloSignIn;
	@FindBy(xpath="(//span[text()='Sign in'])[1]") WebElement signInBtn;
	@FindBy(xpath="//a[@id='createAccountSubmit']") WebElement createAccountBtn;
	@FindBy(name="customerName") WebElement customerNameTb;
	@FindBy(xpath="//input[@type='tel']") WebElement mobileNumber;
	@FindBy(xpath="//input[@type='password']") WebElement createPassTb;
	@FindBy(xpath="//span[@id='auth-continue-announce']") WebElement verifyMobileNumber;
	@FindBy(xpath="//a[@class='a-link-emphasis']") WebElement alreadyHaveAccSignIn;
	@FindBy(name="email") WebElement email_PhoneNoTb;
	@FindBy(xpath="//input[@id='continue']") WebElement continueBtn;
	@FindBy(name="password") WebElement passwordTb;
	@FindBy(id="signInSubmit") WebElement signInSubmit;
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement helloUserText;
	@FindBy(xpath="(//a[@class='a-link-normal'])[2]") WebElement existingCustSign;
	@FindBy(xpath="//button[text()='Start Puzzle']") WebElement startPuzzle;
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signOutLink;
	@FindBy(xpath="(//div[@class='a-alert-content'])[3]") WebElement errorMsgText;
	
//	@FindBy(xpath="") WebElement s;
//	@FindBy(xpath="") WebElement s;
//	@FindBy(xpath="") WebElement s;
//	@FindBy(xpath="") WebElement s;
//	@FindBy(xpath="") WebElement s;
//	@FindBy(xpath="") WebElement s;
	
	public SearchProduct amazonLandingpage() throws IOException, InterruptedException
	{
		implicitwaitMethod();
		rc = new ReuseMethods(driver);
		rc.verifyUrl("https://www.amazon.in/");
		//rc.verifyTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		rc.imageVisibility(imagesFinding);
		hoverAnyElement(helloSignIn);
		waitForElementToBeClickable(signInBtn, 10).click();
//		waitForElementToBeClickable(createAccountBtn, 10).click();
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
		props.load(fis);
		try {

			Thread.sleep(2000);
			// Form Data from Globalinput properties
//			waitForElementToBeClickable(createAccountBtn, 10).click();
//			String customerName = props.getProperty("customername");
//			customerNameTb.sendKeys(customerName);
//			String mobileNo = props.getProperty("mobilenumber");
//			mobileNumber.sendKeys(mobileNo);
//			String createPassword = props.getProperty("createpassword");
//			createPassTb.sendKeys(createPassword);
////			waitForElementToBeClickable(verifyMobileNumber, 30).click();
////			System.out.println("stoping1");
//			Thread.sleep(9000);
//		//	waitForElementToBeClickable(startPuzzle, 30).click();
//			
//			waitForElementToBeClickable(alreadyHaveAccSignIn,30).click();
			String emailPhoneNo = props.getProperty("emailMobilePhoneNo");
			email_PhoneNoTb.clear();
			email_PhoneNoTb.sendKeys(emailPhoneNo);
			waitForElementToBeClickable(continueBtn,30).click();
			String passWord = props.getProperty("password");
			passwordTb.clear();
			passwordTb.sendKeys(passWord);
			waitForElementToBeClickable(signInSubmit,30).click();
			try {
			rc.verify_SingleText_Visibility(helloUserText,"Hello, Ramya");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
//			//Switch to the newtab
//			String currentWindow = driver.getWindowHandle();
//			
//			for(String windowHandle : driver.getWindowHandles())
//			{
//				if(!windowHandle.equals(currentWindow))
//				{
//					driver.switchTo().window(windowHandle);
//					System.out.println("'opened in newTab with Title : '" + driver.getTitle() );
//					driver.close();
//					break;
//					
//				}
//			}
//			
//			driver.switchTo().window(currentWindow);
		
			System.out.println("Try Block SignUp");
			
		} catch (Exception e) {
			
//			waitForElementToBeClickable(alreadyHaveAccSignIn,30).click();
//			String emailPhoneNo = props.getProperty("emailMobilePhoneNo");
//			email_PhoneNoTb.clear();
//			email_PhoneNoTb.sendKeys(emailPhoneNo);
//			waitForElementToBeClickable(continueBtn,30).click();
//			String passWord = props.getProperty("password");
//			passwordTb.clear();
//			passwordTb.sendKeys(passWord);
//			waitForElementToBeClickable(signInSubmit,30).click();
//			rc.verify_SingleText_Visibility(helloUserText,"Hello, Ramya");
			
			System.out.println("Catch Block SignIn");	
		}
		
		System.out.println("------- amazonLandingpage  -----");
		
		SearchProduct searchproduct = new SearchProduct(driver);
		 return searchproduct;  
		 
		 
    }
		
			
	}

