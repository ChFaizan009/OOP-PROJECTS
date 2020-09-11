package Pratise;
import java.util.Scanner;

public class MultiDimesional {

	public static void main(String [] arys)
	{
		
	
	Scanner sc=new Scanner(System.in);
	int rows=sc.nextInt();
	int cols=sc.nextInt();
	
	System.out.println("Enter The Dimenstion : ");
	int a[][]=new int[rows][cols];
	int b[][]=new int[rows][cols];
	
	
	System.out.println("Enter The Value A : ");
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{	a[i][j]=sc.nextInt();
	}
	}
	
	
	System.out.println("Enter The Value B : ");
	
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
				{
				b[i][j]=sc.nextInt();
		}
	}
	
	
	
		
		int c[][]=new int [rows][cols];
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
			{
			c[i][j]=a[i][j]+b[i][j];	
	}}
	System.out.println("The Result of c is : ");
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{
			System.out.println(c[i][j] +" ");
		}
		System.out.println();
	} 
	
		
		
		
		
		
}
}