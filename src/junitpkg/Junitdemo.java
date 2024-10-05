package junitpkg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junitdemo {

      ChromeDriver driver;	//instance variable
      
      @Before
      public void setUp()
      {
    	  	driver=new ChromeDriver();					//object created
    	  	driver.get("https://www.google.com");		// opens required URL
      }
      
      @Test
      public void titleverification()
      {
    	  String actualtitle=driver.getTitle();		// to get title
    	  String exptitle="Google";
    	  
    	  if(actualtitle.equals(exptitle))
    	  {
    		  System.out.println("PASS");
    	  }
    	  else
    	  {
    		  System.out.println("FAIL");
    	  }
    	  
      }
      
      @Test
      public void textverification()
      {
    	  String src=driver.getPageSource();
    	  
    	  if(src.contains("Photo"))
    	  {
    		  System.out.println("Text is Present");
    	  }
    	  else
    	  {
    		  System.out.println("Not Present");
    	  }
      }
      
      @After
      public void teardrop()
      {
    	  driver.quit();
      }
      
}
