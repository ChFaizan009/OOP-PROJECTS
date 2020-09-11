package edu.uog;

import java.util.Scanner;

import edu.uog.Person.PersonMenu;
import edu.uog.campus.roomInterface;
import edu.uog.course.CourseMenu;
import edu.uog.student.StudentInterface;
import edu.uog.student.studentcourseInterface;
import edu.uog.teacher.teacherInterface;
import edu.uog.teacher.teachercourseInterface;
import edu.uog.timetable.SemsterMenu;
import edu.uog.timetable.TimeTableMenu;
import edu.uog.timetable.WeekDayMenu;
import edu.uog.timetable.timeslotMenu;

public class TimeTableManagement {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while(choice!=12)
		{
			System.out.println("=====================================================");
			System.out.println("Main Menu");
			System.out.println("=====================================================");
			System.out.println("1. Press  1 for  Rooms Data");
			System.out.println("2. Press  2 for  Courses Data");
			System.out.println("3.  Press 3 for  Students Data ");
			System.out.println("4.  Press 4 for  Teachers Data ");
			System.out.println("5.  Press 5 for  Persons Data ");
			System.out.println("6.  Press 6 for  WeekDays Data ");
			System.out.println("7.  Press 7 for  TimeSlots Data ");
			System.out.println("8.  Press 8 for  Semsters Data ");
			System.out.println("9.  Press 9 for  Student Course Data ");
			System.out.println("10.  Press 10 for  Teacher Course Data ");
			System.out.println("11.  Press 11 for  Time Table Data ");
			System.out.println("12.   Quit");
			System.out.println("Enter Your Choice [1-12]: ");
			choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				roomInterface.RoomMenu();
				choice=-1;
				break;
				
			case 2:
				
				CourseMenu.Menu();
				choice=-1;
				break;
			case 3:
				StudentInterface.StudentMenu();
				choice=-1;
				break;
			
			case 4:
				teacherInterface.TeacherMenu();
				choice=-1;
				break;
			
			case 5:
				PersonMenu.Menu();
				choice=-1;
				break;
			case 6:
				WeekDayMenu.WeekDayMenu();
				choice=-1;
				break;
			case 7:
				timeslotMenu.Menu();
				choice=-1;
				break;
				
			case 8:
				SemsterMenu.Menu();
				choice=-1;
				break;
			case 9:
				studentcourseInterface.Menu();
				choice=-1;
				break;
			case 10:
				teachercourseInterface.Menu();
				choice=-1;
				break;
			case 11:
				TimeTableMenu.Menu();
				choice=-1;
				break;
			case 12:
				
				break;
			default:
				System.out.println("Invalid Choice!");
			}
		}			}
		
		
//		roomData roomdata = new roomData();
//		
//		System.out.println("FindOne");
//		Course course = coursedata.findOne(1);
//		System.out.println(course.toString());
//		System.out.println("---------------------------------");
//	
//		System.out.println("FindAll");
//		List<Course> courses = courseData.findAll();
//		for (int i=0; i<courses.size(); i++) {
//			System.out.println(courses.get(i).toString());
//		}
//		System.out.println("---------------------------------");
//
//		System.out.println("Search");
//		courses = coursedata.search("CR-");
//		for (int i=0; i<courses.size(); i++) {
//			System.out.println(courses.get(i).toString());
//		}
//		System.out.println("---------------------------------");
//	
//		System.out.println("Save");
//		Room room = new Room();
//		room.setROOM_NAME("LR-03");
//		room.setROOM_FLOUR(1);
//		room.setROOM_CAPACITY(50);
//		room.setROOM_TYPE("Lab Course");
//		room = roomdata.Save(room);
//		System.out.println(room.toString());
//		System.out.println("---------------------------------");
//
//		System.out.println("FindAll");
//		courses = coursedata.findAll();
//		for (int i=0; i<courses.size(); i++) {
//			System.out.println(courses.get(i).toString());
//		}
//		System.out.println("---------------------------------");
//
//		System.out.println("Save Course");
//		Course prerequistcourse = new Course();
//		prerequistcourse = courseData.findByCode("CS-102");
//		
//		Course course = new Course();
//		course.setCOURSE_CODE("CS-106");
//		course.setCOURSE_TITLE("Object Oriented Programming");
//		course.setCOURSE_DESC("It is programming course");
//		course.setCOURSE_CREDITHOUR(4);
//		course.setCOURSEPRERQUIST_ID(prerequistcourse);
//		course = courseData.Save(course);
//		System.out.println(room.toString());
//		System.out.println("---------------------------------");
	}
	