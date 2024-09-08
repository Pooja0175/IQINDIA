package testNgCode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupTestCase {
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static SoftAssert softassert= new SoftAssert();

	@BeforeTest
	public void BrowserLunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test (enabled=true,priority=1)
	public void login() {
		
		driver.get("http://demo.testfire.net/login.jsp");
		js = (JavascriptExecutor) driver;
		driver.findElement(By.id("uid")).sendKeys("jsmith");
		WebElement pwd = driver.findElement(By.id("passw"));
		js.executeScript("arguments[0].value='demo1234'", pwd);
		driver.findElement(By.name("btnSubmit")).click();
	}

	@Test (enabled=false)
	public void personalDetails() throws Exception {
		String actual = driver.findElement(By.xpath("//h1[starts-with(text(), 'Hello')]")).getText();
		String expected = "Hello";
		System.out.println(actual);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='PERSONAL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Deposit Product']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='contact Altoro Mutual']")).click();
		WebElement we = driver.findElement(By.xpath("//h1[text()='Contact Us']"));
		System.out.println(we.getText());

	}

	@Test
	public void smallBusiness() throws Exception {
		js.executeScript("document.getElementById('LinkHeader3').click()");
		Thread.sleep(2000);
		WebElement sb = driver.findElement(By.xpath("//h1[text()='Small Business']"));
		System.out.println(sb.getText());
	}
	@Test (enabled=false)
	public void explicitWait() {
		// apply Explicit wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		
		// open url
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		
		// locate button
		driver.findElement(By.id("btn1")).click();
		
		// 1st way to apply wait in fill text in textbox
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt1"))).sendKeys("first box");
		
		// 2nd way to apply wait in locate 2nd button
		driver.findElement(By.id("btn2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2"))).sendKeys("second box");
	}
	@Test
	public void checkBox() throws InterruptedException {
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='Austria']/preceding-sibling::td[2]/child::input[@type='checkbox']")).click();
	}
	@Test
	public void alertHandle() throws Exception {
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		Thread.sleep(4000);
		
		// locate the web element
		driver.findElement(By.id("alertBox")).click();	// for simple alert
		Thread.sleep(2000);
		
		//switch driver to alert 
		Alert al=driver.switchTo().alert();
		al.accept();
	}
	

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(4000);
		driver.close();
	}

}
