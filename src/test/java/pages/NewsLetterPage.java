package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsLetterPage {

	WebDriver driver;
	public NewsLetterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@value='1']")
	WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement noNewsLetterOption;
	
	public boolean isYesNewsLetterOptionSelected() {
		return yesNewsLetterOption.isSelected();
	}
	public boolean isNoNewsLetterOptionSelected() {
		return noNewsLetterOption.isSelected();
	}
}
