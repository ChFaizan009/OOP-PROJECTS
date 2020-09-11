package hospitalsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Counterdesk {
	private static final File COUNTERDESK_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/counterdesk.txt");
	private static final File TOKENLIST_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/tokenlist.txt");
	private static final File PATIENTHISTORY_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/patienthistory.txt");
	private static int totaltokens;
	private Patients patient;
	public static Scanner input = new Scanner(System.in);
	public static double Return, Fees;

	public static void main(String[] args) throws Exception {
		Counterdeskcontrol();
	}

	public static void Counterdeskcontrol() throws Exception {
		System.out.println("\n\n\t\tWELCOME TO COUNTER DESK");
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
					System.out.println("\n\t\tPress 0 to Reset Tokens");// perfect
					System.out.println("\t\tPress 1 to Book Token For Patient");
					System.out.println("\t\tPress 2 to View All Details of All Patients Tokens");
					System.out.println("\t\tPress 3 to View  Available Doctors");
					System.out.println("\t\tPress 4 to View History Of Patients");
					System.out.println("\t\tPress 5 to Log Out");
					System.out.println("\t\tPress 6 to Back to Hospital Management");
					System.out.println("\t\tPress 7 to Exit");
					System.out.print("\n\t\tPlease Enter Your Choice : ");
					flag = false;
					int choice = input.nextInt();
					switch (choice) {
					case 0: {
						ClearingScreen();
					//	afterlogin a = new afterlogin();
					//	a.setVisitor("awais");
						if (afterlogin.checkbeforeanythingpersonal("RESET TOKEN'S") == true) {
							ResetTokens(Token.TokenReadList());
						}
						break;
					}
					case 1: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("BOOK TOKEN'S") == true) {
							Counterdesk.tokenbookforpatient();
						}
						break;
					}
					case 2: {
						ClearingScreen();
						Counterdesk.displaycounter(Counterdesk.readcounterfile());
						break;
					}
					case 3: {
						ClearingScreen();
						Counterdesk.availabledoctors();
						break;
					}
					case 4: {
						ClearingScreen();
						Counterdesk.displayhistoryofpatients();
						break;
					}
					case 5: {
						login.LoginClearingScreen();
						login.control();
						break;
					}
					case 6: {
						Hospital.HospitalClearingScreen();
						Hospital.hospitalmanagement();
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
			System.out.println("\n\tDo You Want To Use CounterDesk Management Again [y/n]");
			again = input.next().charAt(0);
			if (again == 'y' || again == 'Y') {
				ClearingScreen();
			}
		} while (again == 'y' || again == 'Y');
	}

	public static void ResetTokens(List<Token> t) {
		System.out.println("\n\n\t\t\tPress 1 to Reset All Tokens ");
		System.out.println("\t\t\tPress 2 to Single Token");
		System.out.print("\n\t\tEnter your choice : ");
		int choice = input.nextInt();
		switch (choice) {
		case 1: {
			ClearingScreen();
			ResetAll();
			break;
		}
		case 2: {
			ClearingScreen();
			ResetSpecificToken(Token.TokenReadList());
			break;
		}
		default: {
			System.out.println("you entered a wrong choice ..!");
			break;
		}
		}
	}

	public static void ResetSpecificToken(List<Token> t) {
		try {
		//	File file = new File("/home/owais/Documents/java started/Last Projects/src/Group/TokenList.txt");
			FileWriter fr = new FileWriter(TOKENLIST_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			input.nextLine();
			System.out.print("\n\n\t\tEnter Token ID : ");
			String token = input.nextLine();
			boolean flag = false;
			for (int i = 0; i < t.size(); i++) {
				if (t.get(i).getToken().compareToIgnoreCase(token) == 0) {
					flag = true;
					System.out.println("\n\t\t\tToken Founded ...!");
					System.out.println("\n\t\tToken Status is : " + t.get(i).getTokenstatus());
					String a = "available", b = "not available";
					System.out.println("\n\n\t\t\tPress 1 to Set Status to AVAILABLE");
					System.out.println("\t\t\tPress 2 to Set Status to NOT AVAILABLE");
					System.out.print("\n\t\tEnter Your Choice : ");
					int ch = input.nextInt();
					if (ch == 1) {
						t.get(i).setTokenstatus(a);
						System.out.println("\n\t\tToken Status Updated Successfull ...!");
					} else if (ch == 2) {
						t.get(i).setTokenstatus(b);
						System.out.println("\n\t\tToken Status Updated Successfull ...!");

					}
				}
				br.write("T-" + (i + 1) + "," + t.get(i).getTokenstatus() + "\n");
			}
			br.close();
			if (flag == false) {
				System.out.println("\n\t\tSorry Record not found ..!");
			}
		} catch (Exception e) {
			System.out.println("cannot write token update ...!");
		}
	}

	public static void ResetAll() {
		try {
		//	File file = new File("/home/owais/Documents/java started/Last Projects/src/Group/TokenList.txt");
			FileWriter fr = new FileWriter(TOKENLIST_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 1; i <= 100; i++) {
				br.write("T-" + (i) + ",available\n");
			}
			br.close();
		} catch (Exception e) {
			System.out.println("cannot reset all tokens");
		}
		System.out.println("\n\n\t\tALL TOKEN'S ARE RESET TO DEFAULT(AVAILABLE)");
	}

	public static void ClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tHOSPITAL COUNTER AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public static List<Counterdesk> readcounterfile() {
		List<Counterdesk> counter = new ArrayList<>();
		try {
			FileReader fr = new FileReader(COUNTERDESK_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Counterdesk c = new Counterdesk();
				String[] sp = line.split(",");
				c.patient.setName(sp[0]);
				c.patient.setAge(Integer.parseInt(sp[1]));
				c.patient.setToken(sp[2]);
				c.patient.setAppointment(sp[3]);
				c.patient.setFees(Double.parseDouble(sp[4]));
				c.patient.setTiming(sp[5]);
				c.patient.setStatus(sp[6]);
				c.patient.setAddress(sp[7]);
				counter.add(c);
			}

		} catch (Exception e) {
			System.out.println("cannot add patient to file...!");
		}
		return counter;
	}

	public static void displaycounter(List<Counterdesk> d) {
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(format, "     NAME", "    AGE", "     TOKEN", "     APPOINTMENT", "     FEES", "     TIMING",
				"     STATUS", "     ADDRESS");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < d.size(); i++) {
			System.out.printf(format, d.get(i).patient.getName(), d.get(i).patient.getAge(),
					d.get(i).patient.getToken(), d.get(i).patient.getAppointment(), d.get(i).patient.getFees(),
					d.get(i).patient.getTiming(), d.get(i).patient.getStatus(), d.get(i).patient.getAddress());
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static Counterdesk addPatients() {
		Counterdesk d = new Counterdesk();
		Scanner input = new Scanner(System.in);
		System.out.println("\t\t\nPlease Enter The Deatails Below : \n\n");
		System.out.print("\tEnter Name Of Patient                  : ");
		d.patient.setName(login.validname());
		System.out.println();
		System.out.print("\tEnter Age Of Patient                   : ");
		d.patient.setAge((int) login.validsalary());
		System.out.println();
		String t = Token.TokenLoad(Token.TokenReadList());
		d.patient.setToken(t);
		System.out.print("\tToken Of Patient is                    : " + d.patient.getToken() + "\n");
		System.out.println();
		Counterdesk.availabledoctors();
		System.out.print("\tEnter Appointment To Doctor Of Patient : ");
		d.patient.setAppointment(Counterdesk.ifdoctorexist());
		System.out.println();
		String appoint = d.patient.getAppointment();
		System.out.print("\tEnter Fees Paid By Patient             : ");
		d.patient.setFees(Counterdesk.checkfees(appoint));
		System.out.println();
		System.out.print("\tEnter Timing Of Patient                : ");
		d.patient.setTiming(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Status Of Patient                : ");
		d.patient.setStatus(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Address Of Patient               : ");
		d.patient.setAddress(input.nextLine());
		System.out.println();

		// added successfully
		System.out.println("\n\t\t=========================================");
		System.out.println("\t\t|           DETAILS OF TOKEN            |");
		System.out.println("\t\t=========================================");
		System.out.println("\n\t\t     Patient Name      : " + d.patient.getName().toUpperCase());
		System.out.println("\n\t\t     Token No          : " + d.patient.getToken());
		System.out.println("\n\t\t     Doctor            : " + d.patient.getAppointment().toUpperCase());
		System.out.println("\n\t\t     Patient Age       : " + d.patient.getAge());
		System.out.println("\n\t\t     Appointment Time  : " + d.patient.getTiming());
		Date date = new Date();
		System.out.println("\n\t\t     Token Time        : " + date.toString());
		System.out.println("\n\t\t=========================================");
		System.out.println("\n\t\t     Fees Paid         : " + Fees);
		System.out.println("\n\t\t     Return            : " + Return);
		afterlogin af = new afterlogin();
		System.out.println("\n\t\t  You Were Served By   : " + af.getVisitor().toUpperCase());
		System.out.println("\n\t\t=========================================");

		return d;

	}

	public static double checkfees(String name) {
		List<Doctors> s = Doctors.readdoctors();
		double ret;
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getName().equals(name)) {
				boolean flag = false;
				do {
					flag = false;
					double fees = input.nextDouble();
					if (fees < s.get(i).getFees() && fees >= 0) {
						System.out.print("\n\t\tFees is less than required amount : ");
						flag = false;
						System.out.print("\n\t\tPlease REenter required amount : ");
					} else if (fees < 0) {
						System.out.print("\n\t\tFees is less than required amount : ");
						flag = false;
						System.out.print("\n\t\tplease REenter required amount : ");
					} else if (fees >= s.get(i).getFees()) {
						flag = true;
						ret = fees - s.get(i).getFees();
						Return = ret;
						Fees = fees;
					}
				} while (flag == false);
			}
		}

		return 0;
	}

	public static void tokenbookforpatient() {
		try {
			List<Counterdesk> c = Counterdesk.readcounterfile();
			Counterdesk newpatient = Counterdesk.addPatients();
			c.add(newpatient);
			FileWriter fr = new FileWriter(COUNTERDESK_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < c.size(); i++) {
				br.write(c.get(i).patient.getName() + "," + c.get(i).patient.getAge() + ","
						+ c.get(i).patient.getToken() + "," + c.get(i).patient.getAppointment() + ","
						+ c.get(i).patient.getFees() + "," + c.get(i).patient.getTiming() + ","
						+ c.get(i).patient.getStatus() + "," + c.get(i).patient.getAddress() + "\n");
			}
			br.close();
			fr.close();
			System.out.println("\n\n\t\tPatient addded Successfully...!");
			System.out.println("\n\n\t\t Press Enter To Continue ...!");
		} catch (Exception e) {
			System.out.println("cannot add patient to file...!");
		}
		Counterdesk.historyofpatients();
	}

	public static String iftokenexists() {
		boolean flag = false;
		String token;
		input.nextLine();
		List<Counterdesk> c = Counterdesk.readcounterfile();
		do {
			flag = false;
			token = input.nextLine();
			for (int i = 0; i < c.size(); i++) {
				if (c.get(i).getPatient().getToken().equals(token)) {
					flag = true;
				}
			}
			if (flag == true) {
				System.out.println("\n\tToken Occupied");
				System.out.print("\t\tPlease Enter Another Token : ");
			}
		} while (flag == true);
		return token;
	}

	public static String ifdoctorexist() {
		input.nextLine();
		boolean flag = false;
		String token;
		List<Doctors> d = Doctors.readdoctors();
		do {
			flag = false;
			token = input.nextLine();
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getName().equals(token)) {
					flag = true;
				}
			}
			if (flag == false) {
				System.out.println("\n\tDoctor not Available");
				System.out.print("\t\tPlease ReEnter : ");
			}
		} while (flag == false);
		return token;
	}

	public static void availabledoctors() {
		List<Doctors> d = Doctors.readdoctors();
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(format, "     ID", "    NAME", "     STATUS", "     SPECIALIST", "     FEES", "     TIMING",
				"     ADDRESS");
		System.out.println(
				"------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < d.size(); i++) {
			System.out.printf(format, d.get(i).getId(), d.get(i).getName(), d.get(i).getStatus(),
					d.get(i).getQualification(), d.get(i).getFees(), d.get(i).getTiming(), d.get(i).getAddress());
			System.out.println(
					"------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void historyofpatients() {
		List<Counterdesk> c = Counterdesk.readcounterfile();
		//File file = new File("/home/owais/Documents/java started/Last Projects/src/Group/patienthistory.txt");
		try {
			FileWriter fr = new FileWriter(PATIENTHISTORY_FILE.getAbsoluteFile(), false);
			BufferedWriter br = new BufferedWriter(fr);
			Object d = new Date();
			br.write("\n\n\t\t Date : " + d.toString() + "\n\n");
			br.write("\t" + "NAME" + "::" + "AGE" + "::" + "TOKEN" + "::" + "APPOINTMENT" + "::" + "FEES" + "::"
					+ "TIMING" + "::" + "STATUS" + "::" + "ADDRESS\n\n");
			for (int i = 0; i < c.size(); i++) {
				br.write("\t" + c.get(i).patient.getName() + "::" + c.get(i).patient.getAge() + "::"
						+ c.get(i).patient.getToken() + "::" + c.get(i).patient.getAppointment() + "::"
						+ c.get(i).patient.getFees() + "::" + c.get(i).patient.getTiming() + "::"
						+ c.get(i).patient.getStatus() + "::" + c.get(i).patient.getAddress() + "\n\n");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("cannot update history,,,");
		}
	}

	public static void displayhistoryofpatients() {
		//File file = new File("/home/owais/Documents/java started/Last Projects/src/Group/patienthistory.txt");
		String line;
		try {
			FileReader fr = new FileReader(PATIENTHISTORY_FILE);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("Cannot display file");
		}
	}

	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	public Counterdesk() {
		this.patient = new Patients();
	}

	public static int getTotaltokens() {
		return totaltokens;
	}

	public static void setTotaltokens(int totaltokens) {
		Counterdesk.totaltokens = totaltokens;
	}

	static class Token {
//		private final static File ff = new File(
//				"/home/owais/Documents/java started/Last Projects/src/Group/TokenList.txt");
		private String token;
		private String tokenstatus;

		public static List<Token> TokenReadList() {
			List<Token> tokens = new ArrayList<Token>();

			try {
				FileReader fr = new FileReader(TOKENLIST_FILE);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					Token d = new Token();
					String[] sp = line.split(",");
					d.setToken(sp[0]);
					d.setTokenstatus(sp[1]);

					tokens.add(d);
				}
			} catch (Exception e) {
				System.out.println("cannot read doctors file ...21");
			}
			return tokens;
		}

		public static void DisplayTokens(List<Token> d) {
			String format = "|  %-20s|  %-20s|%n";
			System.out.println("===============================================\n");
			System.out.printf(format, "     Token", "    Status");
			System.out.println("===============================================\n");
			for (int i = 0; i < d.size(); i++) {
				System.out.printf(format, d.get(i).getToken(), d.get(i).getTokenstatus());
				System.out.println("-----------------------------------------------");
			}
			System.out.println("===============================================\n");
		}

		public static String TokenLoad(List<Token> t) {
			try {
				String a = "available";
				FileReader fr = new FileReader(TOKENLIST_FILE);
				BufferedReader br = new BufferedReader(fr);
				for (int i = 0; i < t.size(); i++) {
					if (t.get(i).getTokenstatus().compareToIgnoreCase(a) == 0) {
						String r = t.get(i).getToken();
						t.get(i).setTokenstatus("not available");
						try {
							FileWriter fw = new FileWriter(TOKENLIST_FILE);
							BufferedWriter bw = new BufferedWriter(fw);
							for (int j = 0; j < t.size(); j++) {
								bw.write("T-" + (j + 1) + "," + t.get(j).getTokenstatus() + "\n");
							}
							bw.close();
						} catch (Exception e) {
							System.out.println("cannot sold token");
						}
						return r;
					}
				}
			} catch (Exception e) {

			}
			return null;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getTokenstatus() {
			return tokenstatus;
		}

		public void setTokenstatus(String tokenstatus) {
			this.tokenstatus = tokenstatus;
		}

	}
}
