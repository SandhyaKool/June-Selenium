package junitpkg;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiplelinksrespcode {

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
		
		for (WebElement ele:li)											//webelement is used since the element stored is a webelement
		{
			String link=ele.getAttribute("href"); 
			verifylink(link);
		}
		
		
		}

	private void verifylink(String link) {
		
		try
		{
			URI ob=new URI(link);
			HttpURLConnection con=(HttpURLConnection)ob.toURL().openConnection();
			
			if(con.getResponseCode()==200)
			{
				System.out.println("Successful responsecode is 200---------------"+link);
				
			}
			else if(con.getResponseCode()==404)
			{
				System.out.println("Broken link responsecode is 404---------------"+link);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}	
		
}
