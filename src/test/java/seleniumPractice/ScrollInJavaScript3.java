package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollInJavaScript3 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		set wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		use javaScriptExecutor and do type casting for driver instance		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.hyrtutorials.com/");
		
// 		locate the element scrollIntoView
		WebElement we=driver.findElement(By.xpath("//a[text()='Yada Giri Reddy ']"));
		js.executeScript("arguments[0].scrollIntoView()",we);
		we.click();
		
		

	}

}
