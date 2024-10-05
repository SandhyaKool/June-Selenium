package testNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demosite {

	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
	}
	
	@Test
	public void test()
	{
		WebElement rcm=driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		WebElement edit=driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]"));		
		WebElement dcma=driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		
		Actions act=new Actions(driver);
		act.contextClick(rcm).perform();			//right click
		edit.click();
		driver.switchTo().alert().accept();
				
		act.doubleClick(dcma).perform();			//double click
		Alert a=driver.switchTo().alert();
		String alerttext=a.getText();
		System.out.println(alerttext);
		a.accept();
	}
	
	
	
	
	
	
	
}
