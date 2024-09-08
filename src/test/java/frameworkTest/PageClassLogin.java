package frameworkTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageClassLogin extends BaseClassBrowser{
	public PageClassLogin() throws IOException {
		
	}

	WebElement uname=driver.findElement(By.id("uid"));
	WebElement pwd=driver.findElement(By.id("passw"));
	WebElement submit=driver.findElement(By.name("btnSubmit"));

	public void enterusername(String user) {
		uname.sendKeys(user);
	}
	
	public void enterpassword(String password) {
		pwd.sendKeys(password);
	}
	
	public void click() {
		submit.click();
	}
}
