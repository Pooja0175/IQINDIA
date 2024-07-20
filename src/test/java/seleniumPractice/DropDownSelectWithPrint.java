package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelectWithPrint {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html"); // open url
		driver.manage().window().maximize(); // window maximize
		Thread.sleep(2000); //wait for second
		WebElement dropdown=driver.findElement(By.id("course")); // find element
		Select sl=new Select(dropdown); // create select class
		List<WebElement> lst=sl.getOptions();
		
		// select option with print text
			for (WebElement we:lst) {
				String str=we.getText();
				System.out.println(str);
				sl.selectByVisibleText(str);
				Thread.sleep(2000);
			}
		

			driver.close();
	}

}
