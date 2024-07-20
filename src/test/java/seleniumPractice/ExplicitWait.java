package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
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

}
