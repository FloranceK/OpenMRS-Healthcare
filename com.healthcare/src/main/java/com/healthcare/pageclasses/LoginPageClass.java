package com.healthcare.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPageClass {

	WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//li[text()='Registration Desk']")
	WebElement registrationDesk;
	@FindBy(id = "loginButton")
	WebElement loginButton;
	@FindBy(xpath = "//div[@id='error-message']")
	WebElement unsuccessfulMessage;
	

	public void loginAsRegistrationDesk(String uname, String passwrd) {
		generalUtilities.typeToAnElement(username, uname);
		generalUtilities.typeToAnElement(password, passwrd);
		generalUtilities.clickOnElement(registrationDesk);
		generalUtilities.clickOnElement(loginButton);
	}

	public String getUnsuccessfulLoginMessageForRegDesk() {

		return generalUtilities.getTextOfAnElement(unsuccessfulMessage);

	}
	
	public String getURLOfLoginPage() {
		
		return generalUtilities.getPageCurrentUrl(driver);
	}
	


}