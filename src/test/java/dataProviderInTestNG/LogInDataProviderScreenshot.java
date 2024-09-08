package dataProviderInTestNG;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogInDataProviderScreenshot {
	public static WebDriver driver;

	@Test (dataProvider="DataDriveLogIn",dataProviderClass=DataSupplierLogIn.class)
	public void login(String uname,String pwd) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// typecasting screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		// set  time
		LocalDateTime ldt=LocalDateTime.now();
		
		// set format as per our req
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddMMyyHHmmss");
		ldt.format(dtf);
		String str=ldt.format(dtf);
		
		// set path for screenshot 
		String path="C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ScreenShot"+str+".png";
		
		// create file class object
		File target=new File(path);
		driver.get("http://demo.testfire.net/login.jsp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("uid")).sendKeys(uname);
		driver.findElement(By.id("passw")).sendKeys(pwd);
		driver.findElement(By.name("btnSubmit")).click();
		WebElement signoff = driver.findElement(By.xpath("//font[text()='Sign Off']"));
		boolean dis=signoff.isDisplayed();
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(dis, true,"not login");
		
		if(!signoff.isDisplayed()) {
			File src=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, target);
		}
		softassert.assertAll();
	}	
		@AfterTest
		public void tearDown()throws Exception {
		Thread.sleep(3000);
		driver.close();
		}
		//not complete
	
}
