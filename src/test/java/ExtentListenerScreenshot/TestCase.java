package ExtentListenerScreenshot;

import org.testng.annotations.*;
@Listeners(ListenerClass.class)
public class TestCase extends BaseClass{

	@BeforeTest
	public void setup() {
		BrowserLounch();
	}
	
	@Test
	public void testMethod() {
		driver.findElement(null); // failed to locate
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
}
