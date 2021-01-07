package com.atm.main.funds;

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

import com.atm.main.MenuATM;
import com.atm.main.account.AccountData;
import com.atm.main.customer.Customer;
import com.atm.main.customer.CustomerData;
import com.atm.main.transactions.CustomerTransactions;

public class FundsData {

	public static String fundsFile = "funds.csv";
	static{
		try {
			File file = new File(fundsFile);
			if(!(file.exists())) {
				file.createNewFile();
			}
		} catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void fundsTransfer() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your ID");
		int senderID = scan.nextInt();
		System.out.println("Enter ID of the person you want to transfer fund");
		int recieverID = scan.nextInt();
		Customer sender = CustomerData.findOneCustomer(senderID);
		Customer reciever = CustomerData.findOneCustomer(recieverID);
		while(reciever==null) {
			System.out.println("No Reciver with this ID exists: " + recieverID);
			System.out.print("Enter Reciever ID Again:=> ");
			recieverID = scan.nextInt();
			reciever = CustomerData.findOneCustomer(recieverID);
		}

		System.out.println("Enter amount to be transferred");
		long amount = scan.nextLong();
		long newAmount = sender.getCustomerBalance()-amount;
		
		while(newAmount<0) {
			System.out.println("Sorry you do not have enough money in your account!");
			System.out.println("Amount avalaible is: " + sender.getCustomerBalance());
			System.out.println("Enter amount Again: \nEnter:=> ");
			amount = scan.nextLong();
			newAmount = sender.getCustomerBalance()-amount;
		}
		
		reciever.setCustomerBalance(reciever.getCustomerBalance()+amount);
		sender.setCustomerBalance(sender.getCustomerBalance()-amount);
		System.out.println("Amount Transferred Successfully!");
		System.out.println("Your balance after transaction is:" + sender.getCustomerBalance());
		sender.setCustomerNoOfTransactions(sender.getCustomerNoOfTransactions()+1);
		
		saveFundRecord(sender , reciever ,amount);
		
		AccountData.saveAfterTransaction(sender);
		addStatements(sender, (sender.getCustomerBalance()+amount) , sender.getCustomerBalance(),"Reciver" , reciever.getCustomerName() , amount);
		AccountData.saveAfterTransaction(reciever);
		addStatements(reciever, (reciever.getCustomerBalance()-amount) , reciever.getCustomerBalance(),"Sender" , sender.getCustomerName() , amount);
		
		MenuATM.menu();
		scan.close();
	}
	
	public static void addStatements(Customer customer,long oldAmount,long newAmount,String Transactor,String fundsTransferTO,long fundsTransferAmount) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E dd-MMM-yyyy HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(CustomerTransactions.transactionFile, true));
			writer.append(customer.getCustomerId()+", "+customer.getCustomerName()+", Old Amount="+oldAmount+
			", New balance="+newAmount +", Transaction Number:"+customer.getCustomerNoOfTransactions() +", "+Transactor+" Name: "+ fundsTransferTO+
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
			writer.append("Sender Name:"+sender.getCustomerName()+", Sender's ID:"+sender.getCustomerId()+", Reciever Name:"+reciever.getCustomerName()
			+", Amount transferred:" +amount +", DateAndTime:"+ formattedDate );
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
		MenuATM.menu();
		return null;
	}
}
