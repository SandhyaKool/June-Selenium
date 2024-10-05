package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Rediff {

	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void URL()
	{
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
	
	@Test
	public void logo()
	{
		WebElement logo=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/table[1]/tbody/tr[1]/td[1]/img"));
		boolean b=logo.isDisplayed();
		
		if(b)
		{
			System.out.println("Logo is Present");
		}
		else
		{
			System.out.println("Logo is Not Present");
		}

	}
	
	@Test
	public void radiobutton()
	{
		WebElement radio=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]"));
		boolean s=radio.isSelected();
		
		if(s)
		{
			System.out.println("Radiobutton is Selected");
		}
		else
		{
			System.out.println("Radiobutton is Not Selected");
		}
	}
	
	@Test
	public void createbutton()
	{
		WebElement button=driver.findElement(By.xpath("//*[@id=\"Register\"]"));
		boolean e=button.isEnabled();
		
		if(e)
		{
			System.out.println("Button is Enabled");
		}
		else
		{
			System.out.println("Button is Disabled");
		}	
	}
	
}
