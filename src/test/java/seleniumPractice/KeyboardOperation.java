  package seleniumPractice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardOperation {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Actions act= new Actions(driver);
		driver.get("https://the-internet.herokuapp.com/key_presses");
		Thread.sleep(2000);
		act.sendKeys(Keys.ALT).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_UP).build().perform();
		
		

	}

}
