package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class fbcreatepage {
	
	WebDriver driver;
	
		@FindBy(xpath="//*[@id=\"reg_pages_msg\"]/a")
		WebElement createpage;
		//By createpage=By.xpath("//*[@id=\"reg_pages_msg\"]/a");
		
		By signup=By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div[2]/div/div/span/a");
	
	public fbcreatepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void createpagebutton()
	{
		createpage.click();
		//driver.findElement(createpage).click();
	}
	
	public void textverification()
	{
		String src=driver.getPageSource();
		if(src.contains("Create a Page"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
	}
	
	public void signupclick()
	{
		driver.findElement(signup).click();
		driver.navigate().back();
	}
	
	

}
