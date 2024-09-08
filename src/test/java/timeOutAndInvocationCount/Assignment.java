package timeOutAndInvocationCount;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {
	@Test (timeOut=12000,invocationCount=3 )
	public void timeOutAndInvocation() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Open url
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);
		//locate & print random user name
		String title=driver.findElement(By.id("user_title")).getText();
		String uname=driver.findElement(By.id("user_value")).getText();
		System.out.println(title+" "+uname);
		
		Thread.sleep(2000);
		driver.close();
		
		
	}
	
}
