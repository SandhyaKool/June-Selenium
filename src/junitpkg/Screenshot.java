package junitpkg;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	ChromeDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void test() throws IOException
	{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);										//to take screenshot of page
			FileHandler.copy(src,new File("C:\\Users\\sandh\\OneDrive\\Desktop\\Testing\\google_screenshot.png"));
			
			WebElement ele=driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[2]"));				//to take screenshot of element
			File src1=ele.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src1, new File("./Screenshot/buttonscreenshot.png"));
			
			
	}
	}
