package edu.atm.main.fund;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.atm.main.Menu;
import edu.atm.main.transaction.Transaction;

import edu.atm.main.Menu;
import edu.atm.main.account.AccountData;
import edu.atm.main.customer.Customer;
import edu.atm.main.customer.CustomerData;
import edu.atm.main.transaction.Transaction;

public class FundData
{

	public static String fundsFile = "fund.csv";
	static {
		
			try {
				File file = new File(fundsFile);
				if(!(file.exists())) {
					file.createNewFile();
				}
			} catch(Exception e){
				e.printStackTrace();
			}
	}
	
	public static void fundTransfer() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter Your ID ");
		int senderID = sc.nextInt();
		System.out.println("Please Enter ID of the person who want to transfer funds ");
		int recieverID = sc.nextInt();
		Customer sender = CustomerData.findOneCustomer(senderID);
		Customer reciever = CustomerData.findOneCustomer(recieverID);
		
		while(reciever==null) {
		System.out.println("No Record found with this ID exists: " + recieverID);
      	System.out.print("Enter Reciever ID Again : ");
			recieverID = sc.nextInt();
			reciever = CustomerData.findOneCustomer(recieverID);
	}

		System.out.println("Enter amount to be transferred");
		long amount = sc.nextLong();
		long newAmount = sender.getCUSTOMER_BALANCE()-amount;
		
		while(newAmount<0) {
			System.out.println("Sorry you do not enough money in your account!");
			System.out.println("The Amount avalaible in your account is  : " + sender.getCUSTOMER_BALANCE());
			System.out.println("Enter amount Again :  \nEnter : => ");
			amount = sc.nextLong();
			newAmount = sender.getCUSTOMER_BALANCE()-amount;
		}
		
		reciever.setCUSTOMER_BALANCE(reciever.getCUSTOMER_BALANCE()+amount);
		sender.setCUSTOMER_BALANCE(sender.getCUSTOMER_BALANCE()-amount);
		System.out.println("You Entered the Amount Transferred Successfully!");
		System.out.println("Your balance after transaction is : " + sender.getCUSTOMER_BALANCE());
		sender.setCUSTOMER_NO_OF_TRANSACTIONS(sender.getCUSTOMER_NO_OF_TRANSACTIONS()+1);
		
		saveFundRecord(sender , reciever ,amount);
		
		AccountData.saveAfterTransaction(sender);
		addStatements(sender, (sender.getCUSTOMER_BALANCE()+amount) , sender.getCUSTOMER_BALANCE(),"Reciver" , reciever.getCUSTOMER_NAME() , amount);
		AccountData.saveAfterTransaction(reciever);
		addStatements(reciever, (reciever.getCUSTOMER_BALANCE()-amount) , reciever.getCUSTOMER_BALANCE(),"Sender" , sender.getCUSTOMER_NAME() , amount);
		
		Menu.userMenu();
		sc.close();
	}

	
	public static void addStatements(Customer customer,long oldAmount,long newAmount,String Transactor,String fundsTransferTO,long fundsTransferAmount) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E dd-MMM-yyyy HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Transaction.transactionFile, true));
			writer.append(customer.getCUSTOMER_ID()+", "+customer.getCUSTOMER_NAME()+", Old Amount="+oldAmount+
			", New balance="+newAmount +", Transaction Number:"+customer.getCUSTOMER_NO_OF_TRANSACTIONS() +", "+Transactor+" Name: "+ fundsTransferTO+
			", Amount: "+fundsTransferAmount+", DateAndTime:"+ formattedDate);
			writer.append("\n");
				
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveFundRecord(Customer sender , Customer reciever , long amount) throws Exception {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E dd-MMM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fundsFile, true));
			writer.append("Sender Name is : "+sender.getCUSTOMER_NAME()+", Sender ID is : "+sender.getCUSTOMER_ID()+", Reciever Name is : "+reciever.getCUSTOMER_NAME()
			+", Amount transferred is : " +amount +", DateAndTime : "+ formattedDate );
			writer.append("\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static List<String> fundTransferList(int Id) throws Exception {
		List<String> funds = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fundsFile));
			String line;
			while((line=reader.readLine()) != null) {
				String[] row = line.split("ID:");
				String[] data = row[1].split(",");
				if(Integer.parseInt(data[0])==Id) {
					funds.add(line);
				}
			}
			reader.close();
			return funds;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Menu.userMenu();
		return null;
	}
	
}

