package junitpkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertpgm {


	ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/sandh/OneDrive/Desktop/Testing/AlertPgm.html");
	}
	
	@Test
	public void test()
	{
		driver.findElement(By.xpath("/html/body/input[1]")).click();
		
		Alert a=driver.switchTo().alert();								//to handle alert
		String alerttext=a.getText();
		System.out.println(alerttext);
		a.accept();
		
		driver.findElement(By.xpath("/html/body/input[2]")).sendKeys("abc");
		driver.findElement(By.xpath("/html/body/input[3]")).sendKeys("b");
		driver.findElement(By.xpath("/html/body/input[4]")).click();
		
	}
}
