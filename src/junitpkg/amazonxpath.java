package junitpkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonxpath {

	ChromeDriver driver;
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
	}
	
	@Test
	public void amazon()
	{
		driver.findElement(By.xpath("//div[@class='nav-fill']/div/input")).sendKeys("Mobiles",Keys.ENTER);			 // Search 'Mobiles' in Search bar
		driver.findElement(By.xpath("//div[@id='nav-cart-count-container']/span[1]")).click();						 // Click cart icon
		driver.findElement(By.xpath("//div[@id='nav-xshop']/a[5]")).click();  										 // Today's deals menu
		driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).click(); 						 // Click 'Hello,SignIn
		driver.navigate().back();																					 // Navigate to Back page
		driver.findElement(By.xpath("//div[@id='nav-main']/div/a/i")).click(); 										 // click Hamburger menu
	}
	
	
	
}
