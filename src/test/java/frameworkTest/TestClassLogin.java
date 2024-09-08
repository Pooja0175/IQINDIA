package frameworkTest;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClassLogin extends BaseClassBrowser {
	PageClassLogin pcl;
	
	public TestClassLogin() throws IOException, InterruptedException {
		String browserType = prop.getProperty("browser");
		
		// run with dynamic browser
		if(browserType.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			throw new IllegalArgumentException("Unsupported browser: " + browserType);

		}
		driver.manage().window().maximize();
		String pageurl=prop.getProperty("url");
		driver.get(pageurl);
		Thread.sleep(2000);
		pcl=new PageClassLogin();
	}
	
	@Test
	public void loginTest() {
		String user=prop.getProperty("username");
		String pw=prop.getProperty("password");
		pcl.enterusername(user);
		pcl.enterpassword(pw);
		pcl.click();
	}
	
}
