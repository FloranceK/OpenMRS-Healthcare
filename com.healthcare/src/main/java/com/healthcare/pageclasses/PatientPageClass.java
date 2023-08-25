package com.healthcare.pageclasses;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class PatientPageClass {

	WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();
	ExplicitWaitClass explicitWait = new ExplicitWaitClass();

	public PatientPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='PersonName-givenName']")
	WebElement firstName;

	@FindBy(xpath = "//a[contains(@href,'javascript:delPatient')]")
	WebElement deletePatient;

	@FindBy(xpath = "//input[@id='delete-reason']")
	WebElement reasonTextBox;

	@FindBy(xpath = "(//button[contains(text(),'Confirm')])[4]")
	WebElement confirmButton;

	@FindBy(xpath = "//a[@href='/openmrs/index.htm']")
	WebElement homeButton;

	@FindBy(xpath = "//div[contains(text(),'Start Visit')]")
	WebElement startVisitsLink;

	@FindBy(id = "start-visit-with-visittype-confirm")
	WebElement startAVisitConfirmButton;

	@FindBy(id = "referenceapplication.realTime.vitals")
	WebElement captureVitalsLink;

	@FindBy(xpath = "//input[@id='w8']")
	WebElement height;

	@FindBy(id = "next-button")
	WebElement nextButton;

	@FindBy(xpath = "//*[@class='show-details']")
	WebElement showDetailsLink;

	public String getGivenName() {
		return generalUtilities.getTextOfAnElement(firstName);
	}

	public void clickOnDeleteAPatient(String text) {
		generalUtilities.clickOnElement(deletePatient);
		generalUtilities.typeToAnElement(reasonTextBox, text);
		generalUtilities.clickOnElement(confirmButton);
	}

	public void clickOnHomeButton() {
		explicitWait.elementToBeClickableWait(driver, homeButton);
		generalUtilities.clickUsingJs(driver, homeButton);
	}

	public void clickOnStartVisitLink() {
		generalUtilities.clickOnElement(startVisitsLink);
	}

	public void clickOnStartAVisitConfirmButton() {
		explicitWait.elementToBeClickableWait(driver, startAVisitConfirmButton);
		generalUtilities.clickOnElement(startAVisitConfirmButton);
	}

	public void clickOnCaptureVitalsLink() {
		generalUtilities.clickOnElement(captureVitalsLink);

	}

	public void clickOnShowDetailsLink() {
		generalUtilities.clickOnElement(showDetailsLink);
	}
}
