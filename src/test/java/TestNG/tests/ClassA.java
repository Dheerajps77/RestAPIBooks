package TestNG.tests;

import org.testng.annotations.Test;

public class ClassA {
	
	
	@Test(priority=0)
	public void loginPageTestClassAMethod1()
	{
		System.out.println("I am in Class A -- Method 1");
	}
	@Test(priority=1)
	public void resetPasswordTestClassAMethod2()
	{
		System.out.println("I am in Class A -- Method 2");
	}
	@Test(priority=0)
	public void SendOTPTestclassAMethod3()
	{
		System.out.println("I am in Class A -- Method 3");
	}

}
