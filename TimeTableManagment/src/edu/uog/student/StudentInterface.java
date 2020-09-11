package edu.uog.student;

import java.util.List;
import java.util.Scanner;



public class StudentInterface {

	
		public static void StudentMenu()
		{
		int choice;
		boolean i=true;
		Scanner sc=new Scanner(System.in);
		while(i)
		{
			System.out.println("=====================================================");
			System.out.println("Students Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert The Students Data");
			System.out.println("2.   Delete The Students Data");
			System.out.println("3.   Show The Students Data");
			System.out.println("4.   Search The Students Data");
			System.out.println("5.   Delete All The Students Data Record");
			System.out.println("6.   Find Students Data Record in Row wize  ");
			
		
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = sc.nextInt();

			switch(choice)

			{
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Student");
				System.out.println("---------------------------------");
				Student Student = new Student();
				
				System.out.println("Enter ID Student :");
				int Student_ID=sc.nextInt();
				
				Student.setSTUDENT_ID(Student_ID);
				
				System.out.println("Enter Student Roll No : ");
				String RollNo=sc.nextLine();
				RollNo=sc.nextLine();
				Student.setSTUDENT_ROLLNO(RollNo);
				
				System.out.println("Enter Student STUDY PROGRAM : ");
				String Program=sc.nextLine();
				Program+=sc.nextLine();
				Student.setSTUDY_PROGRAM(Program);
				
				System.out.println("Enter  STUDY_YEAR: ");
				String Year = sc.nextLine();
				Student.setSTUDY_YEAR(Year);
				
				Student = studentData.Save(Student);
				System.out.println(Student.toString());
				System.out.println("---------------------------------");
				break;
				
			
                case 2:
				System.out.println("---------------------------------");
				System.out.println("Delete Student");
				System.out.println("---------------------------------");
				System.out.println("Enter Student ID: ");
				int STUDENT_Id=sc.nextInt();
				Student Studentdelete = studentData.deleteOne(STUDENT_Id);
				System.out.println(Studentdelete.toString());
				System.out.println("---------------------------------");
				break;
				
				case 3:
					
					System.out.println("---------------------------------");
					System.out.println("Show All Students Data");
					System.out.println("---------------------------------");
					
					List<Student> Students=studentData.showAll();
					for(int j=0;j<Students.size();j++)
					{
						System.out.println(Students.get(j).toString());
					}
					System.out.println("---------------------------------");
					break;
					
				case 4 :
					System.out.println("---------------------------------");
					System.out.println("Search Students");
					System.out.println("---------------------------------");
	                System.out.println("Enter Student Search");
	                String Search=sc.nextLine();
	                List<Student> search=studentData.search(Search);
	                
	                for (int j=0; j<search.size(); j++) {
						System.out.println(search.get(j).toString());
					}
					System.out.println("---------------------------------");
					
					break;
				case 5:
					System.out.println(" Delete All records of Students");
					String del=studentData.DeleteAll();
					System.out.println(del);
					break;
				case 6:
			
					Scanner Sc=new Scanner(System.in);
					System.out.println("Enter Student ID to find:-");
					int sc1=Sc.nextInt();
				System.out.println("\n______Found the Matching ID  record in row___________\n");
				Student=studentData.findOne(sc1);
				System.out.println(Student.toString());
				
				break;
					
			
				case 10:
					i=false;
		}
		
	}}}