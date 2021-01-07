import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class Demo  {
		public static Scanner input = new Scanner(System.in);
		private static Object login;
		private static final File Demo_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/Demo.txt");
		private String disease;
		private String token;
		private String appointment;
		private String room;
		private String wardno;
		private double fees;

		public static void main(String[] args) throws Exception {
			Democontrol();
		}

		public static void Democontrol() throws Exception {
			boolean flag = true;
			char again = 'n';
			do {
				do {
					try {
						System.out.println("\n\n\t\tWELCOME TO PATIENT'S MANAGEMENT");
						System.out.println("\n\t\tpress 0 to Update Status Of Demo");
						System.out.println("\t\tpress 1 to Display All Demo");
						System.out.println("\t\tPress 2 to Update Demo");
						System.out.println("\t\tPress 3 to Delete Demo");
						System.out.println("\t\tPress 4 to Add Demo");
						System.out.println("\t\tPress 5 to Back to Hospital Management");
						System.out.println("\t\tPress 6 to Log Out");
						System.out.println("\t\tPress 7 to Exit");
						System.out.print("\n\tPlease Enter Your Choice : ");
						flag = false;
						int choice = input.nextInt();
						switch (choice) {
						case 0: {
							ClearingScreen();
				Demo.updatestatusofDemo(Demo.readDemo());
							break;
						}
						case 1: {
							ClearingScreen();
							Demo.displayDemo(Demo.readDemo());
							break;
						}
						case 2: {
							ClearingScreen();
							Demo.updateDemo(Demo.readDemo());
							}
							break;
						
						case 3: {
							ClearingScreen();
								Demo.deleteDemo(Demo.readDemo());
							}
							break;
						
						case 4: {
							ClearingScreen();
								Demo.addDemo(Demo.readDemo());
							}
							break;
						
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
				System.out.println("\n\tDo You Want To Use Patient Management Again [y/n]");
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

			System.out.println("\t\t\t\tHOSPITAL Demo AREA\n");
			System.out.println(
					"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

		}

		public static void updatestatusofDemo(List<Demo> p) {
			input.nextLine();
			System.out.print("\n\t\tPlease Enter Name Of Patient : ");
			String name = input.nextLine();
			System.out.print("\n\t\tPlease Enter Id Of Patient : ");
			String id = input.nextLine();
			int recordnotfound = 5;
			for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getName().equals(name) && p.get(i).getId().equals(id)) {
				recordnotfound = 10;
				System.out.print("\n\t\tPlease Write the Status of Patient :- ");
				String status = input.nextLine();
				//p.get(i).setStatus(status);
			    System.out.println("\n\t\t Status Updated ...!");
				System.out.println("\n\t\tPress Enter To Continue ...");
				}
			}
			Demo.writefile(p);
			if (recordnotfound == 5) {
				System.out.println("\n\t\tSorry Record Not Found");
				System.out.println("\n\t\tPress Enter To Continue ...");
			}
		}

		public static List<Demo> readDemo() {
			List<Demo> patient = new ArrayList<>();

			try {
				FileReader fr = new FileReader(Demo_FILE);
				BufferedReader br = new BufferedReader(fr);
				String line;
				while ((line = br.readLine()) != null) {
					Demo d = new Demo();
					String[] sp = line.split(",");
					d.setName(sp[0]);
					//d.setId(sp[1]);
					d.setId(Integer.parseInt(sp[2]));
					//d.setAddress(sp[3]);
					d.setDisease(sp[4]);
					d.setRoom(sp[5]);
					d.setWardno(sp[6]);
					//d.setStatus(sp[7]);
					patient.add(d);
				}
			} catch (Exception e) {
				System.out.println("cannot read doctors file ...21");
			}
			return patient;
		}

		private void setName(String string) {
			// TODO Auto-generated method stub
			
		}

		public static void displayDemo(List<Demo> d) {
			String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf(format, "     NAME", "    ID", "     AGE", "     ADDRESS", "     DISEASE", "     ROOM",
					"     WARD NAME", "     STATUS");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			for (int i = 0; i < d.size(); i++) {
				System.out.printf(format, d.get(i).getName(), d.get(i).getId(), d.get(i).getId(), d.get(i).getAddress(),
						d.get(i).getDisease(), d.get(i).getRoom(), d.get(i).getWardno(), d.get(i).getStatus());
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		}

		public static void addDemo(List<Demo> p) {
			Demo d = new Demo();
			Scanner input = new Scanner(System.in);
			System.out.println("\t\t\nPlease Enter The Deatails Below : \n\n");
			System.out.print("\tEnter Name Of Patient : ");
		//	d.setName(login.validname());
			System.out.println();
			System.out.print("\tEnter Id Of Patient : ");
		//	d.setId(ifpatientidexist());
			System.out.println();
			System.out.print("\tEnter Age Of Patient : ");
		//	d.setId((int) login.validsalary());
			System.out.println();
			System.out.print("\tEnter Address Of Patient : ");
			//d.setAddress(input.nextLine());
			System.out.println();
			System.out.print("\tEnter Disease Of Patient : ");
			d.setDisease(input.nextLine());
			System.out.println();
			System.out.print("\tEnter Room Of Patient : ");
			d.setRoom(input.nextLine());
			System.out.println();
			System.out.print("\tEnter Ward Name Of Patient : ");
			d.setWardno(input.nextLine());
			System.out.println();
			System.out.print("\tEnter Status Of Patient : ");
			//	d.setStatus(input.nextLine());
			System.out.println();
			p.add(d);
			Demo.writefile(p);
			System.out.println("\n\n\t\t\t Record Successfully Added...!");
		}

		private void setId(int i) {
			// TODO Auto-generated method stub
			
		}

		public static String ifpatientidexist() {
			boolean flag = false;
			String token;
			input.nextLine();
			List<Demo> d = Demo.readDemo();
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

		public static void updateDemo(List<Demo> d) {
			Demo.displayDemo(d);
			input.nextLine();
			System.out.print("Enter name of Patient : ");
			String updatename = input.nextLine();
			System.out.print("Enter id of Patient : ");
			String id = input.nextLine();
			try {
				boolean flag = false;
				for (int i = 0; i < d.size(); i++) {
					if (d.get(i).getName().equals(updatename) && d.get(i).getId().equals(id)) {
						flag = true;
						System.out.println("\n\t\t\tRecord founded ...!\n\n");
						System.out.print("\n\t\tEnter name : ");
						d.get(i).setName(input.nextLine());
						System.out.print("\n\t\tEnter Id : ");
						//d.get(i).setId(input.nextLine());
						System.out.print("\n\t\tEnter Age : ");
						d.get(i).setId(input.nextInt());
						input.nextLine();
						System.out.print("\n\t\tEnter address : ");
						//d.get(i).setAddress(input.nextLine());
						System.out.print("\n\t\tEnter Disease : ");
						d.get(i).setDisease(input.nextLine());
						System.out.print("\n\t\tEnter Room : ");
						d.get(i).setRoom(input.nextLine());
						System.out.print("\n\t\tEnter Ward Name : ");
						d.get(i).setWardno(input.nextLine());
						System.out.print("\n\t\tEnter Status : ");
						//d.get(i).setStatus(input.nextLine());

					}
				}
				if (flag == true) {
					Demo.writefile(d);
					System.out.println("\n\n\t\t\tRecord Successfully Updated ...!");
				}
				if (flag == false) {
					System.out.println("record not found");
				}
			} catch (Exception e) {
				System.out.println("cannot update doctors  ...!");
			}
		}

		public static void deleteDemo(List<Demo> dd) {
			Demo.displayDemo(dd);
			input.nextLine();
			System.out.print("Enter name of Patient : ");
			String updatename = input.nextLine();
			System.out.print("Enter Id of Patient : ");
			String id = input.nextLine();
			boolean flag = false;
			for (int i = 0; i < dd.size(); i++) {
				if (dd.get(i).getName().equals(updatename) && dd.get(i).getId().equals(id)) {
					flag = true;
					System.out.println("\n\n\t\tRecord founded ...!");
					dd.remove(i);
				}
			}
			if (flag == true) {
				Demo.writefile(dd);
				System.out.println("\n\n\t\t\tRecord deleted Successfully ...!");
			}
			if (flag == false) {
				System.out.println("record not found");
			}
		}

		private Object getId() {
			// TODO Auto-generated method stub
			return null;
		}

		private Object getName() {
			// TODO Auto-generated method stub
			return null;
		}

		public static void writefile(List<Demo> d) {
			try {
				FileWriter fr = new FileWriter(Demo_FILE);
				BufferedWriter br = new BufferedWriter(fr);
				for (int i = 0; i < d.size(); i++) {
					br.write(d.get(i).getName() + "," + d.get(i).getId() + "," + d.get(i).getId() + ","
							+ d.get(i).getAddress() + "," + d.get(i).getDisease() + "," + d.get(i).getRoom() + ","
							+ d.get(i).getWardno() + "," + d.get(i).getStatus() + "\n");
				}
				br.close();
				fr.close();
			} catch (Exception e) {
				System.out.println("cannot write in file");
			}
		}

		private Object getAddress() {
			// TODO Auto-generated method stub
			return null;
		}

		private Object getStatus() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getDisease() {
			return disease;
		}

		public void setDisease(String disease) {
			this.disease = disease;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public String getAppointment() {
			return appointment;
		}

		public void setAppointment(String appointment) {
			this.appointment = appointment;
		}

		public String getRoom() {
			return room;
		}

		public void setRoom(String room) {
			this.room = room;
		}

		public String getWardno() {
			return wardno;
		}

		public double getFees() {
			return fees;
		}

		public void setFees(double fees) {
			this.fees = fees;
		}

		public void setWardno(String wardno) {
			this.wardno = wardno;
		}

	}