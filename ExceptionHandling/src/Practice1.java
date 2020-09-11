
public class Practice1 {

	public static void main(String ar[]) {
	int c=10;int x;
	int a=20,b=10;
			try
		{
			 x=a/(b-c);
		}
		catch(ArithmeticException e)
		{
			
			System.out.println("The Number is divsion of 0 : " );
			
		}
			int y=a/(b+c);
	
	
	System.out.println("Vlaid Answer is : " +y);
	}

}
