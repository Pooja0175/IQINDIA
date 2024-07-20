package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		// apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// open url
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		
		// locate button
		driver.findElement(By.id("btn1")).click();
		
		// fill text in textbox
		driver.findElement(By.id("txt1")).sendKeys("First textbox");
		
		// locate 2nd button
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("txt2")).sendKeys("second textbox");
	
		
		
		

	}

}
