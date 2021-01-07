package com.system.order;

import java.util.List;

import com.system.input.Input;
import com.system.menu.AdministratorPanel;

public class OrderMenu {
	
	public static void orderMenu() {
		List<Order> orders = null;
		Order order = null;
		Input input = new Input();
		try{
			while (true) {
				int ch = -1;
				do {
					System.out.println("\n\n\n\nEnter Your Choice:\n ");
					System.out.println("1. View All Orders");
					System.out.println("2. Get Order Details");
					System.out.println("3. Return to menu");
					System.out.print("Choice:->");
					ch =  input.inputInt();
					orders = null;
					order = null;
					switch (ch) {
					case 1:
						orders = OrderDao.getAllOrders();
						if (orders == null) {
							System.out.println("No Record Found");
						} else {
							orders.forEach(System.out::println);
						}
						break;
					case 2:
						System.out.print("\nEnter Order ID:->");
						order = new Order();
						order = OrderDao.getOrder(input.inputInt());
						System.out.println((order == null ? "Order with Requested Id Not Found" : order.toString()));
						break;
					case 3:
						AdministratorPanel.administratorPanel();
						break;
					default:
						System.out.println("\nInvalid Input!!!");
						break;
					}
				} while (!(ch==1||ch==2||ch==3));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
