package testNG;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdownprint {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
		{
			driver=new ChromeDriver();
			driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		}
		
		@Test
		public void test()
		{
			WebElement Countryele=driver.findElement(By.xpath("//*[@id=\"country\"]"));
			Select Country=new Select(Countryele);
			//Country.selectByIndex(01);w
			
			List<WebElement>options=Country.getOptions();
			
			for(int i=1;i<options.size();i++)
			{
				System.out.println("OPtional Countries: "+i+" "+options.get(i).getText());
			}
			
			
			//for(WebElement Countryoptions:options)
			//{
			//	System.out.println("Optional Countries:"+Countryoptions.getText());
			//}
			
						
		}
	

}
