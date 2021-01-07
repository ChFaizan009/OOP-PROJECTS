package com.atm.main;

import java.util.List;
import java.util.Scanner;

import com.atm.main.account.AccountData;
import com.atm.main.customer.Customer;
import com.atm.main.customer.CustomerData;
import com.atm.main.funds.FundsData;
import com.atm.main.transactions.CustomerTransactions;

@SuppressWarnings("resource")
public class MenuATM {
	
	public static void adminMenu() throws Exception {
		Customer customer = new Customer();
		Scanner scan = new Scanner(System.in);
		char choice;
		System.out.println("\nEnter your choice! ");
		System.out.println("[1. For Seeing Customers List]");
		System.out.println("[2. For Seeing a particular Customer.]");
		System.out.println("[3. For Adding a new Customer.]");
		System.out.println("[4. For Updating record of a Customer.]");
		System.out.println("[5. For Deleting record of a Customer.]");
		System.out.println("[6. For Exiting the System.]");
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
				List<Customer> customers = CustomerData.displayAllCustomers();
				customers.stream().forEach(System.out::println);
				adminMenu();
				break;
			case '2':
				System.out.println(choice);
				customer=null;
				System.out.print("Ente Customer ID to be Found:->");
				int idFound = scan.nextInt();
				customer = CustomerData.findOneCustomer(idFound);
				System.out.println("Your Details Are: "+ customer.toString());
				adminMenu();
				break;
			case '3':
				System.out.println(choice);
				customer=null;
				customer = CustomerData.addCustomer();
				System.out.println("Your Details Are: "+ customer.toString());
				adminMenu();
				break;
			case '4':
				System.out.println(choice);
				System.out.print("Ente Customer ID to be updated:->");
				int idUpdate = scan.nextInt();
				customer = CustomerData.findOneCustomer(idUpdate);
				System.out.println("Details Before Update Are: "+ customer.toString());
				customer = CustomerData.updateCustomer(customer);
				System.out.println("Details After Update Are: "+ customer.toString());
				adminMenu();
				break;
			case '5':
				System.out.println(choice);
				System.out.print("Ente Customer ID to be Deleted:->");
				int idDelete = scan.nextInt();
				customer = CustomerData.findOneCustomer(idDelete);
				if(customer==null) {
					System.out.println("Record with this id does not exists!!!");
				}else {
					CustomerData.deleteCustomer(customer);
					System.out.println("Record deleted");
				}
				adminMenu();
				break;
			case '6':
				System.out.println("Thank you! For visiting us!");
				System.exit(0);
				break;
			default:
				System.out.println("InValid Input!!! Enter Again!");
				break;
			}
		}while(!(choice=='1'||choice=='2'||choice=='3'||choice=='4'||choice=='5'||choice=='6'));

	}

	public static void menu() throws Exception {
		Customer customer = new Customer();
		Scanner scan = new Scanner(System.in);
		char choice;
		System.out.println("\nEnter your choice! ");
		System.out.println("[0. For Seeing your Details.]");
		System.out.println("[1. For Inquring your balance.]");
		System.out.println("[2. For Depositing Cash in Account.]");
		System.out.println("[3. For Widthrawing Cash from Account.]");
		System.out.println("[4. For Complete Transactions History.]");
		System.out.println("[5. For Last 10 Transactions.]");
		System.out.println("[6. For Funds Transfer To another Account.]");
		System.out.println("[7. For Funds Transfer History.]");
		System.out.println("[8. For Exiting the System.]");
		do {
			System.out.print("Choice:=> ");
			choice = scan.next().charAt(0);
			switch (choice) {
			case '0':
				System.out.println(choice);
				System.out.print("Ente Customer ID:->");
				int id= scan.nextInt();
				customer = CustomerData.findOneCustomer(id);
				if(customer==null) {
					System.out.println("Record with this id does not exists!!!");
				}else {				
					System.out.println("Your Details Are: "+ customer.toString());
				}
				menu();
				break;
			case '1':
				System.out.println(choice);
				AccountData.balanceInquiry();
				break;
			case '2':
				System.out.println(choice);
				AccountData.depositCash();
				break;
			case '3':
				System.out.println(choice);
				AccountData.withdrawCash();
				break;
			case '4':
				System.out.println(choice);
				List<String> statements = CustomerTransactions.displayAllStatements();
				statements.stream().forEach(System.out::println);
				menu();
				break;
			case '5':
				System.out.println(choice);
				List<String> statement = CustomerTransactions.displayLast10Statements();
				statement.stream().forEach(System.out::println);
				menu();
				break;
			case '6':
				System.out.println(choice);
				FundsData.fundsTransfer();
				break;
			case '7':
				System.out.println(choice);
				System.out.print("Ente Customer ID:->");
				id= scan.nextInt();
				List<String> fundsHistory = FundsData.fundTransferList(1);;
				if(fundsHistory==null) {
					System.out.println("No funds history with this id Found!!!");
				}else {				
					fundsHistory.stream().forEach(System.out::println);
				}
				menu();
				break;
			case '8':
				System.out.println("Thank you! For visiting us!");
				System.exit(0);
				break;
			default:
				System.out.println("InValid Input!!! Enter Again!");
				break;
			}
		}while(!(choice=='0'||choice=='1'||choice=='2'||choice=='3'||choice=='4'||choice=='5'||choice=='6'||choice=='7'||choice=='8'));


	}

}

