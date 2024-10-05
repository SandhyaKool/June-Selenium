package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Draganddrop {
	
	String baseURL="https://demo.guru99.com/test/drag_drop.html";
	ChromeDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseURL);
	}
	
	@Test
	public void test()
	{
		WebElement DebitSrceValue=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement DebitDstnAmnt=driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
		WebElement DebitSrceBank=driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		WebElement DebitDstnAccnt=driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		WebElement CreditSrceSales=driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		WebElement CreditDstnAccnt=driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		WebElement CreditSrceValue=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement CreditDstnAmnt=driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
		WebElement Perfect=driver.findElement(By.xpath("//*[@id=\"equal\"]/a"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(DebitSrceValue, DebitDstnAmnt).perform();
		act.dragAndDrop(DebitSrceBank, DebitDstnAccnt).perform();
		act.dragAndDrop(CreditSrceSales, CreditDstnAccnt).perform();
		act.dragAndDrop(CreditSrceValue, CreditDstnAmnt).perform();
	
		boolean b=Perfect.isDisplayed();
		
		if(b)
		{
			System.out.println("Perfect is Present");
		}
		else
		{
			System.out.println("Perfect is Not Present");
		}

		
		
	}
	

}
