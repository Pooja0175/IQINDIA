package dataFromExcelSheet;

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

public class LogInDataFromExcel {

	@Test (dataProvider="dataSupplierExcel",dataProviderClass=DataSupplierExcelSheet.class)
	public void login(String uname,String pwd) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.testfire.net/login.jsp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("uid")).sendKeys(uname);
		driver.findElement(By.id("passw")).sendKeys(pwd);
		driver.findElement(By.name("btnSubmit")).click();
		boolean signoff = driver.findElement(By.xpath("//font[text()='Sign Off']")).isDisplayed();
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals(signoff, true,"not login");
		softassert.assertAll();
		
		Thread.sleep(3000);
		driver.close();
}
	
}
