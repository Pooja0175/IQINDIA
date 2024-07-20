package seleniumPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot3 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		// Type Casting driver to takescreenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		// open site
		driver.get("https://www.google.co.in/");
		
		// select file store path
		String path="C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ScreenShot\\image3.png";
		
		// create class of FileOutputStream and use its constructor
		FileOutputStream fos=new FileOutputStream(path);
		
		// take screen shot using base64
		byte []bytearr =ts.getScreenshotAs(OutputType.BYTES);
		fos.write(bytearr);
		driver.close();
		

	}

}
