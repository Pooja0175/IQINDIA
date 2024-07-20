package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePractice2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); // driver launched
		driver.manage().window().maximize(); // window maximize
		
		// open url of Hyrtutorials
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		Thread.sleep(2000);
		
		// enter text in main page
		driver.findElement(By.id("name")).sendKeys("Text in main page");
		
		// switch driver focus to frame 3
		driver.switchTo().frame("frm3");
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Text in frame 3");
		
		// switch driver focus frame 3 to child frame 1
		driver.switchTo().frame("frm1"); // frame using by String name or ID
		Thread.sleep(2000);
		
		// locate dropdown
		WebElement dropdown=driver.findElement(By.id("ide"));
		
		// use select class for select drop down
		Select sl=new Select(dropdown);
		sl.selectByIndex(1);
		
		// switch focus parent frame (last previous frame)
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Text in frame 3 afer child frm 1");
		
		// switch to main frame
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.id("name")).clear(); // text clear
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("Text in main page after child frm 3");
		
		

	}

}
