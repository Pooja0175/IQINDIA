package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterHyrtutorials {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();;
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		driver.findElement(By.xpath("//div[@class='container']/child::input[1]")).sendKeys("Anshika"); // name
		driver.findElement(By.xpath("//div[@class='container']/descendant::input[2]")).sendKeys("Singh"); // last name
		driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input[1]")).sendKeys("anshika1234@gmail.com"); // email
		driver.findElement(By.xpath("(//div/input[@type='password'])[1]")).sendKeys("Anshu@1234"); // password
		driver.findElement(By.xpath("//label[@for='psw-repeat']/following-sibling::input[@type='password'] ")).sendKeys("Anshu@1234"); // reconfirm
		Thread.sleep(4000);
	//	WebElement button=driver.findElement(By.xpath("//div[@class='container']/descendant::input[@name='refreshbtn']")); 
		WebElement button=driver.findElement(By.xpath("//button[text()='Reset']/preceding-sibling::button[@type='reset']"));
	//	WebElement button=driver.findElement(By.xpath("//div[@class='buttons']/child::button[text()='Reset']"));
		//WebElement button=driver.findElement(By.xpath("//div[@class='buttons']/child::button[text()='Register']")); // not working
		button.click();
		String ss=button.getText();
		System.out.println("You have clicked on "+ ss);
		

	}

}
