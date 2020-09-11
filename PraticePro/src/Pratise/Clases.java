package Pratise;

import java.util.Scanner;

public abstract class Clases {

	int a;
	String Name;
	String R_no;
	void dis() {
		System.out.println("<<<<<>>>......Hello......<<<<<<><>>><><><>");
	}
	void getData()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter The Name :");
		Name=sc.nextLine();
		
		System.out.println("Enter The Roll No :");
		R_no=sc.nextLine();
		
		System.out.println("Enter The Value of a :");
		a=sc.nextInt();
		
	}
}

