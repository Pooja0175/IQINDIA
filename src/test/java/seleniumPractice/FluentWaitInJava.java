package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitInJava {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Wait<WebDriver> wait= new FluentWait(driver).withTimeout(Duration.ofSeconds(10))
							.pollingEvery(Duration.ofSeconds(1))
							.ignoring(NoSuchElementException.class)
							.ignoring(ElementNotInteractableException.class);
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.findElement(By.id("btn1")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt1"))).sendKeys("New text");
		driver.findElement(By.id("btn2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2"))).sendKeys("second text");
						
		
								
								
						

	}

}
