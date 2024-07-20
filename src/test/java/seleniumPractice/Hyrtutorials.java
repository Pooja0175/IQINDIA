package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyrtutorials {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
	 List<WebElement> ss=driver.findElements(By.xpath("//td[text()>='5000']"));
	 System.out.println(ss.size()); // print size
	 int sum=0;
	 // for get the element and sum of these amt
	 for(WebElement kk : ss) {
		   String vv=kk.getText();
	 		System.out.println(kk.getText());
		   int ll=Integer.parseInt(vv);
		   sum= ll+sum;	     
	 }
	 System.out.println(sum);
	 
	 // use contains function for locate web element 
	 driver.findElement(By.xpath("//a[contains(text(),'into account')]")).click();
	 
	 
	 

	}

}
