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

import hospitalsystem.Counterdesk.Token;

public class Doctors extends person {
	private double fees;
	private static final File DOCTORS_FILE= new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/doctors.txt");
	private static final File COUNTERDESK_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/counterdesk.txt");
	private static final File TOKENLIST_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/tokenlist.txt");

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Doctors.doctorscontrol();
	}

	public static void doctorscontrol() throws Exception {
		System.out.println("\n\n\t\tWELCOME TO DOCTORS MANAGEMENT");
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
					System.out.println("\n\t\tPress 0 to Update Status of Doctors");
					System.out.println("\t\tPress 1 to Display All Doctors");
					System.out.println("\t\tPress 2 to Update Doctors");
					System.out.println("\t\tPress 3 to Delete Doctors");
					System.out.println("\t\tPress 4 to Add Doctors");
					System.out.println("\t\tPress 5 to Check Patient");
					System.out.println("\t\tPress 6 to Back to Hospital Management");
					System.out.println("\t\tPress 7 to Log Out");
					System.out.println("\t\tPress 8 to Exit");
					System.out.print("\n\tPlease Enter Your Choice : ");
					flag = false;
					int choice = input.nextInt();
					switch (choice) {
					case 0: {
						Doctors.ClearingScreen();
						Doctors.updatestatusofdoctors(Doctors.readdoctors());
						break;
					}
					case 1: {
						Doctors.ClearingScreen();
						Doctors.displaydoctors(Doctors.readdoctors());
						break;
					}
					case 2: {
						Doctors.ClearingScreen();

						if (afterlogin.checkbeforeanythingpersonal("UPDATE DOCTORS") == true) {
							Doctors.updatedoctors(Doctors.readdoctors());
						}
						break;
					}
					case 3: {
						Doctors.ClearingScreen();

						if (afterlogin.checkbeforeanythingpersonal("DELETE DOCTORS") == true) {
							Doctors.deletedoctors(Doctors.readdoctors());
						}
						break;
					}
					case 4: {
						Doctors.ClearingScreen();

						if (afterlogin.checkbeforeanythingpersonal("ADD DOCTORS") == true) {
							Doctors.adddoctors(Doctors.readdoctors());
						}
						break;
					}
					case 5: {
						Doctors.ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("CHECK PATIENT'S") == true) {
							CheckPatient();
						}
						break;
					}
					case 6: {
						Hospital.HospitalClearingScreen();
						Hospital.hospitalmanagement();

						break;
					}
					case 7: {
						login.LoginClearingScreen();
						login.control();
						break;
					}
					case 8: {
						Doctors.ClearingScreen();
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
			System.out.println("\n\tDo You Want To Use Doctors Management Again [y/n]");
			again = input.next().charAt(0);
			if (again == 'y' || again == 'Y') {
				Doctors.ClearingScreen();
			}
		} while (again == 'y' || again == 'Y');
	}

	public static void CheckPatient() {
		input.nextLine();
		List<Counterdesk> L = Counterdesk.readcounterfile();
		System.out.println("Enter token : ");
		String token = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < L.size(); i++) {
			if (L.get(i).getPatient().getToken().compareToIgnoreCase(token) == 0) {
				flag = true;
				System.out.println("Record Founded ...!\n\n");
				System.out.println("\t=============================================");
				System.out.println("\t                     DETAILS                 ");
				System.out.println("\t=============================================");
				System.out.println("\n\tAppointment   :   " + L.get(i).getPatient().getAppointment());
				System.out.println("\n\tPatient Name  :   " + L.get(i).getPatient().getName());
				System.out.println("\n\tAge           :   " + L.get(i).getPatient().getAge());
				System.out.println("\n\tToken         :   " + L.get(i).getPatient().getToken());
				System.out.println("\n\tTiming        :   " + L.get(i).getPatient().getTiming());
				System.out.println("\n\tStatus        :   " + L.get(i).getPatient().getStatus());
				System.out.println("\n\tAddress       :   " + L.get(i).getPatient().getAddress());
				System.out.println("\t=============================================");
				String tok = L.get(i).getPatient().getToken();
				String pat = L.get(i).getPatient().getName();
				System.out.print("Do you want to check patient [y/n] : ");
				char ch = input.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					checkedtoken(tok);
					checkedPatient(pat);
					System.out.println("\n\t\tPatient Checked Successfully ...!");
					System.out.println("\n\n\t\tGive Patient a Prescription ...!");
				}
			}
		}
		if (flag == false) {
			System.out.println("Sorry Record Not Found  ...!");

		}
	}

	public static void checkedPatient(String p) {
		try {
		//	File file = new File("/home/owais/Documents/java started/Last Projects/src/Group/counterdeskfile.txt");
			List<Counterdesk> d = Counterdesk.readcounterfile();
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getPatient().getName().compareToIgnoreCase(p) == 0) {
					d.get(i).getPatient().setStatus("Checked");
				}
			}
			FileWriter fw = new FileWriter(COUNTERDESK_FILE);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < d.size(); i++) {

				bw.write(d.get(i).getPatient().getName() + "," + d.get(i).getPatient().getAge() + ","
						+ d.get(i).getPatient().getToken() + "," + d.get(i).getPatient().getAppointment() + ","
						+ d.get(i).getPatient().getFees() + "," + d.get(i).getPatient().getTiming() + ","
						+ d.get(i).getPatient().getStatus() + "," + d.get(i).getPatient().getAddress() + "\n");
			}
			bw.close();
		} catch (Exception e) {
			System.out.println("cannot reset token ..!");
		}
	}

	public static void checkedtoken(String token) {
		try {
		//	File file = new File("/home/owais/Documents/java started/Last Projects/src/Group/TokenList.txt");
			List<Token> t = Token.TokenReadList();
			for (int i = 0; i < t.size(); i++) {
				if (t.get(i).getToken().compareToIgnoreCase(token) == 0) {
					t.get(i).setTokenstatus("checked");
				}
			}
			FileWriter fw = new FileWriter(TOKENLIST_FILE);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < t.size(); i++) {

				bw.write("T-" + (i + 1) + "," + t.get(i).getTokenstatus() + "\n");
			}
			bw.close();
		} catch (Exception e) {
			System.out.println("cannot reset token ..!");
		}
	}

	public static void ClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tHOSPITAL DOCTORS AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public static void updatestatusofdoctors(List<Doctors> d) {
		input.nextLine();
		System.out.print("\n\t\tPlease Enter Name Of Doctor : ");
		String name = input.nextLine();
		System.out.print("\n\t\tPlease Enter Id Of Doctor : ");
		String id = input.nextLine();
		int recordnotfound = 5;
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).getName().equals(name) && d.get(i).getId().equals(id)) {
				recordnotfound = 10;
				String a = "available";
				String na = "not available";
				System.out.println("\n\t\t Press 1 to " + a);
				System.out.println("\t\t Press 2 to " + na);
				System.out.print("\n\t\t Enter Choice : ");
				int choice = input.nextInt();
				if (choice == 1) {
					d.get(i).setStatus(a);
					System.out.println("\n\t\tStatus Updated ...");
				} else if (choice == 2) {
					d.get(i).setStatus(na);
					System.out.println("\n\t\tStatus Updated ...");
				} else {
					System.out.println("\n\t\tYou Made Wrong Choice ...");
				}
			}
		}
		Doctors.writefile(d);
		if (recordnotfound == 5) {
			System.out.println("\n\t\tSorry Record Not Found");
			System.out.println("\n\t\tPress Enter to Continue ...");
		}
	}

	public static List<Doctors> readdoctors() {
		List<Doctors> doctors = new ArrayList<Doctors>();

		try {
			FileReader fr = new FileReader(DOCTORS_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Doctors d = new Doctors();
				String[] sp = line.split(",");
				d.setName(sp[0]);
				d.setAge(Integer.parseInt(sp[1]));
				d.setId(sp[2]);
				d.setAddress(sp[3]);
				d.setTiming(sp[4]);
				d.setSalary(Double.parseDouble(sp[5]));
				d.setQualification(sp[6]);
				d.setStatus(sp[7]);
				d.setFees(Double.parseDouble(sp[8]));
				doctors.add(d);
			}
		} catch (Exception e) {
			System.out.println("cannot read doctors file ...21");
		}
		return doctors;
	}

	public static void displaydoctors(List<Doctors> d) {
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(format, "     NAME", "    AGE", "     ID", "     ADDRESS", "     TIMING", "     SALARY",
				"     SPECIALIST", "     STATUS", "     FEES");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < d.size(); i++) {
			System.out.printf(format, d.get(i).getName(), d.get(i).getAge(), d.get(i).getId(), d.get(i).getAddress(),
					d.get(i).getTiming(), d.get(i).getSalary(), d.get(i).getQualification(), d.get(i).getStatus(),
					d.get(i).getFees());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void adddoctors(List<Doctors> list) {
		Doctors d = new Doctors();
		Scanner input = new Scanner(System.in);
		System.out.println("\t\t\nPlease Enter The Deatails Below : \n\n");
		System.out.print("\tEnter Name Of Doctor : ");
		d.setName(login.validname());
		System.out.println();
		System.out.print("\tEnter Age Of Doctor : ");
		d.setAge((int) login.validsalary());
		System.out.println();
		System.out.print("\tEnter Id Of Doctor : ");
		d.setId(Doctors.ifdoctoridexist());
		System.out.println();
		System.out.print("\tEnter Address Of Doctor: ");
		d.setAddress(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Timing Of Doctor : ");
		d.setTiming(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Salary Of Doctor : ");
		d.setSalary(input.nextDouble());
		System.out.println();
		input.nextLine();
		System.out.print("\tEnter Qualification Of Doctor : ");
		d.setQualification(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Status Of Doctor : ");
		d.setStatus(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Fees Of Doctor : ");
		d.setFees(input.nextDouble());
		System.out.println();
		list.add(d);
		Doctors.writefile(list);
		System.out.println("Doctor Added Successfully ...!");
	}

	public static String ifdoctoridexist() {
		boolean flag = false;
		String token;
		input.nextLine();
		List<Doctors> d = Doctors.readdoctors();
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

	public static void updatedoctors(List<Doctors> d) {
		Doctors.displaydoctors(d);
		input.nextLine();
		System.out.print("\t\tEnter name of doctor : ");
		String updatename = login.validname();
		System.out.println("\t\tEnter Id of doctor : ");
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
					System.out.print("\n\t\tEnter qualification : ");
					d.get(i).setQualification(input.nextLine());
					input.nextLine();
					System.out.print("\n\t\tEnter status : ");
					d.get(i).setStatus(input.nextLine());
					System.out.print("\n\t\tEnter fees : ");
					d.get(i).setFees(input.nextDouble());

				}
			}
			if (flag == true) {
				Doctors.writefile(d);
				System.out.println("Record Updated Successfully ...!");
			}
			if (flag == false) {
				System.out.println("\t\tRecord not found");
				System.out.println("Press Enter to Continue...!");

			}
		} catch (Exception e) {
			System.out.println("\t\tcannot update doctors  ...!");
		}

	}

	public static void deletedoctors(List<Doctors> dd) {
		Doctors.displaydoctors(dd);
		input.nextLine();
		System.out.print("Enter name of doctor : ");
		String updatename = input.nextLine();
		System.out.println("Enter Id of doctor : ");
		String id = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < dd.size(); i++) {
			if (dd.get(i).getName().equals(updatename) && dd.get(i).getId().equals(id)) {
				flag = true;
				System.out.println("Record founded ...!");
				dd.remove(i);

			}
		}
		if (flag == true) {
			Doctors.writefile(dd);
			System.out.println("Record Deleted Successfully ...!");
		}
		if (flag == false) {
			System.out.println("record not found");
		}

	}

	public static void writefile(List<Doctors> dd) {
		try {
			FileWriter fr = new FileWriter(DOCTORS_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < dd.size(); i++) {
				br.write(dd.get(i).getName() + "," + dd.get(i).getAge() + "," + dd.get(i).getId() + ","
						+ dd.get(i).getAddress() + "," + dd.get(i).getTiming() + "," + dd.get(i).getSalary() + ","
						+ dd.get(i).getQualification() + "," + dd.get(i).getStatus() + "," + dd.get(i).getFees()
						+ "\n");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("cannot write in file");
		}
	}

	public static void checkpatient() {

	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}
}
