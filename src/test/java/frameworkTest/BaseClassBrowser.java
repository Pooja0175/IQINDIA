package frameworkTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassBrowser {
	public static WebDriver driver;
	public static Properties prop;
	public BaseClassBrowser() throws IOException {
		prop=new Properties(); // create a object of properties 
		String path="C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\Data.properties"; // path of data file
		File f=new File(path); // for create file instance
		if (f.exists()) {
			System.out.println("file exists");
		}
		else {
			System.out.println("Not exists");
		}
		FileInputStream fis=new FileInputStream(f); // read the file
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		
	}
//	@BeforeTest
//	public void browser() {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		String pageurl=prop.getProperty("url");
//		driver.get(pageurl);
//	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
}
