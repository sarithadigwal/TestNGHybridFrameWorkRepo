package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")).click();
		driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")).sendKeys("whether");
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@id='Alh6id']//ul[@role='listbox']/li"));
		for(WebElement sug:suggestions) {
			System.out.println(sug.getText());
		}
	}

}
