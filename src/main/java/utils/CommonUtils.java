package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class CommonUtils {
	public static  String generateBrandEmail() {
		String email="saritha"+System.currentTimeMillis()+"@gmail.com";
		return email;
	}
	public static String TakeScreenshot(WebDriver driver,String testName) {
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File srcScreenshot=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String ScreenshotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot, new File(ScreenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ScreenshotPath;
	}
	public static ExtentReports generateExtentReport() {
		ExtentReports extentReport=new ExtentReports();
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"\\Reports\\ExtentReport.html"));
		ExtentSparkReporterConfig config=sparkReporter.config(); 
		config.setDocumentTitle("TutorialNinja");
		config.setReportName("TestReport");
		
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("UserName", "SarithaDigwal");
		return extentReport;
	}
	public static Properties loadPropertyFile() {
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
