package pkg;

import org.openqa.selenium.chrome.ChromeDriver;

public class Textverification {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
		String srce=driver.getPageSource();  //to get source code of the web appln
				
		if(srce.contains("images"))   //to check whether the page contains the word 'images'
		{
			System.out.println("Text is Present");
		}
		else
		{
			System.out.println("Not Present");
		}

	}

}
