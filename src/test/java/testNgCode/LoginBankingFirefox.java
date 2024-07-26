package testNgCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginBankingFirefox {
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static SoftAssert softassert= new SoftAssert();
	
	@BeforeTest
	public void browserLunch(){
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();	
	}
	
  @Test
  public void login() throws InterruptedException {
	
	driver.get("http://demo.testfire.net/login.jsp");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	js=(JavascriptExecutor)driver;
	WebElement uname=driver.findElement(By.id("uid"));
	uname.sendKeys("jsmith1");	
	WebElement pwd=driver.findElement(By.id("passw"));
	js.executeScript("arguments[0].value='demo1234'", pwd);
	driver.findElement(By.name("btnSubmit")).click();
	Thread.sleep(2000);
//	Assert.assertEquals(false,true,"login failed");
	softassert.assertEquals(false, true,"soft not login");
	uname.sendKeys("jsmith");
	pwd.sendKeys("demo1234");
	driver.findElement(By.name("btnSubmit")).click();

	 softassert.assertAll(); 
	 // not complete
  }
  @Test
  public void verify() {
	  WebElement signoff=driver.findElement(By.xpath("//font[text()='Sign Off']"));
	  if(signoff.isDisplayed()) {
		  System.out.println("User Login Sucessfully");
	  }
	  else {
		  System.out.println("Not login");
	  }
  }
  @AfterTest
  public void tearDown() throws Exception {
	  Thread.sleep(4000);
	  driver.close();
  }
  
  
  
  
  
}
