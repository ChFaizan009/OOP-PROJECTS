package com.system.customer;

import java.util.List;

import com.system.input.Input;
import com.system.menu.AdministratorPanel;
import com.system.order.Order;
import com.system.order.OrderDao;

public class CustomerMenu {

	public static void customerMenu() {
		List<Customer> customers = null;
		Customer customer = null;
		Input input = new Input();

		try{
			while (true) {
				int ch = -1;
				do {
					System.out.println("\n\n\n\nEnter Your Choice:\n ");
					System.out.println("1. Get All Customers History");
					System.out.println("2. Get Customers Today History");
					System.out.println("3. Get This Months Customer History");
					System.out.println("4. Get Customer Details By Customer Entry Number");
					System.out.println("5. Get Customer Details By Order ID");
					System.out.println("6. Update a Customer Record");
					System.out.println("7. Delete a Customer Record");
					System.out.println("8. Return to Main Menu");
					System.out.print("Choice:->");
					ch =  input.inputInt();
					customers = null;
					switch (ch) {
					case 1:
						customers = CustomerDao.getAllHistory();
						if(customers==null) {
							System.out.println("\nNo Record Exists");
						} else {
							customers.forEach(System.out::println);
						}
						break;
					case 2:
						customers = CustomerDao.getTodayHistory();
						if(customers==null) {
							System.out.println("\nNo Record of today Date exists");
						} else {
							customers.forEach(System.out::println);
						}
						break;
					case 3:
						customers = CustomerDao.getPresentMonthHistory();
						if(customers==null) {
							System.out.println("\nNo Record of This Month exists");
						} else {
							customers.forEach(System.out::println);
						}
						break;
					case 4:
						System.out.print("\nEnter Customer Entry Number:->");
						customer = CustomerDao.getCustomer(input.inputInt());
						System.out.println((customer == null ? "Customer Not Found" : "\nCustomer Details Are:\n->"+customer.toString()));
						break;
					case 5:
						System.out.print("\nEnter Order ID:->");
						Integer orderId = input.inputInt();
						Order order = OrderDao.getOrder(orderId);

						customer = CustomerDao.getCustomerDetailsbyOrderId(order.getCustomerEntryNumber());
						System.out.println((customer == null ? "Record Not Found" : customer.toString()));
						break;
					case 6:
						char k ='0';
						System.out.print("\nEnter Customer Entry Number:->");
						customer = CustomerDao.getCustomer(input.inputInt());

						if (customer != null) {
							System.out.println("\nOld Details:\n" + customer.toString()+"\n");
							customer.setCustomerEntryNumber(customer.getCustomerEntryNumber());

							System.out.println("\nEnter '1' to Update Customer Name.\nEnter 'Any Number' to Skip Customer Name Update.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("Enter Customer Name:->");
								customer.setCustomerName(input.inputString());
							} else {
								customer.setCustomerName(customer.getCustomerName());
							}

							System.out.println("\nEnter '1' to Update Customer MemberShip Code.\nEnter 'Any Number' to Skip Customer MemberShip Code Update.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("Enter MemberShip Code:->");
								customer.setCustomerMemberShip(input.inputInt());
							} else {
								customer.setCustomerMemberShip(customer.getCustomerMemberShip());
							}

							boolean isUpdated = CustomerDao.updateCustomer(customer);
							System.out.println((isUpdated==true) ? "Record Updated\nNew Data:->"+customer.toString() : "Record Not Updated");

						} else {
							System.out.println("Customer Not Found");
						}
						break;
					case 7:
						System.out.print("\nEnter Customer Entry Number:->");
						boolean isDeleted = CustomerDao.deleteCustomer(input.inputInt());
						System.out.println((isDeleted==true) ? "Record Deleted" : "Record Not Deleted");
						break;
					case 8:
						AdministratorPanel.administratorPanel();
						break;
					default:
						System.out.println("\nInvalid Input!!!");
						System.out.println("Enter Your Choice again!!");
						break;
					}
				} while (!(ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'));
			}
		} catch(Exception e) {

		}

	}

}
