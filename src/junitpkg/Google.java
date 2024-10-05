package junitpkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver= new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void google()
	{
		
		driver.findElement(By.name("q")).sendKeys("Testing",Keys.ENTER);
		
		//WebElement searchfield=driver.findElement(By.name("q"));		
		//searchfield.sendKeys("Testing",Keys.ENTER);	// use this method to enter or click (more useful)
		//searchfield.submit();							// or this method
		//driver.findElement(By.name("btnk")).click();  // won't work since search button got overlayed by dropdown
	}
	
	
	
}
