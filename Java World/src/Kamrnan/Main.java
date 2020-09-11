package Kamrnan;

class Super 
{
	int x=20;
	void disp()
	{
		System.out.println("The Super Class is : " +x);
	}
}

class Sub extends Super
{

	int y=35;
	void disp()
	
	{
		System.out.println("The Super Class is : " +x);
		System.out.println("The Sub Class is : "+y);
	}
	
}
public class Main
{
	public static void main(String [] arys)
	{
		Sub obj= new Sub();
		obj.disp();
	}
}