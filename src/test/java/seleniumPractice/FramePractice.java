package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); // driver launched
		driver.manage().window().maximize(); // window maximize
		
		// open url of Hyrtutorials
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		Thread.sleep(2000);
		
		// enter text in main page
		driver.findElement(By.id("name")).sendKeys("Text in main page");
		
		// calculate count of frame in HTML dom page
		int size=driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total no of frame is "+size);
		
		// switch driver focus to frame 1
		WebElement frm=driver.findElement(By.id("frm1")); // 1st way frame using webelement
		driver.switchTo().frame(frm); 
//		driver.switchTo().frame("frm1"); // 2nd way frame using by String name or ID
		Thread.sleep(2000);
		
		// locate dropdown
		WebElement dropdown=driver.findElement(By.id("selectnav1"));
		
		// use select class for select drop down
		Select sl=new Select(dropdown);
		sl.selectByIndex(5);
		
		// switch to parent frame(last previous frame)
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		driver.findElement(By.id("name")).clear(); // text clear
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("Text in main page after child");
		
		

	}

}
