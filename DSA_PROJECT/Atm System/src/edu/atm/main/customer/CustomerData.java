package edu.atm.main.customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.atm.main.fund.FundData;
import edu.atm.main.transaction.Transaction;

import edu.atm.main.customer.Customer;
import edu.atm.main.fund.FundData;
import edu.atm.main.transaction.Transaction;

public class CustomerData {

	Scanner sc=new Scanner(System.in);
	
	static
	{
		File file=new File(Customer.CustomerFile);
		if(!(file.exists()))
		{
			try {
				file.createNewFile();
			}
			catch(IOException e)
			{
				e.getStackTrace();
			}
		}
	}
	
	public static Customer AddCustomer()throws Exception
	{
		Customer customer = new Customer();
		try
		{
			Scanner sc=new Scanner(System.in);
			BufferedWriter bf = new BufferedWriter(new FileWriter(Customer.CustomerFile, true));
			
				customer.setCUSTOMER_ID(setId());
				
				System.out.println("Please Enter Your Name : ");
				String name = sc.nextLine();
				customer.setCUSTOMER_NAME(name.toUpperCase());
				
				System.out.println("Please Enter Your Age : ");
				int age = sc.nextInt();
				customer.setCUSTOMER_AGE(age);
				customer.setCUSTOMER_NO_OF_TRANSACTIONS(0);
				
				System.out.println("Please Enter the Amount you want to add for new account: ");
				long amount = sc.nextInt();
				while(amount<=0) {
					System.out.println("You cannot enter amount ");
				}
				customer.setCUSTOMER_BALANCE(amount);
				bf.append(customer.toStringSave());
				bf.append("\n");
				bf.flush();
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
			return customer;
		}
	
    public static List<Customer> ShowAll() throws IOException
    {
    	List<Customer> customers=new ArrayList<>();
    	String line;
    
    try {
		BufferedReader reader = new BufferedReader(new FileReader(Customer.CustomerFile));
		
		while((line=reader.readLine())!=null) { 
			Customer customer = new Customer();	
			String[] row = line.split(",");
			customer.setCUSTOMER_ID(Integer.parseInt(row[0]));
			customer.setCUSTOMER_NAME(row[1]);
			customer.setCUSTOMER_AGE(Integer.parseInt(row[2]));
			customer.setCUSTOMER_BALANCE(Long.parseLong(row[3]));
			customer.setCUSTOMER_NO_OF_TRANSACTIONS(Integer.parseInt(row[4]));
			customers.add(customer);
		}
		reader.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return customers;
}

@SuppressWarnings("resource")
public static Customer findOneCustomer(int Id) throws Exception {
	String line;
	try {
		BufferedReader reader = new BufferedReader(new FileReader(Customer.CustomerFile));
		Customer customer = new Customer();
		while((line=reader.readLine())!=null) {
			String[] row = line.split(",");
			if(Integer.parseInt(row[0])==Id) {
				customer.setCUSTOMER_ID(Integer.parseInt(row[0]));
				customer.setCUSTOMER_NAME(row[1]);
				customer.setCUSTOMER_AGE(Integer.parseInt(row[2]));
				customer.setCUSTOMER_BALANCE(Long.parseLong(row[3]));
				customer.setCUSTOMER_NO_OF_TRANSACTIONS(Integer.parseInt(row[4]));
				return customer;
			}
		}
		reader.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return null;
}


public static Customer updateCustomer(Customer customer) throws Exception {
	Scanner scan = new Scanner(System.in);
	List<Customer> customers = ShowAll();
	try {
		new FileWriter(Customer.CustomerFile, false).close();
		//updating customer
		System.out.println("Enter New details:");
		customer.setCUSTOMER_ID(customer.getCUSTOMER_ID());
		System.out.println("Enter Name: ");
		String name = scan.nextLine();
		customer.setCUSTOMER_NAME(name.toUpperCase());
		System.out.println("Enter Age: ");
		int age = scan.nextInt();
		customer.setCUSTOMER_AGE(age);
		customer.setCUSTOMER_NO_OF_TRANSACTIONS(customer.getCUSTOMER_NO_OF_TRANSACTIONS());
		customer.setCUSTOMER_BALANCE(customer.getCUSTOMER_BALANCE());

		BufferedWriter writer = new BufferedWriter(new FileWriter(Customer.CustomerFile, true));
		for(Customer data : customers) {
			if(customer.getCUSTOMER_ID() == data.getCUSTOMER_ID()) {
				writer.append(customer.toStringSave());
				writer.append("\n");
			} else {
				writer.append(data.toStringSave());
				writer.append("\n");
			}
		}
		updateTransactionFile(customer.getCUSTOMER_ID() , name.toUpperCase());
		updateRecordFunds(customer.getCUSTOMER_ID() , name.toUpperCase());
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}	
	return customer;
}


private static void updateTransactionFile(int Id , String name) throws Exception {
	List<String> customerRecords = new ArrayList<>();
	BufferedReader reader = new BufferedReader(new FileReader(Transaction.transactionFile));
	String line;
	while((line = reader.readLine()) != null) {
		String[] row = line.split(",");
		if(Integer.parseInt(row[0]) == Id) {
			customerRecords.add(row[0]+","+name.toUpperCase()+","+row[2]+","+row[3]+","+row[4]+","+row[5]+","+row[6]);
		}else {
			customerRecords.add(line);
		}
	}
	reader.close();
	new FileWriter(Transaction.transactionFile, false).close();

	BufferedWriter writer = new BufferedWriter(new FileWriter(Transaction.transactionFile, true));
	for (String customerRecord : customerRecords) {
		writer.append(customerRecord);
		writer.append("\n");
	}
	writer.close();
}

public static void updateRecordFunds(int Id ,String name) throws Exception {
	List<String> customerRecords = new ArrayList<>();
	BufferedReader reader = new BufferedReader(new FileReader(FundData.fundsFile));
	String line;
	while((line = reader.readLine()) != null) {
		String[] row = line.split(",");
		String[] rowId = row[1].split(":");
		String[] rowSenderName = row[0].split(":");
		String[] rowRecieverName = row[2].split(":");
		if(Integer.parseInt(rowId[1]) == Id) {
			customerRecords.add(rowSenderName[0]+" : "+name+","+rowId[0]+" : "+rowId[1]+" , "+row[2]+" , "+row[3]+","+row[4]);
		}else if(rowRecieverName[1].equals(name)){
			customerRecords.add(row[1]+","+row[2]+","+rowRecieverName[0]+" : "+name+","+row[3]+","+row[4]);
		}else {
			customerRecords.add(line);
		}
	}	
	reader.close();
	new FileWriter(FundData.fundsFile, false).close();
	BufferedWriter writer = new BufferedWriter(new FileWriter(FundData.fundsFile, true));
	for (String customerRecord : customerRecords) {
		writer.append(customerRecord);
		writer.append("\n");
	}
	writer.close();
}

public static void deleteCustomer(Customer customer) throws Exception {
	List<Customer> customerRecords = new ArrayList<>();
	BufferedReader reader = new BufferedReader(new FileReader(Customer.CustomerFile));
	String line;
	while((line = reader.readLine()) != null) {
		String[] row = line.split(",");
		Customer nonDelCustomer = new Customer();
		if(Integer.parseInt(row[0]) != customer.getCUSTOMER_ID()) {
			nonDelCustomer.setCUSTOMER_ID(Integer.parseInt(row[0]));
			nonDelCustomer.setCUSTOMER_NAME(row[1]);
			nonDelCustomer.setCUSTOMER_AGE(Integer.parseInt(row[2]));
			nonDelCustomer.setCUSTOMER_BALANCE(Long.parseLong(row[3]));
			nonDelCustomer.setCUSTOMER_NO_OF_TRANSACTIONS(Integer.parseInt(row[4]));
			customerRecords.add(nonDelCustomer);
		}
	}	
	reader.close();
	new FileWriter(Customer.CustomerFile, false).close();
	try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(Customer.CustomerFile, true));
		for(Customer data : customerRecords) {
			writer.append(data.toStringSave());
			writer.append("\n");
		}
		writer.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	deleteRecordTransactionFile(customer.getCUSTOMER_ID());
	deleteRecordFundsTransferFile(customer.getCUSTOMER_ID());
}

private static void deleteRecordTransactionFile(int Id) throws Exception {
	List<String> customerRecords = new ArrayList<>();
	BufferedReader reader = new BufferedReader(new FileReader(Transaction.transactionFile));
	String line;
	while((line = reader.readLine()) != null) {
		String[] row = line.split(",");
		if(Integer.parseInt(row[0]) != Id) {
			customerRecords.add(line);
		}
	}
	reader.close();
	new FileWriter(Transaction.transactionFile, false).close();

	BufferedWriter writer = new BufferedWriter(new FileWriter(Transaction.transactionFile, true));
	for (String customerRecord : customerRecords) {
		writer.append(customerRecord);
		writer.append("\n");
	}
	writer.close();
}

private static void deleteRecordFundsTransferFile(int Id) throws Exception {
	List<String> customerRecords = new ArrayList<>();
	BufferedReader reader = new BufferedReader(new FileReader(FundData.fundsFile));
	String line;
	while((line = reader.readLine()) != null) {
		String[] row = line.split(",");
		String[] rowId = row[1].split(":");
		if(Integer.parseInt(rowId[1]) != Id) {
			customerRecords.add(line);
		}
	}	
	reader.close();
	new FileWriter(FundData.fundsFile, false).close();
	BufferedWriter writer = new BufferedWriter(new FileWriter(FundData.fundsFile, true));
	for (String customerRecord : customerRecords) {
		writer.append(customerRecord);
		writer.append("\n");
	}
	writer.close();
}




public static int setId() throws Exception{
	BufferedReader reader=new BufferedReader(new FileReader(Customer.CustomerFile));
	String line;
	int count=1;
	while((line=reader.readLine())!=null)
	{
		count++;
	}
	reader.close();
	
	return count;
}

}