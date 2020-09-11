package edu.uog.timetable;

import java.util.List;
import java.util.Scanner;

public class SemsterMenu

{
	

	public static void Menu()
	{
	int choice;
	boolean i=true;
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	while(i)
	{
		System.out.println("=====================================================");
		System.out.println("Semsters Menu");
		System.out.println("=====================================================");
		System.out.println("1.   Insert The Semsters Data");
		System.out.println("2.   Delete The Semsters Data");
		System.out.println("3.   Show The Semsters Data");
		System.out.println("4.   Search The Semsters Data");
		System.out.println("5.   Delete All The Semsters Data Record");
		System.out.println("6.   Find Semsters Data Record in Row wize  ");
		System.out.println("10.   Back");
		System.out.print("Enter Your Choice [1-10]: ");
		choice = sc.nextInt();

		switch(choice)

		{
		case 1:
			System.out.println("---------------------------------");
			System.out.println("Add New Semster");
			System.out.println("---------------------------------");
			Semster Semster = new Semster();
			
			System.out.println("Enter ID Semster :");
			int Semster_ID=sc.nextInt();
			
			Semster.setSEMSTER_ID(Semster_ID);
			
			System.out.println("Enter Semster Code : ");
			String Semster_code=sc.nextLine();
			Semster_code=sc.nextLine();	
			Semster.setSEMSTER_CODE(Semster_code);
			
			System.out.println("Enter Semster Name : ");
			String name=sc.nextLine();
			
			Semster.setSEMSTER_NAME(name);
			
			System.out.println("Enter Semster START DATE: ");
			String DESC = sc.nextLine();
			Semster.setSEMSTER_STARTDATE(DESC);
			
			System.out.println("Enter Semster End DATE: ");
			String EndDate = sc.nextLine();
			Semster.setSEMSTER_ENDDATE(EndDate);
			
		
			Semster = SemsterData.Save(Semster);
			System.out.println(Semster.toString());
			System.out.println("---------------------------------");
			break;
			
			
		case 2:
			System.out.println("---------------------------------");
			System.out.println("Delete Semster");
			System.out.println("---------------------------------");
			System.out.println("Enter Semster ID: ");
			int Semster_id=sc.nextInt();
			Semster Semsterdelete = SemsterData.deleteOne(Semster_id);
			System.out.println(Semsterdelete.toString());
			System.out.println("---------------------------------");
			break;
			
			case 3:
				
				System.out.println("---------------------------------");
				System.out.println("Show All Semsters Data");
				System.out.println("---------------------------------");
				
				List<Semster> Semsters=SemsterData.findAll();
				for(int j=0;j<Semsters.size();j++)
				{
					System.out.println(Semsters.get(j).toString());
				}
				System.out.println("---------------------------------");
				break;
				
			case 4 :
				System.out.println("---------------------------------");
				System.out.println("Search Semsters");
				System.out.println("---------------------------------");
                System.out.println("Enter Semster Search");
                String Search=sc.nextLine();
                List<Semster> search=SemsterData.search(Search);
                
                for (int j=0; j<search.size(); j++) {
					System.out.println(search.get(j).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println(" Delete All records of Semsters");
				String del=SemsterData.DeleteAll();
				System.out.println(del);
				break;
			case 6:
		
				Scanner finone=new Scanner(System.in);
				System.out.println("Enter Semster ID to find:-");
				int input=finone.nextInt();
			System.out.println("\n______Found the Matching ID  record in row___________\n");
		    Semster=SemsterData.findOne(input);
			System.out.println(Semster.toString());
			
			break;
				
		
			case 10:
				i=false;
	}
	
}}}
