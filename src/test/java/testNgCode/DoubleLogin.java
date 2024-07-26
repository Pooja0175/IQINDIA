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
	SoftAssert softassert= new SoftAssert();
  @Test
  public void login() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.testfire.net/login.jsp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("uid")).sendKeys("jsmith1");
		driver.findElement(By.id("passw")).sendKeys("demo1234");
		driver.findElement(By.name("btnSubmit")).click();
		boolean bool=driver.findElement(By.xpath("//font[text()='Sign Off']")).isDisplayed();
		System.out.println(bool);
		
		//Assert.assertEquals(bool, true," 1st not login");
		softassert.assertEquals(bool, false, "not login");
		
//		
		// again login
		Thread.sleep(2000);
		driver.findElement(By.id("uid")).sendKeys("jsmith");
		driver.findElement(By.id("passw")).sendKeys("demo1234");
		driver.findElement(By.name("btnSubmit")).click();
//		boolean bool=driver.findElement(By.xpath("//font[text()='Sign Off']")).isDisplayed();
//		System.out.println(bool);
//		Assert.assertEquals(bool, true," 2nd login");
		Thread.sleep(2000);
		driver.close();
		//softassert.assertAll();
	  
	  
  }
}
