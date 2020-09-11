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

public class Nurses extends person {
	private static final File NURSES_FILE= new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/nurses.txt");
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		nursescontrol();
	}

	public static void nursescontrol() throws Exception {
		System.out.println("\n\n\t\tWELCOME TO NURSES MANAGEMENT");
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
					System.out.println("\n\t\tPress 0 to Update Status Of Nurses");
					System.out.println("\t\tPress 1 to Display All Nurses");
					System.out.println("\t\tPress 2 to Update Nurses");
					System.out.println("\t\tPress 3 to Delete Nurses");
					System.out.println("\t\tPress 4 to Add Nurses");
					System.out.println("\t\tPress 5 to Back to Hospital Management");
					System.out.println("\t\tPress 6 to Log Out");
					System.out.println("\t\tPress 7 to Exit");
					System.out.print("\n\tPlease Enter Your Choice : ");
					flag = false;
					int choice = input.nextInt();
					switch (choice) {
					case 0: {
						ClearingScreen();
						Nurses.updatestatusofnurses(Nurses.readnurses());
						break;
					}
					case 1: {
						ClearingScreen();
						Nurses.displaynurses(Nurses.readnurses());
						break;
					}
					case 2: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("UPDATE NURSES") == true) {
							Nurses.updatenurses(Nurses.readnurses());
						}
						break;
					}
					case 3: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("DELETE NURSES") == true) {
							Nurses.deletenurses(Nurses.readnurses());
						}
						break;
					}
					case 4: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("ADD NURSES") == true) {
							Nurses.addNurses(Nurses.readnurses());
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
			System.out.println("\n\tDo You Want To Use Nurses Management Again [y/n]");
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

		System.out.println("\t\t\t\tHOSPITAL NURSES AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public static void updatestatusofnurses(List<Nurses> n) {
		input.nextLine();
		System.out.print("\n\t\tPlease Enter Name Of Nurse : ");
		String name = input.nextLine();
		System.out.print("\n\t\tPlease Enter Id Of Nurse : ");
		String id = input.nextLine();
		int recordnotfound = 5;
		for (int i = 0; i < n.size(); i++) {
			if (n.get(i).getName().equals(name) && n.get(i).getId().equals(id)) {
				recordnotfound = 10;
				String a = "available";
				String na = "not available";
				System.out.println("\n\t\t Press 1 to " + a);
				System.out.println("\t\t Press 2 to " + na);
				System.out.print("\n\t\t Enter Choice : ");
				int choice = input.nextInt();
				if (choice == 1) {
					n.get(i).setStatus(a);
					System.out.println("\n\t\tStatus Updated ...");
				} else if (choice == 2) {
					n.get(i).setStatus(na);
					System.out.println("\n\t\tStatus Updated ...");
				} else {
					System.out.println("\n\t\tYou Made Wrong Choice ...");
				}
			}
		}
		Nurses.writefile(n);
		if (recordnotfound == 5) {
			System.out.println("\n\t\tSorry Record Not Found");
			System.out.println("\n\t\tPress Enter To Continue ...");
		}
	}

	public static List<Nurses> readnurses() {
		List<Nurses> nurses = new ArrayList<Nurses>();

		try {
			FileReader fr = new FileReader(NURSES_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Nurses n = new Nurses();
				String[] sp = line.split(",");
				n.setName(sp[0]);
				n.setAge(Integer.parseInt(sp[1]));
				n.setId(sp[2]);
				n.setAddress(sp[3]);
				n.setTiming(sp[4]);
				n.setSalary(Double.parseDouble(sp[5]));
				n.setStatus(sp[6]);
				nurses.add(n);
			}
		} catch (Exception e) {
			System.out.println("cannot read nurses file ...21");
		}
		return nurses;
	}

	public static void displaynurses(List<Nurses> d) {
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(format, "     NAME", "    AGE", "     ID", "     ADDRESS", "     TIMING", "     SALARY",
				"     STATUS");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < d.size(); i++) {
			System.out.printf(format, d.get(i).getName(), d.get(i).getAge(), d.get(i).getId(), d.get(i).getAddress(),
					d.get(i).getTiming(), d.get(i).getSalary(), d.get(i).getStatus());
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void addNurses(List<Nurses> n) {
		Nurses d = new Nurses();
		Scanner input = new Scanner(System.in);
		System.out.println("\t\t\nPlease Enter The Deatails Below : \n\n");
		System.out.print("\tEnter Name Of Nurse : ");
		d.setName(login.validname());
		System.out.println();
		System.out.print("\tEnter Age Of Nurse : ");
		d.setAge((int) login.validsalary());
		System.out.println();
		System.out.print("\tEnter Id Of Nurse : ");
		d.setId(Nurses.ifnurseidexist());
		System.out.println();
		System.out.print("\tEnter Address Of Nurse: ");
		d.setAddress(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Timing Of Nurse : ");
		d.setTiming(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Salary Of Nurse : ");
		d.setSalary(input.nextDouble());
		System.out.println();
		input.nextLine();
		System.out.print("\tEnter Status Of Nurse : ");
		d.setStatus(input.nextLine());
		System.out.println();
		n.add(d);
		Nurses.writefile(n);
		System.out.println("Nurse Added Successfully ..!");
	}

	public static String ifnurseidexist() {
		boolean flag = false;
		String token;
		input.nextLine();
		List<Nurses> d = Nurses.readnurses();
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

	public static void updatenurses(List<Nurses> d) {
		Nurses.displaynurses(d);
		input.nextLine();
		System.out.print("Enter name of Nurse : ");
		String updatename = input.nextLine();
		System.out.print("Enter Id of Nurse : ");
		String id = input.nextLine();
		try {
			boolean flag = false;
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getName().equals(updatename) && d.get(i).getId().equals(id)) {
					flag = true;
					System.out.println("\n\t\tRecord founded ...!\n\n");
					System.out.print("\n\tEnter name ");
					d.get(i).setName(input.nextLine());
					System.out.print("\n\tEnter age ");
					d.get(i).setAge(input.nextInt());
					input.nextLine();
					System.out.print("\n\tEnter id ");
					d.get(i).setId(input.nextLine());
					System.out.print("\n\tEnter address ");
					d.get(i).setAddress(input.nextLine());
					System.out.print("\n\tEnter timing ");
					d.get(i).setTiming(input.nextLine());
					System.out.print("\n\tEnter salary ");
					d.get(i).setSalary(input.nextDouble());
					input.nextLine();
					System.out.print("\n\tEnter status ");
					d.get(i).setStatus(input.nextLine());

				}
			}
			if (flag == true) {
				Nurses.writefile(d);
				System.out.println("Successfully updated..!");
			}
			if (flag == false) {
				System.out.println("record not found");
			}
		} catch (Exception e) {
			System.out.println("cannot update doctors  ...!");
		}
	}

	public static void deletenurses(List<Nurses> dd) {
		Nurses.displaynurses(dd);
		input.nextLine();
		System.out.print("Enter name of nurse : ");
		String updatename = input.nextLine();
		System.out.print("Enter Id of nurse : ");
		String id = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < dd.size(); i++) {
			if (dd.get(i).getName().equals(updatename) && dd.get(i).getId().equals(id)) {
				flag = true;
				System.out.println("Record founded ...!\n\n");
				dd.remove(i);
				//
			}
		}
		if (flag == true) {
			Nurses.writefile(dd);
			System.out.println("\n\t\tRecord deleted Succesfully ..!");
		}
		if (flag == false) {
			System.out.println("record not found");
		}
	}

	public static void writefile(List<Nurses> dd) {
		try {
			FileWriter fr = new FileWriter(NURSES_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < dd.size(); i++) {
				br.write(dd.get(i).getName() + "," + dd.get(i).getAge() + "," + dd.get(i).getId() + ","
						+ dd.get(i).getAddress() + "," + dd.get(i).getTiming() + "," + dd.get(i).getSalary() + ","
						+ dd.get(i).getStatus() + "\n");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("cannot write in file");
		}
	}
}
