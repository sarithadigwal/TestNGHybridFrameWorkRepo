package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.CommonUtils;

public class MyListners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	WebDriver driver;
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport=CommonUtils.generateExtentReport();
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 extentTest = extentReport.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.PASS, result.getName()+"got Passed.");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName=result.getName();
		extentTest.log(Status.FAIL, testName+"got failed.");
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ScreenshotPath=CommonUtils.TakeScreenshot(driver,testName);
		extentTest.addScreenCaptureFromPath(ScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(Status.SKIP, result.getName()+"got skipped.");
	}

	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
	}

}
