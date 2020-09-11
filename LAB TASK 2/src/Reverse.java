 import java.util.Scanner;
public class Reverse {

	public static void main(String [] arys)
	{
		int reverse =0;
		int sum=0; 
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter The Value that can be reverse : ");
		int no= obj.nextInt();
		while(no!=0)
		{ 
			reverse=reverse*10;
			int rem=no%10;
	      reverse = reverse + rem;
	      no = no/10;
	      sum=sum+rem;
		}
		System.out.println("The Reverse Value is  : " +reverse);
		System.out.println("sum of number with it’s reverse  is  : " +sum);
	}
}
