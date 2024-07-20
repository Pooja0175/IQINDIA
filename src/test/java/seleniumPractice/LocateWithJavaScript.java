package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocateWithJavaScript {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		driver.get("http://demo.testfire.net/login.jsp");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('uid').value='jsmith'");
		js.executeScript("document.getElementsByName('passw')[0].value='demo1234'");
		js.executeScript("document.getElementsByTagName('input')[4].click()");
		
		

	}

}
