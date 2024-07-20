package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//open URL
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		Thread.sleep(2000);
		
		// find element
		WebElement company=driver.findElement(By.xpath("//td[text()='Canada']/preceding-sibling::td[2]"));
		
		// print company name
		System.out.println(company.getText());
		driver.close();
	}

}
