package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtil;

public class LogoutPage {

	WebDriver driver;
	ElementUtil elementutils;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtil(driver);
	}
	
	@FindBy(xpath="//h1[text()='Account Logout']")
	WebElement accountLogoutPage;
	
	@FindBy(linkText="Continue")
	WebElement continueButton;
	
	public void clickOnContinueButton() {
		elementutils.clickOnElement(continueButton);
	}
	public boolean displayOfAccountLogOutPage() {
		return elementutils.isElementDisplayed(accountLogoutPage);
		 
	}
}
