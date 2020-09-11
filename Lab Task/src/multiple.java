import java.util.Scanner;
public class multiple { 

	public static void main(String [] arys)
	{
		int mul;
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter The First Number : ");
		int a= obj.nextInt();
		System.out.println("Enter The First Number : ");
		int b= obj.nextInt();
		 mul=(a*b);
		System.out.println("The Multipy of two Numbers is  : " +mul);
	}
	
}
