package extentReports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotExtentReport {
	@Test
	public void ExtentReportMethod() throws IOException, Exception {
		ExtentReports extentReport=new ExtentReports(); // for create the report
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ExtentReportsFile\\report3.html");
		extentReport.attachReporter(sparkReporter); // for attach both
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		TakesScreenshot ts=(TakesScreenshot)driver;
		LocalDateTime ldt=LocalDateTime.now();
		DateTimeFormatter myformat=DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String str=ldt.format(myformat);
		String path="C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ScreenShot\\"+str+".png";
		FileOutputStream fos=new FileOutputStream(path);
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		byte []bytearr=ts.getScreenshotAs(OutputType.BYTES);
		fos.write(bytearr);
		extentReport.createTest("Screenshot").addScreenCaptureFromPath(path,"Google page");
		driver.quit();
		
		// write another test
		ExtentTest test=extentReport.createTest("Test Output"); // for create a test
		test.log(Status.INFO, "Test case information")
		.log(Status.FAIL,"<b>Test case fail</b>")
		.log(Status.PASS, "Test case pass")
		.log(Status.SKIP,"Test case skip")
		.log(Status.WARNING,"warning1")
		.log(Status.WARNING,"warning2");
		// print exception in extent report
		try {
		int i=10/0;
		}catch(Exception e) {
//			test.info(e);
			extentReport.createTest("Exception report").info(e);
		}
		
		// print data in JSON format
		String JSONData= "{'name':'QA','Address':'IQ'}";
		test.info(MarkupHelper.createCodeBlock(JSONData,CodeLanguage.JSON));

//		Desktop.getDesktop().browse(new File("C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ExtentReportsFile\\report3.html").toURI());
		extentReport.flush();
		
	}
	
}
