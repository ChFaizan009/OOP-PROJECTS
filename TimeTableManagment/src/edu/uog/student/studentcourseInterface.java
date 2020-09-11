package edu.uog.student;

import java.util.List;
import java.util.Scanner;

import edu.uog.course.courseData;
import edu.uog.timetable.SemsterData;
public class studentcourseInterface {
	



		public static void Menu() {
		
		Scanner sc=new Scanner(System.in);
		int choice=-1;
		choice=-1;
		
		while(choice!=10)
		{
			System.out.println("=====================================================");
			System.out.println("StudentCourse Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert The StudentCourse Data");
			System.out.println("2.   Delete The StudentCourse Data");
			System.out.println("3.   Show The StudentCourse Data");
			System.out.println("4.   Search The StudentCourse Data");
			System.out.println("5.   Delete All The StudentCourse Data Record");
			System.out.println("6.   Find Row wize The StudentCourse Data Record");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = sc.nextInt();

			switch(choice)

			{
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New StudentCourse");
				System.out.println("---------------------------------");
				StudentCourse StudentCourse = new StudentCourse();
				
				System.out.println("Enter Id StudentCourse :");
				int id=sc.nextInt();
				
				StudentCourse.setSTUDENTCOURSE_ID(id);
				
				System.out.println("Enter Id of Course :");
				int Student_id=sc.nextInt();
				StudentCourse.setCOURSE_ID(courseData.findOne(Student_id));
				
				
				System.out.println("Enter StudentCourse id : ");
				int Floor=sc.nextInt();
				StudentCourse.setSTUDENT_ID(studentData.findOne(Floor));
				
				
				System.out.println("Enter Section  : ");
				String section=sc.nextLine();
				
				StudentCourse.setSECTION(section);
				
				System.out.println("Enter Semster Id: ");
				int capacity = sc.nextInt();
				StudentCourse.setSEMESTER_ID(SemsterData.findOne(capacity));
				
				
				
				StudentCourse = studentcourseData.Save(StudentCourse);
				System.out.println(StudentCourse.toString());
				System.out.println("---------------------------------");
				break;
				
				
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete StudentCourse");
				System.out.println("---------------------------------");
				System.out.println("Enter StudentCourse ID: ");
				int StudentCourse_ID=sc.nextInt();
				StudentCourse StudentCoursedelete = studentcourseData.deleteOne(StudentCourse_ID);
				System.out.println(StudentCoursedelete.toString());
				System.out.println("---------------------------------");
				break;
				
				case 3:
					
					System.out.println("---------------------------------");
					System.out.println("Show All StudentCourse Data");
					System.out.println("---------------------------------");
					
					List<StudentCourse> StudentsCourse=studentcourseData.FindAll();
					for(int i=0;i<StudentsCourse.size();i++)
					{
						System.out.println(StudentsCourse.get(i).toString());
					}
					System.out.println("---------------------------------");
					break;
					
				case 4 :
					System.out.println("---------------------------------");
					System.out.println("Search StudentCourse");
					System.out.println("---------------------------------");
	                System.out.println("Enter StudentCourse Search");
	                String Search=sc.nextLine();
	                List<StudentCourse> StudentCourseearch=studentcourseData.Search(Search);
	                
	                for (int i1=0; i1<StudentCourseearch.size(); i1++) {
						System.out.println(StudentCourseearch.get(i1).toString());
					}
					System.out.println("---------------------------------");
					
					break;
				case 5:
					System.out.println("Trying to delete All records");
					String delhelper=studentcourseData.DeleteAll();
					System.out.println(delhelper);
					break;
				case 6:
			
					Scanner finone=new Scanner(System.in);
					System.out.println("Enter StudentCourse ID to find:-");
					int input=finone.nextInt();
				System.out.println("\n_________Found the Matching ID  record in row___________\n");
			    StudentCourse=studentcourseData.FindOne(input);
				System.out.println(StudentCourse.toString());
				
				break;
				case 10:
					break;
			
			}
			
		}
	}}

