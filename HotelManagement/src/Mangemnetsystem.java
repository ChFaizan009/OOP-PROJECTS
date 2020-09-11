import java.io.File;
import java.util.Scanner;


public class Mangemnetsystem extends data {

	private static final File Mangament_FILE= new File("D://hotel.xlsx");
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		Mangemnetsystemcontrol();
	}
	public static void Mangemnetsystemcontrol() throws Exception
	{
		System.out.println("\n\n\t\tWELCOME TO HOTEL MANAGEMENT SYSTEM");
	boolean flag=false;
	char again='n';
	do {
		do {
			try {
				System.out.println("\n\t\tPress 0 to Update Status Of All Managers");
				System.out.println("\t\tPress 1 to Display Manager bio Data");
				System.out.println("\t\tPress 2 to Update Manager bio Data");
				System.out.println("\t\tPress 3 to Delete Manager bio Data");
				System.out.println("\t\tPress 4 to Add Manager bio Data");
		        System.out.println("\t\tPress 5 to Log Out");
				System.out.println("\t\tPress 6 to Exit");
				System.out.println("\n\tPlease Enter Your Choice : ");
			flag=false;
			int choice=input.nextInt();
			switch (choice) {
			case 0: {
				ClearingScreen();
				Mangemnetsystem.updatestatusofMangemnetsystem(Mangemnetsystem.readMangemnetsystem());
				break;
			}
			case 1: {
				ClearingScreen();
				Mangemnetsystem.displayMangemnetsystem(Mangemnetsystem.readMangemnetsystem());
				break;
			}
			case 2: {
				ClearingScreen();
				if (afterlogin.checkbeforeanythingpersonal("UPDATE MANGEMENT SYSTEM ") == true) {
					Mangemnetsystem.updateMangemnetsystem(Mangemnetsystem.readMangemnetsystem());
				}
				break;
			}
			case 3: {
				ClearingScreen();
				if (afterlogin.checkbeforeanythingpersonal("DELETE MANGEMENT SYSTEM") == true) {
					Mangemnetsystem.deleteMangemnetsystem(Mangemnetsystem.readMangemnetsystem());
				}
				break;
			}
			case 4: {
				ClearingScreen();
				if (afterlogin.checkbeforeanythingpersonal("ADD MANGER BIO DATA") == true) {
					Mangemnetsystem.addMangemnetsystem(Mangemnetsystem.readMangemnetsystem());
				}
				break;
			}
			
			
			case 5: {
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
		}
		while(flag==true); {
			input.nextLine();
			System.out.println("\n\tDo You Want To Use Hotel Management Again [y/n]");
			input.nextLine();
			System.out.println("\n\tDo You Want To Use Transport Management Again [y/n]");
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

		System.out.println("\t\t\t\tHOSPITAL TRANSPORT AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}

		}
	}
	

}

	

 