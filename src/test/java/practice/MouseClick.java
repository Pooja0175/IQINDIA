package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons"); // open URL
		WebElement button=driver.findElement(By.id("rightClickBtn"));
		WebElement button2=driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		WebElement button3=driver.findElement(By.xpath("//button[@id='sqDeI']"));
		Actions click=new Actions(driver);
		//click.contextClick(button).perform(); // right click action on button
		Thread.sleep(2000);
		// 2nd action double click on button
		click.doubleClick(button2).perform();
		
		
		
		
		
		

	}

}
