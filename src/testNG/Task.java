package testNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task {
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://janasya.com/");
	}
	
	@Test
	public void titleverification() throws IOException
	{
		String Expectedtitle="Janasya";
		String Actualtitle=driver.getTitle();
		
		if(Actualtitle.equals(Expectedtitle))
				{
					System.out.println("PASS");
				}
		else
				{
					System.out.println("FAIL");
				}
		
		//To Hover over New and Click Saaga
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement newtag=driver.findElement(By.xpath("//*[@id=\"shopify-section-sections--16405611937962__header\"]/height-observer/x-header/nav[1]/ul/li[1]/details/summary"));
		Actions act=new Actions(driver);
		act.moveToElement(newtag).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"shopify-section-sections--16405611937962__header\"]/height-observer/x-header/nav[1]/ul/li[1]/details/div/ul/li[1]/ul/li[3]/a"))).click();
		
		//Link Count
		
		List<WebElement> linkcount=driver.findElements(By.tagName("a"));
		System.out.println("Total no.of links="+linkcount.size());
		
		if(linkcount.size()==400)
		{
			System.out.println("Link count is same as expected");
		}
		else
		{
			System.out.println("Link count is not same as expected");
		}
				
		//Screenshot
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);										
		FileHandler.copy(src,new File("C:\\Users\\sandh\\OneDrive\\Desktop\\Testing\\janasya_screenshot.png"));
		
	}

}
