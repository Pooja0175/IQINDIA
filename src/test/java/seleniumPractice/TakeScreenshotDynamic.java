package seleniumPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotDynamic {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		// Type Casting driver to takescreenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		// set time 
		LocalDateTime ldt= LocalDateTime.now();
		System.out.println(ldt);
		
		// time Format set as per our 
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("ddMMyyHHmmss"); // static method
		String str=ldt.format(dtf);
		
		// open site
		driver.get("https://www.google.co.in/");
		
		// select file store path
		String path="C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ScreenShot\\"+ldt+".png";
		
		// create class of FileOutputStream and use its constructor
		FileOutputStream fos=new FileOutputStream(path);
		
		// take screen shot using base64
		byte []bytearr =ts.getScreenshotAs(OutputType.BYTES);
		fos.write(bytearr);
		driver.close();
		

	}

}
