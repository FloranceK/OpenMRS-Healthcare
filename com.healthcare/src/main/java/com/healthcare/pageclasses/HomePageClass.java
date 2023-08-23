package com.healthcare.pageclasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class HomePageClass {

	WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h4[contains(text(),'Logged in as Super User')]")
	WebElement successLoginMessage;
	
	@FindBy(xpath = "//a[@class='btn btn-default btn-lg button app big align-self-center']")
	List<WebElement> allTiles;
	
	@FindBy(xpath = "//a[contains(@id,'referenceapplication-registrati')]")
	WebElement registerAPatient;
	
	@FindBy(xpath = "//a[contains(@href,'/openmrs/coreapps/activeVisits.page')]")
	WebElement activeVisitTile;
	
	@FindBy(xpath = "//a[contains(@href,'/openmrs/referenceapplic')]")
	WebElement logoHomePage;
	
	@FindBy(xpath = "//a[contains(@href,'findPatient.page?app=coreapps.findPatient')]")
	WebElement findPatientRecordTile;
	
	
	public String getTextOfWelcomeMessage() {
		return generalUtilities.getTextOfAnElement(successLoginMessage);
	}
	public Boolean isAllTilesDisplayed() {
		for (WebElement element : allTiles) {
			generalUtilities.elementIsDisplayed(element); 
			return true;
		}
		return false;
	}
	public void clickOnRegisterAPatient() {
		generalUtilities.clickOnElement(registerAPatient);
	}
	public void clickOnActiveVisitsTile() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(activeVisitTile));
		
		generalUtilities.clickOnElement(activeVisitTile);
	}
	public Boolean isLogoDisplayedInHomePage() {
		return generalUtilities.elementIsDisplayed(logoHomePage);
	}
	public void clickOnFindPatientRecord() {
		generalUtilities.clickOnElement(findPatientRecordTile);
	}
	
}
