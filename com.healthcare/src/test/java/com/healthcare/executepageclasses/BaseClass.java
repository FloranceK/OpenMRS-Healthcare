package com.healthcare.executepageclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotClass;

public class BaseClass {
	
	WebDriver driver;
	ScreenshotClass sc;
	
	public static Properties property;
	
	public static void readProperty() throws IOException {
//		getClass().getClassLoader().getResource("config.properties");
		property = new Properties();
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config.properties");
		property.load(f);  // to load the file
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		readProperty();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get(property.getProperty("url"));  // to retrieve the url mentioned from config.properies file.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod()
	public void afterMethod(ITestResult itr) throws IOException {
	//ITestResult describes the result of a test
		
		if (itr.getStatus() == ITestResult.FAILURE) { // test execution status ie, PASS, FAIL, SKIP etc
			sc = new ScreenshotClass();    // screenshots are taken only when test result is FAIL
			sc.takeScreenshot(driver, itr.getName());
		}
		driver.quit();
	}

}
