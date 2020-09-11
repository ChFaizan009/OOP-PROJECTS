package Pratise;

public class ConsPractice2 extends ConsPractice {


	ConsPractice2(int a, int b) {
		super(a, b);}
		public void display()
		{
			System.out.println("The Value of variable First is  "+  x  + "  The Value of variable Second is   "+ y );
			}
		
	
public static void main(String [] arys)
{
	ConsPractice2 obj = new ConsPractice2(4 ,6);
	
	obj.display();
}
}
	
