package TestNG.tests;

import org.testng.annotations.Test;

public class ClassB {
	
	@Test(priority=3)
	public void loginPageTestClassBMethod1()
	{
		System.out.println("I am in Class B -- Method 1");
	}
	@Test(priority=4)
	public void resetPasswordTestClassBMethod2()
	{
		System.out.println("I am in Class B -- Method 2");
	}
	@Test(priority=5)
	public void SendOTPTestclassBMethod3()
	{
		System.out.println("I am in Class B -- Method 3");
	}

}
