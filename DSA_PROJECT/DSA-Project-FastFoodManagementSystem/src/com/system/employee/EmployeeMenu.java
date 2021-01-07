package com.system.employee;

import java.util.List;

import com.system.input.Input;
import com.system.menu.AdministratorPanel;

public class EmployeeMenu {

	public static void employeeMenu() {
		List<Employee> employees = null;
		Employee employee = null;
		Input input = new Input();
		try{
			while (true) {
				int ch = -1;
				do {
					System.out.println("\n\n\n\nEnter Your Choice:\n ");
					System.out.println("1. Add a new Employee");
					System.out.println("2. View All Employees");
					System.out.println("3. View All Working Employees");
					System.out.println("4. Get an Employee");
					System.out.println("5. Update an Employee");
					System.out.println("6. Delete an Employee");
					System.out.println("7. Return to menu");
					System.out.print("Choice:");
					ch =  input.inputInt();
					switch (ch) {
					case 1:
						employee = new Employee();
						employee.setEmployeeCode(EmployeeDao.getAllEmployees().getLast().getEmployeeCode()+1);

						System.out.print("\nEnter Employee Name:->");
						employee.setEmployeeName(input.inputString());

						System.out.print("\nEnter Employee Age:->");
						employee.setEmployeeAge(input.inputInt());

						System.out.print("\nEnter Employee Salary:->");
						employee.setEmployeeSalary(input.inputInt());

						System.out.print("\nEnter Employee Contact#:->");
						employee.setEmployeeContactNumber(input.inputLong());

						System.out.print("\nEnter Employee Work Hours:->");
						employee.setEmployeeWorkHours(input.inputInt());

						System.out.println("\nSelect Employee Status.");
						int i=1;
						for(EmployeeStatus status : EmployeeStatus.values()) {
							System.out.println(i +". "+status.toString());
							i++;
						}
						do {
							System.out.print("\nEnter Choice:->");
							i = input.inputInt();
							if(i==1) {
								employee.setEmployeeStatus(EmployeeStatus.Single);
							} else if(i==2) {
								employee.setEmployeeStatus(EmployeeStatus.Married);
							} else if(i==3) {
								employee.setEmployeeStatus(EmployeeStatus.Student);
							} else {
								System.out.println("Invalid Input!!!");
							}
						}while(!(i==1||i==2||i==3));
						System.out.println("Selected Choice:->" + employee.getEmployeeStatus().name());

						System.out.print("\nEnter Employee Address:->");
						employee.setEmployeeAddress(input.inputString());

						System.out.println("is Employee Working? :");
						System.out.println("\nEnter 1 for yes and any for No.");
						System.out.print("Input:->");
						i = input.inputInt();
						if(i==1) {
							employee.setWorking(true);
						} else {
							employee.setWorking(false );
						}

						EmployeeDao.addEmployee(employee);
						System.out.println("Employee Added:"+employee.toString());
						break;
					case 2:
						employees = EmployeeDao.getAllEmployees();
						if(employees == null) {
							System.out.println("No Employee Record Found!");
						}else {
							employees.forEach(System.out::println);
						}
						break;
					case 3:
						employees = EmployeeDao.getWorkingEmployee();
						if(employees == null) {
							System.out.println("No Employee Record Found!");
						}else {
							employees.forEach(System.out::println);
						}
						break;
					case 4:
						System.out.print("\nEnter Employee Code:->");
						employee = EmployeeDao.getEmployee(input.inputInt());
						if(employee == null) {
							System.out.println("No Employee With The Given Id is Found!");
						}else {
							System.out.println(employee.toString());
						}
						break;
					case 5:
						char k = '0';
						System.out.print("\nEnter Employee Code:->");
						employee = EmployeeDao.getEmployee(input.inputInt());

						if(employee != null) {
							System.out.println("\nOld Details:\n" + employee.toString()+"\n");

							employee.setEmployeeCode(employee.getEmployeeCode());

							System.out.println("\nEnter '1' to Update Employee Name.\nEnter 'Any Number' to Skip Employee Name Update.");
							System.out.print("\nEnter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("\nEnter Employee Name:->");
								employee.setEmployeeName(input.inputString());
							} else {
								employee.setEmployeeName(employee.getEmployeeName());
							}

							System.out.println("\nEnter '1' to Update Employee Age.\nEnter 'Any Number' to Skip Employee Age Update.");
							System.out.print("\nEnter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("\nEnter Employee Age:->");
								employee.setEmployeeAge(input.inputInt());
							} else {
								employee.setEmployeeAge(employee.getEmployeeAge());
							}

							System.out.println("\nEnter '1' to Update Employee Salary.\nEnter 'Any Number' to Skip Employee Salary Update.");
							System.out.print("\nEnter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("\nEnter Employee Salary:->");
								employee.setEmployeeSalary(input.inputInt());
							} else {
								employee.setEmployeeSalary(employee.getEmployeeSalary());
							}

							System.out.println("\nEnter '1' to Update Employee Contact#.\nEnter 'Any Number' to Skip Employee Contact# Update.");
							System.out.print("\nEnter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("\nEnter Employee Contact#:->");
								employee.setEmployeeContactNumber(input.inputLong());
							} else {
								employee.setEmployeeContactNumber(employee.getEmployeeContactNumber());
							}

							System.out.println("\nEnter '1' to Update Employee Work Hours.\nEnter 'Any Number' to Skip Employee Work Hours Update.");
							System.out.print("\nEnter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("\nEnter Employee Work Hours:->");
								employee.setEmployeeWorkHours(input.inputInt());
							} else {
								employee.setEmployeeWorkHours(employee.getEmployeeWorkHours());
							}

							System.out.println("\nEnter '1' to Update Employee Status.\nEnter 'Any Number' to Skip Employee Status Update.");
							System.out.print("\nEnter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.println("Select Employee Status.");
								i=1;
								for(EmployeeStatus status : EmployeeStatus.values()) {
									System.out.println(i +". "+status.toString());
									i++;
								}
								do {
									System.out.print("\nEnter Choice:->");
									i = input.inputInt();
									if(i==1) {
										employee.setEmployeeStatus(EmployeeStatus.Single);
									} else if(i==2) {
										employee.setEmployeeStatus(EmployeeStatus.Married);
									} else if(i==3) {
										employee.setEmployeeStatus(EmployeeStatus.Student);
									} else {
										System.out.println("Invalid Input!!!");
									}
								}while(!(i==1||i==2||i==3));
								System.out.println("Selected Choice:->" + employee.getEmployeeStatus().name());
							} else {
								employee.setEmployeeStatus(employee.getEmployeeStatus());
							}

							System.out.println("\nEnter '1' to Update Employee Address.\nEnter 'Any Number' to Skip Employee Address Update.");
							System.out.print("\nEnter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("\nEnter Employee Address:->");
								employee.setEmployeeAddress(input.inputString());
							} else {
								employee.setEmployeeAddress(employee.getEmployeeAddress());
							}

							System.out.println("\nEnter '1' to Mark As Working Employee.\nEnter 'Any Number' to Mark As Non-Working Employee.");
							System.out.print("\nEnter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								employee.setWorking(true);
							} else {
								employee.setWorking(false);
							}

							boolean isUpdated = EmployeeDao.updateEmployee(employee);
							System.out.println((isUpdated==true) ? "Record Updated.\nNew Data:->"+employee.toString() : "Record Not Updated");
						}else {
							System.out.println("No Employee With The Given Id is Found!");
						}
						break;
					case 6:
						System.out.print("\nEnter Employee Code:->");
						boolean isDeleted = EmployeeDao.deleteEmployee(input.inputInt());
						System.out.println((isDeleted==true) ? "Record Deleted" : "Record Not Deleted");
						break;
					case 7:
						AdministratorPanel.administratorPanel();
						break;	
					default:
						System.out.println("\nInvalid Input!!!");
						break;
					}
				} while (!(ch==1||ch==2||ch==3||ch==4||ch==5||ch==6||ch==7));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}