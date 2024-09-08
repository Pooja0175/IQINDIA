package extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LogExtentReport {
	@Test
	public void ExtentReportMethod() throws IOException {
		ExtentReports extentReport=new ExtentReports(); // for create the report
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ExtentReportsFile\\report2.html");
		extentReport.attachReporter(sparkReporter); // for attach both
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
//		Desktop.getDesktop().browse(new File("C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ExtentReportsFile\\report2.html").toURI());
		extentReport.flush();
		
	}
	
}
