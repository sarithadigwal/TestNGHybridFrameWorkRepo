package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtil;

public class HomePage {

	WebDriver driver;
	ElementUtil elementutil;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutil=new ElementUtil(driver);
	}
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccountDropMenu;
	
	@FindBy(linkText="Register")
	WebElement registerOption;
	
	@FindBy(linkText="Login")
	WebElement login;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public void navigateToRegisterPage() {
		clickOnMyaccountDropMenu();
		selectRegisterOption();
	}
	public void clickOnMyaccountDropMenu() {
		elementutil.clickOnElement(myAccountDropMenu);
	}
	public void selectRegisterOption() {
		elementutil.clickOnElement(registerOption);
	}
	public void clickOnLoginOption() {
		elementutil.clickOnElement(login);
	}
	public LogoutPage clickOnLogoutOption() {
		elementutil.clickOnElement(logout);
		return new LogoutPage(driver);
	}
	
	public LoginPage navigateToLoginPage() {
		clickOnMyaccountDropMenu();
		clickOnLoginOption();
		return new LoginPage(driver);
	}
	
}
