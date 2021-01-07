package com.atm.main;

import java.util.Scanner;

public class AtmApplicationClass {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 1 if Admin or else anything for user");
		System.out.println("Enter password: ");
		char j = scan.next().charAt(0);
		char i = '1';
		if(j==i) {
			System.out.println("Welcome Admin: ");
			MenuATM.adminMenu();
		}else {
			System.out.println("Welcome User: ");
			MenuATM.menu();
		}
		scan.close();

	}

}
