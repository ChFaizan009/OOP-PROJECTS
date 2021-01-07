package com.system.menu;

import com.system.customer.CustomerMenu;
import com.system.customerMembership.CustomerMemberShipMenu;
import com.system.employee.EmployeeMenu;
import com.system.foodItem.FoodItemMenu;
import com.system.input.Input;
import com.system.order.OrderMenu;

public class AdministratorPanel {

	public static void administratorPanel() {
		Input input = new Input();
		try{
			while (true) {
				char ch = ' ';
				do {
					System.out.println("Enter Your Choice:\n ");
					System.out.println("1. Enter Customer Menu");
					System.out.println("2. Enter Customer MemberShip Menu");
					System.out.println("3. Enter Employee Menu");
					System.out.println("4. Enter Food Menu");
					System.out.println("5. Enter Order Menu");
					System.out.println("6. Return to Main Menu");
					System.out.print("Choice:->");
					ch =  input.inputChar();
					System.out.println("\n\n\n\n");
					switch (ch) {
					case '1':
						CustomerMenu.customerMenu();
						break;
					case '2':
						CustomerMemberShipMenu.customerMemberShipMenu();
						break;
					case '3':
						EmployeeMenu.employeeMenu();
						break;
					case '4':
						FoodItemMenu.foodItemMenu();
						break;
					case '5':
						OrderMenu.orderMenu();
						break;
					case '6':
						Menu.mainMenu();
						break;
					default:
						System.out.println("\nInvalid Input!!!");
						System.out.println("Enter Your Choice again!!");
						break;
					}
				} while (!(ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'));
			}
		} catch(Exception e) {

		}
	}
	
}
