package test;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.CommonUtils;

public class Search extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=openBrowserAndApplicationURL();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	@AfterMethod
	public void tearDown() {
		closeBrowser(driver);
	}

	@Test
	public void searchWithExistingProductName() {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(prop.getProperty("existingProduct"));
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		boolean productStatus=driver.findElement(By.linkText("iMac")).isDisplayed();
		Assert.assertTrue(productStatus);
	}

	@Test
	public void searchWithNonExistingProductName() {
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(prop.getProperty("nonExistingProduct"));
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String ErrorMsg=driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText();
		Assert.assertEquals(ErrorMsg, "There is no product that matches the search criteria.");
	}

	@Test
	public void searchWithOutProvidingAnyProductName() {
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String ErrorMsg=driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).getText();
		Assert.assertEquals(ErrorMsg, "There is no product that matches the search criteria.");
	}

	@Test
	public void searchForProductAfterLogin() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(prop.getProperty("existingProduct"));
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		boolean productStatus=driver.findElement(By.linkText("iMac")).isDisplayed();
		Assert.assertTrue(productStatus);
	}
}
