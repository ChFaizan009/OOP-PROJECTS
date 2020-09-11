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

public class hospitalrooms extends Rooms {
	private static final File HOSPITALROOMS_FILE= new File(
			"E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/hospitalrooms.txt");
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		hospitalroomcontrol();
	}

	public static void hospitalroomcontrol() throws Exception {
		System.out.println("\n\n\t\tWELCOME TO HOSPITAL ROOM MANAGEMENT");
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
					System.out.println("\n\t\tPress 0 to Update Status Of Rooms");
					System.out.println("\t\tPress 1 to Display All Rooms");
					System.out.println("\t\tPress 2 to Update Rooms");
					System.out.println("\t\tPress 3 to Delete Rooms");
					System.out.println("\t\tPress 4 to Add Rooms");
					System.out.println("\t\tPress 5 to Back to Hospital Management");
					System.out.println("\t\tPress 6 to Log Out");
					System.out.println("\t\tPress 7 to Exit");
					System.out.print("\n\tPlease Enter Your Choice : ");
					flag = false;
					int choice = input.nextInt();
					switch (choice) {
					case 0: {
						ClearingScreen();
						hospitalrooms.updatestatusofrooms(hospitalrooms.readhospitalrooms());
						break;
					}
					case 1: {
						ClearingScreen();
						hospitalrooms.displayhospitalrooms(hospitalrooms.readhospitalrooms());
						break;
					}
					case 2: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("UPDATE ROOMS") == true) {
							hospitalrooms.updatehospitalrooms(hospitalrooms.readhospitalrooms());
						}
						break;
					}
					case 3: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("DELETE ROOMS") == true) {
							hospitalrooms.deletehospitalrooms(hospitalrooms.readhospitalrooms());
						}
						break;
					}
					case 4: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("ADD ROOMS") == true) {
							hospitalrooms.addhospitalrooms(hospitalrooms.readhospitalrooms());
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
			System.out.println("\n\tDo You Want To Use Hospital Room Management Again [y/n]");
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

		System.out.println("\t\t\t\tHOSPITAL ROOMS AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public static void updatestatusofrooms(List<hospitalrooms> r) {
		input.nextLine();
		System.out.print("\n\t\tPlease Enter Name Of Room : ");
		String name = input.nextLine();
		int recordnotfound = 5;
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i).getName().equals(name)) {
				recordnotfound = 10;
				String a = "available";
				String na = "not available";
				System.out.println("\n\t\t Press 1 to " + a);
				System.out.println("\t\t Press 2 to " + na);
				System.out.print("\n\t\t Enter Choice : ");
				int choice = input.nextInt();
				if (choice == 1) {
					r.get(i).setStatus(a);
					System.out.println("\n\t\tStatus Updated ...");
				} else if (choice == 2) {
					r.get(i).setStatus(na);
					System.out.println("\n\t\tStatus Updated ...");
				} else {
					System.out.println("\n\t\tYou Made Wrong Choice ...");
				}
			}
		}
		hospitalrooms.writefile(r);
		if (recordnotfound == 5) {
			System.out.println("\n\t\tSorry Record Not Found");
			System.out.println("\n\t\tPress Enter To Continue ...");
		}
	}

	public static List<hospitalrooms> readhospitalrooms() {
		List<hospitalrooms> HRooms = new ArrayList<>();

		try {
			FileReader fr = new FileReader(HOSPITALROOMS_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				hospitalrooms d = new hospitalrooms();
				String[] sp = line.split(",");
				d.setName(sp[0]);
				d.setStatus(sp[1]);
				d.setWardname(sp[2]);
				d.setTypeofroom(sp[3]);
				HRooms.add(d);
			}
		} catch (Exception e) {
			System.out.println("cannot read hospital Rooms file ...21");
		}
		return HRooms;
	}

	public static void displayhospitalrooms(List<hospitalrooms> d) {
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		System.out.printf(format, "     ROOM NAME", "    STATUS", "     WARD NAME", "     TYPE");
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		for (int i = 0; i < d.size(); i++) {
			System.out.printf(format, d.get(i).getName(), d.get(i).getStatus(), d.get(i).getWardname(),
					d.get(i).getTypeofroom());
			System.out.println(
					"---------------------------------------------------------------------------------------------");
		}
	}

	public static void addhospitalrooms(List<hospitalrooms> hr) {
		hospitalrooms d = new hospitalrooms();
		Scanner input = new Scanner(System.in);
		System.out.println("\t\t\nPlease Enter The Deatails Below : \n\n");
		System.out.print("\tEnter Name Of Room : ");
		d.setName(hospitalrooms.ifroomnameexist());
		System.out.println();
		System.out.print("\tEnter Status Of Room : ");
		d.setStatus(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Ward Of Room : ");
		d.setWardname(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Type Of Room: ");
		d.setTypeofroom(input.nextLine());
		System.out.println();
		hr.add(d);
		hospitalrooms.writefile(hr);
		System.out.println("\n\n\t\t\tRecord Successfully Added..!");
	}

	public static String ifroomnameexist() {
		boolean flag = false;
		String token;
		input.nextLine();
		List<hospitalrooms> d = hospitalrooms.readhospitalrooms();
		do {
			flag = false;
			token = input.nextLine();
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getName().equals(token)) {
					flag = true;
				}
			}
			if (flag == true) {
				System.out.println("\n\tRoom Name Already Exists");
				System.out.print("\t\tPlease ReEnter : ");
			}
		} while (flag == true);
		return token;
	}

	public static void updatehospitalrooms(List<hospitalrooms> d) {
		hospitalrooms.displayhospitalrooms(d);
		input.nextLine();
		System.out.print("Enter name of Hospital Rooms : ");
		String updatename = input.nextLine();
		System.out.print("Enter ward of Hospital ward : ");
		String ward = input.nextLine();
		try {
			boolean flag = false;
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getName().equals(updatename) && d.get(i).getWardname().equals(ward)) {
					flag = true;
					System.out.println("\n\t\tRecord founded ...!\n\n");
					System.out.print("\n\t\tEnter name : ");
					d.get(i).setName(input.nextLine());
					System.out.print("\n\t\tEnter Status : ");
					d.get(i).setStatus(input.nextLine());
					System.out.print("\n\t\tEnter Ward Name : ");
					d.get(i).setWardname(input.nextLine());
					System.out.print("\n\t\tEnter Type Of Room : ");
					d.get(i).setTypeofroom(input.nextLine());
				}
			}
			if (flag == true) {
				hospitalrooms.writefile(d);
				System.out.println("\n\n\t\t\tRecord Successfully Updated ...!");
			}
			if (flag == false) {
				System.out.println("record not found");
			}
		} catch (Exception e) {
			System.out.println("cannot update doctors  ...!");
		}
	}

	public static void deletehospitalrooms(List<hospitalrooms> dd) {
		hospitalrooms.displayhospitalrooms(dd);
		input.nextLine();
		System.out.print("\n\n\t\tEnter name of Hospital Room : ");
		String updatename = input.nextLine();
		System.out.print("\n\t\tEnter Ward of Hospital Ward : ");
		String ward = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < dd.size(); i++) {
			if (dd.get(i).getName().equals(updatename) && dd.get(i).getWardname().equals(ward)) {
				flag = true;
				System.out.println("\n\n\t\t\tRecord founded ...!");
				dd.remove(i);
			}
		}
		if (flag == true) {
			hospitalrooms.writefile(dd);
			System.out.println("\n\n\t\t\t\tRecord deleted Successfully ...! ");

		}
		if (flag == false) {
			System.out.println("record not found");
		}
	}

	public static void writefile(List<hospitalrooms> d) {
		try {
			FileWriter fr = new FileWriter(HOSPITALROOMS_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < d.size(); i++) {
				br.write(d.get(i).getName() + "," + d.get(i).getStatus() + "," + d.get(i).getWardname() + ","
						+ d.get(i).getTypeofroom() + "\n");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("cannot write in file");
		}
	}
}
