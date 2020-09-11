package edu.uog.teacher;

import edu.uog.course.Course;
import edu.uog.course.courseData;
import edu.uog.student.StudentCourse;
import edu.uog.student.studentcourseData;

public class TeacherCourse {

	public static String csvFile="D:\\OOP Projects\\TimeTableFiles\\TeacherCourses.csv";
	private int TEACHERCOURSE_ID;
	private StudentCourse STUDENTCOURSE_ID;
	private Course COURSE_ID;
	private Teacher TEACHER_ID;
	private String SECTION;
	
	public String toString()
	{
		String str= null;
		str=this.TEACHERCOURSE_ID
				+" ,"+this.STUDENTCOURSE_ID.getSTUDENTCOURSE_ID()
				+" ,"+ this.COURSE_ID.getCOURSE_ID()
				+" ,"+ this.TEACHER_ID.getPERSON_ID()
				+" ,"+ this.SECTION;
			
		return str;

	}

	
	
	public static String getCsvFile() {
		return csvFile;
	}




	public static void setCsvFile(String csvFile) {
		TeacherCourse.csvFile = csvFile;
	}


	public StudentCourse getSTUDENTCOURSE_ID() {
		return STUDENTCOURSE_ID;
	}


	public void setSTUDENTCOURSE_ID(StudentCourse sTUDENTCOURSE_ID) {
		STUDENTCOURSE_ID = sTUDENTCOURSE_ID;
	}



	public Course getCOURSE_ID() {
		return COURSE_ID;
	}

	public void setCOURSE_ID(Course cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}

	public Teacher getTEACHER_ID() {
		return TEACHER_ID;
	}


	public void setTEACHER_ID(Teacher tEACHER_ID) {
		TEACHER_ID = tEACHER_ID;
	}


	public String getSECTION() {
		return SECTION;
	}

	public void setSECTION(String sECTION) {
		SECTION = sECTION;
	}



	public int getTEACHERCOURSE_ID() {
		return TEACHERCOURSE_ID;
	}



	public void setTEACHERCOURSE_ID(int tEACHERCOURSE_ID) {
		TEACHERCOURSE_ID = tEACHERCOURSE_ID;
	}
}
