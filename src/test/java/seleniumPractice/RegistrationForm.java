package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationForm {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.india.gov.in/user/register");
		WebElement country=driver.findElement(By.id("edit-profile-main-field-country-und"));
		Select dropdown=new Select(country);
		dropdown.selectByVisibleText("Afghanistan"); // print any country
		List<WebElement> allvalue=dropdown.getOptions();
		System.out.println(allvalue.size()); //247
		for(WebElement name:allvalue) {
			System.out.println(name.getText());
		}
		
	}

}
