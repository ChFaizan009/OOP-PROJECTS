package cust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerData

{

	@SuppressWarnings("resource")
	public static List<Customer> findAll()  {
		List<Customer> Customers = new ArrayList<Customer>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Customer.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Customer Customer = new Customer();
				
				
				String[] CustomerRow = line.split(",");
				
				Customer.setCUSTOMER_ID(Integer.parseInt(CustomerRow[0]));
				Customer.setCUSTOMER_NAME(CustomerRow[1]);
				Customer.setCOMPANY_NAME(CustomerRow[2]);
				Customer.setCUSTOMER_GENDER(CustomerRow[3]);
				Customer.setCUSTOMER_ADDRESS(CustomerRow[4]);
				Customer.setCUSTOMER_POSTALCODE(Integer.parseInt(CustomerRow[5]));
				Customer.setCUSTOMER_PHONE(Integer.parseInt(CustomerRow[6]));
				Customers.add(Customer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Customers;
	}

	@SuppressWarnings("resource")
	public static Customer findOne(int Customer_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Customer.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Customer Customer = new Customer();
				
				String[] CustomerRow = line.split(",");
				
				if (Integer.parseInt(CustomerRow[0]) == Customer_ID) {
					Customer.setCUSTOMER_ID(Integer.parseInt(CustomerRow[0]));
					Customer.setCUSTOMER_NAME(CustomerRow[1]);
					Customer.setCOMPANY_NAME(CustomerRow[2]);
					Customer.setCUSTOMER_GENDER(CustomerRow[3]);
					Customer.setCUSTOMER_ADDRESS(CustomerRow[4]);
					Customer.setCUSTOMER_POSTALCODE(Integer.parseInt(CustomerRow[5]));
					Customer.setCUSTOMER_PHONE(Integer.parseInt(CustomerRow[6]));
					
					return Customer;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static Customer findByCode(String Customer_CODE)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Customer.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Customer Customer = new Customer();
				
				
				String[] CustomerRow = line.split(",");
				
				if (CustomerRow[1].contains(Customer_CODE) == true) {
					Customer.setCUSTOMER_ID(Integer.parseInt(CustomerRow[0]));
					Customer.setCUSTOMER_NAME(CustomerRow[1]);
					Customer.setCOMPANY_NAME(CustomerRow[2]);
					Customer.setCUSTOMER_GENDER(CustomerRow[3]);
					Customer.setCUSTOMER_ADDRESS(CustomerRow[4]);
					Customer.setCUSTOMER_POSTALCODE(Integer.parseInt(CustomerRow[5]));
					Customer.setCUSTOMER_PHONE(Integer.parseInt(CustomerRow[6]));		
										
					return Customer;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static List<Customer> search(String search)  {
		List<Customer> Customers = new ArrayList<Customer>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Customer.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Customer Customer = new Customer();
				
				String[] CustomerRow = line.split(",");
				
				if (CustomerRow[1].contains(search) == true) {
					
					Customer.setCUSTOMER_ID(Integer.parseInt(CustomerRow[0]));
					Customer.setCUSTOMER_NAME(CustomerRow[1]);
					Customer.setCOMPANY_NAME(CustomerRow[2]);
					Customer.setCUSTOMER_GENDER(CustomerRow[3]);
					Customer.setCUSTOMER_ADDRESS(CustomerRow[4]);
					Customer.setCUSTOMER_POSTALCODE(Integer.parseInt(CustomerRow[5]));
					Customer.setCUSTOMER_PHONE(Integer.parseInt(CustomerRow[6]));
					
					
					Customers.add(Customer);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Customers;
	}

	@SuppressWarnings("resource")
	public static Customer Save(Customer Customer) {
		FileWriter filewriter;

		List<Customer> Customers = findAll();

		try {
			filewriter = new FileWriter(Customer.csvFile);

			for (int i=0; i<Customers.size(); i++) {
				filewriter.append(Customers.get(i).toString());
				filewriter.append("\n");
			}
			if (Customers.size()>0)
				Customer.setCUSTOMER_ID(Customers.get(Customers.size()-1).getCUSTOMER_ID()+1);
			else
				Customer.setCUSTOMER_ID(1);
			filewriter.append(Customer.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
e.printStackTrace();
		}
		
		
		
		return Customer;
	}
	@SuppressWarnings("resource")
	public static Customer deleteOne(int Customer_ID)  {
		FileWriter filewriter;

		List<Customer> Customers = findAll();
		Customer Customer = findOne(Customer_ID);

		try {
			filewriter = new FileWriter(Customer.csvFile);

			for (int i=0; i<Customers.size(); i++) {
				if (Customers.get(i).getCUSTOMER_ID() != Customer_ID) {
					filewriter.append(Customers.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Customer;
	}
	
	
	
	
public static String DeleteAll() {
		
		FileWriter wr;
		List<Customer>Customers=findAll();
		try {
			wr=new FileWriter(Customer.csvFile);
			for (int i=0;i<Customers.size();i++) {
				Customers.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("Customers Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of Customers ";
	}
	
}
