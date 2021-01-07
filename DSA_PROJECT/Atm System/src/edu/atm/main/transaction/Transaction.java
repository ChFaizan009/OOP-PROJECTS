package edu.atm.main.transaction;

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

import edu.atm.main.Menu;

import edu.atm.main.customer.Customer;

public class Transaction
{

	public static String transactionFile = "transaction.csv";
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

	public static void addTransactionStatements(Customer customer,long oldAmount,long newAmount,String depositOrWidthraw,long depositOrWidthrawAmount) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, dd-MMM-yyyy HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(transactionFile, true));
			writer.append(customer.getCUSTOMER_ID()+", "+customer.getCUSTOMER_NAME()+", Old Amount =  "+oldAmount
			+", "+depositOrWidthraw+" Amount =  "+depositOrWidthrawAmount+", New balance =  "+newAmount +", DateAndTime : "+ formattedDate);
			writer.append("\n");
 				
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static List<String> showAllStatementData() throws Exception{
		Scanner scan = new Scanner(System.in);
		System.out.print("Please Enter the Customer Id for check Statement :-> " );
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
		Menu.userMenu();
		return null;
	}
	
	public static List<String> showLastTenTranscationStatement() throws Exception{
		List<String> statements = showAllStatementData();
		List<String> lastTenStatements = new ArrayList<>(); 
		int size = 1;
		for(int i=statements.size()-1; size<=10 ;i--) {
			lastTenStatements.add(statements.get(i));
			size++;
		}
		return lastTenStatements;
	}


}
