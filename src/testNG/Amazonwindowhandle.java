package testNG;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazonwindowhandle {

	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void test()
	{
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobile phones",Keys.ENTER);		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
		String ActualTitle= driver.getTitle();
		String ExpectedTitle="Amazon.in:mobile phones";
		//Assert.assertEquals(ExpectedTitle, ActualTitle);
		
			if(ActualTitle.equals(ExpectedTitle))
				{
					System.out.println("PASS");
				}
			else
				{
					System.out.println("FAIL");
				}
		
		String parentwindow=driver.getWindowHandle();	
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		
		Set<String> allwindows = driver.getWindowHandles();
		
		for(String handle : allwindows)
		{
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,1000)");
				
				driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[38]/div[1]/span/span/span/input")).click();
			}
			
		}
		
	}
}
		
		
	
	
	
	


