package com.system.menu;

import com.system.admin.AdminMenu;
import com.system.input.Input;

public class Menu {
	
	public static void mainMenu() {
		Input input = new Input();
		try{
			while (true) {
				char ch = ' ';
				do {
					System.out.println("Enter Your Choice:\n ");
					System.out.println("1. Enter Food Order Menu");
					System.out.println("2. Enter Administrator Panel");
					System.out.println("3. Enter Admin Menu");
					System.out.println("4. Exit System!!!");
					System.out.print("Choice:->");
					ch =  input.inputChar();
					System.out.println("\n\n\n\n");
					switch (ch) {
					case '1':
						FoodMenu.foodMenu();
						break;
					case '2':
						AdministratorPanel.administratorPanel();
						break;
					case '3':
						AdminMenu.adminMenu();
						break;
					case '4':
						System.out.println("System Exiting. \n-> Thank You For Using Our System!");
						System.exit(0);
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

	

}
