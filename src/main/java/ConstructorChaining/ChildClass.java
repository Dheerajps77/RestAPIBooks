package ConstructorChaining;

public class ChildClass extends ParentClass {
	
	String name="Rahul Singh";
	
	/*
	 * ChildClass() {
	 * System.out.println("I am in default Constructor of  - Child Class"); }
	 */
	
	ChildClass(String name)
	{
		super("iOSDevice", 234454);
		System.out.println(name);
	}
	
	ChildClass(int age, int houseNumber)
	{
		this("Rahul Kumar");
		System.out.println(age + " " + houseNumber);
	}
}
