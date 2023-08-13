package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void clearAnElement(WebElement element) {
		element.clear();
	}

	public void typeToAnElement(WebElement element, String text) {
		element.sendKeys(text);
	}

	public String getPageCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public Boolean elementIsDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public String getTextOfAnElement(WebElement element) {
		return element.getText();
	}

	public String getAttributeOfAnElement(WebElement element, String attributeType) {
		return element.getAttribute(attributeType);
	}

	public void clickUsingJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToAnElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}
	public void selectValueFromDropDownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectDropDownByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectDropDownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String alertGetText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	public void alertSendKeys(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	public void clickAnElementUsingSendKeys(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(element, Keys.ENTER).build().perform();
	}
	public void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).build().perform();
	}
	
	
}
