package com.system.admin;

import java.util.LinkedList;

import com.system.input.Input;
import com.system.menu.Menu;

public class AdminMenu {

	public static void adminMenu() {
		Input input = new Input();
		LinkedList<AdminSecurity> admins = null;
		AdminSecurity admin = null;

		try{
			while (true) {
				int ch = -1;
				do {
					System.out.println("\n\n\n\nEnter Your Choice:\n ");
					System.out.println("1. Add a new Admin");
					System.out.println("2. Get an Admin");
					System.out.println("3. Get All Admins");
					System.out.println("4. Update an Admin Record");
					System.out.println("5. Delete an Admin Record");
					System.out.println("6. Return to Main Menu");
					System.out.print("Choice:->");
					ch =  input.inputInt();
					admins = null;
					switch (ch) {
					case 1:
						admin = new AdminSecurity();
						admin.setAdminId(AdminSecurityDao.getAllAdmins().getLast().getAdminId()+1);

						System.out.print("Enter Admin UserName:->");
						admin.setAdminUserName(input.inputString());

						System.out.print("Enter Admin Password:->");
						admin.setAdminPassWord(input.inputString());

						AdminSecurityDao.addAdmin(admin);
						System.out.println("Admin Details Added: " + admin.toString());
						break;
					case 2:
						System.out.print("\nEnter Admin Id:->");
						admin = AdminSecurityDao.getAdmin(input.inputInt());
						System.out.println((admin != null ? admin.toString() : "No Admin Found With This Admin Id\nReturning To Menu...!" ));
						break;
					case 3:
						admins = AdminSecurityDao.getAllAdmins();
						if(admins==null) {
							System.out.println("No Record of Admins Found");
						} else {
							admins.forEach(System.out::println);
						}
						break;
					case 4:
						char k = '0';
						System.out.print("\nEnter Admin Id:->");
						admin = AdminSecurityDao.getAdmin(input.inputInt());

						if (admin != null) {
							System.out.println("\nOld Details:\n" + admin.toString()+"\n");
							admin.setAdminId(admin.getAdminId());

							System.out.println("Enter '1' to Update UserName.\nEnter 'Any Number' to Skip UserName Update.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("Enter Admin UserName:->");
								admin.setAdminUserName(input.inputString());
							} else {
								admin.setAdminUserName(admin.getAdminUserName());
							}

							System.out.println("Enter '1' to Update Password.\nEnter 'Any Number' to Skip Password Update.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("Enter Admin Password:->");
								admin.setAdminPassWord(input.inputString());
							} else {
								admin.setAdminPassWord(admin.getAdminPassWord());
							}

							boolean isUpdated = AdminSecurityDao.updateAdmin(admin);
							System.out.println((isUpdated==true) ? "Record Updated.\nNew Data:->"+(admin.toString()) : "Record Not Updated");
						} else {
							System.out.println("No Record With Given Admin Id Found!!!\nReturning To Menu...!" );
						}
						break;
					case 5:
						System.out.print("\nEnter Admin Id:->");
						boolean isDeleted = AdminSecurityDao.deleteAdmin(input.inputInt());
						System.out.println((isDeleted==true) ? "Record Deleted" : "Record Not Deleted");
						break;
					case 6:
						Menu.mainMenu();
						break;
					default:
						System.out.println("\nInvalid Input!!!");
						System.out.println("Enter Your Choice again!!");
						break;
					}
				} while (!(ch==1||ch==2||ch==3||ch==4||ch==5||ch==6));
			}
		} catch(Exception e) {

		}
	}
}
