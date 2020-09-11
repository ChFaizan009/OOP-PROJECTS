package hospitalsystem;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class login {
	private String name;
	private String Password;
	private static String admin;
	private String id;
	private String contactno;
	private String address;
	private String email;
	private String role;
	private String lasttimelogin;
	public static Scanner input = new Scanner(System.in);

	private static final File LOGIN_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/login.txt");

	public static void main(String[] args) throws Exception {
		login.control();
	}

	public static void control() throws Exception {
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
					login.startup();
					int choice = 0;
					System.out.println("\n\t\t\tPress 1 For Login ");// ok
					System.out.println("\t\t\tPress 2 to Exit\n");// ok
					System.out.print("\tENTER CHOICE : ");
					flag = false;
					choice = input.nextInt();
					switch (choice) {
					case 1: {
						login.CheckPassword(login.ReadPassword());
						break;
					}
					case 2: {
						login.goodby();
						System.exit(0);
						break;
					}
					default: {
						System.out.println("******************YOU ENTERED WRONG CHOICE*********************\n");
						break;
					}
					}
				} catch (Exception e) {
					System.out.println("\n\t\t YOU CANNOT DO THAT BRO...!");
				}
			} while (flag == true);
			input.nextLine();
			System.out.println("\n\tDO YOU WANT TO TRY LOGIN AGAIN [y/n]");
			again = input.next().charAt(0);
			if (again == 'y' || again == 'Y') {
				login.LoginClearingScreen();
			}
		} while (again == 'y' || again == 'Y');

	}

	public static List<login> ReadPassword() {
		List<login> log = new ArrayList<login>();
		try {
			FileReader fr = new FileReader(LOGIN_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				login o = new login();
				String[] sp = line.split(",");
				o.setAdmin(sp[0]);
				o.setId(sp[1]);
				o.setName(sp[2]);
				o.setPassword(sp[3]);
				o.setAddress(sp[4]);
				o.setContactno(sp[5]);
				o.setRole(sp[6]);
				o.setEmail(sp[7]);
				o.setLasttimelogin(sp[8]);
				log.add(o);
			}
		} catch (Exception e) {
			System.out.println("cannot read file...!");
		}

		return log;
	}

	public static void CheckPassword(List<login> logo) throws Exception {
		int again = 1;
		int count = 0, p = 0;
		Console con = System.console();
		input.nextLine();
		System.out.println("\n\tLOGIN PLEASE");
		while (again == 1) {
			System.out.print("\t\tUserName : ");
			String name = input.nextLine();
			System.out.print("\t\tPassword : ");
			String pass = input.nextLine();
			for (int i = 0; i < logo.size(); i++) {
				if ((logo.get(i).getName().equals(name) && logo.get(i).getPassword().equals(pass))
						|| (logo.get(i).getName().equals(name) && logo.get(i).getAdmin().equals(pass))) {
					System.out.println("\n\t\tPASSWORD ACCEPTED");
					String use = logo.get(i).getName().toString();
					new afterlogin(use);
					afterlogin.control();
					again++;
					p++;
				}

			}
			if (count == 3 && p == 0) {
				System.out.println("\n\t\tDo You Want To Reset Password [y/n]");
				char reset = input.next().charAt(0);

				if (reset == 'y' || reset == 'Y') {
					try {
						input.nextLine();
						System.out.print("\t\tUserName : ");
						String resetname = input.nextLine();
						System.out.print("\t\tId : ");
						String resetid = input.nextLine();
						System.out.print("\t\tMail : ");
						String resetmail = input.nextLine();
						int notfound = 0;
						for (int i = 0; i < logo.size(); i++) {
							if (logo.get(i).getName().equals(resetname) && logo.get(i).getId().equals(resetid)
									&& logo.get(i).getEmail().equals(resetmail)) {
								System.out.println("\n\tRECORD  FOUNDED ...!");
								logo.get(i).setPassword("0000");
								System.out.println("\n\nt\t\tPASSWORD RESET SUCCESSFULL...!");
								System.out.println("\n\t\tYOUR NEW PASSWORD IS '0000'");
								notfound++;
								login.goodby();
							}
						}
						login.writefile(logo);
						again++;
						if (notfound == 0) {
							System.out.println("\n\t\tRECORD NOT FOUNDED ...!");
							System.out.println("\n\t\tASK ADMIN TO RESET ...!");

						}
					} catch (Exception e) {
						System.out.println("\n\t\t CANNOT RESET PASSWORD...!");
					}

				}

				else {
					again++;
					login.goodby();
					System.exit(0);
				}

			}
			count++;
			if (again == 1) {
				System.out.println("\n\t\tTRY AGAIN PLEASE....!\n");
			}
		}

	}

//	public static String GUIPassword() {
//		String password = null;
//		JPasswordField pf = new JPasswordField();
//		int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION,
//				JOptionPane.PLAIN_MESSAGE);
//
//		if (okCxl == JOptionPane.OK_OPTION) {
//			password = new String(pf.getPassword());
//		}
//		return password;
//	}

	public static void LoginClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tHOSPITAL LOGIN AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public static void startup() {

		System.out.println("\t\t-------------------------------------------------------------------------");
		System.out.println("\t\t*************************************************************************");
		System.out.println("\t\t*************************************************************************");
		System.out.println("\t\t-------------------------------------------------------------------------\n\n");
		System.out.println("\t\t                       WELCOME TO LOGIN                                  \n\n");
		System.out.println("\t\t-------------------------------------------------------------------------");
		System.out.println("\t\t*************************************************************************");
		System.out.println("\t\t*************************************************************************");
		System.out.println("\t\t-------------------------------------------------------------------------");

	}

	public static void goodby() {

		System.out.println("\t\t-------------------------------------------------------------------------");
		System.out.println("\t\t*************************************************************************");
		System.out.println("\t\t*************************************************************************");
		System.out.println("\t\t-------------------------------------------------------------------------\n\n");
		System.out.println("\t\t                  THANK YOU FOR USING THIS SOFTWARE                      \n\n");
		System.out.println("\t\t-------------------------------------------------------------------------");
		System.out.println("\t\t*************************************************************************");
		System.out.println("\t\t*************************************************************************");
		System.out.println("\t\t-------------------------------------------------------------------------");

	}

	public static String validname() {
		String name;
		int space = 0;
		boolean flag;
		do {
			space = 0;
			flag = false;
			name = input.nextLine();
			for (int i = 0; i < name.length(); i++) {
				if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')
						|| (name.charAt(i) == ' ' || name.charAt(i) == '-')) {
					if (name.charAt(i) == ' ' || name.charAt(i) == '-') {
						space++;
					}
				} else {
					flag = true;
				}
				if (space == 3) {
					flag = true;
				}
			}
			if (flag == true) {
				System.out.println("\n\t\tInvalid");
				System.out.print("\t\tTry Again : ");

			}

		} while (flag == true);
		return name;
	}

	public static double validsalary() {
		double n = 0;
		boolean flag = true;
		do {
			try {
				flag = false;
				n = input.nextDouble();

			} catch (Exception e) {
				flag = true;
				System.out.println("\n\t\tInvalid");
				System.out.print("\t\tTry Again : ");
				input.nextLine();
			}
		} while (flag == true);

		return n;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLasttimelogin() {
		return lasttimelogin;
	}

	public void setLasttimelogin(String lasttimelogin) {
		this.lasttimelogin = lasttimelogin;
	}

}
