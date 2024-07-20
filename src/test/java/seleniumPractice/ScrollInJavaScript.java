package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollInJavaScript {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		set wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		use javaScriptExecutor and do typecasting for driver instance		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.hyrtutorials.com/");
//		use scroll
		js.executeScript("window.scroll(0,4000)");
		Thread.sleep(5000);
// 		use scrollTo
		js.executeScript("window.scrollTo(0,2000)"); //scroll and scrollTo both are same
		
		Thread.sleep(5000);
//		use scrollBy
		js.executeScript("window.scrollBy(0,1000)");
		

	}

}
