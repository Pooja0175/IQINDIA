package seleniumPractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenShot1 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		TakesScreenshot ts=(TakesScreenshot)driver;
		driver.get("https://www.google.co.in/");
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\Sheetal\\eclipse-workspace\\SELENIUM\\ScreenShot\\image1.png";
		File targetFile=new File(path);
		FileUtils.copyFile(srcFile, targetFile);
		driver.close();

		

	}

}
