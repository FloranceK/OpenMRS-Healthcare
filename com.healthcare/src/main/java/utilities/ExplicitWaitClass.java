package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {

	public WebDriverWait wait;

	public void presenceOfElementLocatedWaitXPath(WebDriver driver, String xpathValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
	}

	public void presenceOfElementLocatedWaitID(WebDriver driver, String idValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue)));
	}

	public void presenceOfElementLocatedWaitName(WebDriver driver, String nameValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue)));
	}

	public void elementToBeClickableWait(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void elementToBeClickableWaitXPath(WebDriver driver, String xpathValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValue)));
	}

	public void elementToBeClickableWaitID(WebDriver driver, String idValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(idValue)));
	}

	public void elementToBeClickableWaitName(WebDriver driver, String nameValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.name(nameValue)));
	}

	public void alertsPresentWait(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void visiblityOfElementLocatedWaitXPath(WebDriver driver, String xpathValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
	}

	public void visiblityOfElementLocatedWaitId(WebDriver driver, String idValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idValue)));
	}

	public void visiblityOfElementLocatedWaitName(WebDriver driver, String nameValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(nameValue)));
	}

	public void visiblityOfWait(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
