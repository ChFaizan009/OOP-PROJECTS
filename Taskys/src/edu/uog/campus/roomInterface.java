package edu.uog.campus;
import java.util.List;
import java.util.Scanner;


public class roomInterface
{

	public static void RoomMenu() {
	
	Scanner sc=new Scanner(System.in);
	int choice=-1;
	choice=-1;
	
	while(choice!=10)
	{
		System.out.println("=====================================================");
		System.out.println("Rooms Menu");
		System.out.println("=====================================================");
		System.out.println("1.   Insert The Rooms Data");
		System.out.println("2.   Delete The Rooms Data");
		System.out.println("3.   Show The Rooms Data");
		System.out.println("4.   Search The Rooms Data");
		System.out.println("5.   Delete All The Rooms Data Record");
		System.out.println("6.   Find Row wize The Rooms Data Record");
		System.out.println("10.   Back");
		System.out.print("Enter Your Choice [1-10]: ");
		choice = sc.nextInt();

		switch(choice)

		{
		case 1:
			System.out.println("---------------------------------");
			System.out.println("Add New Room");
			System.out.println("---------------------------------");
			Room room = new Room();
			
			System.out.println("Enter Id Room :");
			int id=sc.nextInt();
			
			room.setROOM_ID(id);
			
			System.out.println("Enter Name Room :");
			String name=sc.nextLine();
			name+=sc.nextLine();
			room.setROOM_NAME(name);
			
			System.out.println("Enter Room Floor : ");
			int Floor=sc.nextInt();
			
			room.setROOM_FLOOR(Floor);
			
			System.out.println("Enter Room Type : ");
			String Type=sc.nextLine();
			Type+=sc.nextLine();
			room.setROOM_TYPE(Type);
			
			System.out.println("Enter Room Capacity: ");
			int capacity = sc.nextInt();
			room.setROOM_CAPACITY(capacity);
			
			
			room = roomData.Save(room);
			System.out.println(room.toString());
			System.out.println("---------------------------------");
			break;
			
			
		case 2:
			System.out.println("---------------------------------");
			System.out.println("Delete Room");
			System.out.println("---------------------------------");
			System.out.println("Enter Room ID: ");
			int room_ID=sc.nextInt();
			Room roomdelete = roomData.deleteOne1(room_ID);
			System.out.println(roomdelete.toString());
			System.out.println("---------------------------------");
			break;
			
			case 3:
				
				System.out.println("---------------------------------");
				System.out.println("Show All Rooms Data");
				System.out.println("---------------------------------");
				
				List<Room> rooms=roomData.findAll();
				for(int i=0;i<rooms.size();i++)
				{
					System.out.println(rooms.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
				
			case 4 :
				System.out.println("---------------------------------");
				System.out.println("Search Rooms");
				System.out.println("---------------------------------");
                System.out.println("Enter Room Search");
                String Search=sc.nextLine();
                List<Room> roomsearch=roomData.search(Search);
                
                for (int i1=0; i1<roomsearch.size(); i1++) {
					System.out.println(roomsearch.get(i1).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println("Trying to delete All records");
				String delhelper=roomData.DeleteAll();
				System.out.println(delhelper);
				break;
			case 6:
		
				Scanner finone=new Scanner(System.in);
				System.out.println("Enter Room ID to find:-");
				int input=finone.nextInt();
			System.out.println("\n_________Found the Matching ID  record in row___________\n");
		    room=roomData.findOne(input);
			System.out.println(room.toString());
			
			break;
			case 10:
				break;
		
		}
		
	}
}}
