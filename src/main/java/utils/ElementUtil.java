package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTextFromElement(WebElement element) {
		String text ="";
		if(isElementDisplayed(element)) {
			text=element.getText();
		}
		return text;
	}

	public void clickOnElement(WebElement element) {

		if(isElementDisplayed(element)&&isElementEnabled(element)) {
			element.click();
		}
	}
	public void enterTextIntoElement(WebElement element,String text) {
		if(isElementDisplayed(element) && isElementEnabled(element)) {
			element.clear();
			element.sendKeys(text);
		}
	}
	public boolean isElementDisplayed(WebElement element) {
		boolean b = false;
		try {
			b = element.isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	public boolean isElementEnabled(WebElement element) {

		boolean b = false;
		if (isElementDisplayed(element)) {
			b = element.isEnabled();
		}
		return b;
	}
}
