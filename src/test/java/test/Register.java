package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.NewsLetterPage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register extends Base {
	public WebDriver driver;
	AccountSuccessPage accountsuccesspage;
	AccountPage accountPage;
	NewsLetterPage newsLetterPage;
	@BeforeMethod
	public void setup() {
		driver = openBrowserAndApplicationURL();
		HomePage homepage = new HomePage(driver);
		homepage.navigateToRegisterPage();

	}

	@Test(priority = 2)
	public void verifyRegisterAccountByGivingMandatoryFields() {
		// TODO Auto-generated method stub

		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("firstName"));
		registerpage.enterLastName(prop.getProperty("lastName"));
		registerpage.enterEmail(CommonUtils.generateBrandEmail());
		registerpage.enterTelephone(prop.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("password"));
		registerpage.enterConfirmpassword(prop.getProperty("password"));
		registerpage.selectPrivacyPolicyCheckbox();

		accountsuccesspage = registerpage.clickContinueButton();

		Assert.assertTrue(accountsuccesspage.displayOfLogoutOption());

		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");

		accountsuccesspage.clickOnContinueButton();

		Assert.assertEquals(driver.getTitle(), "My Account");

	}

	@Test(priority = 1)
	public void verifyRegisterAccountByGivingAllFields() {

		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("firstName"));
		registerpage.enterLastName(prop.getProperty("lastName"));
		registerpage.enterEmail(CommonUtils.generateBrandEmail());
		registerpage.enterTelephone(prop.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("password"));
		registerpage.enterConfirmpassword(prop.getProperty("password"));
		registerpage.selectYesSubscribeNewsletter();
		registerpage.selectPrivacyPolicyCheckbox();
		accountsuccesspage=registerpage.clickContinueButton();

		Assert.assertTrue(accountsuccesspage.displayOfLogoutOption());
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");

		accountsuccesspage.clickOnContinueButton();
		Assert.assertEquals(driver.getTitle(), "My Account");
	}

	@Test(priority = 3)
	public void verifyRegisterAccountBySubscribingNewsLetter() {

		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("firstName"));
		registerpage.enterLastName(prop.getProperty("lastName"));
		registerpage.enterEmail(CommonUtils.generateBrandEmail());
		registerpage.enterTelephone(prop.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("password"));
		registerpage.enterConfirmpassword(prop.getProperty("password"));
		registerpage.selectYesSubscribeNewsletter();
		registerpage.selectPrivacyPolicyCheckbox();
		
		accountsuccesspage=registerpage.clickContinueButton();

		accountPage=accountsuccesspage.clickOnContinueButton();

		newsLetterPage=accountPage.clickSubscribeOrUnsubscribeNewsLetter();
		
		Assert.assertEquals(driver.getTitle(), "Newsletter Subscription");
		
		Assert.assertTrue(newsLetterPage.isYesNewsLetterOptionSelected());

	}

	@Test(priority = 4)
	public void verifyRegisterAccountByNotSubscribingNewsletter() {

		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(prop.getProperty("firstName"));
		registerpage.enterLastName(prop.getProperty("lastName"));
		registerpage.enterEmail(CommonUtils.generateBrandEmail());
		registerpage.enterTelephone(prop.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("password"));
		registerpage.enterConfirmpassword(prop.getProperty("password"));
		registerpage.selectNoSubscribeNewsletter();
		registerpage.selectPrivacyPolicyCheckbox();
		accountsuccesspage=registerpage.clickContinueButton();
		
		accountPage=accountsuccesspage.clickOnContinueButton();

		newsLetterPage=accountPage.clickSubscribeOrUnsubscribeNewsLetter();
		Assert.assertEquals(driver.getTitle(), "Newsletter Subscription");

		Assert.assertTrue(newsLetterPage.isNoNewsLetterOptionSelected());

	}

	
	@AfterMethod
	public void tearDown() {
		closeBrowser(driver);
	}
}
