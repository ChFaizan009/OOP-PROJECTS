import java.util.Scanner;
public class Test {

	public static void main(String [] arys)
	{
		String a;
		String b,c;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter The Name Of Student ");
		 a = obj.nextLine();
		
		 System.out.println("Enter The Adress Of Student ");
		 
		b=obj.nextLine(); 
		 
		System.out.println("Enter The City Of Student ");
		  c=obj.nextLine();
		  System.out.println("The Name of Student is : " + a);
		  System.out.println("The Adress of Student is : " + b);
		  System.out.println("The City of Student is : " + c);
			
	}
}
