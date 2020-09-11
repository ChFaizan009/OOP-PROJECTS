import java.util.Scanner;
public class LargestNumber {

	public static void main(String [] arys)
	{
		int num1=10,num2=20,num3=30,num4=40,num5=50;
	//LAgest Number
		
		if(num1>num2 && num1>num3 && num1>num4 && num1>num5)
		{
			System.out.println(num1+"is the Largest Number : ");
		}
		if(num2>num1 && num2>num3 && num2>num4 && num2>num5)
		{
			System.out.println(num2+"is the Largest Number : ");
		}
		if(num3>num2 && num3>num1 && num3>num4 && num3>num5)
		{
			System.out.println(num3+"is the Largest Number : ");
		}
		if(num4>num2 && num4>num3 && num4>num1 && num4>num5)
		{
			System.out.println(num4+"is the Largest Number : ");
		}
		if(num5>num2 && num5>num3 && num5>num4 && num5>num1)
		{
			System.out.println(num5+"is the Largest Number : ");
			
		}
		
		//smallest numbers
		if(num1<num2 && num1<num3 && num1<num4 && num1<num5)
		{
			System.out.println(num1+"is the Smallest Number : ");
		}
		if(num2<num1 && num2<num3 && num2<num4 && num2>num5)
		{
			System.out.println(num2+"is the smallest Number : ");
		}
		if(num3<num2 && num3<num1 && num3<num4 && num3<num5)
		{
			System.out.println(num3+"is the Smallest Number : ");
		}
		if(num4<num2 && num4<num3 && num4<num1 && num4<num5)
		{
			System.out.println(num4+"is the Smallest Number : ");
		}
		if(num5<num2 && num5<num3 && num5<num4 && num5<num1)
		{
			System.out.println(num5+"is the Smallest Number : ");
			
		}
		
	}
}
