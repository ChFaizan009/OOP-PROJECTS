import java.util.Scanner;
public class Average {
	public static double average(double x, double y, double z)
	{
		return (x+y+z)/3;
	}
		
	
	public static void main(String [] arys)
	{
		Average obj = new Average();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The First Number : ");
		int  x =sc.nextInt();
		System.out.println("Enter The Second Number : ");
		int  y =sc.nextInt();
		System.out.println("Enter The Thirld Number : ");
		int  z =sc.nextInt();
		
		System.out.print("The average value is " + average(x, y, z)+"\n" );
	}
	}
