package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDrop {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		driver.get("https://jqueryui.com");
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		WebElement we=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(we);
		WebElement source=driver.findElement(By.id("draggable"));
		Thread.sleep(2000);
		WebElement target=driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, target).build().perform();
		Thread.sleep(5000);
// 		switch to parent frame		
		driver.switchTo().parentFrame();
		
// 		working on draggable option
		driver.findElement(By.xpath("//a[text()='Draggable']")).click();
		
// 		switch to draggable frame option
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
		WebElement drag=driver.findElement(By.id("draggable"));
		act.dragAndDropBy(drag, 0, 100).release().build().perform();
		
	}

}
