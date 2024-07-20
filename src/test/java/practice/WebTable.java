package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		Thread.sleep(2000);
		// find total row in table
		List <WebElement> row= driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr"));
		System.out.println(row.size());
		
		// find total column in table
		List <WebElement> col= driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr[1]/th"));
		System.out.println(col.size());
		
		// print the web element in list
		for (int r=2;r<=row.size();r++) { // row
			for (int c=2;c<=col.size()-1;c++) {  // column
				String data=driver.findElement(By.xpath("//table[@id='contactList']/tbody/tr["+ r +"]/td["+c +"]")).getText();
				System.out.println(data); // print element
			}
		}
		
	}
	

}
