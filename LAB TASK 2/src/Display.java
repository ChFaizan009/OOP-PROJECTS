import java.util.Scanner;
public class Display {
public static void main(String [] arys)
{
	Scanner obj = new Scanner(System.in);
	System.out.println("Enter Your Name ");
	String a = obj.nextLine();
	System.out.println("Enter Your Branch No ");
	int b = obj.nextInt();
	System.out.println("Enter Your Year ");
	int c = obj.nextInt();
	System.out.println(" Your 	Name is :  " +a);
	System.out.println(" Your Branch No is :  " +b);
	System.out.println(" Your Year is :  " +c);
	
}
}
