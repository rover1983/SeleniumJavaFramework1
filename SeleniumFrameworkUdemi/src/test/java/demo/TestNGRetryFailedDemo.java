package demo;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {
	
	@Test 
	public void test1() {
		System.out.println("Teest 1");		
	}
	
	@Test
	public void test2() {
		System.out.println("Teest 2");
		int in = 5/0;
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class) 
	public void test3() {
		System.out.println("Teest 3");
		Assert.assertTrue(false);
	}

}
