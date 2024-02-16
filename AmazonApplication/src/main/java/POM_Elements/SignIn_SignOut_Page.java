package POM_Elements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilitiesPackage.BaseAbstractMethods;
import UtilitiesPackage.ReuseMethods;

public class SignIn_SignOut_Page extends BaseAbstractMethods{
	
	WebDriver driver;
	ReuseMethods rc;
	Properties props;
	public SignIn_SignOut_Page(WebDriver driversuper)
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
	@FindBy(xpath="//input[@name='email']")WebElement email_mobileTb;
	@FindBy(xpath="//input[@type='tel']") WebElement mobileNumber;
	@FindBy(xpath="//input[@type='password']") WebElement createPassTb;
	@FindBy(xpath="//input[@name='passwordCheck']")WebElement pswCheck;
	@FindBy(xpath="//span[@id='auth-continue-announce']") WebElement verifyMobileNumber;
	@FindBy(xpath="//a[@class='a-link-emphasis']") WebElement alreadyHaveAccSignIn;
	@FindBy(name="email") WebElement email_PhoneNoTb;
	@FindBy(xpath="//input[@id='continue']") WebElement continueBtn;
	@FindBy(name="password") WebElement passwordTb;
	@FindBy(id="signInSubmit") WebElement signInSubmit;
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") WebElement helloUserText;
	@FindBy(xpath="(//a[@class='a-link-normal'])[2]") WebElement existingCustSign;
	@FindBy(xpath="//span[text()='Sign Out']") WebElement signOutLink;
	@FindBy(xpath="(//div[@class='a-alert-content'])[3]") WebElement errorMsgText;
	@FindBy(xpath="(//a[text()='Start here.'])[1]")WebElement newCustomer;
	@FindBy(id = "ap_email")WebElement emailaddress;	
	@FindBy(xpath = "//*[@id=\"ap_password\"]")WebElement passw;	
	@FindBy(id = "signInSubmit")WebElement signIn;
	
	
	public void amazonLandingpage() throws IOException, InterruptedException
	{
		implicitwaitMethod();
		rc = new ReuseMethods(driver);
		rc.verifyUrl("https://www.amazon.in/");
		rc.verifyTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		rc.imageVisibility(imagesFinding);
		
		System.out.println("------- amazonLandingpage  -----");	
    }
	public void signIn() throws IOException
	{
		implicitwaitMethod();
		rc = new ReuseMethods(driver);
		hoverAnyElement(helloSignIn);
		waitForElementToBeClickable(signInBtn, 10).click();
	    props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
		props.load(fis);
		
		try {
			Thread.sleep(2000);
			String emailPhoneNo = props.getProperty("emailMobilePhoneNo");
			email_PhoneNoTb.clear();
			email_PhoneNoTb.sendKeys(emailPhoneNo);
			waitForElementToBeClickable(continueBtn,30).click();
			String passWord = props.getProperty("password");
			passwordTb.clear();
			passwordTb.sendKeys(passWord);
			waitForElementToBeClickable(signInSubmit,30).click();
			rc.verify_SingleText_Visibility(helloUserText,"Hello, Ramya");
			
			System.out.println("Try Block SignIn");
			
		} catch (Exception e) {
	
			System.out.println("Catch Block - SignIn");	
		}
		
	}
	public void sign_In_Continue() throws IOException 
	{
		try {
			props = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
			props.load(fis);
			String emailPhoneNo = props.getProperty("emailMobilePhoneNo");
			email_PhoneNoTb.clear();
			email_PhoneNoTb.sendKeys(emailPhoneNo);
			waitForElementToBeClickable(continueBtn,30).click();
			String passWord = props.getProperty("password");
			passwordTb.clear();
			passwordTb.sendKeys(passWord);
			waitForElementToBeClickable(signInSubmit,30).click();
			rc.verify_SingleText_Visibility(helloUserText,"Hello, Ramya");
			
			System.out.println("Try Block sign_In_Continue");
			
		} catch (Exception e) {
	
			//System.out.println("Catch Block - sign_In_Continue");	
		}
	}
	public void signinMethod() throws IOException
	{
		rc = new ReuseMethods(driver);
		 props = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
			props.load(fis);
		String emailPhoneNo = props.getProperty("emailMobilePhoneNo");
		emailaddress.clear();
		emailaddress.sendKeys(emailPhoneNo);
		
		String passWord = props.getProperty("password");
		passw.clear();
		passw.sendKeys(passWord);
		waitForElementToBeClickable(signIn,30).click();
		rc.verify_SingleText_Visibility(helloUserText,"Hello, Ramya");
		
	}
	public void signOut()
	{
		try {
		hoverAnyElement(helloSignIn);
		waitForElementToBeClickable(signOutLink, 30).click();
		} catch (Exception e) {
			System.out.println("------- signOut Exception  -----");
		}
		System.out.println("------- signOut  -----");
	}
	public void signUp() throws IOException
	{
		implicitwaitMethod();
		rc = new ReuseMethods(driver);
		hoverAnyElement(helloSignIn);
		waitForElementToBeClickable(newCustomer, 20).click();

		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
		props.load(fis);
		try {
			Thread.sleep(2000);
			String customerName = props.getProperty("customername");
			customerNameTb.sendKeys(customerName);
			String mobileNo = props.getProperty("mobilenumber");
			email_mobileTb.sendKeys(mobileNo);
			String createPassword = props.getProperty("createpassword");
			createPassTb.sendKeys(createPassword);
			String passwordCheck = props.getProperty("passwordcheck");
			pswCheck.sendKeys(passwordCheck);
		//	waitForElementToBeClickable(continueBtn,30).click();
			waitForElementToBeClickable(verifyMobileNumber, 30).click();
			System.out.println("stoping1");
			Thread.sleep(9000);
			
			System.out.println("Try Block SignUp");
			
		} catch (Exception e) {
			
			waitForElementToBeClickable(alreadyHaveAccSignIn,30).click();
			String emailPhoneNo = props.getProperty("emailMobilePhoneNo");
			email_PhoneNoTb.clear();
			email_PhoneNoTb.sendKeys(emailPhoneNo);
			waitForElementToBeClickable(continueBtn,30).click();
			String passWord = props.getProperty("password");
			passwordTb.clear();
			passwordTb.sendKeys(passWord);
			waitForElementToBeClickable(signInSubmit,30).click();
			rc.verify_SingleText_Visibility(helloUserText,"Hello, Ramya");
			
			System.out.println("Catch Block SignIn");	
		}
		
		System.out.println("------- amazonLandingpage  -----");
	}

}
