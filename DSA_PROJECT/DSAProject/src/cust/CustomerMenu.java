package cust;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {

	
	

		public static void Menu()
		{
		int choice;
		boolean i=true;
		Scanner sc=new Scanner(System.in);
		while(i)
		{
			System.out.println("=====================================================");
			System.out.println("Customers Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert The Customers Data");
			System.out.println("2.   Delete The Customers Data");
			System.out.println("3.   Show The Customers Data");
			System.out.println("4.   Search The Customers Data");
			System.out.println("5.   Delete All The Customers Data Record");
			System.out.println("6.   Find Customers Data Record in Row wize  ");
			
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = sc.nextInt();

			switch(choice)

			{
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Customer");
				System.out.println("---------------------------------");
				Customer Customer = new Customer();
				
				System.out.println("Enter Customer ID :");
				int Customer_ID=sc.nextInt();
				
				Customer.setCUSTOMER_ID(Customer_ID);
				
				System.out.println("Enter Customer Name : ");
				String Customer_name=sc.nextLine();
				Customer_name+=sc.nextLine();	
				Customer.setCUSTOMER_NAME(Customer_name);
				
				System.out.println("Enter Company Name : ");
				String name=sc.nextLine();
			
				Customer.setCOMPANY_NAME(name);
				
				
				System.out.println("Enter Customer Gender : ");
				String gender=sc.nextLine();
				gender+=sc.nextLine();
				Customer.setCUSTOMER_GENDER(gender);
				
				System.out.println("Enter Customer Address : ");
				String Add = sc.nextLine();
				Customer.setCUSTOMER_ADDRESS(Add);
				
				System.out.println("Enter Customer POSTAL CODE: ");
				int Code = sc.nextInt();
				Customer.setCUSTOMER_POSTALCODE(Code);
				
				System.out.println("Enter Customer Number : ");
				int No = sc.nextInt();
				Customer.setCUSTOMER_PHONE(No);
				
				Customer = CustomerData.Save(Customer);
				System.out.println(Customer.toString());
				System.out.println("---------------------------------");
				break;
				
				
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Customer");
				System.out.println("---------------------------------");
				System.out.println("Enter Customer ID: ");
				int ID=sc.nextInt();
				Customer Customerdelete = CustomerData.deleteOne(ID);
				System.out.println(Customerdelete.toString());
				System.out.println("---------------------------------");
				break;
				
				case 3:
					
					System.out.println("---------------------------------");
					System.out.println("Show All Customers Data");
					System.out.println("---------------------------------");
					
					List<Customer> Customers=CustomerData.findAll();
					for(int j=0;j<Customers.size();j++)
					{
						System.out.println(Customers.get(j).toString());
					}
					System.out.println("---------------------------------");
					break;
				case 4 :
					System.out.println("---------------------------------");
					System.out.println("Search Customers");
					System.out.println("---------------------------------");
	                System.out.println("Enter Customer Search");
	                String Search=sc.nextLine();
	                List<Customer> search=CustomerData.search(Search);
	                
	                for (int j=0; j<search.size(); j++) {
						System.out.println(search.get(j).toString());
					}
					System.out.println("---------------------------------");
					
					break;
				case 5:
					System.out.println(" Delete All records of Customers");
					String del=CustomerData.DeleteAll();
					System.out.println(del);
					break;
				case 6:
			
					Scanner Sc=new Scanner(System.in);
					System.out.println("Enter Customer ID to find:-");
					int sc1=Sc.nextInt();
				System.out.println("\n______Found the Matching ID  record in row___________\n");
				Customer=CustomerData.findOne(sc1);
				System.out.println(Customer.toString());
				
				break;
					
			
				case 10:
					i=false;
		}
		
	}}}


