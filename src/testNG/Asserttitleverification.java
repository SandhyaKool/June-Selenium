package testNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Asserttitleverification {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}


	@Test
	public void test()
	{
		driver.get("https://www.google.com/");
		String expectedtitle="Google1";
		String actualtitle=driver.getTitle();
		System.out.println("Title: "+actualtitle);
		
		Assert.assertEquals(expectedtitle, actualtitle);		//if actual and expected are same,test passes or fails
		System.out.println("Verified");							//prints only when test passes in Hard Assert
		
	}
}
