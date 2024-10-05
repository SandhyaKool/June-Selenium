package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datepicker {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.trivago.com/");
	}

	@Test
	public void test()
	{
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div/fieldset/button[1]/span/span[2]/span[2]")).click();	//click on checkin
		datepicker("November 2024","18");																													//calling datepicker method with expected data as parameters
	}

	public void datepicker(String expmonth, String expdate) {																								//datepicker method definition
		
		while(true)
		{
			WebElement monthdetails=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/h3"));	//displayed month
			String month=monthdetails.getText();																															//to get the text of displayed month
			
			if(month.equals(expmonth))																																		//to check expected and displayed months are same																											
			{
				System.out.println(month);
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/button[2]/span")).click();			//if not same,click navigation > and continue the while loop
			}
			
		}
		
		List<WebElement> datelist=driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/button/time"));		//all dates of the month
		
		for(WebElement ele:datelist)
		{
			String date=ele.getText();																								
			
			if(date.equals(expdate))																																							//to check expected and date from the list are same
			{
				ele.click();																																									//if yes,click on the date 
				break;
			}
			
		}
		
	}
	
	
	
	
}
