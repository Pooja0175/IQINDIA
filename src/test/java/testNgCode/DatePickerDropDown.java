package testNgCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDropDown {
  @Test
  public void DatePicker() {
	  
	  WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		// click on date filed
		driver.findElement(By.id("third_date_picker")).click();
		
		// explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement we=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		
		// store expected date
		String ExpectedDate="15";
		String ExpectedMonth="Dec";
		String ExpectedYear="2020";
		
		// locate year and month
		WebElement month= driver.findElement(By.className("ui-datepicker-month"));
		
		Select select1=new Select(month);
		select1.selectByVisibleText(ExpectedMonth);
		
		WebElement year = driver.findElement(By.className("ui-datepicker-year"));
		Select select2=new Select(year);
		select2.selectByVisibleText(ExpectedYear);
		
		// click on date
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()="+ExpectedDate+"]")).click();
		
		
	  
  }
}
