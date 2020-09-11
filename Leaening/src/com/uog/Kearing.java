package com.uog;
import java.util.Scanner;
public class Kearing
{

	String Persn_Name;
	String Persn_IdC;
	String Gender;
	int Persn_age;
	
	void getData()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter The Name of Person  : ");
		Persn_Name=sc.nextLine();
		System.out.println("Enter The Id Card of Person  : ");
		Persn_IdC=sc.nextLine();
		System.out.println("Enter The Gender of Person  : ");
		Gender=sc.nextLine();
		System.out.println("Enter The Age of Person  : ");
		Persn_age=sc.nextInt();
		
	}
	void showData()
	{
		System.out.println("The Name of Person is : "+Persn_Name);
		System.out.println("The Id Card of Person is : "+Persn_IdC);
		System.out.println("The Gender of Person is : "+Gender);
		System.out.println("The Age of Person is : "+Persn_age);
	
	}
	
	


}

