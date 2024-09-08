package ExtentListenerScreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListenerClass extends BaseClass implements ITestListener  {
	
	@Test
	public void onTestFailure(ITestResult result) {
		 System.out.println("Test is failed");
		try {
			captureScreenshot(result.getMethod());
		}catch(Exception e) {
			e.getMessage();
		}
		 
		 
	  }

}
