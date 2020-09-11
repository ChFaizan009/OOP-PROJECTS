package edu.uog.Student.model;

import java.util.Scanner;

public class MainClass 
{

	public void Function()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Course in Which Student want to enroll :");
		int id=sc.nextInt();
		
		Course find = Course.findOne(id);
		System.out.println(find.toString());
		System.out.println("---------------------------------");
		
		System.out.println("---------------------------------");
			
		if(find==Course.findOne(id))
		
			System.out.println("The Admin is Accept the Student Request");
			else
				System.out.println("The Admin is not Accept the Student Request");
			
		
	}
	
	public static void main(String []ar)
	{
		MainClass mn=new MainClass();
		mn.Function();
	}
}
