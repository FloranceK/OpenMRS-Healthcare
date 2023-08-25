package com.healthcare.executepageclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotClass;

public class BaseClass {

	WebDriver driver;
	ScreenshotClass sc;

	public static Properties property;

	public static void readProperty() throws IOException {
//		getClass().getClassLoader().getResource("config.properties");
		property = new Properties();
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config.properties");
		property.load(f); // to load the file
	}

	@Parameters("browser")
	@BeforeMethod(groups = {"launch"})
	public void beforeMethod(String browserValue) throws IOException {
		readProperty();
		if (browserValue.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserValue.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserValue.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		 

		driver.get(property.getProperty("url"));  // to retrieve the url mentioned from config.properies file.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(groups = {"close"})
	public void afterMethod(ITestResult itr) throws IOException {
		// ITestResult describes the result of a test

		if (itr.getStatus() == ITestResult.FAILURE) { // test execution status ie, PASS, FAIL, SKIP etc
			sc = new ScreenshotClass(); // screenshots are taken only when test result is FAIL 
			sc.takeScreenshot(driver, itr.getName());
		}  
		driver.quit();
	}
	
	@BeforeSuite(alwaysRun = true)
	public void createExtendReport(final ITestContext testContext) {
		com.healthcare.extendreport.ExtentManager.createInstance().createTest(testContext.getName(), "message");
	}

}
