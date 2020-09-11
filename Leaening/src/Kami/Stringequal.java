package Kami;

public class Stringequal {
public static void main(String [] arys)
{
	String myString ="String0";
	String myString1 ="String1";
	String myString2 ="String3";
	
	System.out.println("Length of string0: " +
			myString.length());
			System.out.println("Char at index 3 in strOb1: " +
			myString1.charAt(3));
			if(myString.equals(myString1))
			{
				System.out.println("myString1 == myString");
			}
			else
				System.out.println("myString1 != myString2");
			if(myString1.equals(myString2))
			{
				System.out.println("myString1 == myString2 ");
			}
			else
				System.out.println("myString1 != myString2 ");	
			
}
}
