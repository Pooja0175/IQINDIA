package seleniumPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassMouseHover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		Actions act=new Actions(driver);
		driver.get("https://www.flipkart.com/");
		String pwindow = driver.getWindowHandle();
		
// 		choose the dress		
		WebElement we=driver.findElement(By.xpath("//span[text()='Fashion']"));
		act.moveToElement(we).build().perform();
		WebElement we1=driver.findElement(By.xpath("//a[text()='Women Ethnic']"));
		act.moveToElement(we1).build().perform();
		WebElement we2=driver.findElement(By.xpath("//a[text()='Ethnic Dresses']"));
		act.click(we2).build().perform();
		driver.findElement(By.xpath("//a[@title='Women Printed Pure Cotton Ethnic Dress']")).click();
		
//		switch to new tab
		Set<String> cwindow=driver.getWindowHandles();
		for (String str:cwindow) {
			if (!str.equals(pwindow)) {
				driver.switchTo().window(str);
//				get the price of dress				
				WebElement we3=driver.findElement(By.xpath("//div[@class='Nx9bqj CxhGGd']"));
				System.out.println(we3.getText());
//				add to cart dress
				//js.executeScript("window.scrollIntoView");
				//driver.findElement(By.xpath("//button[text()='Buy Now']")).click(); // not working
				WebElement webuy=driver.findElement(By.className("QqFHMw vslbG+ _3Yl67G _7Pd1Fp"));
				js.executeScript("arguments[0].scrollIntoView()",webuy);
				webuy.click();
				// uncomplete
			}

		}
 		
		
		
	}

}
