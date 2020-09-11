package hospitalsystem;

import java.util.Scanner;

public class Hospital {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Hospital.hospitalmanagement();
	}

	public static void hospitalmanagement() throws Exception {
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {// perfect
					System.out.println("\n\n\t\t\tWELCOME TO HOSPITAL MANAGEMENT");// ok
					System.out.println("\n\n\t\t Press 0 To Appointments");// ok
					System.out.println("\t\t Press 1 To Counter ");// ok
					System.out.println("\t\t Press 2 To Doctors ");// ok
					System.out.println("\t\t Press 3 To Nurses ");// ok
					System.out.println("\t\t Press 4 To Transport ");// ok
					System.out.println("\t\t Press 5 To Patients ");// ok
					System.out.println("\t\t Press 6 To Rooms ");// ok
					System.out.println("\t\t Press 7 To Employees ");// ok
					System.out.println("\t\t Press 8 To Dispensory ");// ok
					System.out.println("\t\t Press 9 To Log Out");// ok
					System.out.println("\t\t Press 10 To CONTROL ROOM");// ok
					System.out.println("\t\t Press 11 to EXIT");// ok
					System.out.print("\n\t Please Enter Your Choice : ");// ok
					flag = false;
					int choice = input.nextInt();
					switch (choice) {
					case 0: {
						HospitalClearingScreen();
						appointment.appointmentcontrol();// OK
						break;
					}
					case 1: {
						HospitalClearingScreen();
						Counterdesk.Counterdeskcontrol();// OK
						break;
					}
					case 2: {
						HospitalClearingScreen();
						Doctors.doctorscontrol();// OK
						break;
					}
					case 3: {
						HospitalClearingScreen();
						Nurses.nursescontrol();// OK
						break;
					}
					case 4: {
						HospitalClearingScreen();
						Transportfacility.Transportfacilitycontrol();// OK
						break;
					}
					case 5: {
						HospitalClearingScreen();
						Patients.Patientscontrol();// OK
						break;
					}
					case 6: {
						HospitalClearingScreen();
						hospitalrooms.hospitalroomcontrol();// OK
						break;
					}
					case 7: {
						HospitalClearingScreen();
						Employees.Employeescontrol();// OK
						break;
					}
					case 8: {
						HospitalClearingScreen();
						Dispensory.Dispensorycontrol();// OK
						break;
					}
					case 9: {
						login.LoginClearingScreen();
						System.out.println("\n\n\t\t LOGGED OUT COMPLETED...!\n\n");// OK
						login.control();
						break;
					}
					case 10: {
						afterlogin.AfterLoginClearingScreen();
						afterlogin.control();// OK
						break;
					}
					case 11: {
						HospitalClearingScreen();
						login.goodby();// OK
						System.exit(0);
						break;
					}
					default: {
						System.out.println("\n\n\t\t YOU ENTERED WRONG CHOICE ...!");// OK
						break;
					}
					}

				} catch (Exception e) {
					System.out.println("\n\t\t YOU CANNOT DO THAT BRO...!");
				}
			} while (flag == true);
			input.nextLine();
			System.out.println("\n\tDo You Want To Use HOSPITAL MANAGEMENT AGAIN [y/n]");
			again = input.next().charAt(0);
			if (again == 'y' || again == 'Y') {
				HospitalClearingScreen();
			}
		} while (again == 'y' || again == 'Y');

	}

	public static void HospitalClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tHOSPITAL MAIN AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

}
