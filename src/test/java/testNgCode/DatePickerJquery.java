package testNgCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerJquery {
  @Test
  public void datePicker() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
	  // open the url
	  driver.get("https://jqueryui.com/datepicker/");
	  
	  // locate the datepicker option
	  driver.findElement(By.xpath("//a[text()='Datepicker']")).click();
	  
	  // switch to frame
	  WebElement frm=driver.findElement(By.className("demo-frame"));
	  driver.switchTo().frame(frm);
	  
	  // Click on date field
	  driver.findElement(By.id("datepicker")).click();
	  
	  // store expected date any variable
	  String expectedDate="25";
	  String expectedMY="December 2025";
	  
	  // Locate month and year
	  String currentMY=driver.findElement(By.className("ui-datepicker-title")).getText();
	  
	  //Compare the actual and expected condition
	  while(true) {
		  if (currentMY.equals(expectedMY)) {
			  driver.findElement(By.xpath("//tbody/tr/td/a[text()="+expectedDate+"]")).click();
			  break;
		  }
		  else {
			  driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		  }
		  currentMY=driver.findElement(By.className("ui-datepicker-title")).getText(); // for updation 
	  }
	 
	  
	 
	  
	  
  }
}
