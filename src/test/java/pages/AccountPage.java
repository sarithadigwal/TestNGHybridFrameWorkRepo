package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtil;

public class AccountPage {

	WebDriver driver;
	ElementUtil elementutils;
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtil(driver);
	}
	@FindBy(xpath="//a[text()='Subscribe / unsubscribe to newsletter']")
	WebElement subscribeOrUnsubscribeNewsletter;
	
	@FindBy(xpath="//div[@class='list-group']/a[text()='Logout']")
	WebElement logoutLink;
	
	public NewsLetterPage clickSubscribeOrUnsubscribeNewsLetter() {
		elementutils.clickOnElement(subscribeOrUnsubscribeNewsletter);
		return new NewsLetterPage(driver);
	}
	public LogoutPage clickOnLogoutLinkfromRightColumn() {
		elementutils.clickOnElement(logoutLink);
		return new LogoutPage(driver);
	}
}
