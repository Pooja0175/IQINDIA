package listenerInTestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners (ITestListenerClass.class)
public class ListenerTestCase {

	@Test
	public void test1() {
		System.out.println("inside Test1");
	}
	@Test
	public void test2() {
		System.out.println("inside Test2");
		Assert.assertTrue(false);
	}
	@Test (timeOut=100)
	public void test3() throws Exception {
		Thread.sleep(2000);
		System.out.println("inside Test3");
	}
	@Test (dependsOnMethods="test3")
	public void test4() {
		System.out.println("inside Test4");
	}
	
}
