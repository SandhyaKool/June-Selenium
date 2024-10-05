package testNG;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Windowhandler {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/popup.php");;
	}
	
	@Test
	public void test() throws InterruptedException
	{
		String parentwindow=driver.getWindowHandle();								//Current tab
		
		System.out.println("Parent window title: "+driver.getTitle());
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		Set<String> allwindows = driver.getWindowHandles();
		
		for(String handle : allwindows)
		{
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("abc@gmail.com");
				Thread.sleep(3000);
				driver.close();
			}
			driver.switchTo().window(parentwindow);
		}
	}
	
	
	

}
