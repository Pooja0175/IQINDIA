  package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardOperationTextCopyPaste {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Actions act= new Actions(driver);
		driver.get("https://text-compare.com/");
		Thread.sleep(2000);
		
		// locate the text box
		WebElement input1=driver.findElement(By.id("inputText1"));
		WebElement input2=driver.findElement(By.id("inputText2"));
		input1.sendKeys("This is my automation script");
		
		// ctrl + A
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		
		// ctrl + C
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		
		// change focus to next text box
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		
		// ctrl + V
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		
		// text compare
		String text1=input1.getText();
		String text2=input2.getText();
		
		if (text1.equals(text2)) {
			System.out.println("Test case pass");
		}
		else {
			System.out.println("Test case fail");
		}
		
		
		

	}

}
