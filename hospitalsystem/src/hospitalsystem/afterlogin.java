package hospitalsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class afterlogin {
	private static String Visitor;
	public static Scanner input = new Scanner(System.in);
	private static final File LOGIN_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/login.txt");
	private static final File BACKUP_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/backup.txt");
	private static final File BACKUPHISTORY_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/backuphistory.txt");
	private static final File EVERYRECENTLY_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/EveryRecently.txt");

	public static void main(String[] args) throws Exception {
		afterlogin.control();
	}

	public afterlogin() {

	}

	public afterlogin(String user) {
		this.Visitor = user;
		this.setVisitor(user);
	//	File f = new File("/home/owais/Documents/java started/Last Projects/src/Group/login.txt");
		List<login> list = login.ReadPassword();
		try {
			Object d = new Date();
			FileWriter fw = new FileWriter(LOGIN_FILE);
			BufferedWriter br = new BufferedWriter(fw);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equals(user)) {
					list.get(i).setLasttimelogin(d.toString());
				}
				br.write(list.get(i).getAdmin() + "," + list.get(i).getId() + "," + list.get(i).getName() + ","
						+ list.get(i).getPassword() + "," + list.get(i).getAddress() + "," + list.get(i).getContactno()
						+ "," + list.get(i).getRole() + "," + list.get(i).getEmail() + ","
						+ list.get(i).getLasttimelogin() + "\n");
			}
			br.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("cannot update date...!");
		}
	}

	public static void afterloginbackupfile() {
	//	File f = new File("/home/owais/Documents/java started/Last Projects/src/Group/login.txt");
	//	File backupfile = new File("/home/owais/Documents/java started/Last Projects/src/Group/backup.txt");
		try {
			FileReader fr = new FileReader(LOGIN_FILE);
			Object d = new Date();
			FileWriter bfr = new FileWriter(BACKUP_FILE.getAbsoluteFile(), false);
			int backup;
			bfr.write("\n\t\t" + d.toString() + "\n\n");
			while ((backup = fr.read()) != -1) {
				bfr.write((char) backup);
			}
			fr.close();
			bfr.close();
		} catch (Exception e) {
			System.out.println("cannot update backup file...!");
		}
	}

	public static void control() throws Exception {
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
					afterlogin.afterloginbackupfile();
					afterlogin.afterloginbacuphistory();

					System.out.println(
							"\n##################################################################################################");
					System.out.println(
							"##################################################################################################");
					System.out.println("\n\n\t\t************* WELCOME TO CONTROL ROOM ***********");
					System.out.println("\n\n\t\t\t\t\t" + Visitor.toUpperCase());
					System.out.println("\n\n\t\t****************ALL RIGHTS RESERVED**************\n\n");
					System.out.println("\t\tPress 1 To Enter Hospital Management");// ok
					System.out.println("\t\tPress 2 To Create New User Account");// ok
					System.out.println("\t\tPress 3 To Personalize Your Account");// ok
					System.out.println("\t\tPress 4 To View History & Details");// ok
					System.out.println("\t\tPress 5 To Delete Any User");// ok
					System.out.println("\t\tPress 6 To Log Out");
					System.out.println("\t\tPress 7 To Exit\n");
					System.out.println(
							"##################################################################################################");
					System.out.println(
							"##################################################################################################\n\n");
					System.out.print("\n\tEnter Choice  :  ");
					flag = false;
					int choice = input.nextInt();
					switch (choice) {
					case 1: {// perfect
						AfterLoginClearingScreen();
						Hospital.hospitalmanagement();
						break;
					}
					case 2: {// perfect
						AfterLoginClearingScreen();
						afterlogin.creatnewuser();
						break;
					}
					case 3: {// perfect
						AfterLoginClearingScreen();
						afterlogin.personalizeaccount(login.ReadPassword());
						break;
					}
					case 4: {// perfect
						AfterLoginClearingScreen();
						afterlogin.History(login.ReadPassword());
						break;
					}
					case 5: {// perfect
						AfterLoginClearingScreen();
						afterlogin.DeleteRecord(login.ReadPassword());
						break;
					}
					case 6: {// perfect
						login.LoginClearingScreen();
						System.out.println("\n\n\t\t\t*******************LOGGED OUT COMPLETED********************\n\n");
						login.control();
						break;
					}
					case 7: {// perfect
						AfterLoginClearingScreen();
						login.goodby();
						System.exit(0);
						break;
					}
					default: {// perfect
						System.out.println("\n\t\t***** YOU ENTERED WRONG CHOICE *****\n");
						break;
					}
					}
				} catch (Exception e) {
					System.out.println("\n\t\t YOU CANNOT DO THAT BRO...!");
				}
			} while (flag == true);
			input.nextLine();
			System.out.println("\n\t\tDo You Want To Use CONTROL ROOM AGAIN [y/n]");
			again = input.next().charAt(0);
			if (again == 'y' || again == 'Y') {
				AfterLoginClearingScreen();
			}
		} while (again == 'y' || again == 'Y');

	}

	public static void AfterLoginClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tHOSPITAL CONTROL AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public static void afterloginbacuphistory() {
	//	File f = new File("/home/owais/Documents/java started/Last Projects/src/Group/backuphistory.txt");
		List<login> list = login.ReadPassword();

		try {
			Object d = new Date();
			FileWriter fr = new FileWriter(BACKUPHISTORY_FILE.getAbsoluteFile(), true);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equals(Visitor)) {

					br.write("\n\t" + (String) list.get(i).getName() + " :: " + d.toString() + " :: "
							+ (String) list.get(i).getAddress() + " :: " + (String) list.get(i).getContactno());
				}
			}
			br.close();
			br.close();
		} catch (Exception e) {
			System.out.println("cannot update backup file...!");
		}
	}

	public static void personalizeaccount(List<login> list) {

		Scanner input = new Scanner(System.in);
		System.out.println("\n\n\n\t\t$$$$$ PERSONALIZATION $$$$$\n\n");
		System.out.print("\n\t\tPlease enter your password : ");
		String checkpassword = input.nextLine();
		Date d = new Date();
		int notfound = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(Visitor) && list.get(i).getPassword().equals(checkpassword)) {// use//
				notfound++; // compare
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.println("\n\t\t\t\t DETAILS BELOW");
				System.out.println("\n\t\t-------------------------------------------------------");
				String format = "\t\t|    %-15s |   %-29s|";
				System.out.printf(format, "ID", list.get(i).getId());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "NAME", list.get(i).getName());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "PASSWORD", list.get(i).getPassword());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "ADDRESS", list.get(i).getAddress());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "CONTACT NO", list.get(i).getContactno());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "ROLE", list.get(i).getRole());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "EMAIL", list.get(i).getEmail());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "LAST TIME LOGIN", list.get(i).getLasttimelogin());
				System.out.println("\n\t\t-------------------------------------------------------");

				System.out.println("\n\nt\tDo You Really Want to Personalize [y/n]");
				char up = input.next().charAt(0);
				if (up == 'y' || up == 'Y') {
					input.nextLine();
					System.out.println("\t\t\nPlease Enter The Deatails Below : \n\n");
					System.out.print("\tEnter Id     : ");
					list.get(i).setId(input.nextLine());
					System.out.println();
					System.out.print("\tEnter Name       : ");
					list.get(i).setName(login.validname());
					System.out.println();
					System.out.print("\tEnter Password   : ");
					String p = afterlogin.ifpasswordexist();
					list.get(i).setPassword(afterlogin.ifpasswordexist());
					System.out.println("your new password is ");
					System.out.println();
					System.out.print("\tEnter Address    : ");
					list.get(i).setAddress((input.nextLine()));
					System.out.println();
					System.out.print("\tEnter Contact No : ");
					list.get(i).setContactno(input.nextLine());
					System.out.println();
					System.out.print("\tEnter Role       : ");
					list.get(i).setRole(login.validname());
					System.out.println();
					System.out.print("\tEnter Email      : ");
					list.get(i).setEmail(input.nextLine());
					System.out.println();
					System.out.println("\n\n\t\t ***** YOUR ACCOUNT SUCCESFULLY PERSONALIZED ****\n\n");
				} else {
					System.out.println("\n\n\tPersonalized Cancled");
				}
			} else if ((list.get(i).getName().equals(Visitor) && list.get(i).getAdmin().equals(checkpassword))) {
				notfound++;
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.println("\n\t\t\t\t DETAILS BELOW");
				System.out.println("\n\t\t-------------------------------------------------------");
				String format = "\t\t|    %-15s |   %-29s|";
				System.out.printf(format, "Secret Password", list.get(i).getAdmin());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "ID", list.get(i).getId());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "NAME", list.get(i).getName());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "PASSWORD", list.get(i).getPassword());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "ADDRESS", list.get(i).getAddress());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "CONTACT NO", list.get(i).getContactno());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "ROLE", list.get(i).getRole());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "EMAIL", list.get(i).getEmail());
				System.out.println("\n\t\t-------------------------------------------------------");
				System.out.printf(format, "LAST TIME LOGIN", list.get(i).getLasttimelogin());
				System.out.println("\n\t\t-------------------------------------------------------");

				System.out.println("\n\nt\tDo You Really Want to Personalize [y/n]");
				char up = input.next().charAt(0);
				if (up == 'y' || up == 'Y') {
					input.nextLine();
					System.out.println("\t\t\nPlease Enter The Deatails Below : \n\n");
					System.out.print("\tEnter SecretPassword     : ");
					list.get(i).setAdmin(input.nextLine());
					System.out.println();
					System.out.print("\tEnter Id     : ");
					list.get(i).setId(input.nextLine());
					System.out.println();
					System.out.print("\tEnter Name       : ");
					list.get(i).setName(login.validname());
					System.out.println();
					System.out.print("\tEnter Password   : ");
					String p = afterlogin.ifpasswordexist();
					list.get(i).setPassword(afterlogin.ifpasswordexist());
					System.out.println();
					System.out.print("\tEnter Address    : ");
					list.get(i).setAddress((input.nextLine()));
					System.out.println();
					System.out.print("\tEnter Contact No : ");
					list.get(i).setContactno(input.nextLine());
					System.out.println();
					System.out.print("\tEnter Role       : ");
					list.get(i).setRole(input.nextLine());
					System.out.println();
					System.out.print("\tEnter Email      : ");
					list.get(i).setEmail(input.nextLine());
					System.out.println();
					System.out.println("\n\n\t\t ***** YOUR ACCOUNT SUCCESFULLY PERSONALIZED ****\n\n");
				} else {
					System.out.println("\n\n\tPersonalized Cancled");
				}

			}
		}
		afterlogin.writefile(list);
		if (notfound == 0) {
			System.out.println("\n\n\t\t ******  INCORRECT PASSWORD *****");
		}
	}

	public static void creatnewuser() throws IOException {
		List<login> newuser = login.ReadPassword();
		login newuserdetails = afterlogin.addUser();
		newuser.add(newuserdetails);
		afterlogin.writefile(newuser);
		System.out.println("\n\n\t\t ***** ACCOUNT CREATED SUCCESFULLY ****\n\n");
	}

	public static login addUser() {
		login c = new login();
		input.nextLine();
		System.out.println("\n\n\t\tPlease Enter The Details Below : \n\n");
		System.out.print("\tEnter Name Of New User      : ");
		c.setName(login.validname());// logoin.validname
		System.out.println();
		System.out.print("\tEnter Id of New User        : ");
		c.setId(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Password of New User  : ");
		c.setPassword(afterlogin.ifpasswordexist());
		System.out.println();
		System.out.print("\tEnter Address of New User   : ");
		c.setAddress((input.nextLine()));
		System.out.println();
		System.out.print("\tEnter Contact No of New User: ");
		c.setContactno(input.nextLine());
		System.out.println();
		System.out.print("\tEnter Role of New User      : ");
		c.setRole(input.nextLine());// logoin.vaildname
		System.out.println();
		System.out.print("\tEnter Email of New User     : ");
		c.setEmail(input.nextLine());
		System.out.println();
		return c;
	}

	public static String ifpasswordexist() {
		boolean flag = false;
		String token;
		List<login> d = login.ReadPassword();
		do {
			flag = false;
			token = input.nextLine();
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).getPassword().equals(token)) {
					flag = true;
				}
			}
			if (flag == true) {
				System.out.print("\n\t\tPlease ReEnter Another Password : ");
			}
		} while (flag == true);
		return token;
	}

	public static void History(List<login> list) {
		Scanner input = new Scanner(System.in);
		System.out.print("\n\t\tPlease enter your User Name : ");
		String checkname = input.nextLine();
		System.out.print("\n\t\tPlease enter your password : ");
		String checkpassword = input.nextLine();
		int notfound = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPassword().equals(checkpassword) && list.get(i).getName().equals(checkname)) {
				notfound++;
				afterlogin.showhistoryforothers();
			} else if (list.get(i).getName().equals(checkname) && list.get(i).getAdmin().equals(checkpassword)) {
				notfound++;
				afterlogin.showhistoryforadmin();
				System.out.println("\n\n\t\tDo you want to see all Previous Details in backup file....[y/n]");
				char yes = input.next().charAt(0);
				if (yes == 'y' || yes == 'Y') {
					afterlogin.backupfile();
				}
				System.out.println("\n\n\t\t Do You want to View all Prevoius Details in  Recently history ...[y/n]");
				char yess = input.next().charAt(0);
				if (yess == 'y' | yess == 'Y') {
					afterlogin.backuphistory();
				}
				System.out.println("\n\n\t\t Do You want to View all Details in  Recently history ... [y/n]");
				char yesss = input.next().charAt(0);
				if (yesss == 'y' | yesss == 'Y') {
					afterlogin.recenthistory();
				}

				/// here add activity history in check before anything personal
			}
		}
		if (notfound == 0) {
			System.out.println("\n\n\t\t ********** INCORRECT PASSWORD OR USERNAME **********");
			System.out.println("\n\n\t\t Press Enter To Continue ...!");
		}
	}

	public static void showhistoryforothers() {
		System.out.println();
		List<login> list = login.ReadPassword();
		String format = "\t|    %-15s |     %-15s |    %-24s |    %-15s |    %-15s |   %-30s |   %-30s |%n";
		System.out.println(
				"\t------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"\t|        ID          |      USER NAME      |           ADDRESS           |     CONTACT NO     |        ROLE        |               EMAIL              |          LAST TIME LOGIN         |");
		System.out.println(
				"\t------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf(format, list.get(i).getId(), list.get(i).getName(), list.get(i).getAddress(),
					list.get(i).getContactno(), list.get(i).getRole(), list.get(i).getEmail(),
					list.get(i).getLasttimelogin());
			System.out.println(
					"\t------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void showhistoryforadmin() {
		System.out.println();
		List<login> list = login.ReadPassword();
		String format = "\t|    %-15s |     %-15s |     %-15s    |    %-24s |    %-15s |    %-15s |   %-30s |   %-30s |%n";
		System.out.println(
				"\t-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"\t|        ID          |      USER NAME      |        PASSWORD        |           ADDRESS           |     CONTACT NO     |        ROLE        |               EMAIL              |          LAST TIME LOGIN         |");
		System.out.println(
				"\t-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf(format, list.get(i).getId(), list.get(i).getName(), list.get(i).getPassword(),
					list.get(i).getAddress(), list.get(i).getContactno(), list.get(i).getRole(), list.get(i).getEmail(),
					list.get(i).getLasttimelogin());
			System.out.println(
					"\t-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void DeleteRecord(List<login> list) {
		input.nextLine();
		System.out.println("\n\n\t\t ONLY ADMIN CAN DELETE ANY USER'S\n");
		System.out.print("\n\t\tPlease enter your User Name : ");
		String checkname = input.nextLine();
		System.out.print("\n\t\tPlease enter your password : ");
		String checkpassword = input.nextLine();
		boolean X = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(checkname) && list.get(i).getPassword().equals(checkpassword)&&list.get(i).getRole().equals("Admin")) {
				X = true;
				afterlogin.showhistoryforadmin();
				System.out.print("\n\t\tPlease enter User Name  You Want to Delete : ");
				String delatename = input.nextLine();
				int notfound = 0;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).getName().equals(delatename)) {

						notfound++;
						list.remove(j).getName();
						System.out.println(
								"\n\n\t*********************   Record successfully Deleted   *********************");
						System.out.println("\n\n\t\t Press Enter To Continue ...!");
					}
				}
				afterlogin.writefile(list);
				if (notfound == 0) {
					System.out.println("\n\n\t\t RECORD NOT FOUND IN THE LIST ...!");
					System.out.println("\n\n\t\t Press Enter To Continue ...!");
				}

			}
		}
		if (X == false) {
			System.out.println("\n\n\t\t SORRY YOU DONT HAVE ACCESS ...!");
			System.out.println("\n\t\t Press Enter To Continue ...!");
		}

	}

	public static void backupfile() {// for Reading and displaying only
	//	File backupfile = new File("/home/owais/Documents/java started/Last Projects/src/Group/backup.txt");
		try {
			FileReader fr = new FileReader(BACKUP_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			try {
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void backuphistory() {// for Reading and displaying only
	//	File backupfile = new File("/home/owais/Documents/java started/Last Projects/src/Group/backuphistory.txt");
		try {
			FileReader fr = new FileReader(BACKUPHISTORY_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			try {
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkbeforeanythingpersonal(String visitplace) {
		boolean answer = false;
		boolean t = false;
		List<login> c = login.ReadPassword();
		System.out.print("\n\t\tPlease Enter Your Password : \n");
		String pass = input.nextLine();
		int found = 10;
		for (int i = 0; i < c.size(); i++) {
			if (c.get(i).getPassword().equals(pass)) {
				answer = true;
				try {
					Date d = new Date();
//					File file = new File(
//							"/home/owais/Documents/java started/Last Projects/src/Group/EveryRecently.txt");
					FileWriter fw = new FileWriter(EVERYRECENTLY_FILE.getAbsoluteFile(), true);
					BufferedWriter br = new BufferedWriter(fw);
					br.write("\n\n\t\t" + d.toString() + "::\t\t" + visitplace + "\t\t::\t\t" + Visitor);
					br.close();
				} catch (Exception e) {
					System.out.println("cannot updatde recently file");
				}
				t = true;
			}

		}
		if (answer == false) {
			System.out.println("\n\t\t Sorry You Dont Have Access ...");
			System.out.println("\t\tRecord Not Found ...");

		}
		return t;
	}

	public static void writefile(List<login> logo) {
		try {
			FileWriter fr = new FileWriter(LOGIN_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < logo.size(); i++) {
				br.write(logo.get(i).getAdmin() + "," + logo.get(i).getId() + "," + logo.get(i).getName() + ","
						+ logo.get(i).getPassword() + "," + logo.get(i).getAddress() + "," + logo.get(i).getContactno()
						+ "," + logo.get(i).getRole() + "," + logo.get(i).getEmail() + ","
						+ logo.get(i).getLasttimelogin() + "\n");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("cannot write in file");
		}
	}

	public static void recenthistory() {
	//	File file = new File("/home/owais/Documents/java started/Last Projects/src/Group/EveryRecently.txt");
		try {
			FileReader fr = new FileReader(EVERYRECENTLY_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("cannot show recent history file ");
		}
	}

	public String getVisitor() {
		return Visitor;
	}

	public void setVisitor(String visitor) {
		Visitor = visitor;
	}

}
