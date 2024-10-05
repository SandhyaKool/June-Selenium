package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Copypaste {

	String baseURL="https://register.rediff.com/register/register.php?FormName=user_details";
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
		WebElement fullname=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));			//locates the webelement fullname
		WebElement reddiffid=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));		//locates the webelement reddiffid
		fullname.sendKeys("abc");																					//inserts text abc
		Actions act=new Actions(driver);																			//object for actions class
		act.keyDown(fullname,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);										//selects the data in fullname field
		act.keyDown(fullname,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);										//copies the data in fullname field
		act.keyDown(reddiffid,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);										//pastes the copied data in reddiffid field
		act.perform();																								//calls the perform method to execute the above actions
		
	}
	
	
	
}
