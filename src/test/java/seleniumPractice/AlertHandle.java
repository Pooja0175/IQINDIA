package seleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		Thread.sleep(4000);
		
		// locate the web element
		driver.findElement(By.id("alertBox")).click();	// for simple alert
//		driver.findElement(By.id("confirmBox")).click();	// for confirmation alert
//		driver.findElement(By.id("promptBox")).click();		// for prompt alert mens given any input then confirm
		Thread.sleep(2000);
		
		//switch driver to alert 
		Alert al=driver.switchTo().alert();
//		al.sendKeys("Test"); // for prompt pop-up
		al.accept();
		WebElement output=driver.findElement(By.xpath("//div[@id='output']"));
		System.out.println(output.getText());
		
					

	}

}
