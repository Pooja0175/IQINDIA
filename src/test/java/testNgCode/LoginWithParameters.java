package testNgCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithParameters {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
  @Parameters ({"login","password"})	
  @Test
  public void login(String lgn,String pwd) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// create object of softassert
		SoftAssert softassert= new SoftAssert();
		
		// open url
		driver.get("http://demo.testfire.net/login.jsp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("uid")).sendKeys(lgn);
		driver.findElement(By.id("passw")).sendKeys(pwd);
		driver.findElement(By.name("btnSubmit")).click();
		String actual = driver.getCurrentUrl();
		String expected = "http://www.altoromutual.com/bank/main.jsp";
		softassert.assertEquals(actual, expected, "url not found");
//		Assert.assertEquals(actual, expected, "url not found");
		softassert.assertAll();
  }
		@AfterTest
		public void tearDown() throws Exception {
			Thread.sleep(4000);
			driver.close();
		}
		
	  
	  
  
}
