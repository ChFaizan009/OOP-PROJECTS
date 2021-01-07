package com.system.menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import com.system.customer.Customer;
import com.system.customer.CustomerDao;
import com.system.foodItem.FoodItem;
import com.system.foodItem.FoodItemDao;
import com.system.input.Input;
import com.system.linkedlist.LinkedListClass;
import com.system.order.Order;
import com.system.order.OrderDao;

public class FoodMenu {

	static LinkedListClass list = null;
	
	public static void foodMenu() {
		Order order = null;
		Input input = new Input();
		try{
			while (true) {
				char ch = ' ';
				do {
					System.out.println("\n\nEnter Your Choice:\n ");
					System.out.println("1. Order Food");
					System.out.println("2. Get Your Order Details");
					System.out.println("3. Check Order Delivery Remaining Time");
					System.out.println("4. Return to Main Menu");
					System.out.print("Choice:->");
					ch =  input.inputChar();
					switch (ch) {
					case '1':
						FoodMenu.Menu();
						break;
					case '2':
						System.out.print("Enter Order ID:");
						order = new Order();
						order = OrderDao.getOrder(input.inputInt());
						
						System.out.println((order == null ? "Order with Requested Id Not Found" : order.toString()));
						break;
					case '3':
						System.out.print("Enter Order ID:");
						Integer RemainingTime = OrderDao.getOrderDeliveryRemainigTime(input.inputInt());
						System.out.println("Remaining Time is: "+RemainingTime +" Minutes");
						break;
					case '4':
						Menu.mainMenu();
						break;
					default:
						System.out.println("\nInvalid Input!!!");
						System.out.println("Enter Your Choice again!!");
						break;
					}
				} while (!(ch=='1'||ch=='2'||ch=='3'||ch=='4'));
			}
		} catch(Exception e) {

		}

	}

	public static void Menu() {
		Input input = new Input();
		System.out.println("\n\nWelcome To Food Menu");
		System.out.println("Select Food Items That you want to Eat");
		LinkedList<FoodItem> foodItems = FoodItemDao.getAllFoodItems();
		list = new LinkedListClass();
		
		int k=1;
		int bill = 0;
		int choice = 0;
		int j=1;
		
		for (FoodItem foodItem : foodItems) {
			System.out.print(foodItem.getFoodItemId()+". "+foodItem.getFoodItemName()+"    ");
			if(j%3==0) {System.out.println();}j++;
		}

		System.out.println("Enter Your Order");
		System.out.println("Enter Food Id to Add that Item.\n");
		while(k!=0) {
			int id = -1;
			int amount = -1;

			System.out.print("Enter Food Item Number: ");
			id = input.inputInt();
			if(id == 0) {break;}

			System.out.print("Enter Amount: ");
			amount = input.inputInt();
			if(amount == 0 ) {break;}

			FoodItem foodItem = FoodItemDao.getFoodItem(id);
			int price = foodItem.getFoodItemPrice();
			bill = (amount*price);
			list.add(id, amount, price, bill, foodItem.getFoodItemName());
		}
		
		do {
			System.out.println("To Finalize Order Enter 1 \n"
					+ "To Cancel Order Enter 0. ");
			choice = input.inputInt();
			if(choice == 0) {
				System.out.println("Cancelling Order....");
				foodMenu();
			} else if (choice == 1) {
				list.getAll();
				bookOrder();
			} else {
				System.out.println("Invalid Input..");
			}
		} while (!(choice==0||choice==1));
		
	}

	public static void bookOrder() {
		Customer customer = new Customer();
		Order order = new Order();
		Input input = new Input();
		//saving customer details
		customer.setCustomerEntryNumber(CustomerDao.getAllHistory().getLast().getCustomerEntryNumber()+1);

		System.out.print("Enter Customer Name: ");
		customer.setCustomerName(input.inputString());

		customer.setCustomerBill(list.getBill());
		customer.setCustomerFoodItemIds(list.getIds());
		customer.setCustomerFoodPurchaseTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")));
		customer.setCustomerFoodItemNames(list.getNames());

		System.out.print("Enter Customer Member Ship Code: ");
		customer.setCustomerMemberShip(input.inputInt());

		//saving order details
		order.setOrderId(OrderDao.getAllOrders().getLast().getOrderId()+1);
		order.setCustomerMemberShipCode(customer.getCustomerMemberShip());
		order.setOrderStartTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")));
		order.setOrderEndTime(LocalDateTime.now().plusMinutes(30).format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")));
		order.setOrderDileveryTime(LocalDateTime.now().plusMinutes((list.getCount()*4)).format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")));
		order.setCustomerEntryNumber(customer.getCustomerEntryNumber());
		customer.setOrderId(order.getOrderId());

		//saving to database
		System.out.println("Customer Details");
		System.out.println(customer.toStringCustomer());
		CustomerDao.addRecord(customer);

		System.out.println("Order Details");
		System.out.println(order.toString());
		OrderDao.addOrder(order);
	}
}
