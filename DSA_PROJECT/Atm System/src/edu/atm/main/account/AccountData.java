package edu.atm.main.account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import edu.atm.main.Menu;
import edu.atm.main.transaction.Transaction;

import edu.atm.main.Menu;
import edu.atm.main.customer.Customer;
import edu.atm.main.customer.CustomerData;
import edu.atm.main.transaction.Transaction;

public class AccountData {

	
	static CustomerData customerData = new CustomerData();

	public static void balanceInquiry() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID of Customer to check Balance:-> " );
		int ID = sc.nextInt();
		Customer customer = CustomerData.findOneCustomer(ID);
		if(customer == null) {
			System.out.println("Requested ID not Found!! ");
		}else {
			System.out.println("Customer Balance is :" + customer.getCUSTOMER_BALANCE());
		}
		Menu.userMenu();
		sc.close();
	}

	public static void depositCash() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter Your ID : " );
		int Id = sc.nextInt();
		Customer customer = CustomerData.findOneCustomer(Id);
		if(customer == null) {
			System.out.println("Requested ID not Found!! ");
		}
		else {
			System.out.print("Please Enter the new Amount you want to deposit :-> ");
			long deposit = sc.nextLong();
			long newAmount = customer.getCUSTOMER_BALANCE() + deposit;
			customer.setCUSTOMER_BALANCE(newAmount);
			customer.setCUSTOMER_NO_OF_TRANSACTIONS(customer.getCUSTOMER_NO_OF_TRANSACTIONS()+1);
			System.out.println("Your detials after Transaction is : \n"+ customer.toString());
			saveAfterTransaction(customer);
			Transaction.addTransactionStatements(customer, customer.getCUSTOMER_BALANCE()-deposit , newAmount , "Deposit" , deposit);
		}
		Menu.userMenu();
		sc.close();		
	}
	
	public static void withdrawCash() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter Your ID : " );
		int Id = sc.nextInt();
		Customer customer = CustomerData.findOneCustomer(Id);
		if(customer == null) {
			System.out.println("Requested ID not Found ");
		}else {
			System.out.print("Please Enter the Amount you want to Widthraw the Money :-> ");
			long withdraw = sc.nextLong();

			while(withdraw<500 || withdraw>25000) {
				System.out.println("Entered Amount does not fulfill widthrawal Requirement!");
				System.out.println("You can enter Amount from [500]-[25000]");
				System.out.print("Enter Again: ");
				withdraw = sc.nextLong();
			}
			
			long newAmount = customer.getCUSTOMER_BALANCE() - withdraw;
			while(newAmount<0) {
				
				System.out.println("Sorry we cannot process this transaction.You do not have this much Amount");
				System.out.println("Your Current balance is : "+ customer.getCUSTOMER_BALANCE()+"]");
				System.out.print("Please Enter Again : ");
				withdraw = sc.nextLong();
				newAmount = customer.getCUSTOMER_BALANCE() - withdraw;
			}
			customer.setCUSTOMER_BALANCE(newAmount);
			customer.setCUSTOMER_NO_OF_TRANSACTIONS(customer.getCUSTOMER_NO_OF_TRANSACTIONS()+1);
			System.out.println("Your detials after Transaction is : \n"+ customer.toString());
			saveAfterTransaction(customer);		
			Transaction.addTransactionStatements(customer,customer.getCUSTOMER_BALANCE()+withdraw , newAmount , "Withdraw" , withdraw);
			}
		Menu.userMenu();
		sc.close();		
	}

	public static void saveAfterTransaction(Customer customer) throws Exception{

		List<Customer> customers = CustomerData.ShowAll();
		try {
			FileWriter write = new FileWriter(Customer.CustomerFile);
			write.write("");
			write.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Customer.CustomerFile, true));
			for(Customer customerData : customers) {
				if(customerData.getCUSTOMER_ID() == customer.getCUSTOMER_ID()) {
					writer.append(customer.toStringSave());
					writer.append("\n");
				}
				else {
					writer.append(customerData.toStringSave());
					writer.append("\n");
				}
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
