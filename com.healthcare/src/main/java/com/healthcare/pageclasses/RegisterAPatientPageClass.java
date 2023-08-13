package com.healthcare.pageclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class RegisterAPatientPageClass {

	WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	public RegisterAPatientPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "givenName")
	WebElement givenName;

	@FindBy(name = "familyName")
	WebElement familyName;

	@FindBy(id = "next-button")
	WebElement nextButton;

	@FindBy(id = "gender-field")
	WebElement genderSelect;

	@FindBy(name = "birthdateDay")
	WebElement birthDateDay;

	@FindBy(name = "birthdateMonth")
	WebElement birthDateMonth;

	@FindBy(name = "birthdateYear")
	WebElement birthDateYear;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "cityVillage")
	WebElement cityVillage;

	@FindBy(id = "stateProvince")
	WebElement stateProvince;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "postalCode")
	WebElement postalcode;

	@FindBy(name = "phoneNumber")
	WebElement phoneNumber;

	@FindBy(id = "relationship_type")
	WebElement relationshipDropDown;

	@FindBy(xpath = "//input[contains(@class,'person-typeahead')]")
	WebElement personName;

	@FindBy(id = "submit")
	WebElement confirmButton;

	public void enterFullName(String firstName, String lastName) {
		generalUtilities.typeToAnElement(givenName, firstName);
		generalUtilities.typeToAnElement(familyName, lastName);
		generalUtilities.clickOnElement(nextButton);
	}

	public void selectGender(int index) {
		generalUtilities.selectValueFromDropDownByIndex(genderSelect, index);
		generalUtilities.clickOnElement(nextButton);
	}

	public void enterBirthDate(String day, String value, String year) {
		generalUtilities.typeToAnElement(birthDateDay, day);
		generalUtilities.selectDropDownByValue(birthDateMonth, value);
		generalUtilities.typeToAnElement(birthDateYear, year);
		generalUtilities.clickOnElement(nextButton);
	}

	public void enterAddress(String add1, String add2, String city, String state, String Cntry, String postcode) {
		generalUtilities.typeToAnElement(address1, add1);
		generalUtilities.typeToAnElement(address2, add2);
		generalUtilities.typeToAnElement(cityVillage, city);
		generalUtilities.typeToAnElement(stateProvince, state);
		generalUtilities.typeToAnElement(country, Cntry);
		generalUtilities.typeToAnElement(postalcode, postcode);
		generalUtilities.clickOnElement(nextButton);
	}

	public void enterPhoneNumber(String phone) {
		generalUtilities.typeToAnElement(phoneNumber, phone);
		generalUtilities.clickOnElement(nextButton);
	}

	public void enterPatientRelationship(String person, int index) {
		generalUtilities.selectValueFromDropDownByIndex(relationshipDropDown, index);
		generalUtilities.typeToAnElement(personName, person);
		generalUtilities.clickOnElement(nextButton);
	}

	public void confirmDetails() {
		generalUtilities.clickOnElement(confirmButton);
	}

	public String readStringData(int i, int j) throws IOException {
		return ExcelRead.getStringData(i, j);
	}

	public String readIntegerData(int i, int j) throws IOException {
		return ExcelRead.getIntegerData(i, j);
	}
}
