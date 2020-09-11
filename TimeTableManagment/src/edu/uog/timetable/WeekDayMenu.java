package edu.uog.timetable;

import java.util.List;
import java.util.Scanner;

public class WeekDayMenu {

	

	public static void WeekDayMenu() {
	
	Scanner sc=new Scanner(System.in);
	int choice=-1;
	choice=-1;
	
	while(choice!=10)
	{
		System.out.println("=====================================================");
		System.out.println("WeekDays Menu");
		System.out.println("=====================================================");
		System.out.println("1.   Insert The WeekDay Data");
		System.out.println("2.   Delete The WeekDay Data");
		System.out.println("3.   Show The WeekDay Data");
		System.out.println("4.   Search The WeekDay Data");
		System.out.println("5.   Delete All The WeekDay Data Record");
		System.out.println("6.   Find Row wize The WeekDay Data Record");

		System.out.println("10.   Back");
		System.out.print("Enter Your Choice [1-10]: ");
		choice = sc.nextInt();

		switch(choice)

		{
		case 1:
			System.out.println("---------------------------------");
			System.out.println("Add WeekDay Data");
			System.out.println("---------------------------------");
			WeekDay WeekDay = new WeekDay();
			
			System.out.println("Enter Id WeekDay :");
			int id=sc.nextInt();
			
			WeekDay.setWEEKDAY_ID(id);
			
			System.out.println("Enter Name WeekDay :");
			String name=sc.nextLine();
			
			WeekDay.setWEEKDAY_NAME(name);
			
			
			WeekDay = weekdayData.Save(WeekDay);
			
			System.out.println(WeekDay.toString());
			System.out.println("---------------------------------");
			break;
			
			
		case 2:
			System.out.println("---------------------------------");
			System.out.println("Delete WeekDay");
			System.out.println("---------------------------------");
			System.out.println("Enter WeekDay ID: ");
			int WeekDay_ID=sc.nextInt();
			WeekDay WeekDaydelete = weekdayData.deleteOne(WeekDay_ID);
			System.out.println(WeekDaydelete.toString());
			System.out.println("---------------------------------");
			break;
			
			case 3:
				
				System.out.println("---------------------------------");
				System.out.println("Show All WeekDay Data");
				System.out.println("---------------------------------");
				
				List<WeekDay> Weekday=weekdayData.findAll();
				for(int i=0;i<Weekday.size();i++)
				{
					System.out.println(Weekday.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;

			case 4 :
				System.out.println("---------------------------------");
				System.out.println("Search WeekDay");
				System.out.println("---------------------------------");
                System.out.println("Enter WeekDay Search");
                String Search=sc.nextLine();
                List<WeekDay> search=weekdayData.search(Search);
                
                for (int i1=0; i1<search.size(); i1++) {
					System.out.println(search.get(i1).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println("Trying to delete All records");
				String del=weekdayData.DeleteAll();
				System.out.println(del);
				break;
			case 6:
		
				Scanner scan=new Scanner(System.in);
				System.out.println("Enter WeekDay ID to find:-");
				int input=sc.nextInt();
			System.out.println("\n_________Found the Matching ID  record in row___________\n");
		    WeekDay=weekdayData.findOne(input);
			System.out.println(WeekDay.toString());
			
			break;
		
				
		
			case 10:
				break;
		
		}
		
	}
}}


