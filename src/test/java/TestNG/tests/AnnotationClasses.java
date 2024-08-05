package TestNG.tests;

import org.testng.annotations.*;

public class AnnotationClasses {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am After Suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am After Test");
	}
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("I am Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am After Class");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("I am Before Method");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("I am After Method");
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
