package ExtentListenerScreenshot;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestNGMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver; 
	
	public void BrowserLounch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://demo.testfire.net/login.jsp");
	}
	
	public void captureScreenshot(ITestNGMethod itestngmethod) {
		ExtentReports reports=new ExtentReports();
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ExtentReportsFile\\screenshot.html");
		reports.attachReporter(sparkReporter);
		try {
		String path="C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ScreenShot\\listenerScreenshot.png";
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File targetfile=new File(path);
		FileUtils.copyFile(file, targetfile);
		reports.createTest("Screenshot").addScreenCaptureFromPath(path,"Login page");
				
		}catch(Exception e){
			e.getMessage(); // handle  exception
		}
		reports.flush();
	}
	
}
