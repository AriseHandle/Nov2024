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
	
	@Test
	public void demo() {
		System.out.println("Demo");
	}
	
	@Test
	public void Test4() {
		System.out.println("test4");
	}
	
}
