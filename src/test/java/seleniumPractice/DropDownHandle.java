package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html"); // open url
		driver.manage().window().maximize(); // window maximize
		Thread.sleep(2000); //wait for second
		WebElement dropdown=driver.findElement(By.id("course")); // find element
		Select sl=new Select(dropdown); // create select class
		// select any one option from below methods:-
		sl.selectByIndex(2); 
		Thread.sleep(3000); 
		sl.selectByValue("python");
		Thread.sleep(3000);
		sl.selectByVisibleText("Javascript");
		

	}

}
