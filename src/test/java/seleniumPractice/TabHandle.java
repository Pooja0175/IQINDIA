package seleniumPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TabHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String pwindow=driver.getWindowHandle();
		System.out.println(pwindow);
		driver.findElement(By.xpath("//input[@class='whTextBox']")).sendKeys("Text in Parent window");
		driver.wait(5000);
		/*WebElement button=*/driver.findElement(By.xpath("//button[@onclick='newBrowserTab()']")).click();	// not working ,tab handle
			
		// use multiple windows
		Set<String> cwindow=driver.getWindowHandles();
		for (String str:cwindow) {
			if (!str.equals(pwindow)) {
				driver.switchTo().window(str);
				Thread.sleep(2000);
				String title=driver.getTitle();
				System.out.println(title);
				driver.close();
				
			}
		}
		driver.switchTo().window(pwindow);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='whTextBox']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='whTextBox']")).sendKeys("text in parent after chid window");
		driver.close();
		// code not working
	}

}
