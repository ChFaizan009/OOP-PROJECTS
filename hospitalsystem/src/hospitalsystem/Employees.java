package hospitalsystem;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employees extends person {
	private static final File EMPLOYEES_FILE= new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/employees.txt");
	public static Scanner input = new Scanner(System.in);
	private String role;

	public static void main(String[] args) throws Exception {
		Employeescontrol();
	}

	public static void Employeescontrol() throws Exception {
		System.out.println("\n\n\t\tWELCOME TO EMPLOYEE'S MANAGEMENT");
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
					System.out.println("\n\t\tPress 0 to Update Status Of Employees");
					System.out.println("\t\tPress 1 to Display All Employees");
					System.out.println("\t\tPress 2 to Update Employees");
					System.out.println("\t\tPress 3 to Delete Employees");
					System.out.println("\t\tPress 4 to Add Employees");
					System.out.println("\t\tPress 5 to Back to Hospital Management");
					System.out.println("\t\tPress 6 to Log Out");
					System.out.println("\t\tPress 7 to Exit");
					System.out.print("\n\tPlease Enter Your Choice : ");
					flag = false;
					int choice = input.nextInt();
					switch (choice) {
					case 0: {
						ClearingScreen();
						Employees.updatestatusofemployees(Employees.readEmployees());
						break;
					}
					case 1: {
						ClearingScreen();
						Employees.displayEmployees(Employees.readEmployees());
						break;
					}
					case 2: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("UPDATE EMPLOYEES") == true) {
							Employees.updateEmployees(Employees.readEmployees());
						}
						break;
					}
					case 3: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("DELETE EMPLOYEES") == true) {
							Employees.deleteEmployees(Employees.readEmployees());
						}
						break;
					}
					case 4: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("ADD EMPLOYEES") == true) {
							Employees.addEmployees(Employees.readEmployees());
						}
						break;
					}
					case 5: {
						Hospital.HospitalClearingScreen();
						Hospital.hospitalmanagement();
						break;
					}
					case 6: {
						login.LoginClearingScreen();
						login.control();
						break;
					}
					case 7: {
						ClearingScreen();
						login.goodby();
						System.exit(0);
						break;
					}
					default: {
						System.out.println("\n\n\t\t YOU ENTERED WRONG CHOICE ...!");
						break;
					}
					}
				} catch (Exception e) {
					System.out.println("\n\t\t YOU CANNOT DO THAT BRO...!");

				}
			} while (flag == true);
			input.nextLine();
			System.out.println("\n\tDo You Want To Use Employees Management Again [y/n]");
			again = input.next().charAt(0);
			if (again == 'y' || again == 'Y') {
				ClearingScreen();
			}
		} while (again == 'Y' || again == 'y');
	}

	public static void ClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tHOSPITAL EMPLOYEE'S AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public static void updatestatusofemployees(List<Employees> e) {
		input.nextLine();
		System.out.print("\n\t\tPlease Enter Name Of Employee : ");
		String name = input.nextLine();
		System.out.print("\n\t\tPlease Enter Id Of Employee : ");
		String id = input.nextLine();
		int recordnotfound = 5;
		for (int i = 0; i < e.size(); i++) {
			if (e.get(i).getName().equals(name) && e.get(i).getId().equals(id)) {
				recordnotfound = 10;
				String a = "available";
				String na = "not available";
				System.out.println("\n\t\t Press 1 to " + a);
				System.out.println("\t\t Press 2 to " + na);
				System.out.print("\n\t\t Enter Choice : ");
				int choice = input.nextInt();
				if (choice == 1) {
					e.get(i).setStatus(a);
					System.out.println("\n\t\tStatus Updated ...");
				} else if (choice == 2) {
					e.get(i).setStatus(na);
					System.out.println("\n\t\tStatus Updated ...");
				} else {
					System.out.println("\n\t\tYou Made Wrong Choice ...");
				}
			}
		}
		Employees.writefile(e);
		if (recordnotfound == 5) {
			System.out.println("\n\t\tSorry Record Not Found");
			System.out.println("\n\t\tPress Enter To Continue ...");
		}
	}

	public static List<Employees> readEmployees() {
		List<Employees> employees = new ArrayList<>();

		try {
			FileReader fr = new FileReader(EMPLOYEES_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Employees d = new Employees();
				String[] sp = line.split(",");
				d.setName(sp[0]);
				d.setAge(Integer.parseInt(sp[1]));
				d.setId(sp[2]);
				d.setAddress(sp[3]);
				d.setTiming(sp[4]);
				d.setSalary(Double.parseDouble(sp[5]));
				d.setStatus(sp[6]);
				d.setRole(sp[7]);
				employees.add(d);
			}
		} catch (Exception e) {
			System.out.println("cannot read doctors file ...21");
		}
		return employees;
	}

	public static void displayEmployees(List<Employees> d) {
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(format, "     NAME", "    AGE", "     ID", "     ADDRESS", "     TIMING", "     SALARY",
				"     STATUS", "     ROLE");
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < d.size(); i++) {
			System.out.printf(format, d.get(i).getName(), d.get(i).getAge(), d.get(i).getId(), d.get(i).getAddress(),
					d.get(i).getTiming(), d.get(i).getSalary(), d.get(i).getStatus(), d.get(i).getRole());
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void addEmployees(List<Employees> e) {
		Employees d = new Employees();
		Scanner input = new Scanner(System.in);
		System.out.println("\t\t\nPlease Enter The Deatails Below : \n\n");
		System.out.print("\tEnter Name Of Employee : ");
		d.setName(login.validname());
		System.out.println();
		System.out.print("\tEnter Age Of Employee : ");
		d.setAge((int) login.validsalary());
		System.out.println();
		System.out.print("\tEnter Id Of Employee : ");
		d.setId(Employees.ifemployeeidexist());
		System.out.println();
		System.out.print("\tEnter Address Of Employee: ");
		d.setAddress(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Timing Of Employee : ");
		d.setTiming(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Salary Of Employee : ");
		d.setSalary(login.validsalary());
		System.out.println();
		// input.nextLine();
		System.out.print("\tEnter Status Of Employee : ");
		d.setStatus(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Role Of Employee : ");
		d.setRole(input.nextLine());
		System.out.println();
		e.add(d);
		Employees.writefile(e);
		System.out.println("\n\n\t\t\t Record Successfully Added...!");
	}

	public static String ifemployeeidexist() {
		boolean flag = false;
		String token;
		input.nextLine();
		List<Employees> d = Employees.readEmployees();
		do {
			flag = false;
			token = input.nextLine();
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getId().equals(token)) {
					flag = true;
				}
			}
			if (flag == true) {
				System.out.println("\n\tID Already Exists");
				System.out.print("\t\tPlease ReEnter : ");
			}
		} while (flag == true);
		return token;
	}

	public static void updateEmployees(List<Employees> d) {
		Employees.displayEmployees(d);
		input.nextLine();
		System.out.print("Enter name of Employee : ");
		String updatename = input.nextLine();
		System.out.print("Enter Id of Employee : ");
		String id = input.nextLine();
		try {
			boolean flag = false;
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getName().equals(updatename) && d.get(i).getId().equals(id)) {
					flag = true;
					System.out.println("\n\t\tRecord founded ...!\n");
					System.out.print("\n\t\tEnter name : ");
					d.get(i).setName(input.nextLine());
					System.out.print("\n\t\tEnter age : ");
					d.get(i).setAge(input.nextInt());
					input.nextLine();
					System.out.print("\n\t\tEnter id : ");
					d.get(i).setId(input.nextLine());
					System.out.print("\n\t\tEnter address : ");
					d.get(i).setAddress(input.nextLine());
					System.out.print("\n\t\tEnter timing : ");
					d.get(i).setTiming(input.nextLine());
					System.out.print("\n\t\tEnter salary : ");
					d.get(i).setSalary(input.nextDouble());
					input.nextLine();
					System.out.print("\n\t\tEnter status : ");
					d.get(i).setStatus(input.nextLine());
					System.out.print("\n\t\tEnter Role : ");
					d.get(i).setRole(input.nextLine());

				}
			}
			if (flag == true) {
				Employees.writefile(d);
				System.out.println("\n\n\t\t\t Record Updated Successfully ...!");
			}
			if (flag == false) {
				System.out.println("record not found");
			}
		} catch (Exception e) {
			System.out.println("cannot update doctors  ...!");
		}
	}

	public static void deleteEmployees(List<Employees> dd) {
		Employees.displayEmployees(dd);
		input.nextLine();
		System.out.print("Enter name of Employee : ");
		String updatename = input.nextLine();
		System.out.print("Enter id of Employee : ");
		String id = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < dd.size(); i++) {
			if (dd.get(i).getName().equals(updatename) && dd.get(i).getId().equals(id)) {
				flag = true;
				System.out.println("\n\n\t\t\tRecord founded ...!");
				dd.remove(i);
			}
		}
		if (flag == true) {
			Employees.writefile(dd);
			System.out.println("\n\n\t\t\tRecord deleted Successfully ...! ");
		}
		if (flag == false) {
			System.out.println("record not found");
		}
	}

	public static void writefile(List<Employees> dd) {
		try {
			FileWriter fr = new FileWriter(EMPLOYEES_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < dd.size(); i++) {
				br.write(dd.get(i).getName() + "," + dd.get(i).getAge() + "," + dd.get(i).getId() + ","
						+ dd.get(i).getAddress() + "," + dd.get(i).getTiming() + "," + dd.get(i).getSalary() + ","
						+ dd.get(i).getStatus() + "," + dd.get(i).getRole() + "\n");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("cannot write in file");
		}
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
