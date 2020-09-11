package Kami;

public class Janzbond {

	public static void main (String [] n)
	{
		B obj = new B();
		obj.disp();
		obj.show();
	}
}

class A
{
	final void show()
	{
		
		System.out.println("This oiis  ");
	}
}
class B extends A
{
	 void disp()
	{

		System.out.println("This error");
	}
}