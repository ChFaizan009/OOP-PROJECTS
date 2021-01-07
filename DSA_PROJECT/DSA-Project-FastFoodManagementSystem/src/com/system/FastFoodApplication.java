package com.system;

import java.util.HashMap;
import java.util.LinkedList;

import com.system.admin.AdminSecurity;
import com.system.admin.AdminSecurityDao;
import com.system.input.Input;
import com.system.menu.Menu;

public class FastFoodApplication {

	public static void main(String[] args) {
		while(true) {
			boot();
		}	
	}
	
	public static void boot() {
		LinkedList<AdminSecurity> admins = AdminSecurityDao.getAllAdmins();
		HashMap<String, String> admin = new HashMap<>();
		Input input = new Input();

		for (AdminSecurity adminSecurity : admins) {
			admin.put(adminSecurity.getAdminUserName(), adminSecurity.getAdminPassWord());
		}
		
		System.out.print("Enter UserName: ");
		String userName = input.inputString();
		
		String password = admin.get(userName.toLowerCase());
		System.out.print("Enter Password: ");
		String tempPass = input.inputString();
		
		if(password==null || password=="") {
			System.out.println("\nNo User With this user Name exists!  "+userName);
		} else if (tempPass.toLowerCase().equals(password)) {
			System.out.println("\nWelcome "+ userName);
			Menu.mainMenu();
		} else {
			System.out.println("In Correct Password!!!");
		}
	}
}
