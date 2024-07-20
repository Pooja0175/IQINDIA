package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseWithResize {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		// create the actions class
		Actions act=new Actions(driver);
		driver.get("https://jqueryui.com");
		Thread.sleep(2000);
		// click the resize option
		driver.findElement(By.xpath("//a[text()='Resizable']")).click();
		Thread.sleep(2000);
		// switch to frame
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		Thread.sleep(5000);
		// resize the box
		WebElement we=driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		act.dragAndDropBy(we, 300, 100).build().perform();
		
		// switch to the parent frame
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		
		// click on sortable option
		driver.findElement(By.xpath("//a[text()='Sortable']")).click();
		
		// switch to sortable frame
		WebElement sframe=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(sframe);
		Thread.sleep(3000);
		
		// short the list
		WebElement source=driver.findElement(By.xpath("//ul[@id='sortable']/child::li[1]"));
		//WebElement target=driver.findElement(By.xpath("//ul[@id='sortable']/child::li[4]"));
		//act.clickAndHold(source).moveToElement(target).release().build().perform(); // not working
         	act.dragAndDropBy(source, 0, 130).build().perform();


	}

}
