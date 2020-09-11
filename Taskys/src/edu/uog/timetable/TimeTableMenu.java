    package edu.uog.timetable;
    import java.util.List;
	import java.util.Scanner;

import edu.uog.campus.roomData;
import edu.uog.course.courseData;
    import edu.uog.teacher.teacherData;
import edu.uog.teacher.teachercourseData;
import edu.uog.timetable.SemsterData;

public class TimeTableMenu 
{

			public static void Menu() {
			
			Scanner sc=new Scanner(System.in);
			int choice=-1;
			choice=-1;
			
			while(choice!=10)
			{
				System.out.println("=====================================================");
				System.out.println("TimeTable Menu");
				System.out.println("=====================================================");
				System.out.println("1.   Insert The TimeTable Data");
				System.out.println("2.   Delete The TimeTable Data");
				System.out.println("3.   Show The TimeTable Data");
				System.out.println("4.   Search The TimeTable Data");
				System.out.println("5.   Delete All The TimeTable Data Record");
				System.out.println("6.   Find Row wize The TimeTable Data Record");
				System.out.println("10.   Back");
				System.out.print("Enter Your Choice [1-10]: ");
				choice = sc.nextInt();

				switch(choice)

				{
				case 1:
					System.out.println("---------------------------------");
					System.out.println("Add New TimeTable");
					System.out.println("---------------------------------");
					TimeTable TimeTable = new TimeTable();
					
					System.out.println("Enter Id TimeTable :");
					int id=sc.nextInt();
					
					TimeTable.setTIMETABLE_ID(id);
					
					System.out.println("Enter Id of Semster :");
					int semster=sc.nextInt();
					TimeTable.setSEMESTER_ID(SemsterData.findOne(semster));
					
					System.out.println("Enter TEACHERCOURSE Id : ");
					int teacherid=sc.nextInt();
					TimeTable.setTEACHERCOURSE_ID(teachercourseData.findOne(teacherid));
					
					
					System.out.println("Enter TIMESLOT Id  : ");
					int timeid=sc.nextInt();
					TimeTable.setTIMESLOT_ID(timeslotData.findOne(timeid));
					
					
					
					System.out.println("Enter ROOM id : ");
					int roomid = sc.nextInt();
					
					TimeTable.setROOM_ID(roomData.findOne(roomid));
					
					
					
					TimeTable = timetableData.Save(TimeTable);
					System.out.println(TimeTable.toString());
					System.out.println("---------------------------------");
					break;
					
					
				case 2:
					System.out.println("---------------------------------");
					System.out.println("Delete TimeTable");
					System.out.println("---------------------------------");
					System.out.println("Enter TimeTable ID: ");
					int TimeTable_ID=sc.nextInt();
					TimeTable TimeTabledelete = timetableData.deleteOne(TimeTable_ID);
					System.out.println(TimeTabledelete.toString());
					System.out.println("---------------------------------");
					break;
					
					case 3:
						
						System.out.println("---------------------------------");
						System.out.println("Show All TimeTable Data");
						System.out.println("---------------------------------");
						
						List<TimeTable> timetable=timetableData.FindAll();
						for(int i=0;i<timetable.size();i++)
						{
							System.out.println(timetable.get(i).toString());
						}
						System.out.println("---------------------------------");
						break;
						
					case 4 :
						System.out.println("---------------------------------");
						System.out.println("Search TimeTable");
						System.out.println("---------------------------------");
		                System.out.println("Enter TimeTable Search");
		                String Search=sc.nextLine();
		                List<TimeTable> TimeTableearch=timetableData.Search(Search);
		                
		                for (int i1=0; i1<TimeTableearch.size(); i1++) {
							System.out.println(TimeTableearch.get(i1).toString());
						}
						System.out.println("---------------------------------");
						
						break;
					case 5:
						System.out.println("Trying to delete All records");
						String del=timetableData.DeleteAll();
						System.out.println(del);
						break;
					case 6:
				
						Scanner finone=new Scanner(System.in);
						System.out.println("Enter TimeTable ID to find:-");
						int input=finone.nextInt();
					System.out.println("\n_________Found the Matching ID  record in row___________\n");
				    TimeTable=timetableData.FindOne(input);
					System.out.println(TimeTable.toString());
					
					break;
					case 10:
						break;
				
				}
				
			}
		}}




