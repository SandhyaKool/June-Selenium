package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class reddiffbutton {

	String baseURL="https://register.rediff.com/register/register.php?FormName=user_details";
	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseURL);
	}
	
		
	@Test
	public void text()
	{
		WebElement Avlblty=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]"));
		String buttontext=Avlblty.getAttribute("value");
		if(buttontext.equals("Check availability"))
		{
			System.out.println("Text is Correct");
		}
		else
		{
			System.out.println("Text is Incorrect");
		}
	}
	
	
}
