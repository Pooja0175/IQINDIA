package testNgCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	WebDriver driver;
	
  @Test
  public void datePickerInSelenium() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	// locate date picker
	driver.findElement(By.id("datepicker")).click();
	
	// create expected date
	String expectedDate="19";
	String expectedMonth="May";
	String expectedYear="2025";
	
	// Locate current month and year
	while(true) {
	String currentMonth=driver.findElement(By.className("ui-datepicker-month")).getText();
	String currentYear=driver.findElement(By.className("ui-datepicker-year")).getText();
	
	// compare with expected date
		if (currentMonth.equals(expectedMonth)&& currentYear.equals(expectedYear)) {
			List<WebElement>dayList=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
			
			for(WebElement day:dayList) {
				String calenderDay=day.getText();
				if(calenderDay.equals(expectedDate)) {
					day.click();
					break;
				}
			}
			break;
		}
		else {
			driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span")).click();
		}
	}
	  
  }	
//  @AfterTest
//  public void  windowClose() throws Exception {
//	  Thread.sleep(5000);
//	  driver.close();
//  }
  
  
  
  
}
