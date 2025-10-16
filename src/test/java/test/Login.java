package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login extends Base {
	public WebDriver driver;
	HomePage homepage;
	LoginPage loginPage ;
	
	@BeforeMethod
	public void setup() {
		
		driver=openBrowserAndApplicationURL();
		homepage=new HomePage(driver);
		loginPage = homepage.navigateToLoginPage();
		
	}
	@Test(priority=1,groups="login1")
	public void verifyLoginWithValidCredentials() {
		Assert.assertEquals(driver.getTitle(), "Account Login");
		loginPage.loginIntoApplication(prop.getProperty("validEmail"), prop.getProperty("password"));
		Assert.assertEquals(driver.getTitle(), "My Account");
	}
	@Test(priority=2,groups="login2")
	public void verifyLoginwithInvalidCredentials() {
		
		loginPage.enterEmail(CommonUtils.generateBrandEmail());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getWarningMessage(), "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=3,groups="login1")
	public void verifyLoginwithInvalidEmailAndValidPassword() {
		loginPage.enterEmail(CommonUtils.generateBrandEmail());
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getWarningMessage(), "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=4,groups="login2")
	public void verifyLoginwithValidEmailAndInvalidPassword() {
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getWarningMessage(), "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=5,groups="login3")
	public void verifyLoginWithoutEnteringCredentials() {
		loginPage.clickOnLoginButton();
		Assert.assertEquals(loginPage.getWarningMessage(), "Warning: No match for E-Mail Address and/or Password.");
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser(driver);
	}
	
}
