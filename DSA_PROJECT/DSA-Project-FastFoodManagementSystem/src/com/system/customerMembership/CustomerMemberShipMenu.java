package com.system.customerMembership;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import com.system.input.Input;
import com.system.menu.AdministratorPanel;

public class CustomerMemberShipMenu {

	public static void customerMemberShipMenu() {
		LinkedList<CustomerMemberShip> customers = null;
		CustomerMemberShip customer = null;
		Input input = new Input();
		try{
			while (true) {
				int ch = -1;
				do {
					System.out.println("\n\n\n\nEnter Your Choice:\n ");
					System.out.println("1. Add a new MemberShip Customer");
					System.out.println("2. View All MemberShip Customers");
					System.out.println("3. Get a MemberShip Customer");
					System.out.println("4. Update a MemberShip Customer");
					System.out.println("5. Delete a MemberShip Customer");
					System.out.println("6. Return to menu");
					System.out.print("Choice:->");
					ch =  input.inputInt();
					customers = null;
					customer = null;
					switch (ch) {
					case 1:
						CustomerMemberShip c = new CustomerMemberShip();
						c.setMemberShipID(1000+CustomerMemberShipDao.getAllMemberShipCustomer().size());

						int randomNumber = 0;
						while(!(randomNumber>999 && randomNumber<10000)) {
							randomNumber = (int)( Math.random() * 9999 );
							if( randomNumber <= 1000 ) {
								randomNumber = randomNumber + 1000;
							} else if( randomNumber >= 10000 ) {
								randomNumber = randomNumber - 1000;
							}
						}
						c.setMemberShipCode(randomNumber);

						System.out.print("Enter name:->");
						c.setMemberShipName(input.inputString());

						c.setMemberShipStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
						System.out.println("Select member ship type:->");
						int i=1;
						for(MemberShipType e : MemberShipType.values()) {
							System.out.println(i +". "+e.toString());
							i++;
						}
						do {
							System.out.print("Enter Choice:->");
							i = input.inputInt();
							if(i==1) {
								c.setMemberShipType(MemberShipType.BRONZE);
								c.setMemberShipEndDate(LocalDateTime.now().plusMonths(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
							} else if(i==2) {
								c.setMemberShipType(MemberShipType.SILVER);
								c.setMemberShipEndDate(LocalDateTime.now().plusMonths(4).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
							} else if(i==3) {
								c.setMemberShipType(MemberShipType.GOLD);
								c.setMemberShipEndDate(LocalDateTime.now().plusMonths(6).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
							} else {
								System.out.println("Invalid Input!!!");
							}
						}while(!(i==1||i==2||i==3));
						System.out.println("Selected Choice: " + c.getMemberShipType().name());

						c.setActive(true);
						System.out.println();

						CustomerMemberShipDao.addMemberShipCustomer(c);
						System.out.println("\nData:\n"+ c.toString()+"\n");
						break;
					case 2:
						customers = CustomerMemberShipDao.getAllMemberShipCustomer();
						if (customers == null) {
							System.out.println("No Record Found");
						} else {
							customers.forEach(System.out::println);
						}
						break;
					case 3:
						customer = new CustomerMemberShip();
						System.out.print("Enter Customer Member Ship Code:->");
						customer = CustomerMemberShipDao.getMemberShipCustomer(input.inputInt());

						System.out.println((customer !=null ? customer.toString() : "No Record with This Code Found\nReturning To Menu...!"));
						break;
					case 4:
						char k ='0';
						System.out.print("\nEnter Customer Member Ship Code:->");
						customer = CustomerMemberShipDao.getMemberShipCustomer(input.inputInt());

						if (customer != null) {
							System.out.println("\nOld Details:\n"+ customer.toString()+"\n");

							customer.setMemberShipID(customer.getMemberShipID());
							customer.setMemberShipCode(customer.getMemberShipCode());

							System.out.println("\nEnter '1' to Update Customer Name.\nEnter 'Any Number' to Skip Customer Name Update.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("Enter name:->");
								customer.setMemberShipName(input.inputString());
							}

							System.out.println("\nEnter '1' to Update MemberShip Type.\nEnter 'Any Number' to Skip MemberShip Type Update.");
							System.out.println("Note: Changing MemberShip Type will Reset Your MemberShip Starting and Ending Date.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.println("Select member ship type: ");
								int j=1;
								for(MemberShipType e : MemberShipType.values()) {
									System.out.println(j +". "+e.toString());
									j++;
								}
								do {
									System.out.print("Enter Choice:->");
									j = input.inputInt();
									if(j==1) {
										customer.setMemberShipType(MemberShipType.BRONZE);
										customer.setMemberShipStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
										customer.setMemberShipEndDate(LocalDateTime.now().plusMonths(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
									} else if(j==2) {
										customer.setMemberShipType(MemberShipType.SILVER);
										customer.setMemberShipStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
										customer.setMemberShipEndDate(LocalDateTime.now().plusMonths(4).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
									} else if(j==3) {
										customer.setMemberShipType(MemberShipType.GOLD);
										customer.setMemberShipStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
										customer.setMemberShipEndDate(LocalDateTime.now().plusMonths(6).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
									} else {
										System.out.println("Invalid Input!!!");
									}
								}while(!(j==1||j==2||j==3));
								System.out.println("\nSelected Choice: " + customer.getMemberShipType().name());
								System.out.println("New Dates: \n->Start Date: "+ customer.getMemberShipStartDate()+"\n->End Date:" + customer.getMemberShipEndDate());
							}

							System.out.println("\nEnter '1' To Keep Account Active.\nEnter 'Any Number' to De-Activate Account.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								customer.setActive(true);
							} else {
								customer.setActive(false);
							}

							boolean isUpdated = CustomerMemberShipDao.updateCustomerMemberShip(customer);
							System.out.println((isUpdated==true) ? "Record Updated\nNew Data:->"+customer.toString() : "Record Not Updated");
						} else {
							System.out.println("No Record with This Code Found\nReturning To Menu...!");
						}
						break;
					case 5:
						System.out.print("Enter Customer Member Ship Code:->");
						boolean isDeleted = CustomerMemberShipDao.deleteCustomerMemberShip(input.inputInt());
						System.out.println((isDeleted==true) ? "Record Deleted" : "Record Not Deleted");
						break;
					case 6:
						AdministratorPanel.administratorPanel();
						break;
					default:
						System.out.println("\nInvalid Input!!!");
						break;
					}
				} while (!(ch==1||ch==2||ch==3||ch==4||ch==5||ch==6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
