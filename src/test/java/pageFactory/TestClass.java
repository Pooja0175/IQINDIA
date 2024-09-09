package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	
	public WebDriver driver;
	
	public PageClass pc;
	@Test
	public void userLogin() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		pc=new PageClass(driver);
		driver.get("http://demo.testfire.net/login.jsp");
		Thread.sleep(2000);
		pc.enterUserName();
		pc.enterPassword();
		pc.clickSubmit();
		driver.close();
	}

}
