package edu.uog.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.course.courseData;
import edu.uog.timetable.SemsterData;






public class studentcourseData {

	
	public static List<StudentCourse> FindAll(){
		List<StudentCourse> studentCourses= new ArrayList<StudentCourse>();
		String line ;
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while((line=bufferedReader.readLine()) != null) {
				StudentCourse StudentCourse = new StudentCourse();
				String[] rowstudent = line.split(",");
				StudentCourse.setSTUDENTCOURSE_ID(Integer.parseInt(rowstudent[0]));
				StudentCourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(rowstudent[1])));
				StudentCourse.setSTUDENT_ID(studentData.findOne(Integer.parseInt(rowstudent[2])));
				StudentCourse.setSECTION(rowstudent[3]);
				StudentCourse.setSEMESTER_ID(SemsterData.findOne(Integer.parseInt(rowstudent[4])));
				
				
				studentCourses.add(StudentCourse);
			}
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return studentCourses;
	}
	
	
	
	public static StudentCourse FindOne(int StudentCourse_ID){
	
		List<StudentCourse> studentsStudentCourses = new ArrayList<StudentCourse>();	
		String line;
		try {
		@SuppressWarnings("resource")
		BufferedReader bufferreader = new BufferedReader(new FileReader(StudentCourse.csvFile));
		
		while((line=bufferreader.readLine())!=null) {
			StudentCourse studentCourse = new StudentCourse();
			String[] rowstudent = line.split(",");
			
			if(Integer.parseInt(rowstudent[0]) == StudentCourse_ID ) 
			
			{
				studentCourse.setSTUDENTCOURSE_ID(Integer.parseInt(rowstudent[0]));
				studentCourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(rowstudent[1])));
				studentCourse.setSTUDENT_ID(studentData.findOne(Integer.parseInt(rowstudent[2])));
				studentCourse.setSECTION(rowstudent[3]);
				studentCourse.setSEMESTER_ID(SemsterData.findOne(Integer.parseInt(rowstudent[4])));;
	
			
			
			
			studentsStudentCourses.add(studentCourse);
			
			return studentCourse;
			}
			
			
		}
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return null;
	
	
}
	
	

	public static List<StudentCourse> Search(String search){
		List<StudentCourse> sCourses= new ArrayList<StudentCourse>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while((line=bufferedReader.readLine())!=null) {
				StudentCourse studentCourse = new StudentCourse();
				String[] rowstudent = line.split(",");
				studentCourse.setSTUDENTCOURSE_ID(Integer.parseInt(rowstudent[0]));
				studentCourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(rowstudent[1])));
				studentCourse.setSTUDENT_ID(studentData.findOne(Integer.parseInt(rowstudent[2])));
				studentCourse.setSECTION(rowstudent[3]);
				studentCourse.setSEMESTER_ID(SemsterData.findOne(Integer.parseInt(rowstudent[4])));;
	
				
				
				
				sCourses.add(studentCourse);
				}
				//return rooms;
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return sCourses;
	}

	public static StudentCourse Save(StudentCourse student) {
		
		FileWriter fr;
		List<StudentCourse> studentsStudentCourses = FindAll();
		
		try {
			fr = new FileWriter(StudentCourse.csvFile);
			
			for(int i=0;i<studentsStudentCourses.size();i++) {
				fr.append(studentsStudentCourses.get(i).toString());
				fr.append("\n");
			}
			
			
			if(studentsStudentCourses.size()>0) {
				student.setSTUDENTCOURSE_ID(studentsStudentCourses.get(studentsStudentCourses.size()-1).getSTUDENTCOURSE_ID()+1);
			}
			else {
				student.setSTUDENTCOURSE_ID(1);
			}
			studentsStudentCourses.add(student);
				fr.append(student.toString());
				fr.append("\n");
				fr.flush();
				fr.close();
			
			
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return student;
	}


	public static String DeleteAll() {
		
		FileWriter fr;
		List<edu.uog.student.StudentCourse> StudentCourses = FindAll();
		try {
			fr = new FileWriter(StudentCourse.csvFile);
			
			for(int i=0;i<StudentCourses.size();i++) {
				StudentCourses.remove(i);
			}
				fr.flush();
				fr.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Students StudentCourse Data Removed Successfully";
		
	}
	
	@SuppressWarnings({ "resource", "static-access" })
	public static StudentCourse deleteOne(int StudentCourse_ID)  {
		FileWriter filewriter;

		List<StudentCourse> StudentCourses = FindAll();
		StudentCourse StudentCourse = FindOne(StudentCourse_ID);

		try {
			filewriter = new FileWriter(StudentCourse.csvFile);

			for (int i=0; i<StudentCourses.size(); i++) {
				if (StudentCourses.get(i).getSTUDENTCOURSE_ID() != StudentCourse_ID) {
					filewriter.append(StudentCourses.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return StudentCourse;
	}
		
	}

