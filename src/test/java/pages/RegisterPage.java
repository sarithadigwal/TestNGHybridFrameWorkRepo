package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtil;

public class RegisterPage {

	WebDriver driver;
	ElementUtil elementUtils;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtil(driver);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='confirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacyPolicyCheckbox;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//label[text()='Yes']")
	WebElement subscribeYesNewsLetterCheckbox;

	@FindBy(xpath = "//label[text()='No']")
	WebElement subscribeNoNewsLetterCheckbox;

	public void enterFirstName(String firstNameText) {
		elementUtils.enterTextIntoElement(firstName, firstNameText);
	}

	public void enterLastName(String lastNameText) {
		elementUtils.enterTextIntoElement(lastName, lastNameText);
		
	}

	public void enterEmail(String emailText) {
		elementUtils.enterTextIntoElement(email, emailText);
		
	}

	public void enterTelephone(String telephoneText) {
		elementUtils.enterTextIntoElement(telephone, telephoneText);
	}

	public void enterPassword(String passwordText) {
		elementUtils.enterTextIntoElement(password, passwordText);
	}

	public void enterConfirmpassword(String confirmPasswordText) {
		elementUtils.enterTextIntoElement(confirmPassword, confirmPasswordText);
	}

	public void selectPrivacyPolicyCheckbox() {
		elementUtils.clickOnElement(privacyPolicyCheckbox);
	}

	public AccountSuccessPage clickContinueButton() {
		elementUtils.clickOnElement(continueButton);
		return new AccountSuccessPage(driver);
	}

	public void selectYesSubscribeNewsletter() {
		elementUtils.clickOnElement(subscribeYesNewsLetterCheckbox);
		
	}

	public void selectNoSubscribeNewsletter() {
		elementUtils.clickOnElement(subscribeNoNewsLetterCheckbox);
		
	}

}