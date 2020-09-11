
public class Practie3 {
public static void main(String [] arys)
{
	int a=10,b=0,c;
	try 
	{
	
	 
	c=a/b;
	System.out.println(c);
	}
	catch(ArithmeticException e)
	{
		
		System.out.println("Expection"+e);
	}
	finally {
		System.out.println("Now I am in finally Block");
	}
}
}
