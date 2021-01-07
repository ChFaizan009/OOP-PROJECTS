package cust;

import java.util.Scanner;

public class TestCustomer
{

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while(choice!=12)
		{
			System.out.println("=====================================================");
			System.out.println("Main Menu");
			System.out.println("=====================================================");
			System.out.println("1. Press  1 for  Customers Data");
			System.out.println("2.   Quit");
			System.out.println("Enter Your Choice [1-2]: ");
			choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				CustomerMenu.Menu();
				choice=-1;
				break;
			default:
				System.out.println("Invalid Choice!");
			}
		}			}
}
