package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class Logout extends Base {

	public WebDriver driver;
	HomePage homepage;
	LoginPage loginPage;
	LogoutPage logoutPage;
	AccountPage accountPage;
	@BeforeMethod
	public void setup() {
		
		driver=openBrowserAndApplicationURL();
		homepage=new HomePage(driver);
		loginPage = homepage.navigateToLoginPage();
	}
		
	@Test(priority=1)
	public void verifyLogoutOptionFromMyAccountMenu() {
		loginPage.loginIntoApplication(prop.getProperty("validEmail"), prop.getProperty("password"));
		homepage.clickOnMyaccountDropMenu();
		logoutPage=homepage.clickOnLogoutOption();
		Assert.assertTrue(logoutPage.displayOfAccountLogOutPage());
		logoutPage.clickOnContinueButton();
		Assert.assertEquals(driver.getTitle(), "Your Store");
	}
	
	@Test(priority=2)
	public void verifyLogoutOptionFromRightColumn() {
		accountPage=loginPage.loginIntoApplication(prop.getProperty("validEmail"), prop.getProperty("password"));
		logoutPage=accountPage.clickOnLogoutLinkfromRightColumn();
		Assert.assertTrue(logoutPage.displayOfAccountLogOutPage());
		logoutPage.clickOnContinueButton();
		Assert.assertEquals(driver.getTitle(), "Your Store");
		
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser(driver);
	}
	
}
