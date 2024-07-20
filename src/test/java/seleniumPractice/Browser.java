package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
		
	//	WebDriverManager.edgedriver().setup();
	//	WebDriver driver=new EdgeDriver();
		
	    driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://www.hyrtutorials.com/");
		
		

	}

}
