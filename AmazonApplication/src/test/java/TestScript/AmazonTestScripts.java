package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import POM_Elements.ReusableMethodsFlow;

public class AmazonTestScripts {
	WebDriver driver;
	ReusableMethodsFlow rm;
	@BeforeTest
	public void setupBrowser_And_LaunchUrl() throws IOException {
		// load properties file
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
		props.load(fis);
		// initializing browser
		String browser = props.getProperty("browsername");
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			String downloadFilePath = System.getProperty("user.dir");
			prefs.put("download.default_directory", downloadFilePath);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		// launch Application
		driver.manage().window().maximize();
		String url = props.getProperty("url");
		driver.get(url);
		System.out.println("Application Launched Successfully");
	}

//	@AfterTest
//	public void closeBrowser() {
//		driver.quit();
//		System.out.println("Browser Quit");
//	}
	
	@Test
	public void amazonApplication() throws IOException, InterruptedException
	{
		rm = new ReusableMethodsFlow(driver);
		rm.amazonApplication();
	}

}
