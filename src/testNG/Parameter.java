package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {

	@Parameters("v")
	@Test
	public void parameter(String v)
	{
		System.out.println("v="+v);
	}
}
