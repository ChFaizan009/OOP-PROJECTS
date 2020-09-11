package com.uog.pk;

public class defau {
	int a,b;
	defau()
	{
		System.out.println("Default Constructor ");
		a=10;
		b=20;
		
	}
	void disp()
	{
		System.out.println("The Value of a is :  "+a);
		System.out.println("The Value of b is :  "+b);
	}
	public static void main(String [] arys)
	{
		defau obj = new defau();
		obj.disp();
	}
	
}
