import java.util.Scanner;
public class Farhenthit {
public static void main(String [] arys)
{
	double c;
	double d=1.8;
	Scanner obj = new Scanner(System.in);
	
	System.out.println("Enter The Farhenthit : ");
	int F= obj.nextInt();
	
	 c=(F-32)/d;
	System.out.println("The Answer is  : " +c);
}
}
