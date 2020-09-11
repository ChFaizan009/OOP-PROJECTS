package edu.uog.teacher;




import java.util.List;
import java.util.Scanner;

import edu.uog.course.Course;
import edu.uog.course.courseData;


public class teacherInterface {

	public static void TeacherMenu()
	{
	int choice;
	boolean i=true;
	Scanner sc=new Scanner(System.in);
	while(i)
	{
		System.out.println("=====================================================");
		System.out.println("Teachers Menu");
		System.out.println("=====================================================");
		System.out.println("1.   Insert The Teachers Data");
		System.out.println("2.   Delete The Teachers Data");
		System.out.println("3.   Show The Teachers Data");
		System.out.println("4.   Search The Teachers Data");
		System.out.println("5.   Delete All The Teachers Data Record");
		System.out.println("6.   Find Teachers Data Record in Row wize  ");
		System.out.println("10.   Back");
		System.out.print("Enter Your Choice [1-10]: ");
		choice = sc.nextInt();

		switch(choice)

		{
		case 1:
			System.out.println("---------------------------------");
			System.out.println("Add New Teacher");
			System.out.println("---------------------------------");
			Teacher Teacher = new Teacher();
			
			System.out.println("Enter ID Teacher :");
			int Teacher_ID=sc.nextInt();
			
			Teacher.setTEACHER_ID(Teacher_ID);
			
		
			Teacher = teacherData.Save(Teacher);
			System.out.println(Teacher.toString());
			
			break;
			
			
		case 2:
			System.out.println("---------------------------------");
			System.out.println("Delete Teacher");
			System.out.println("---------------------------------");
			System.out.println("Enter Teacher ID: ");
			int Teacher_ID1=sc.nextInt();
			Course Coursedelete = courseData.deleteOne(Teacher_ID1);
			System.out.println(Coursedelete.toString());
			System.out.println("---------------------------------");
			break;
			
			case 3:
				
				System.out.println("---------------------------------");
				System.out.println("Show All Teachers Data");
				System.out.println("---------------------------------");
				
				List<Teacher> Teachers=teacherData.findAll();
				for(int j=0;j<Teachers.size();j++)
				{
					System.out.println(Teachers.get(j).toString());
				}
				
				break;
			case 4 :
				System.out.println("---------------------------------");
				System.out.println("Search Teachers Data");
				System.out.println("---------------------------------");
                System.out.println("Enter Teacher Search");
                String Search=sc.nextLine();
                List<Teacher> search=teacherData.search(Search);
                
                for (int j=0; j<search.size(); j++) {
					System.out.println(search.get(j).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 5:
				System.out.println(" Delete All records of Teachers");
				String del=teacherData.DeleteAll();
				System.out.println(del);
				break;
			case 6:
		
				Scanner finone=new Scanner(System.in);
				System.out.println("Enter Teacher ID to find:-");
				int input=finone.nextInt();
			System.out.println("\n______Found the Matching ID  record in row___________\n");
		    Teacher=teacherData.findOne(input);
			System.out.println(Teacher.toString());
			
			break;
		
			case 10:
				i=false;
	}
	
}}}