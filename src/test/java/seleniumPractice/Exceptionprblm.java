package seleniumPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exceptionprblm{

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		Thread.sleep(2000);
		String pwindow=driver.getWindowHandle();
		System.out.println(pwindow);
		driver.findElement(By.xpath("//input[@class='whTextBox']")).sendKeys("Text in parent window");
		driver.findElement(By.id("newWindowsBtn")).click();
	
		Set<String>cwindow=driver.getWindowHandles();
		for (String str:cwindow) {
			if (!str.equals(pwindow)) {
				driver.switchTo().window(str);
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
	    driver.switchTo().window(pwindow);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='whTextBox']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='whTextBox']")).sendKeys("Text in parent after  child window");
	
	}
	
}	
		