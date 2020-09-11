package edu.uog.student;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class studentData {

	@SuppressWarnings("resource")
	public static List<Student> showAll()  {
		List<Student> students = new ArrayList<Student>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Student Student = new Student();
				
				
				String[] StudentRow = line.split(",");
				
				Student.setSTUDENT_ID(Integer.parseInt(StudentRow[0]));
				Student.setSTUDENT_ROLLNO(StudentRow[1]);
				Student.setSTUDY_PROGRAM(StudentRow[2]);
				Student.setSTUDY_YEAR(StudentRow[3]);
				
				students.add(Student);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}
	
	

	
	
	
	@SuppressWarnings("resource")
	public static Student findOne(int Student_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Student Student = new Student();
				
				
				String[] StudentRow = line.split(",");
				
				if (Integer.parseInt(StudentRow[0]) == Student_ID) {

					Student.setSTUDENT_ID(Integer.parseInt(StudentRow[0]));
					Student.setSTUDENT_ROLLNO(StudentRow[1]);
					Student.setSTUDY_PROGRAM(StudentRow[2]);
					Student.setSTUDY_YEAR(StudentRow[3]);
					
									
					return Student;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	@SuppressWarnings("resource")
	public static List<Student> search(String search)  {
		List<Student> Students = new ArrayList<Student>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Student Student = new Student();
				
				String[] StudentRow = line.split(",");
				
				if (StudentRow[1].contains(search) == true) {
					Student.setSTUDENT_ID(Integer.parseInt(StudentRow[0]));
					Student.setSTUDENT_ROLLNO(StudentRow[1]);
					Student.setSTUDY_PROGRAM(StudentRow[2]);
					Student.setSTUDY_YEAR(StudentRow[3]);
					
					Students.add(Student);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Students;
	}

	@SuppressWarnings("resource")
	public static Student Save(Student Student) {
		FileWriter filewriter;

		List<Student> Students = showAll();

		try {
			filewriter = new FileWriter(Student.csvFile);

			for (int i=0; i<Students.size(); i++) {
				filewriter.append(Students.get(i).toString());
				filewriter.append("\n");
			}
			if (Students.size()>0)
				Student.setSTUDENT_ID(Students.get(Students.size()-1).getSTUDENT_ID()+1);
			else
				Student.setSTUDENT_ID(1);
			filewriter.append(Student.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return Student;
	}
	@SuppressWarnings("resource")
	public static Student deleteOne(int Student_ID)  {
		FileWriter filewriter;

		List<Student> Students = showAll();
		Student Student = findOne(Student_ID);

		try {
			filewriter = new FileWriter(Student.csvFile);

			for (int i=0; i<Students.size(); i++) {
				if (Students.get(i).getSTUDENT_ID() != Student_ID) {
					filewriter.append(Students.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Student;
	}
}