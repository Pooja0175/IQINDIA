package seleniumPractice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighLightText {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		TakesScreenshot ts=(TakesScreenshot)driver;
		String path="C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ScreenShot\\demosite.png";
		
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		driver.get("http://demo.testfire.net/login.jsp");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('CatLink1').style.border='4px solid red'");
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(path);
		FileUtils.copyFile(srcFile, targetfile);
		driver.close();
		

	}

}
