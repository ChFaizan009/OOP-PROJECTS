package Functions;

import java.util.Scanner;

import admin.FlightMenu;

public class FunctionClass
{
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while(choice!=5)
		{
			System.out.println("=====================================================");
			System.out.println("Main Menu");
			System.out.println("=====================================================");
			System.out.println("1. Press  1 for  Flights Data");
			
			
			choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				FlightMenu.Interface();
			
				break;
        case 5:
				
				break;
			default:
				System.out.println("Invalid Choice!");
			}
}}}