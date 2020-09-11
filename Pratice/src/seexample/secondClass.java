package seexample;

import java.util.Scanner;

public class secondClass extends mainclas

{
	int id;
	String fname;
	String lname;
	String email;
	String no;
	String contact;
	public void getData()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Id  : ");
		id=sc.nextInt();
				
		System.out.println("Enter The First Name : ");
		fname=sc.nextLine();
		fname+=sc.nextLine();
		System.out.println("Enter The Last Name : ");
	    lname=sc.nextLine();
		
		System.out.println("Enter The Email : ");
		 email=sc.nextLine();
		System.out.println("Enter The Phone Number : ");
		 no=sc.nextLine();
		System.out.println("Enter The Address : ");
		 contact=sc.nextLine();
	}


	public void showData()
	{
	
		System.out.println("The Id is : "+id);
		System.out.println("The First Name is: "+fname);
		System.out.println("The Last Name is: "+lname);
		System.out.println("The Email is: "+email);
		System.out.println("The Phone Number is: "+no);
		
		System.out.println("The Address is : "+contact);
		
	}
	
	public void work()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Given Id : ");
		int in=sc.nextInt();
		
		
	if(id!=in)
	
		System.out.println("The Id is not Match");
		
	else 
	
		System.out.println("The Id is Match");
	}
	public static void main(String [] at)
	{
		secondClass sc=new secondClass();
		sc.getData();
		sc.showData();
		sc.work();
	}
}
