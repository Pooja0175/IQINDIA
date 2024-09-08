package testNgCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleLogin {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	
  @Test
  public void login() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// create object of softassert
		SoftAssert softassert= new SoftAssert();
		
		// open url
		driver.get("http://demo.testfire.net/login.jsp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("uid")).sendKeys("jsmith1");
		driver.findElement(By.id("passw")).sendKeys("demo1234");
		driver.findElement(By.name("btnSubmit")).click();
		String actual = driver.getCurrentUrl();
		String expected = "http://www.altoromutual.com/bank/main.jsp";
		softassert.assertEquals(actual, expected, "url not found");
//		Assert.assertEquals(actual, expected, "url not found");
		
		// again login
		Thread.sleep(2000);
		driver.findElement(By.id("uid")).sendKeys("jsmith");
		driver.findElement(By.id("passw")).sendKeys("demo1234");
		driver.findElement(By.name("btnSubmit")).click();
		softassert.assertAll();
		Thread.sleep(2000);
		driver.close();
		
	  
	  
  }
}
