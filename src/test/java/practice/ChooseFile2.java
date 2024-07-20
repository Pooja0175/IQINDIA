package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChooseFile2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://demoqa.com/upload-download");
		
		//locate obj and choose file
		driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("C:\\Users\\Sheetal\\OneDrive\\Pictures\\Desktop\\java qus.docx");

	}

}
