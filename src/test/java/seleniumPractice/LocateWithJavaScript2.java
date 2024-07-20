package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocateWithJavaScript2 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		driver.get("http://demo.testfire.net/login.jsp");
		Thread.sleep(2000);
		// locate normal and operation js executor
		WebElement uname=driver.findElement(By.id("uid"));
		js.executeScript("arguments[0].value='jsmith'", uname);
		WebElement pass=driver.findElement(By.name("passw"));
		js.executeScript("arguments[0].value='demo1234'", pass);
		js.executeScript("document.getElementsByTagName('input')[4].click()");
		
		

	}

}
