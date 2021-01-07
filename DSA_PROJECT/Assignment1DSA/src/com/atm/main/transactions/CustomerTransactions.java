package com.atm.main.transactions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.atm.main.MenuATM;
import com.atm.main.customer.Customer;

public class CustomerTransactions {
	public static String transactionFile = "transactions.csv";
	static {
		File file = new File(transactionFile);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void addStatements(Customer customer,long oldAmount,long newAmount,String depositOrWidthraw,long depositOrWidthrawAmount) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E dd-MMM-yyyy HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(transactionFile, true));
			writer.append(customer.getCustomerId()+", "+customer.getCustomerName()+", Old Amount="+oldAmount
			+", "+depositOrWidthraw+" Amount="+depositOrWidthrawAmount+", New balance="+newAmount +", Transaction Number:"+customer.getCustomerNoOfTransactions()
			+", DateAndTime:"+ formattedDate);
			writer.append("\n");
				
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public static List<String> displayAllStatements() throws Exception{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Customer Id for statement check:-> " );
		int Id = scan.nextInt();
		List<String> statements = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(transactionFile));
			String line;
			while((line=reader.readLine())!=null) {
				String[] row = line.split(",");
				if(Integer.parseInt(row[0])==Id) {
					statements.add(line);
				}
			}
			reader.close();
			return statements;
		} catch (Exception e) {
			e.printStackTrace();
		}
		MenuATM.menu();
		return null;
	}
	
	public static List<String> displayLast10Statements() throws Exception{
		List<String> statements = displayAllStatements();
		List<String> lastTenStatements = new ArrayList<>(); 
		int counter = 1;
		if(statements.size()>=10) {
			for(int i=statements.size()-1; counter<=10 ;i--) {
				lastTenStatements.add(statements.get(i));
				counter++;
			}
		}
		else {
			for(int i=statements.size()-1; counter<=statements.size(); i--) {
				lastTenStatements.add(statements.get(i));
				counter++;
			}
		}
		return lastTenStatements;
	}
	
}
