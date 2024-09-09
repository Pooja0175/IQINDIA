package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClass {
	// constructor
	public PageClass (WebDriver driver) {
		PageFactory.initElements(driver,this); // for initialize all element
	}
	// locate the element
	@FindBy(id="uid")
	WebElement uname;
	
	@FindBy(id="passw")
	WebElement password;
	
	@FindBy (name="btnSubmit")
	WebElement submit;
	
	// create method for login page
	public void enterUserName() {
		uname.sendKeys("jsmith");
	}
	
	public void enterPassword() {
		password.sendKeys("demo1234");
	}
	
	public void clickSubmit() {
		submit.click();
	}

}
