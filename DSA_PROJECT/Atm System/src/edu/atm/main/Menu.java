package edu.atm.main;

import java.util.List;
import java.util.Scanner;

import edu.atm.main.fund.FundData;
import edu.atm.main.transaction.Transaction;

import edu.atm.main.customer.Customer;

import edu.atm.main.customer.CustomerData;

import edu.atm.main.account.AccountData;
import edu.atm.main.fund.FundData;
import edu.atm.main.transaction.Transaction;

public class Menu
{

	public static void userMenu() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Customer customer = new Customer();
		char Choice;
		
		
			System.out.println("   Enter Your Choice!  ");
			
			System.out.println(" 1. Press 1 for Check your balance ");
			System.out.println(" 2. Press 2 for Deposit the Money in Account ");
			System.out.println(" 3. Press 3 for Widthrawn money from Account ");
			System.out.println(" 4. Press 4 for Seeing Your Details ");
			System.out.println(" 5. Press 5 for Transactions History ");
			System.out.println(" 6. Press 6 for Last 10 Transactions History ");
			System.out.println(" 7. Press 7 for Funds Transfer To another Account ");
			System.out.println(" 8. Press 8 for Funds Transfer History ");
			System.out.println(" 9. For Exit from this System ");
			
			do
			{
				System.out.print("Choice : = > ");
				Choice = sc.next().charAt(0);
				switch (Choice) {
					case '1':
						System.out.println(Choice);
						AccountData.balanceInquiry();
						break;
					case '2':
						System.out.println(Choice);
						AccountData.depositCash();
						break;
					case '3':
						System.out.println(Choice);
						AccountData.withdrawCash();
						break;
					case '4':
						System.out.println(Choice);
						System.out.print("Please Enter Customer ID : ");
						int id= sc.nextInt();
						customer = CustomerData.findOneCustomer(id);
						System.out.println("Your Details are : "+ customer.toString());
						break;
					case '5':
						System.out.println(Choice);
						List<String> statements = Transaction.showAllStatementData();
						statements.stream().forEach(System.out::println);
						userMenu();
						break;
					case '6':
						System.out.println(Choice);
						
						List<String> statement = Transaction.showLastTenTranscationStatement();
						statement.stream().forEach(System.out::println);
						userMenu();
						break;
					case '7':
						System.out.println(Choice);
						FundData.fundTransfer();
						break;
					case '8':
						System.out.println(Choice);
						System.out.print("Please Enter Customer ID :->");
						id= sc.nextInt();
						List<String> fundsHistory = FundData.fundTransferList(id);
						if(fundsHistory==null) {
							System.out.println(" No funds history Found !!!");
						}else {				
							fundsHistory.stream().forEach(System.out::println);
						}
						userMenu();
						break;
					case '9':
						System.out.println("Thanks You For Vist In Atm System");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Choice! Enter Again");
						break;
				}
				
			}
			while(!(Choice=='1'||Choice=='2'||Choice=='3'||Choice=='4'||Choice=='5'||Choice=='6'||Choice=='7'||Choice=='8'));
		}
		
				
	public static void adminMenu() throws Exception {
		Customer customer = new Customer();
		Scanner scan = new Scanner(System.in);
		char choice;
		System.out.println("\n Enter your choice! ");
		System.out.println("1. Press 1 For Customers List Detail ");
		System.out.println("2. Press 2 For particular Customer Detail ");
		System.out.println("3. Press 3 For Add a new  Customer Detail ");
		System.out.println("4. Press 4 For Update record of a Customer ");
		System.out.println("5. Press 5 For Delete record of a Customer ");
		System.out.println("6. Press 6 For Exit this System ");
		do {
			System.out.print("Choice:=> ");
			try{
				choice = scan.next().charAt(0);
			}catch (Exception e){
				choice = scan.next().charAt(0);
			}
			switch (choice) {
			case '1':
				System.out.println(choice);
				List<Customer> customers = CustomerData.ShowAll();
				customers.stream().forEach(System.out::println);
				adminMenu();
				break;
			case '2':
				System.out.println(choice);
				customer=null;
				System.out.print("Please Enter Customer ID : ->");
				int idFound = scan.nextInt();
				customer = CustomerData.findOneCustomer(idFound);
				System.out.println("Your Details are : "+ customer.toString());
				adminMenu();
				break;
			case '3':
				System.out.println(choice);
				customer=null;
				customer = CustomerData.AddCustomer();
				System.out.println("Your Details Are: "+ customer.toString());
				adminMenu();
				break;
			case '4':
				System.out.println(choice);
				System.out.print("Please Enter Customer ID :->");
				int idUpdate = scan.nextInt();
				customer = CustomerData.findOneCustomer(idUpdate);
				System.out.println("Before Update Details are: "+ customer.toString());
				customer = CustomerData.updateCustomer(customer);
				System.out.println(" After Update Details are: "+ customer.toString());
				adminMenu();
				break;
			case '5':
				System.out.println(choice);
				System.out.print("Please Enter Customer ID :->");
				int idDelete = scan.nextInt();
				customer = CustomerData.findOneCustomer(idDelete);
				if(customer==null) {
					System.out.println("Record with this id does not exists");
				}else {
					CustomerData.deleteCustomer(customer);
					System.out.println("Record deleted");
				}
				adminMenu();
				break;
			case '6':
				System.out.println("Thank you For visiting us ");
				System.exit(0);
				break;
			default:
				System.out.println("InValid Input!!! Enter Again!");
				break;
			}
		}while(!(choice=='1'||choice=='2'||choice=='3'||choice=='4'||choice=='5'||choice=='6'));

	}
	
			}
			
