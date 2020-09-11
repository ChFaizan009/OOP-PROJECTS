 import java.util.Scanner;
public class Arthmeticoperation {
	
	public static void main(String [] arys)
	{
		Scanner obj = new Scanner(System.in);
	System.out.println("Enter Two Numbers : ");
	int a= obj.nextInt();
	int b= obj.nextInt();
	int add =a+b;
	int subt=a-b;
	int mul=a*b;
	float divide =(float)a/b;
	System.out.println(" The Addition of two Numbers is  :  " +add);
	System.out.println("Difference = " + subt);
    System.out.println("Multiplication = " + mul);
    System.out.println("Division = " + divide);
	}

}
