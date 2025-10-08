package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtil;

public class AccountSuccessPage {

	WebDriver driver;
	ElementUtil elementUtils;
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtil(driver);
	}
	@FindBy(xpath="//aside[@id='column-right']//a[text()='Logout']")
	WebElement logoutOption;
	
	@FindBy(linkText="Continue")
	WebElement continueButton;
	
	public boolean displayOfLogoutOption() {
		
		return elementUtils.isElementDisplayed(logoutOption);
	
	}
	
	public AccountPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton);
		return new AccountPage(driver);
	}
	
}
