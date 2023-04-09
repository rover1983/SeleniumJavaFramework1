package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
	@Test(dependsOnMethods= {"test2"})
	public void test1() {
		System.out.println("Method 1");
	}

	@Test(dependsOnGroups= {"load"})
	public void test2() {
		System.out.println("Method 2");
	}
	
	@Test(groups={"load"})
	public void test3() {
		System.out.println("Method 3");
	}

}
