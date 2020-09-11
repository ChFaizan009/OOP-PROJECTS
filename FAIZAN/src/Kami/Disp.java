package Kami;
abstract class A
{
	abstract void disp();
	
	void dis()
	{
		System.out.println("The Answer is : 14  " );
	}
}
 class B extends A
 
 {
	 void disp()
 {
	 System.out.println("The Question  is : 29 " );
 }

 }


public class Disp {
public static void main(String[] arys)

{

	B obj=new B();
	obj.disp();
	obj.dis();
}

}
