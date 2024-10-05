package testNG;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportss {
	
	WebDriver driver;
	String baseURL="https://www.facebook.com/";
	ExtentSparkReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeTest
	public void beforetest()
	{
		reporter=new ExtentSparkReporter("./Reports/myreport1.html");		//new object creation with location where the report has to be saved as constructor
		reporter.config().setDocumentTitle("Automation Report");			//theme setting
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();											//new object
		extent.attachReporter(reporter);									//reporter
		extent.setSystemInfo("Hostname", "Localhost");						//setting environment
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Testername", "Sandhya");
		extent.setSystemInfo("Browsername", "Chrome");
		
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		driver.get(baseURL);
	}
	
	@Test
	public void fbTitleVerification()
	{
		test=extent.createTest("fbTitleVerification");
		String ExpectedTitle="facebook";
		String ActualTitle=driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
	
	@Test
	public void ButtonTextVerification()
	{
		test=extent.createTest("ButtonTextVerification");
		WebElement Button=driver.findElement(By.xpath("//*[@id=\"u_0_5_Xs\"]"));
		String buttontext=Button.getAttribute("name");
		Assert.assertEquals(buttontext, "login");
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush();															//flush must be given for report generation
	}
	
	@AfterMethod()
	public void browserclose(ITestResult result)								
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test case failed is "+result.getName());
			test.log(Status.FAIL, "Test case failed is "+result.getThrowable());
			//String screenshotpath=screenshotMethod(driver,result.getName());
			//test.addScreenCaptureFromPath(screenshotpath);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test case skipped is "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test case Passed is "+result.getName());
		}
		
	}
	
	public static String screenshotMethod(WebDriver driver,String screenshotname) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destination="./Screenshot/"+screenshotname +".png";
		//File finaldestination=new File(destination);
		//FileHandler.copy(src, finaldestination);
		FileHandler.copy(src, new File(destination));
		return destination;
	}
	
	
	
	
	

}
