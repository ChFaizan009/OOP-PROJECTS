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

public class Transportfacility extends Vehicles {
	private static final File TRANSPORT_FILE= new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/transport.txt");
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Transportfacilitycontrol();
	}

	public static void Transportfacilitycontrol() throws Exception {
		System.out.println("\n\n\t\tWELCOME TO TRANSPORT MANAGEMENT");
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
		System.out.println("\n\t\tPress 0 to Update Status Of All Transport Vans & Drivers");
	    System.out.println("\t\tPress 1 to Display All Transport Vans");
		System.out.println("\t\tPress 2 to Update Transport Vans");
		System.out.println("\t\tPress 3 to Delete Transport Vans");
		System.out.println("\t\tPress 4 to Add Transport Vans");
		System.out.println("\t\tPress 5 to Back to Hospital Management");
		System.out.println("\t\tPress 6 to Log Out");
		System.out.println("\t\tPress 7 to Exit");
		System.out.print("\n\tPlease Enter Your Choice : ");
		flag = false;
		int choice = input.nextInt();
		switch (choice) {
 		case 0: {
						ClearingScreen();
					Transportfacility.updatestatusoftransportfacility(Transportfacility.readTransportfacility());
						break;
					}
					case 1: {
						ClearingScreen();
						Transportfacility.displayTransportfacility(Transportfacility.readTransportfacility());
						break;
					}
					case 2: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("UPDATE TRANSPORT") == true) {
							Transportfacility.updateTransportfacility(Transportfacility.readTransportfacility());
						}
						break;
					}
					case 3: {
						ClearingScreen();
					if (afterlogin.checkbeforeanythingpersonal("DELETE TRANSPORT") == true) {
							Transportfacility.deleteTransportfacility(Transportfacility.readTransportfacility());
						}
						break;
					}
					case 4: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("ADD TRANSPORT") == true) {
							Transportfacility.addTransportfacility(Transportfacility.readTransportfacility());
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
			System.out.println("\n\tDo You Want To Use Transport Management Again [y/n]");
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

		System.out.println("\t\t\t\tHOSPITAL TRANSPORT AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public static void updatestatusoftransportfacility(List<Transportfacility> t) {
		input.nextLine();
		System.out.print("\n\t\tPlease Enter Name Of Driver : ");
		String name = input.nextLine();
		System.out.print("\n\t\tPlease Enter Id Of Driver : ");
		String drid = input.nextLine();
		System.out.print("\n\t\tPlease Enter Id Of Van : ");
		String vanid = input.nextLine();
		int recordnotfound = 5;
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i).getVanid().equals(vanid) && t.get(i).getVandriver().equals(name)
					&& t.get(i).getVandriverid().equals(drid)) {
				recordnotfound = 10;
				String a = "available";
				String na = "not available";
				System.out.println("\n\t\t Press 1 to Both Are Available");
				System.out.println("\t\t Press 2 to Both Are Not Available");
				System.out.println("\t\t Press 3 to Driver Available But Not Van");
				System.out.println("\t\t Press 4 to Van Available But Not Driver");
				System.out.print("\n\t\t Enter Choice : ");
				int choice = input.nextInt();
				if (choice == 1) {
					t.get(i).setVandriverstatus(a);
					t.get(i).setVanstatus(a);
					System.out.println("\n\t\tStatus Updated ...");
				} else if (choice == 2) {
					t.get(i).setVandriverstatus(na);
					t.get(i).setVanstatus(na);
					System.out.println("\n\t\tStatus Updated ...");
				} else if (choice == 3) {
					t.get(i).setVandriverstatus(a);
					t.get(i).setVanstatus(na);
					System.out.println("\n\t\tStatus Updated ...");
				} else if (choice == 4) {
					t.get(i).setVandriverstatus(na);
					t.get(i).setVanstatus(a);
					System.out.println("\n\t\tStatus Updated ...");
				} else {
					System.out.println("\n\t\tYou Made Wrong Choice ...");
				}
			}
		}
		if (recordnotfound == 5) {
			System.out.println("\n\t\tSorry Record Not Found");
			System.out.println("\n\t\tPress Enter to Continue ...");
		}
		Transportfacility.writefile(t);
	}

	public static List<Transportfacility> readTransportfacility() {
		List<Transportfacility> transport = new ArrayList<>();

		try {
			FileReader fr = new FileReader(TRANSPORT_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Transportfacility d = new Transportfacility();
				String[] sp = line.split(",");
				d.setVanid(sp[0]);
				d.setVandriver(sp[1]);
				d.setVandriverid(sp[2]);
				d.setVandriverstatus(sp[3]);
				d.setVanstatus(sp[4]);
				d.setVandrivertiminig(sp[5]);
				d.setVanddriversalary(Double.parseDouble(sp[6]));

				transport.add(d);
			}
		} catch (Exception e) {
			System.out.println("cannot read transport file ...21");
		}
		return transport;
	}

	public static void displayTransportfacility(List<Transportfacility> d) {
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(format, "     VAN ID", "    DRIVER", "     DRIVER ID", "     DRIVER STATUS",
				"     VAN STATUS", "     DRIVER TIMING", "     DRIVER SALARY");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < d.size(); i++) {
			System.out.printf(format, d.get(i).getVanid(), d.get(i).getVandriver(), d.get(i).getVandriverid(),
					d.get(i).getVandriverstatus(), d.get(i).getVanstatus(), d.get(i).getVandrivertiminig(),
					d.get(i).getVanddriversalary());
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void addTransportfacility(List<Transportfacility> list) {
		Transportfacility d = new Transportfacility();
		System.out.print("\n\t\tEnter Van Id : ");
		d.setVanid(Transportfacility.ifvanidexist());
		System.out.print("\n\t\tEnter Van Driver Name : ");
		d.setVandriver(input.nextLine());
		System.out.print("\n\t\tEnter Van Driver id : ");
		d.setVandriverid(Transportfacility.ifvandriveridexist());
		System.out.print("\n\t\tEnter Van Driver Status : ");
		d.setVandriverstatus(input.nextLine());
		System.out.print("\n\t\tEnter Van Status : ");
		d.setVanstatus(input.nextLine());
		System.out.print("\n\t\tEnter Van Driver Timing : ");
		d.setVandrivertiminig(input.nextLine());
		System.out.print("\n\t\tEnter Van Driver Salary : ");
		d.setVanddriversalary(input.nextDouble());
		list.add(d);
		Transportfacility.writefile(list);
		System.out.println("Record Successfully Added...!");
	}

	public static String ifvandriveridexist() {
		boolean flag = false;
		String token;
		// input.nextLine();
		List<Transportfacility> d = Transportfacility.readTransportfacility();
		do {
			flag = false;
			token = input.nextLine();
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getVandriverid().equals(token)) {
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

	public static String ifvanidexist() {
		boolean flag = false;
		String token;
		input.nextLine();
		List<Transportfacility> d = Transportfacility.readTransportfacility();
		do {
			flag = false;
			token = input.nextLine();
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getVanid().equals(token)) {
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

	public static void updateTransportfacility(List<Transportfacility> d) {
		Transportfacility.displayTransportfacility(d);
		input.nextLine();
		System.out.print("Enter Van ID you want to update : ");
		String updatename = input.nextLine();
		try {
			boolean flag = false;
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getVanid().equals(updatename)) {
					flag = true;
					System.out.println("\n\t\tRecord founded ...!");
					System.out.print("\n\t\tEnter Van Id : ");
					d.get(i).setVanid(input.nextLine());
					System.out.print("\n\t\tEnter Van Driver Name : ");
					d.get(i).setVandriver(input.nextLine());
					System.out.print("\n\t\tEnter Van Driver id : ");
					d.get(i).setVandriverid(input.nextLine());
					System.out.print("\n\t\tEnter Van Driver Status : ");
					d.get(i).setVandriverstatus(input.nextLine());
					System.out.print("\n\t\tEnter Van Status : ");
					d.get(i).setVanstatus(input.nextLine());
					System.out.print("\n\t\tEnter Van Driver Timing : ");
					d.get(i).setVandrivertiminig(input.nextLine());
					System.out.print("\n\t\tEnter Van Driver Salary : ");
					d.get(i).setVanddriversalary(input.nextDouble());

				}
			}
			if (flag == true) {
				Transportfacility.writefile(d);
				System.out.println("Record Successfully Updated ...1");
			}
			if (flag == false) {
				System.out.println("record not found");
			}
		} catch (Exception e) {
			System.out.println("cannot update doctors  ...!");
		}
	}

	public static void deleteTransportfacility(List<Transportfacility> dd) {
		Transportfacility.displayTransportfacility(dd);
		input.nextLine();
		System.out.print("Enter Van Id you want to delete : ");
		String updatename = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < dd.size(); i++) {
			if (dd.get(i).getVanid().equals(updatename)) {
				flag = true;
				System.out.println("\n\n\t\tRecord founded ...!");
				dd.remove(i);
			}
		}
		if (flag == true) {
			Transportfacility.writefile(dd);
			System.out.println("\n\t\t\tRecord deleted Successfully ...!");
		}
		if (flag == false) {
			System.out.println("record not found");
		}
	}

	public static void writefile(List<Transportfacility> d) {
		try {
			FileWriter fr = new FileWriter(TRANSPORT_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < d.size(); i++) {
				br.write(d.get(i).getVanid() + "," + d.get(i).getVandriver() + "," + d.get(i).getVandriverid() + ","
						+ d.get(i).getVandriverstatus() + "," + d.get(i).getVanstatus() + ","
						+ d.get(i).getVandrivertiminig() + "," + d.get(i).getVanddriversalary() + "\n");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("cannot write in file");
		}
	}
}
