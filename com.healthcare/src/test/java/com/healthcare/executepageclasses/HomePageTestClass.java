package com.healthcare.executepageclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.pageclasses.HomePageClass;
import com.healthcare.pageclasses.LoginPageClass;

public class HomePageTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;

	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "dp")
	public void verifyAllTilesAreDisplayedInHomePage(String uname, String password) {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, password);
		hp = new HomePageClass(driver);
		Boolean actualResult = hp.isAllTilesDisplayed();
		Assert.assertTrue(actualResult);
	}

	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "dp")
	public void verifyTheLogoIsDisplayedOrNotInHomePage(String uname, String password) {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, password);
		hp = new HomePageClass(driver);
		Boolean actualResult = hp.isLogoDisplayedInHomePage();
		Assert.assertTrue(actualResult);

	}
}
	