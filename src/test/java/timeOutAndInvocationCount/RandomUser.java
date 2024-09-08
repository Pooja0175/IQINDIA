package timeOutAndInvocationCount;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class RandomUser {
		WebDriver driver;
		@BeforeMethod
		public void sintu() {
		 WebDriverManager.chromedriver().setup();
	     driver=new ChromeDriver();
//	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	     driver.manage().window().maximize();
		}
		@Test (invocationCount=3)
		public void komal() throws InterruptedException {
			 driver.get("https://randomuser.me/");
//			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 Thread.sleep(3000);
			 
			 WebElement ss2= driver.findElement(By.xpath("//p[@id='user_title']"));
			 WebElement ss3= driver.findElement(By.xpath("//p[@id='user_value']"));
			 String title=ss2.getText();
			 String name=ss3.getText();
			 
	         System.out.println(title+" "+name);
	         driver.navigate().refresh();
	         
	         driver.close();
		}
	           
	    
}
	
	

