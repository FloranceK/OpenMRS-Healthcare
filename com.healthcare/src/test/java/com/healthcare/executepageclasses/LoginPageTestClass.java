package com.healthcare.executepageclasses;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.pageclasses.HomePageClass;
import com.healthcare.pageclasses.LoginPageClass;
import com.healthcare.pageclasses.RegisterAPatientPageClass;
import com.healthcare.retry.RetryAnalyzer;

import utilities.ExcelRead;

public class LoginPageTestClass extends BaseClass { 

	private LoginPageClass loginPageClass;
	private HomePageClass homePageClass;

	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "dp",retryAnalyzer = RetryAnalyzer.class,groups = {"group2"})
	public void verifySuccessfulLogin(String uname, String password) {
		loginPageClass = new LoginPageClass(driver);
		loginPageClass.loginAsRegistrationDesk(uname, password);
		homePageClass = new HomePageClass(driver);
		String actualResult = homePageClass.getTextOfWelcomeMessage();
		String expectedResult = "Logged in as Super User (admin) at Registration Desk.";
		Assert.assertEquals(actualResult, expectedResult, "Actual and Expected are not same");

	}

	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "unsucessfulLogin", retryAnalyzer = RetryAnalyzer.class,groups = {"group2"})
	public void verifyUnsuccessfulLogin(String uname, String password) {
		loginPageClass = new LoginPageClass(driver);
		loginPageClass.loginAsRegistrationDesk(uname, password);
		String actualResult = loginPageClass.getUnsuccessfulLoginMessageForRegDesk();
		String expectedResult = "Invalid username/password. Please try again.";
		Assert.assertEquals(actualResult, expectedResult, "Actual and expcted outcomes are not same");
	}

	@Test(retryAnalyzer = RetryAnalyzer.class,groups = {"group1"})
	public void verifyTheCorrectSiteIsLoadedWhileHittingTheURL() throws IOException {
		loginPageClass = new LoginPageClass(driver);
		String actualResult = loginPageClass.getURLOfLoginPage();
		String expectedResult = ExcelRead.getStringData(19, 1);
		Assert.assertEquals(actualResult, expectedResult);

	}

}
