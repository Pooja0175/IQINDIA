package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollInJavaScript2 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		set wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		use javaScriptExecutor and do typecasting for driver instance		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.hyrtutorials.com/");
		
//		use as per scroll height
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
// 		click the below element after scroll
		driver.findElement(By.xpath("//a[text()='Yada Giri Reddy ']")).click();
		
		
		

	}

}
