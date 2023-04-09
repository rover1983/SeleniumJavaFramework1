package demo;

import org.testng.annotations.Test;

public class TestNGGroupsDemo {
	
	@Test(groups={"sanity"})
	public void test1() {
		System.out.println("C'est l'épreuve 1 [се лепг1ёв ан]");
	}
	@Test(groups={"smoke", "regression"})
	public void test2() {
		System.out.println("C'est l'épreuve 2");
	}
	@Test(groups={"sanity"})
	public void test3() {
		System.out.println("C'est l'épreuve 3");
	}
	@Test(groups={"regression"})
	public void test4() {
		System.out.println("C'est l'épreuve 4");
	}
	@Test
	public void test5() {
		System.out.println("C'est l'épreuve 5");
	}

}
