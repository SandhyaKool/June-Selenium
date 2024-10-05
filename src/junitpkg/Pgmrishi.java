package junitpkg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pgmrishi {

	ChromeDriver driver;
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://rishiherbalindia.linker.store");
	}
	
	@Test
	public void titleverification()
	{
		String actualtitle=driver.getTitle();
		String exptitle="rishiherbal";
		
		if(actualtitle.equals(exptitle))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
			
		}
	
	@Test
	public void Linkcount()
	{
		List<WebElement>li=driver.findElements(By.tagName("a"));
		System.out.println("Total no.of links="+li.size());
		int explink=100;
		
		if (li.size()==explink)
		{
			System.out.println("As expected");
		}
		else
		{
			System.out.println("Doesn't meet expected count");
		}
		
	}
	
	@Test
	public void textverification()
	{
		String srce=driver.getPageSource();
		
		if(srce.contains("Food"))
		{
			System.out.println("Text is Present");
		}
		else
		{
			System.out.println("Not Present");	
		}
		
	}
	
	@Test
	public void open()
	{
		driver.findElement(By.xpath("//a[@glair-source-value='534025']")).click();
	}
	
	}
	
	

