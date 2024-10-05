package junitpkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class fbxpath {

	ChromeDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void fbxpath()
	{
		driver.findElement((By.xpath("//input[@id='email']"))).sendKeys("123@gmail.com"); 
		driver.findElement((By.xpath("//input[@name='pass']"))).sendKeys("abc123");
		driver.findElement((By.xpath("//button[@name='login']"))).click();
	}
	
	
}
