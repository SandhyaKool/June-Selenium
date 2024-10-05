package testpkg;

import org.testng.annotations.Test;

import pagepkg.fbcreatepage;

public class fbcreatetest extends Baseclass {

	@Test
	public void createpagetest()
	{
		fbcreatepage cpage=new fbcreatepage(driver);
		cpage.createpagebutton();
		cpage.textverification();
		cpage.signupclick();
		
	}

}
