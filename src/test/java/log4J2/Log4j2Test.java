package log4J2;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log4j2Test {
	public static WebDriver driver;
	public Logger log =LogManager.getLogger(Log4j2Test.class);
	@Test
	public void login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.testfire.net/login.jsp");
		log.info("User launch url");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.id("uid")).sendKeys("jsmith");
		log.info("user entered uname");
		WebElement pwd = driver.findElement(By.id("passw"));
		js.executeScript("arguments[0].value='demo1234'", pwd);
		log.info("User entered password");
		driver.findElement(By.name("btnSubmit")).click();
		
		WebElement signoff = driver.findElement(By.xpath("//font[text()='Sign Off']"));
		if (signoff.isDisplayed()) {
//			System.out.println("User Login Successfully");
			log.info("user login successfully");
		} else {
//			System.out.println("Not login");
			log.info("user login failed");
		}
		driver.close();
	}
	
}
