package com.uog;

public class TeacherCourse {
	
	private int STUDENTCOURSE_ID;
	private int COURSE_ID;
	private int TEACHER_ID;
	private String SECTION;
	
	public TeacherCourse(int sTUDENTCOURSE_ID, int cOURSE_ID, int tEACHER_ID, String sECTION) {
		
		STUDENTCOURSE_ID = sTUDENTCOURSE_ID;
		COURSE_ID = cOURSE_ID;
		TEACHER_ID = tEACHER_ID;
		SECTION = sECTION;
	}


	public int getSTUDENTCOURSE_ID() {
		return STUDENTCOURSE_ID;
	}

	
	public void setSTUDENTCOURSE_ID(int sTUDENTCOURSE_ID) {
		STUDENTCOURSE_ID = sTUDENTCOURSE_ID;
	}

	
	public int getCOURSE_ID() {
		return COURSE_ID;
	}

	
	public void setCOURSE_ID(int cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}

	public int getTEACHER_ID() {
		
		return TEACHER_ID;
	}

	public void setTEACHER_ID(int tEACHER_ID) {
	
		TEACHER_ID = tEACHER_ID;
	}

	
	public String getSECTION() {
		return SECTION;
	}

	public void setSECTION(String sECTION) {
		SECTION = sECTION;
	}
	
	
	
}
