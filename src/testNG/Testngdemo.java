package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngdemo {
	
	@BeforeTest
	public void setup()
	{
		System.out.println("BeforeTest");
	}

	@BeforeMethod
	public void URLloading()
	{
		System.out.println("BeforeMethod");
	}
	
	@Test(priority=5,invocationCount=3)
	public void test1()
	{
		System.out.println("Test1");
	}
	
	@Test(priority=4,groups= {"smoke"})
	public void test2()
	{
		System.out.println("Test2");
	}
	
	@Test(priority=2,dependsOnMethods = {"test2"},groups= {"smoke","sanity"} )
	public void test3()
	{
		System.out.println("Test3");
	}
	
	@Test(priority=3,enabled=false)
	public void test4()
	{
		System.out.println("Test4");
	}
	
	@Test(priority=1,groups= {"regression"})
	public void test5()
	{
		System.out.println("Test5");
	}
	
	@AfterMethod
	public void after()
	{
		System.out.println("AfterMethod");
	}
	
	@AfterTest
	public void teardown()
	{
		System.out.println("AfterTest");
	}
	
			
}
