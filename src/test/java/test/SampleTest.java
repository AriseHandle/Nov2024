package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (test.Listeners.class)

public class SampleTest {
	@Test
	public void test() {
		System.out.println("test");
	}
	
	@Test (timeOut = 1000)
	public void test1() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("test1");
	}
	
	@Test (dependsOnMethods = "test1")
	public void test2() {
		System.out.println("test2");
	}
	
	
}
