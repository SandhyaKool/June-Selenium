package pkg;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Webdriverdemo {

	public static void main(String[] args) {
	
		ChromeDriver driver=new ChromeDriver();   //opens browser
		driver.get("https://www.google.com");    // opens google
		
		
	String actualtitle=driver.getTitle();
	String expectedtitle="Google";
	
	if(actualtitle.equals(expectedtitle))   //.equals, used to compare string is case sensitive.
	{
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
		

	}

}
