package retryLogic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int RetryCount=0;
	int RetryMaxCount=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(RetryCount<RetryMaxCount) {
			RetryCount++;
			 System.out.println("Retrying test " + result.getName() + " again - " + RetryCount);
			return true;
		}
		else {
			return false;
		}
		
	}

}
