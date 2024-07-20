package seleniumPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	//	ChromeOptions options = new ChromeOptions();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		
		String pwindow=driver.getWindowHandle();
		System.out.println(pwindow);
		driver.findElement(By.xpath("//input[@class='whTextBox']")).sendKeys("Text in Parent window");
		
	//	options.addArguments("--disable-notifications");
		WebElement we=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));	// not working
		Thread.sleep(2000);
		System.out.println(we.isEnabled());
		we.click();
		// use multiple windows
		Set<String> cwindow=driver.getWindowHandles();
		for (String str:cwindow) {
			if (!str.equals(pwindow)) {
				driver.switchTo().window(str);
				Thread.sleep(5000);
				String title=driver.getTitle();
				System.out.println(title);
				driver.findElement(By.id("femalerb")).click();
				driver.close();
				
			}
		}
		
		driver.switchTo().window(pwindow);
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//input[@class='whTextBox']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='whTextBox']")).sendKeys("text in parent after child window");
		driver.quit();
		// code not working
	}

}
