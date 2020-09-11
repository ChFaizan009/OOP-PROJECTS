import java.util.Scanner;
public class Area {
	public static void main(String [] arys)
	{
		float r;
		double pi=3.142;
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Enter The Radius of Area Of The Circle : ");
		 r= obj.nextFloat();
		double area=(pi*r*r);
		System.out.println("The  Area Of The Circle is  :  " +area);	
	}

}
