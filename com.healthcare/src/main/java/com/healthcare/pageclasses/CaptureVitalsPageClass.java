package com.healthcare.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class CaptureVitalsPageClass {

	WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	public CaptureVitalsPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='w8']")
	WebElement height;

	@FindBy(id = "next-button")
	WebElement nextButton;

	@FindBy(id = "w10")
	WebElement weight;

	@FindBy(id = "w12")
	WebElement temperature;

	@FindBy(id = "w14")
	WebElement pulse;

	@FindBy(id = "w16")
	WebElement respiratoryRate;

	@FindBy(id = "w18")
	WebElement bp1;

	@FindBy(id = "w20")
	WebElement bp2;

	@FindBy(id = "w22")
	WebElement pulseOximeterValue;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;

	@FindBy(xpath = "//*[text()='168.0 cm']")
	WebElement heightDisplayed;

	@FindBy(xpath = "//*[contains(text(),'60.0 kg')]")
	WebElement weightDisplayed;

	@FindBy(xpath = "//*[contains(text(),'40.0 DEG C')]")
	WebElement tempDisplayed;

	@FindBy(xpath = "//*[text()='40 beats/min']")
	WebElement pulseDisplayed;

	@FindBy(xpath = "//*[text()='12']")
	WebElement respiratoryRateDisplayed;

	@FindBy(xpath = "//*[text()='120 mmHg']")
	WebElement systolicBPDisplayed;

	@FindBy(xpath = "//*[text()='80 mmHg']")
	WebElement DiastolicBPDisplayed;

	@FindBy(xpath = "//*[text()='95 %']")
	WebElement oximeterReadingDisplayed;

	public void enterVitalDetails() {
		generalUtilities.typeToAnElement(height, "168");
		generalUtilities.clickOnElement(nextButton);
		generalUtilities.typeToAnElement(weight, "60");
		generalUtilities.clickOnElement(nextButton);
		generalUtilities.clickOnElement(nextButton);
		generalUtilities.typeToAnElement(temperature, "40");
		generalUtilities.clickOnElement(nextButton);
		generalUtilities.typeToAnElement(pulse, "40");
		generalUtilities.clickOnElement(nextButton);
		generalUtilities.typeToAnElement(respiratoryRate, "12");
		generalUtilities.clickOnElement(nextButton);
		generalUtilities.typeToAnElement(bp1, "120");
		generalUtilities.typeToAnElement(bp2, "80");
		generalUtilities.clickOnElement(nextButton);
		generalUtilities.typeToAnElement(pulseOximeterValue, "95");
		generalUtilities.clickOnElement(nextButton);
		generalUtilities.clickOnElement(saveButton);

	}

	public String getTextOfHeight() {
		
		return generalUtilities.getTextOfAnElement(heightDisplayed);
	}

	public String getTextOfWeight() {
		generalUtilities.scrollToAnElement(driver, weightDisplayed);
		return generalUtilities.getTextOfAnElement(weightDisplayed);
	}

	public String getTextOfTemp() {
		generalUtilities.scrollToAnElement(driver, tempDisplayed);
		return generalUtilities.getTextOfAnElement(tempDisplayed);
	}

	public String getTextOfPulse() {
		generalUtilities.scrollToAnElement(driver, pulseDisplayed);
		return generalUtilities.getTextOfAnElement(pulseDisplayed);
	}

	public String getTextOfResiratoryRate() {
		generalUtilities.scrollToAnElement(driver, respiratoryRateDisplayed);
		return generalUtilities.getTextOfAnElement(respiratoryRateDisplayed);
	}

	public String getTextOfSystolicBP() {
		generalUtilities.scrollToAnElement(driver, systolicBPDisplayed);
		return generalUtilities.getTextOfAnElement(systolicBPDisplayed);
	}

	public String getTextOfDiastolicBP() {
		generalUtilities.scrollToAnElement(driver, DiastolicBPDisplayed);
		return generalUtilities.getTextOfAnElement(DiastolicBPDisplayed);
	}

	public String getTextOfOximeterReading() {
		generalUtilities.scrollToAnElement(driver, oximeterReadingDisplayed);
		return generalUtilities.getTextOfAnElement(oximeterReadingDisplayed);
	}

}
