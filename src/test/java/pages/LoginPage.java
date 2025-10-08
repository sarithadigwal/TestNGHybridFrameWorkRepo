package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtil;

public class LoginPage {

	WebDriver driver;
	ElementUtil elementutils;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtil(driver);
	}
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[text()='Warning: No match for E-Mail Address and/or Password.']")
	WebElement warnMessage;
	
	public String getWarningMessage() {
		String warnText=elementutils.getTextFromElement(warnMessage);
		return warnText;
		
	}
	
	public AccountPage loginIntoApplication(String email,String password) {
		enterEmail(email);
		enterPassword(password);
		clickOnLoginButton();
		return new AccountPage(driver);
		
	}
	public void enterEmail(String text) {
		elementutils.enterTextIntoElement(email, text);
	}
	public void enterPassword(String text) {
		elementutils.enterTextIntoElement(password, text);
	}
	public void clickOnLoginButton() {
		elementutils.clickOnElement(loginButton);
	}
}
