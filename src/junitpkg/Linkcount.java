package junitpkg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkcount {

	ChromeDriver driver;
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void test()
	{
		List<WebElement> li=driver.findElements(By.tagName("a"));
		System.out.println("Total no.of links="+li.size());
		
		for (WebElement ele:li)											//webelement is used since the element stored is a webelement
		{
			String link=ele.getAttribute("href");   					//to get the link
			String linktext=ele.getText();								//to get the text
			System.out.println(link+"---------------"+linktext);   		//prints the link and text
		}
		
		
	}
}
