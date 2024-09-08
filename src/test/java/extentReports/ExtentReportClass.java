package extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportClass {
	@Test
	public void ExtentReportMethod() throws IOException {
		ExtentReports extentReport=new ExtentReports(); // for create the report
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ExtentReportsFile\\report1.html");
		extentReport.attachReporter(sparkReporter); // for attach both
		ExtentTest test1=extentReport.createTest("Test1"); // for create a test
		test1.pass("This test is pass");
		test1.fail("This test is fail");
		ExtentTest test2=extentReport.createTest("Test2"); // for create a test
		test2.pass("This test is pass");
		test2.fail("<i>This test is fail</i>");
		test2.assignAuthor("QA");
		test2.assignCategory("Automation");
		test2.assignDevice("Window");
		
		// apply a theme
		sparkReporter.config(
				  ExtentSparkReporterConfig.builder()
				    .theme(Theme.DARK)
				    .documentTitle("MyReport")
				    .build());
		Desktop.getDesktop().browse(new File("C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ExtentReportsFile\\report1.html").toURI());
		
		extentReport.flush();
		
	}
	
}
