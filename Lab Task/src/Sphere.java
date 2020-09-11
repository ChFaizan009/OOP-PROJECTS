import java.util.Scanner;
public class Sphere {
public static void main(String [] arys)

{
	float r;
	double pi=3.142;
	double Volume,Area;
	Scanner obj = new Scanner(System.in);
	System.out.println("Enter The Radius of Area Of The Sphere : ");
	 r= obj.nextFloat();
	 Area=(4*r*r*pi);
	 System.out.println("The  Area Of The Sphere is  :  " +Area);
	 Volume=(4/3*pi*r*r*r);
	 System.out.println("The  Volume Of The Sphere is  :  " +Volume);
}
}
