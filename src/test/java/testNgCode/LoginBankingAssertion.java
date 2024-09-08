package testNgCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginBankingAssertion {
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static SoftAssert softassert= new SoftAssert();

	@BeforeTest
	public void login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.testfire.net/login.jsp");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		js = (JavascriptExecutor) driver;
		driver.findElement(By.id("uid")).sendKeys("jsmith");
		WebElement pwd = driver.findElement(By.id("passw"));
		js.executeScript("arguments[0].value='demo1234'", pwd);
		driver.findElement(By.name("btnSubmit")).click();
	}

	@Test
	public void personalDetails() throws Exception {
		String actual = driver.findElement(By.xpath("//h1[starts-with(text(), 'Hello')]")).getText();
		String expected = "Hello";
		System.out.println(actual);
		softassert.assertEquals(actual,expected,"name not found"); // soft assert
//		Assert.assertEquals(actual,expected,"name not found"); // hard assert
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='PERSONAL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Deposit Product']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='contact Altoro Mutual']")).click();
		WebElement we = driver.findElement(By.xpath("//h1[text()='Contact Us']"));
		System.out.println(we.getText());
		// go to small business
		js.executeScript("document.getElementById('LinkHeader3').click()");
		Thread.sleep(2000);
		WebElement sb = driver.findElement(By.xpath("//h1[text()='Small Business']"));
		System.out.println(sb.getText());
		softassert.assertAll();
	}


	@Test
	public void verify() {
		WebElement signoff = driver.findElement(By.xpath("//font[text()='Sign Off']"));
		if (signoff.isDisplayed()) {
			System.out.println("User Login Sucessfully");
		} else {
			System.out.println("Not login");
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(4000);
		driver.close();
	}

}
