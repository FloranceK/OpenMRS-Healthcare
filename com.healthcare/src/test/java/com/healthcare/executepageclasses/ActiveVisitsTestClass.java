package com.healthcare.executepageclasses;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.pageclasses.ActiveVisitsPageClass;
import com.healthcare.pageclasses.HomePageClass;
import com.healthcare.pageclasses.LoginPageClass;
import com.healthcare.pageclasses.PatientPageClass;
import com.healthcare.pageclasses.RegisterAPatientPageClass;
import com.healthcare.retry.RetryAnalyzer;

public class ActiveVisitsTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientPageClass rp;
	PatientPageClass pp;
	ActiveVisitsPageClass av;

	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "dp", retryAnalyzer = RetryAnalyzer.class)
	public void verifyThePatientIsNotDisplayedInActiveVisitsWhenVisitNotStarted(String uname, String password)
			throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, password);
		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();
		rp = new RegisterAPatientPageClass(driver);
		rp.enterFullName(rp.readStringData(5, 3), rp.readStringData(6, 3));
		rp.selectGender(0);
		rp.enterBirthDate(rp.readIntegerData(7, 1), rp.readIntegerData(8, 1), rp.readIntegerData(9, 1));
		rp.enterAddress(rp.readStringData(10, 1), rp.readStringData(11, 1), rp.readStringData(12, 1),
				rp.readStringData(13, 1), rp.readStringData(14, 1), rp.readIntegerData(15, 1));
		rp.enterPhoneNumber(rp.readIntegerData(16, 1));
		rp.enterPatientRelationship(rp.readStringData(17, 1), 6);
		rp.confirmDetails();
		pp = new PatientPageClass(driver);
		pp.clickOnHomeButton();
		hp.clickOnActiveVisitsTile();
		av = new ActiveVisitsPageClass(driver);
		Boolean actualResult = av.isPatientNameDisplayed(rp.readStringData(5, 3));
		Assert.assertFalse(actualResult);

	}

	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "dp",retryAnalyzer = RetryAnalyzer.class)
	public void verifyThePatientIsInActiveVisitsWhenVisitStarts(String uname, String password) throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, password);
		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();
		rp = new RegisterAPatientPageClass(driver);
		rp.enterFullName(rp.readStringData(5, 3), rp.readStringData(6, 3));
		rp.selectGender(0);
		rp.enterBirthDate(rp.readIntegerData(7, 1), rp.readIntegerData(8, 1), rp.readIntegerData(9, 1));
		rp.enterAddress(rp.readStringData(10, 1), rp.readStringData(11, 1), rp.readStringData(12, 1),
				rp.readStringData(13, 1), rp.readStringData(14, 1), rp.readIntegerData(15, 1));
		rp.enterPhoneNumber(rp.readIntegerData(16, 1));
		rp.enterPatientRelationship(rp.readStringData(17, 1), 6);
		rp.confirmDetails();
		pp = new PatientPageClass(driver);
		pp.clickOnStartVisitLink();
		pp.clickOnStartAVisitConfirmButton();
		pp.clickOnHomeButton();
		hp.clickOnActiveVisitsTile();
		av = new ActiveVisitsPageClass(driver);
		String name = rp.readStringData(5, 3).concat(" ".concat(rp.readStringData(6, 3)));
		Boolean actualResult = av.isPatientNameDisplayed(name);
		System.out.println(rp.readStringData(5, 3).concat(" ".concat(rp.readStringData(6, 3))));
		Assert.assertTrue(actualResult);
	}

}
