package seleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseRightClick {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
//		Locate the element
		WebElement we=driver.findElement(By.xpath("//span[text()='right click me']"));
//		right click of the element
		act.contextClick(we).build().perform();
// 		copy the element
		WebElement we1=driver.findElement(By.xpath("//span[text()='Copy']"));
		act.click(we1).build().perform();
		Thread.sleep(2000);
		Alert al=driver.switchTo().alert();
		al.accept();
		

	}

}
