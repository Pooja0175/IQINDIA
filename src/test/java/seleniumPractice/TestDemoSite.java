package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDemoSite {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("http://altoro.testfire.net/login.jsp");
		driver.findElement(By.id("uid")).sendKeys("jsmith");
		//driver.findElement(By.name("passw")).sendKeys("demo1234");
		driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td[2]/div/form/table/tbody/tr[2]/td[2]/input")).sendKeys("demo1234");
		driver.findElement(By.name("btnSubmit")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Transfer Funds")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("View Recent")).click();
		Thread.sleep(1000);
		driver.findElement(By.tagName("img")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("subheader")).click();
		Thread.sleep(2000);
		driver.close();
		

	}

}
