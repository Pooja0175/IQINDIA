package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadSendkeys {
	public static void main(String []args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/upload");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// locate the choose file option
		// file upload krne ke liye sendKeys ka use tbhi krnege jb iski HTML property me iska type=file ho
		// otherwise robot class ka use hoga for file upload
		driver.findElement(By.id("fileInput")).sendKeys("C:\\Users\\Sheetal\\OneDrive\\Pictures\\Desktop\\Hello.java");
	}
}
