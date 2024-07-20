package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentKeyboardOpertation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		Actions act=new Actions(driver);
		
		// locate the address box
		WebElement ca=driver.findElement(By.id("currentAddress"));
		WebElement pa=driver.findElement(By.id("permanentAddress"));
		ca.sendKeys("SuperTech Eco village-2, Greater Noida");
		
		// ctrl+a
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		
		// ctrl+c
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		// change the focus to permanent address
		act.sendKeys(Keys.TAB);
		
		// ctrl+v
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

	}

}
