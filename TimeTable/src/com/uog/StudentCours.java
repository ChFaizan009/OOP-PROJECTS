package com.uog;

public class StudentCours {
	private int STUDENTCOURSE_ID;
	private int COURSE_ID;
	private int STUDENT_ID;
	private String SECTION;
	
	
	
	public StudentCours(int sTUDENTCOURSE_ID, int cOURSE_ID, int sTUDENT_ID, String sECTION) {
		
		STUDENTCOURSE_ID = sTUDENTCOURSE_ID;
		COURSE_ID = cOURSE_ID;
		STUDENT_ID = sTUDENT_ID;
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
	
	public int getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(int sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public String getSECTION() {
		return SECTION;
	}
	public void setSECTION(String sECTION) {
		SECTION = sECTION;
	}


}
