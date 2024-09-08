package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetKundli {
	@Test
	public void getKundliMethod() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.astroyogi.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Kundli")).click();
		driver.findElement(By.className("kundli_form_input")).sendKeys("Pooja Kunwar");
		WebElement we=driver.findElement(By.id("UserGender"));
		Select sl=new Select(we);
		sl.selectByValue("Female");
		WebElement we1=driver.findElement(By.id("Date"));
		Select s12=new Select(we1);
		s12.selectByIndex(12);
		WebElement we2=driver.findElement(By.id("Month"));
		Select sl3=new Select(we2);
		sl3.selectByVisibleText("5");
		WebElement we3=driver.findElement(By.id("Year"));
		Select sl4=new Select(we3);
		sl4.selectByVisibleText("1995");
		WebElement we4=driver.findElement(By.id("Kund_F_BirthPlace_Hour"));
		Select sl5=new Select(we4);
		sl5.selectByVisibleText("1");
		WebElement we5=driver.findElement(By.id("Kund_F_BirthPlace_Minute"));
		Select sl6=new Select(we5);
		sl6.selectByVisibleText("15");
		WebElement we6=driver.findElement(By.id("Kund_F_BirthPlace_AM"));
		Select sl7=new Select(we6);
		sl7.selectByVisibleText("PM");
		driver.findElement(By.xpath("//input[@id='Kund_BirthPlace']")).sendKeys("Gurgaon, Haryana, IN");
		
		
		// use action class 
		Actions act=new Actions(driver);
		WebElement we7=driver.findElement(By.id("ui-id-2"));
		act.keyDown(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		act.keyUp(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Get Your Kundli']")).click();
		
		
		
		
		
		
		
		
	}

}
