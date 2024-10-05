package testNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class fileuploadrobot {

	ChromeDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
	}
	
	@Test
	public void test() throws AWTException
	{
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]/span")).click();
		fileUpload("C:\\Users\\sandh\\OneDrive\\Desktop\\Demo.docx");							//Declaration of method with parameter 
		driver.findElement(By.xpath("//*[@id=\"processTask\"]")).click();
	}
	
	public void fileUpload(String p) throws AWTException										//Method definition
	{
		StringSelection FleSelection=new StringSelection(p);									//Selects file path 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(FleSelection, null);		//Copies file to clipboard
		
		Robot robot=new Robot();																//wait
							
		robot.delay(3000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);													//pastes the file
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
}
