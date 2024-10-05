package junitpkg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void fb()
	{
	driver.findElement(By.id("email")).sendKeys("123@gmail.com");  //inspect the element and enter the value/word there inside id and name
	driver.findElement(By.id("pass")).sendKeys("abc123");
	driver.findElement(By.name("login")).click();
	}
	
		
}
