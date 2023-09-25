package ConstructorChaining;

public class ChildClass2 extends ChildClass {
	
	ChildClass2()
	{
		//super("String");
	    super(45,656);
		System.out.println("I am in ChildClass2 constructor class");		
	}
	
	public static void main(String[] args) {
		ChildClass2 childClass2=new ChildClass2();
		
	}

}
