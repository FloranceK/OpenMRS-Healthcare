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

import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.pageclasses.FindAPatientPageClass;
import com.healthcare.pageclasses.HomePageClass;
import com.healthcare.pageclasses.LoginPageClass;
import com.healthcare.pageclasses.PatientPageClass;
import com.healthcare.pageclasses.RegisterAPatientPageClass;
import com.healthcare.retry.RetryAnalyzer;

public class RegisterAPatientTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientPageClass rp;
	PatientPageClass pp;
	FindAPatientPageClass fp;

	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "dp", priority = 0,retryAnalyzer = RetryAnalyzer.class)
	public void verifyToRegisterAPatient(String uname, String password) throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, password);
		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();
		rp = new RegisterAPatientPageClass(driver);
		rp.enterFullName(rp.readStringData(5, 2), rp.readStringData(6, 2));
		rp.selectGender(0);
		rp.enterBirthDate(rp.readIntegerData(7, 1), rp.readIntegerData(8, 1), rp.readIntegerData(9, 1));
		rp.enterAddress(rp.readStringData(10, 1), rp.readStringData(11, 1), rp.readStringData(12, 1),
				rp.readStringData(13, 1), rp.readStringData(14, 1), rp.readIntegerData(15, 1));
		rp.enterPhoneNumber(rp.readIntegerData(16, 1));
		rp.enterPatientRelationship(rp.readStringData(17, 1), 6);
		rp.confirmDetails();
		pp = new PatientPageClass(driver);
		String actualResult = pp.getGivenName();
		String expectedResult = rp.readStringData(5, 2);
		AssertJUnit.assertEquals(actualResult, expectedResult);

	}

	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "dp", priority = 1,retryAnalyzer = RetryAnalyzer.class)
	public void verifyToDeleteARegisteredPatient(String uname, String password) throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, password);
		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();
		rp = new RegisterAPatientPageClass(driver);
		String gName = rp.readStringData(5, 1);
		String fName = rp.readStringData(6, 1);
		rp.enterFullName(gName, fName);
		rp.selectGender(0);
		rp.enterBirthDate(rp.readIntegerData(7, 1), rp.readIntegerData(8, 1), rp.readIntegerData(9, 1));
		rp.enterAddress(rp.readStringData(10, 1), rp.readStringData(11, 1), rp.readStringData(12, 1),
				rp.readStringData(13, 1), rp.readStringData(14, 1), rp.readIntegerData(15, 1));
		rp.enterPhoneNumber(rp.readIntegerData(16, 1));
		rp.enterPatientRelationship(rp.readStringData(17, 1), 6);
		rp.confirmDetails();
		pp = new PatientPageClass(driver);
		pp.clickOnDeleteAPatient("no");
		fp = new FindAPatientPageClass(driver);
		Boolean actualResult = fp.isPatientNameDisplayed(gName.concat(" ".concat(fName)));
		System.out.println(gName.concat(fName));
		Assert.assertFalse(actualResult);
		
	}
	
	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "dp", priority = 2,retryAnalyzer = RetryAnalyzer.class)
	public void verifyTheRegisteredPatientIsFoundOrNotInPatientRecordTable(String uname, String password) throws IOException {
		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, password);
		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();
		rp = new RegisterAPatientPageClass(driver);
		String gName = rp.readStringData(5, 7);
		String fName = rp.readStringData(6, 7);
		rp.enterFullName(gName, fName);
		rp.selectGender(0);
		rp.enterBirthDate(rp.readIntegerData(7, 1), rp.readIntegerData(8, 1), rp.readIntegerData(9, 1));
		rp.enterAddress(rp.readStringData(10, 1), rp.readStringData(11, 1), rp.readStringData(12, 1),
				rp.readStringData(13, 1), rp.readStringData(14, 1), rp.readIntegerData(15, 1));
		rp.enterPhoneNumber(rp.readIntegerData(16, 1));
		rp.enterPatientRelationship(rp.readStringData(17, 1), 6);
		rp.confirmDetails();
		pp = new PatientPageClass(driver);
		pp.clickOnHomeButton();
		System.out.println("home button clicked");
		pp.clickOnHomeButton();
		hp.clickOnFindPatientRecord();
		fp = new FindAPatientPageClass(driver);
		Boolean actualResult = fp.isPatientNameDisplayed(gName.concat(" ".concat(fName)));
		System.out.println(gName.concat(" ".concat(fName)));
		Assert.assertTrue(actualResult);
	}

}
