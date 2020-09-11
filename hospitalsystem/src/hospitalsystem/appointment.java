package hospitalsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class appointment {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		appointment.appointmentcontrol();
	}

	public static void appointmentcontrol() throws Exception {
		System.out.println("\n\n\t\tWELCOME TO APPOINTMENT VIEWER");
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
					System.out.println("\n\t\tPress 1 to See All Appointment of patients");
					System.out.println("\t\tpress 2 to See Specific Appointments By Doctors Name");
					System.out.println("\t\tpress 3 to Back to Hospital Mangement");
					System.out.println("\t\tpress 4 to Log Out");
					System.out.println("\t\tpress 5 to Exit");
					System.out.print("\n\t\tPlease Enter Your Choice : ");
					flag = false;
					int choice = input.nextInt();
					switch (choice) {
					case 1: {
						appointment.ClearingScreen();
						appointment.seeappointments();
						break;
					}
					case 2: {
						appointment.ClearingScreen();
						appointment.specificsearch();
						break;
					}
					case 3: {
						Hospital.HospitalClearingScreen();
						Hospital.hospitalmanagement();
						break;
					}
					case 4: {
						login.LoginClearingScreen();
						login.control();
						break;
					}
					case 5: {
						appointment.ClearingScreen();
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
			System.out.println("\n\tDo You Want To Use Appointment Viewer Again [y/n]");
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

		System.out.println("\t\t\t\tHOSPITAL APPOINTMENT AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public static void seeappointments() {
		List<Counterdesk> list = new ArrayList<>();
		list = Counterdesk.readcounterfile();
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(format, "     TOKEN", "    DOCTOR'S", "     PATIENT'S", "     TIMING", "     STATUS",
				"     ADDRESS");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf(format, list.get(i).getPatient().getToken(), list.get(i).getPatient().getAppointment(),
					list.get(i).getPatient().getName(), list.get(i).getPatient().getTiming(),
					list.get(i).getPatient().getStatus(), list.get(i).getPatient().getAddress());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void specificsearch() {
		appointment.printdoctorsforsearch();
		List<Counterdesk> list = Counterdesk.readcounterfile();
		boolean flag = true;
		input.nextLine();
		System.out.print("\n\t\tPlease Enter Name of Doctor : ");
		String specific = input.nextLine();
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(format, "     TOKEN", "    DOCTOR'S", "     PATIENT'S", "     TIMING", "     STATUS",
				"     ADDRESS");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPatient().getAppointment().equals(specific)) {
				flag = false;
				System.out.printf(format, list.get(i).getPatient().getToken(),
						list.get(i).getPatient().getAppointment(), list.get(i).getPatient().getName(),
						list.get(i).getPatient().getTiming(), list.get(i).getPatient().getStatus(),
						list.get(i).getPatient().getAddress());
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		}

		if (flag == true) {
			System.out.println("RECORD NOT FOUND OF DOCTOR...!");
			System.out.println("Press Enter to Continue...!");
		}
	}

	public static void printdoctorsforsearch() {
		System.out.println("========================");
		System.out.println("|   Doctor's Name      |");
		System.out.println("========================\n");
		String format = "|  %-20s|%n";
		List<Counterdesk> list = Counterdesk.readcounterfile();
		for (int i = 0; i < list.size(); i++) {
			System.out.printf(format, list.get(i).getPatient().getAppointment());
			System.out.println("------------------------");
		}
		System.out.println("\n========================");

	}
}
