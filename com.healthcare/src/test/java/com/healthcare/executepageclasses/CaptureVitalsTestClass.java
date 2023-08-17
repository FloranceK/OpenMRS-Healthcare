package com.healthcare.executepageclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.pageclasses.CaptureVitalsPageClass;
import com.healthcare.pageclasses.HomePageClass;
import com.healthcare.pageclasses.LoginPageClass;
import com.healthcare.pageclasses.PatientPageClass;
import com.healthcare.pageclasses.RegisterAPatientPageClass;

public class CaptureVitalsTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatientPageClass rp;
	PatientPageClass pp;
	CaptureVitalsPageClass cv;

	@Test(dataProviderClass = DataProviderLogin.class, dataProvider = "dp")
	public void verifyAllAddVitalDetailsOfRegisteredPatient(String uname, String password) throws IOException {

		lp = new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, password);
		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();
		rp = new RegisterAPatientPageClass(driver);
		rp.enterFullName(rp.readStringData(5, 4), rp.readStringData(6, 4));
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
		pp.clickOnCaptureVitalsLink();
		cv = new CaptureVitalsPageClass(driver);
		cv.enterVitalDetails(rp.readIntegerData(20, 1), rp.readIntegerData(21, 1), rp.readIntegerData(22, 1),
				rp.readIntegerData(23, 1), rp.readIntegerData(24, 1), rp.readIntegerData(25, 1),
				rp.readIntegerData(26, 1), rp.readIntegerData(27, 1));
		pp.clickOnShowDetailsLink();

		String actualResult = cv.getTextOfHeight()
				.concat(cv.getTextOfWeight()
						.concat(cv.getTextOfTemp().concat(
								cv.getTextOfPulse().concat(cv.getTextOfResiratoryRate().concat(cv.getTextOfSystolicBP()
										.concat(cv.getTextOfDiastolicBP().concat(cv.getTextOfOximeterReading())))))));
		System.out.println(actualResult);
		String expectedResult = "168.0 cm60.0 kg40.0 DEG C40 beats/min12120 mmHg80 mmHg95 %";
		Assert.assertEquals(actualResult, expectedResult);

	}
}
