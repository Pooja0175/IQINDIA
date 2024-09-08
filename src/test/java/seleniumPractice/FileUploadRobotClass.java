package seleniumPractice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadRobotClass {
	public static void main(String []args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// locate the choose file option
		// file upload krne ke liye sendKeys ka use tbhi krnege jb iski HTML property me iska type=file ho
		// otherwise robot class ka use hoga for file upload
//		driver.findElement(By.id("fileInput")).sendKeys("C:\\Users\\Sheetal\\OneDrive\\Pictures\\Desktop\\Hello.java");
		WebElement button=driver.findElement(By.id("input-4"));
		
		// Create action class
		Actions act=new Actions(driver);
		act.moveToElement(button).click().build().perform();
		
		// robot class
		Robot rb=new Robot();
		rb.delay(5000);
		
		// copy file to clip board
		StringSelection ss=new StringSelection("C:\\\\Users\\\\Sheetal\\\\OneDrive\\\\Pictures\\\\Desktop\\\\Hello.java");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// perform ctrl + v
//		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		// perform enter
//		act.sendKeys(Keys.ENTER).build().perform();
		rb.keyPress(KeyEvent.VK_ENTER);
		
		
		
		
	}
}
