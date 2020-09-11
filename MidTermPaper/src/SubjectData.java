import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class SubjectData
{

		private static final String Subject_FILE = null;

	
		
		public static void Menu() {
			
			Scanner sc=new Scanner(System.in);
			int choice=-1;
			choice=-1;
			
			while(choice!=5)
			{

				System.out.println("1.   Add The Subjects Data");
				System.out.println("2.   Update The Subjects Data");
				System.out.println("3.   Delete The Subjects Data");
		     	System.out.println("5.   Back");
		        System.out.print("Enter Your Choice [1-5]: ");
		       choice = sc.nextInt();

		switch(choice)

		{
		case 1:
			
			public static void addSubject(List<Subject> hr) {
				Subject d = new Subject();
				Scanner input = new Scanner(System.in);
				System.out.println("\t\t\nPlease Enter The Details Below : \n\n");
				System.out.print("\tEnter Name Of Subject : ");
				d.setSUBJECTName(Subject.ifsubjectnameexist());
				System.out.println();
				System.out.print("\tEnter id Of Subject : ");
				d.setSUBJECT_ID(input.nextInt());
				System.out.println();
				System.out.print("\tEnter Code Of Subject : ");
				d.setSUBJECT_CODE(input.nextLine());
				System.out.println();
				System.out.print("\tEnter tITLE Of Subject: ");
				d.setSUBJECT_TITLE(input.nextLine());
				System.out.println();
				hr.add(d);
				Subject.writefile(hr);
				System.out.println("\n\n\t\t\tRecord Successfully Added..!");
			}

			public static String ifsubjectnameexist() {
				Scanner input=new Scanner(System.in);
				boolean flag = false;
				String sc;
				
				input.nextLine();
				List<Subject> d = Subject.readSubject();
				do {
					flag = false;
					sc = input.nextLine();
					for (int i = 0; i < d.size(); i++) {
						if (d.get(i).getSUBJECT_NAME().equals(sc)) {
							flag = true;
						}
					}
					if (flag == true) {
						System.out.println("\n\tSubject Name Already Exists");
						System.out.print("\t\tPlease ReEnter : ");
					}
				} while (flag == true);
				return sc;
			
			break;

			case 2:
				
	public static void updatestatusofsubject(List<Subject> r) {
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		
		input.nextLine();
		System.out.print("\n\t\tPlease Enter Name Of Subject : ");
		String name = input.nextLine();
		int recordnotfound = 5;
		for (int i = 0; i < r.size(); i++) {
			if (r.get(i).getSUBJECT_NAME().equals(name)) {
				recordnotfound = 10;
				String a = "available";
				String na = "not available";
				System.out.println("\n\t\t Press 1 to " + a);
				System.out.println("\t\t Press 2 to " + na);
				System.out.print("\n\t\t Enter Choice : ");
				int choice = input.nextInt();
				if (choice == 1) {
					r.get(i).setStatus1(a);
					System.out.println("\n\t\tStatus Updated ...");
				} else if (choice == 2) {
					((Subject) r.get(i)).setStatus(na);
					System.out.println("\n\t\tStatus Updated ...");
				} else {
					System.out.println("\n\t\tYou Made Wrong Choice ...");
				}
			}
		}
	
		if (recordnotfound == 5) {
			System.out.println("\n\t\tSorry Record Not Found");
			System.out.println("\n\t\tPress Enter To Continue ...");
		
		}	
	break;
	

	case 3:
	public static void deleteSubject(List<Subject> dd) {
		
	Scanner input=new Scanner(System.in);
		Subject.displaySubject1(dd);
		input.nextLine();
		System.out.print("\n\n\t\tEnter name of Hospital Room : ");
		String updatename = input.nextLine();
		System.out.print("\n\t\tEnter Ward of Hospital Ward : ");
		String ward = input.nextLine();
		boolean flag = false;
		for (int i = 0; i < dd.size(); i++) {
			if (dd.get(i).getSUBJECT_NAME().equals(updatename) && dd.get(i).getSUBJECTName().equals(ward)) {
				flag = true;
				System.out.println("\n\n\t\t\tRecord founded ...!");
				dd.remove(i);
			}
		}
		if (flag == true) {
			Subject.writefile(dd);
			System.out.println("\n\n\t\t\t\tRecord deleted Successfully ...! ");

		}
		if (flag == false) {
			System.out.println("record not found");
		}
	}

	public static void writefile(List<Subject> d) {
		try {
			FileWriter fr = new FileWriter(Subject_FILE);
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 0; i < d.size(); i++) {
				br.write(d.get(i).getSUBJECT_NAME() + "," + d.get(i).getSUBJECT_CODE() + "," + d.get(i).getSUBJECT_TITLE() + ","
						 + "\n");
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("cannot write in file");
		}
	
	}
	case 5:
		break;
	
	
	
}}