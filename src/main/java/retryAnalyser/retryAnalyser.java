package retryAnalyser;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyser implements IRetryAnalyzer {
	private static int counter = 0;
	private static final int retryLimit = 2;

	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (counter < retryLimit) {
				counter++;
				result.setStatus(ITestResult.SKIP);
				return true;
			} else {
				result.setStatus(ITestResult.FAILURE);
			}
		} else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

	public static int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
