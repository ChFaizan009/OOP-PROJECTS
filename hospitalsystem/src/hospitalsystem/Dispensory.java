package hospitalsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Dispensory {
	private medicines MED;
	public static Scanner input = new Scanner(System.in);
	private static final File DISPENSORY_FILE = new File("E:/Sts WorkSpace 3.9.5/hospitalsystem/txt_files/dispensory.txt");

	public Dispensory() {
		this.MED = new medicines();
	}

	public static void main(String[] args) throws Exception {
		Dispensorycontrol();
	}

	public static void Dispensorycontrol() throws Exception {

		System.out.println("\n\n\t\tWELCOME TO DISPENSORY MANAGEMENT");
		boolean flag = true;
		char again = 'n';
		do {
			do {
				try {
					System.out.println("\n\t\tPress 0 to Update Status of Medicines");
					System.out.println("\t\tPress 1 to Display Medicines");
					System.out.println("\t\tPress 2 to Delete Medicines");
					System.out.println("\t\tPress 3 to Update Medicines");
					System.out.println("\t\tPress 4 to Add Medicines");
					System.out.println("\t\tPress 5 to Sale Medicines");
					System.out.println("\t\tPress 6 to Update Quantity Of Medicine");
					System.out.println("\t\tpress 7 to Back to Hospital Management");
					System.out.println("\t\tPress 8 to Log Out");
					System.out.println("\t\tPress 9 to Exit\n");
					System.out.print("\tPlease Enter Your Choice : ");
					flag = false;
					int choice = input.nextInt();
					medicines m = new medicines();
					switch (choice) {
					case 0: {
						ClearingScreen();
						UpdateStatusOfMedicines(ReadMedicine());
						break;
					}
					case 1: {
						ClearingScreen();
						DisplayMedicine(ReadMedicine());
						break;
					}
					case 2: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("DELETE MEDICINES") == true) {
							DeleteMedicines(ReadMedicine());
						}
						break;
					}
					case 3: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("UPDATE MEDICINE") == true) {
							UpdateMedicines(ReadMedicine());
						}
						break;
					}
					case 4: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("ADD MEDICINES") == true) {
							AddMedicines();
						}
						break;
					}
					case 5: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("SALE MEDICINES") == true) {
							SaleMedicine(ReadMedicine());
						}
						break;
					}
					case 6: {
						ClearingScreen();
						if (afterlogin.checkbeforeanythingpersonal("ADD QUANTITY OF MEDICINES") == true) {
							AddQuantityofMedicine(ReadMedicine());
						}
						break;
					}
					case 7: {
						Hospital.HospitalClearingScreen();
						Hospital.hospitalmanagement();
						break;
					}
					case 8: {
						login.LoginClearingScreen();
						login.control();
						break;
					}
					case 9: {
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
			System.out.println("\n\tDo You Want To Use Dispensory Management Again [y/n]");
			again = input.next().charAt(0);
			if (again == 'y' || again == 'Y') {
				ClearingScreen();
			}
		} while (again == 'Y' || again == 'y');
	}

	public static void AddQuantityofMedicine(List<Dispensory> m) {
		DisplayMedicine(m);
		input.nextLine();
		System.out.print("Enter Name Of Medicine : ");
		String name = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).MED.getName().compareToIgnoreCase(name) == 0) {
				System.out.println("\n\t\tRecord Successfully Founded...!");
				flag = true;
				System.out.print("\n\t\tEnter New Quantity : ");
				int newquantity = input.nextInt();
				m.get(i).MED.setQuantity(newquantity + m.get(i).MED.getQuantity());
			}
		}
		if (flag == true) {
			WriteFile(m);
			System.out.println("\n\t\tRecord Successfully updated..!");
		}
		if (flag == false) {
			System.out.println("Record not found in list ...!");
		}
	}

	public static void SaleMedicine(List<Dispensory> m) {

		DisplayMedicine(m);
		List<Dispensory> salelist = new ArrayList<Dispensory>();
		double quantity;
		char again;
		boolean bill = false;
		do {
			input.nextLine();
			System.out.print("\n\n\t\t\tEnter Name Of Medicine : ");
			String name = input.nextLine();

			boolean flag = false;
			for (int i = 0; i < m.size(); i++) {
				if (m.get(i).MED.getName().compareToIgnoreCase(name) == 0) {
					flag = true;
					bill = true;
					double diff;
					Dispensory sm = new Dispensory();
					System.out.println("\n\t\tMedicine Available...!");
					sm.MED.setName(name);
					do {
						System.out.print("\n\t\t Enter Quantity Of Medicine : ");
						quantity = input.nextInt();
						if (m.get(i).MED.getQuantity() < quantity || quantity < 0) {
							System.out.println("\n\t\tSorry we dont have enough medicine");
						} else if (quantity == 0) {
							System.out.println("\n\t\tSorry All Stock of this Medicine is Sold Out ...!");
						}
					} while (m.get(i).MED.getQuantity() < quantity || quantity < 0);
					diff = m.get(i).MED.getQuantity() - quantity;
					m.get(i).MED.setQuantity(diff);
					sm.MED.setQuantity(quantity);
					sm.MED.setPrice(m.get(i).MED.getPrice());
					salelist.add(sm);
				}
			}
			if (flag == false) {
				System.out.println("Sorry Record Not Found ...!");
			}
			System.out.println("Do you Need Another Medicine [y/n]");
			again = input.next().charAt(0);
		} while (again == 'y');
		if (bill == true) {
			WriteFile(m);
			DisplayBill(salelist);
		}

	}

	public static void DisplayBill(List<Dispensory> m) {
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		double total = 0, grandtotal = 0;
		System.out.println(
				"=============================================================================================\n");
		System.out.println("                                   CUSTOMER BILL                                \n");
		System.out.println(
				"=============================================================================================");
		System.out.printf(format, "     MEDICINE", "    QUANTITY", "     PRICE/QUANTITY", "    TOTAL");
		System.out.println(
				"=============================================================================================\n");
		for (int i = 0; i < m.size(); i++) {
			total = m.get(i).MED.getQuantity() * m.get(i).MED.getPrice();
			System.out.printf(format, m.get(i).MED.getName(), m.get(i).MED.getQuantity(), m.get(i).MED.getPrice(),
					total);
			grandtotal = grandtotal + total;
		}
		System.out.println(
				"\n=============================================================================================");
		System.out.println("\n\t\t GRAND TOTAL  =  " + grandtotal);
		afterlogin af = new afterlogin();
		Date date = new Date();
		af.setVisitor("awais");
		System.out.println("\n\t\t You were Served By  : " + af.getVisitor().toUpperCase());
		System.out.println("\n\t\t Time                : " + date.toString());
		System.out.println(
				"\n=============================================================================================");
		System.out.println("\n\n\t\t\t\t THANK YOU FOR VISITING    ");
		System.out.println(
				"\n=============================================================================================");

	}

	public static void UpdateStatusOfMedicines(List<Dispensory> m) {
		input.nextLine();
		DisplayMedicine(m);
		System.out.print("\n\t\tPlease Enter Name Of Medicine : ");
		String name = input.nextLine();
		System.out.print("\n\t\tPlease Enter Specification Of Medicine : ");
		String pri = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).MED.getName().compareToIgnoreCase(name) == 0
					&& m.get(i).MED.getSpecification().compareToIgnoreCase(pri) == 0) {
				flag = true;
				System.out.println("\n\n\t\t Medicine Founded Successfully ....!\n\n");
				String a = "available";
				String na = "not available";
				System.out.println("\n\t\t Press 1 to " + a);
				System.out.println("\t\t Press 2 to " + na);
				System.out.print("\n\t\t Enter Choice : ");
				int choice = input.nextInt();
				if (choice == 1) {
					m.get(i).MED.setStatus(a);
					System.out.println("\n\t\tStatus Updated Successfully...");
				} else if (choice == 2) {
					m.get(i).MED.setStatus(na);
					System.out.println("\n\t\tStatus Updated Successfully...");
				} else {
					System.out.println("\n\t\tYou Made Wrong Choice ...");
				}
			}
		}
		if (flag == true) {
			WriteFile(m);
		}

		if (flag == false) {
			System.out.println("\n\t\tSorry Record Not Found");
			System.out.println("\n\t\tPress Enter To Continue ...");
		}
	}

	public static void AddMedicines() {
		input.nextLine();
		List<Dispensory> med = ReadMedicine();
		Dispensory m = new Dispensory();
		System.out.println("\n\t\tPlease Enter Details Below ...!");
		System.out.print("\n\t\tEnter Name          : ");
		m.MED.setName(input.nextLine());
		System.out.print("\n\t\tEnter Expiry Date   : ");
		m.MED.setDate(input.nextLine());
		System.out.print("\n\t\tEnter Price         : ");
		m.MED.setPrice(input.nextDouble());
		input.nextLine();
		System.out.print("\n\t\tEnter Specification : ");
		m.MED.setSpecification(input.nextLine());
		System.out.print("\n\t\tEnter Status        : ");
		m.MED.setStatus(input.nextLine());
		System.out.print("\n\t\tEnter Quantity      : ");
		m.MED.setQuantity(input.nextDouble());
		med.add(m);
		WriteFile(med);
		System.out.println("\n\t\t Medicine Added Successfully...!");
	}

	public static void UpdateMedicines(List<Dispensory> d) {
		DisplayMedicine(d);
		input.nextLine();
		System.out.print("\n\t\tEnter name of medicine you want to update : ");
		String updatename = input.nextLine();
		try {
			boolean flag = false;
			for (int i = 0; i < d.size(); i++) {
				if (d.get(i).MED.getName().compareToIgnoreCase(updatename) == 0) {
					flag = true;
					System.out.println("\n\t\tRecord founded ...!");
					System.out.print("\n\t\tEnter Name         : ");
					d.get(i).MED.setName(input.nextLine());
					System.out.print("\n\t\tEnter Expiry Date  : ");
					d.get(i).MED.setDate(input.nextLine());
					System.out.print("\n\t\tEnter Price        : ");
					d.get(i).MED.setPrice(input.nextDouble());
					input.nextLine();
					System.out.print("\n\t\tEnter Specification : ");
					d.get(i).MED.setSpecification(input.nextLine());
					System.out.print("\n\t\tEnter Status        : ");
					d.get(i).MED.setStatus(input.nextLine());
					System.out.print("\n\t\tEnter Quantity      : ");
					d.get(i).MED.setQuantity(input.nextDouble());
				}
			}
			if (flag == true) {
				WriteFile(d);
				System.out.println("\n\t\t SuccessFully Updated ...");
			}
			if (flag == false) {
				System.out.println("record not found");
			}
		} catch (Exception e) {
			System.out.println("cannot update medicines  ...!");
		}
	}

	public static void DeleteMedicines(List<Dispensory> m) {
		DisplayMedicine(m);
		input.nextLine();
		System.out.print("\n\t\tEnter name of medicines you want to delete : ");
		String updatename = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).MED.getName().equals(updatename)) {
				flag = true;
				System.out.println("\n\t\tRecord Founded ...!");
				m.remove(i);
			}
		}
		if (flag == true) {
			WriteFile(m);
			System.out.println("\n\t\t\tRecord Deleted Successfully ...!");

		}
		if (flag == false) {
			System.out.println("\n\t\tRecord Not Found");
		}
	}

	public static void WriteFile(List<Dispensory> dd) {
		try {
			FileWriter fr = new FileWriter(DISPENSORY_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < dd.size(); i++) {
				br.write(dd.get(i).MED.getName() + "," + dd.get(i).MED.getDate() + "," + dd.get(i).MED.getPrice() + ","
						+ dd.get(i).MED.getSpecification() + "," + dd.get(i).MED.getStatus() + ","
						+ dd.get(i).MED.getQuantity() + "\n");
			}
			br.close();
		} catch (Exception e) {
			System.out.println("cannot write in file");
		}
	}

	public static List<Dispensory> ReadMedicine() {
		List<Dispensory> counter = new ArrayList<>();
		try {
			FileReader fr = new FileReader(DISPENSORY_FILE);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				Dispensory c = new Dispensory();
				String[] sp = line.split(",");
				c.MED.setName(sp[0]);
				c.MED.setDate((sp[1]));
				c.MED.setPrice(Double.parseDouble(sp[2]));
				c.MED.setSpecification(sp[3]);
				c.MED.setStatus((sp[4]));
				c.MED.setQuantity(Double.parseDouble(sp[5]));
				counter.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return counter;
	}

	public static void DisplayMedicine(List<Dispensory> m) {
		String format = "|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|  %-20s|%n";
		System.out.println(
				"\n--------------------------------------------------------------------------------------------------------------------");
		System.out.printf(format, "     NAME", "    DATE", "     PRICE", "     SPECIFICATION", "     STATUS",
				"     QUANTITY");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < m.size(); i++) {
			System.out.printf(format, m.get(i).MED.getName(), m.get(i).MED.getDate(), m.get(i).MED.getPrice(),
					m.get(i).MED.getSpecification(), m.get(i).MED.getStatus(), m.get(i).MED.getQuantity());
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------");
		}
	}

	public static void ClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tHOSPITAL DISPENSORY AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

	public medicines getMed() {
		return MED;
	}

	public void setMed(medicines med) {
		this.MED = med;
	}

}

class medicines {
	private String name;
	private String date;
	private String specification;
	private double price;
	private String status;
	private double quantity;

	public double getPrice() {
		return price;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}

