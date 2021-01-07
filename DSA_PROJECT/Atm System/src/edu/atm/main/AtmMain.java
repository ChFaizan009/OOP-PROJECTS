package edu.atm.main;

import java.util.Scanner;

import edu.atm.main.Menu;
import edu.atm.main.account.AccountData;
import edu.atm.main.Menu;
import edu.atm.main.customer.CustomerData;

@SuppressWarnings("unused")
public class AtmMain 
{

	public static void main(String[] ary) throws Exception
	{
	    Scanner sc=new Scanner(System.in);
	    System.out.println("   Welcome to Atm System    : ");
	    System.out.println("-------------------------");
	    
	    
	    Scanner scan=new Scanner(System.in);
	    char choice;
	 
	    System.out.println("1. Press 1 for Admin Menu ");
	    System.out.println("2. Press 2 for User Menu ");
	    System.out.println("3. Press 3 for Exist ");
	    do
		{
	    	  System.out.println("Enter Your Choice");
	     choice = sc.next().charAt(0);
	     
	    
	    switch (choice) {
		case '1':
			
				System.out.println(choice);
				System.out.println("Welcome to Admin System : ");
				Menu.adminMenu();
			
			break;
		case '2':
			
		    
				System.out.println(choice);
				System.out.println("Welcome to User System : ");
				Menu.userMenu();
			
			break;
	    
		case '3':
				System.exit(0);
		 
			break;

		default:
			System.out.println("Invalid Choice! Enter Again");
			break;
	}
	    
	}
	    while(!(choice=='1'||choice=='2'||choice=='3'));
	}
}