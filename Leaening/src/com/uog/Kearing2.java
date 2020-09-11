package com.uog;

public class Kearing2 extends Kearing
{

	void processdata()
	{
		if(Persn_age>=18)
		{
			System.out.println("<<<<<<..............>>>>>>");
			System.out.println("The Person is Eligible for Vote");
		} 
		else
		{
			System.out.println("<<<<<<..............>>>>>>");
			System.out.println("The Person is not Eligible for Vote");
		}
	}
	public static void main(String [] ar)
	{
		Kearing2 ob=new Kearing2();
		ob.getData();
		ob.showData();
		ob.processdata();
	}
}
