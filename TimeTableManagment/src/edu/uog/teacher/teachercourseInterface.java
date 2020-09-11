package edu.uog.teacher;



import java.util.List;
import java.util.Scanner;

import edu.uog.course.courseData;
import edu.uog.student.studentcourseData;
import edu.uog.timetable.SemsterData;

public class teachercourseInterface{
	



		public static void Menu() {
		
		Scanner sc=new Scanner(System.in);
		int choice=-1;
		choice=-1;
		
		while(choice!=10)
		{
			System.out.println("=====================================================");
			System.out.println("TeacherCourse Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert The TeacherCourse Data");
			System.out.println("2.   Delete The TeacherCourse Data");
			System.out.println("3.   Show The TeacherCourse Data");
			System.out.println("4.   Search The TeacherCourse Data");
			System.out.println("5.   Delete All The TeacherCourse Data Record");
			System.out.println("6.   Find Row wize The TeacherCourse Data Record");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = sc.nextInt();

			switch(choice)

			{
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New TeacherCourse");
				System.out.println("---------------------------------");
				TeacherCourse TeacherCourse = new TeacherCourse();
				
				System.out.println("Enter Id TeacherCourse :");
				int id=sc.nextInt();
				TeacherCourse.setTEACHERCOURSE_ID(id);
				
				System.out.println("Enter Id of STUDENTCOURSE :");
				int Student_id=sc.nextInt();
				TeacherCourse.setSTUDENTCOURSE_ID(studentcourseData.FindOne(Student_id));
				
				System.out.println("Enter Id of COURSE :");
				int COURSE_id=sc.nextInt();
				TeacherCourse.setCOURSE_ID(courseData.findOne(COURSE_id));
				
				
				System.out.println("Enter TeacherCourse id : ");
				int Floor=sc.nextInt();
				TeacherCourse.setTEACHER_ID(teacherData.findOne(Floor));
				
				
				System.out.println("Enter Section  : ");
				String section=sc.nextLine();
				
				TeacherCourse.setSECTION(section);
				
				
				
				TeacherCourse = teachercourseData.Save(TeacherCourse);
				System.out.println(TeacherCourse.toString());
				System.out.println("---------------------------------");
				break;
				
				
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete TeacherCourse");
				System.out.println("---------------------------------");
				System.out.println("Enter TeacherCourse ID: ");
				int TeacherCourse_ID=sc.nextInt();
				TeacherCourse TeacherCoursedelete = teachercourseData.deleteOne(TeacherCourse_ID);
				System.out.println(TeacherCoursedelete.toString());
				System.out.println("---------------------------------");
				break;
				
				case 3:
					
					System.out.println("---------------------------------");
					System.out.println("Show All TeacherCourse Data");
					System.out.println("---------------------------------");
					
					List<TeacherCourse> StudentsCourse=teachercourseData.findAll();
					for(int i=0;i<StudentsCourse.size();i++)
					{
						System.out.println(StudentsCourse.get(i).toString());
					}
					System.out.println("---------------------------------");
					break;
					
				case 4 :
					System.out.println("---------------------------------");
					System.out.println("Search TeacherCourse");
					System.out.println("---------------------------------");
	                System.out.println("Enter TeacherCourse Search");
	                String Search=sc.nextLine();
	                List<TeacherCourse> TeacherCourseearch=teachercourseData.Search(Search);
	                
	                for (int i1=0; i1<TeacherCourseearch.size(); i1++) {
						System.out.println(TeacherCourseearch.get(i1).toString());
					}
					System.out.println("---------------------------------");
					
					break;
				case 5:
					System.out.println("Trying to delete All records");
					String delhelper=teachercourseData.DeleteAll();
					System.out.println(delhelper);
					break;
				case 6:
			
					Scanner finone=new Scanner(System.in);
					System.out.println("Enter TeacherCourse ID to find:-");
					int input=finone.nextInt();
				System.out.println("\n_________Found the Matching ID  record in row___________\n");
			    TeacherCourse=teachercourseData.findOne(input);
				System.out.println(TeacherCourse.toString());
				
				break;
				case 10:
					break;
			
			}
			
		}
	}}




