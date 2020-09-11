package edu.uog.timetable;

import java.util.List;
import java.util.Scanner;
public class timeslotMenu {


	public static void Menu() {
	
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	int choice=-1;
	choice=-1;
	
	while(choice!=10)
	{
		System.out.println("=====================================================");
		System.out.println("TimeSlot Menu");
		System.out.println("=====================================================");
		System.out.println("1.   Insert The TimeSlot Data");
		System.out.println("2.   Delete The TimeSlot Data");
		System.out.println("3.   Show The TimeSlot Data");
		System.out.println("4.   Search The TimeSlot Data");
		System.out.println("5.   Delete All The TimeSlot Data Record");
		System.out.println("6.   Find Row wize The TimeSlot Data Record");
		System.out.println("10.   Back");
		System.out.print("Enter Your Choice [1-10]: ");
		choice = sc.nextInt();

		switch(choice)

		{
		case 1:
			System.out.println("---------------------------------");
			System.out.println("Add New TimeSlot");
			System.out.println("---------------------------------");
			TimeSlot TimeSlot = new TimeSlot();
			
			System.out.println("Enter Id TimeSlot :");
			int id=sc.nextInt();
			
			TimeSlot.setTIMESLOT_ID(id);
			
			System.out.println("Enter time of TimeSlot Start :");
			String start=sc.nextLine();
			start+=sc.nextLine();
			TimeSlot.setTIMESLOT_START(start);
			
			System.out.println("Enter time of TimeSlot End :");
			String end=sc.nextLine();
			
			TimeSlot.setTIMESLOT_START(end);
			
			
			
			TimeSlot = timeslotData.Save(TimeSlot);
			System.out.println(TimeSlot.toString());
			System.out.println("---------------------------------");
			break;
			
			
		case 2:
			System.out.println("---------------------------------");
			System.out.println("Delete TimeSlot");
			System.out.println("---------------------------------");
			System.out.println("Enter TimeSlot ID: ");
			int TimeSlot_ID=sc.nextInt();
			TimeSlot TimeSlotdelete = timeslotData.deleteOne1(TimeSlot_ID);
			System.out.println(TimeSlotdelete.toString());
			System.out.println("---------------------------------");
			break;
			
			case 3:
				
				System.out.println("---------------------------------");
				System.out.println("Show All TimeSlot Data");
				System.out.println("---------------------------------");
				
				List<TimeSlot> Timeslot=timeslotData.findAll();
				for(int i=0;i<Timeslot.size();i++)
				{
					System.out.println(Timeslot.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
				
			case 4 :
				System.out.println("---------------------------------");
				System.out.println("Search TimeSlots");
				System.out.println("---------------------------------");
                System.out.println("Enter TimeSlot Search");
                String Search=sc.nextLine();
                List<TimeSlot> TimeSlotsearch=timeslotData.search(Search);
                
                for (int i1=0; i1<TimeSlotsearch.size(); i1++) {
					System.out.println(TimeSlotsearch.get(i1).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println("Trying to delete All records");
				String del=timeslotData.DeleteAll();
				System.out.println(del);
				break;
			case 6:
		
				Scanner finone=new Scanner(System.in);
				System.out.println("Enter TimeSlot ID to find:-");
				int input=finone.nextInt();
			System.out.println("\n_________Found the Matching ID  record in row___________\n");
		    TimeSlot=timeslotData.findOne(input);
			System.out.println(TimeSlot.toString());
			
			break;
		
			case 10:
				break;
		
		}
		
	}
}}
