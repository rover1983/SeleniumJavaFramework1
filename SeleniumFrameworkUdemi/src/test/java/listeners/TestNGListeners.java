package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("********** Test started: "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("********** Test success: "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("********** Test failed: "+result.getName());
	}
	
	public void onTestScipped(ITestResult result) {
		System.out.println("********** Test scipped: "+result.getName());
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("********** "+result.getName());
	}
	
	public void onStart(ITestResult result) {
		System.out.println("********** On start: "+result.getName());
	}
	
	public void onFinish(ITestResult result) {
		System.out.println("********** "+result.getName());
	}
	
	
	

}
