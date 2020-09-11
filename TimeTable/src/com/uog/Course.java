package com.uog;

public class Course {

	private int COURSE_ID;
	private String COURSE_NAME;
	private String COURSE_CODE;
	private String COURSE_DESC;
	private String COURSE_CREDESC;
	private Course CoursePrerquist_ID;
	
	
	
Course(int cOURSE_ID, String cOURSE_NAME, String cOURSE_CODE, String DESC, String cOURSE_CREDESC,
			Course Prerquist_ID) {
		
		COURSE_ID = cOURSE_ID;
		COURSE_NAME = cOURSE_NAME;
		COURSE_CODE = cOURSE_CODE;
		COURSE_DESC = DESC;
		COURSE_CREDESC = cOURSE_CREDESC;
		CoursePrerquist_ID = Prerquist_ID;
	}

	public int getCOURSE_ID() {
		return COURSE_ID;
	}
	
	public void setCOURSE_ID(int cOURSE_ID) {
		COURSE_ID = cOURSE_ID;
	}
	
	public String getCOURSE_NAME() {
		return COURSE_NAME;
	}
	
	public void setCOURSE_NAME(String cOURSE_NAME) {
		COURSE_NAME = cOURSE_NAME;
	}
	
	public String getCOURSE_CODE() {
		return COURSE_CODE;
	}
	
	public void setCOURSE_CODE(String cOURSE_CODE) {
		COURSE_CODE = cOURSE_CODE;
	}
	
	public String getCOURSE_DESC() {
		return COURSE_DESC;
	}
	
	public void setCOURSE_DESC(String cOURSE_DESC) {
		COURSE_DESC = cOURSE_DESC;
	}
	
	public String getCOURSE_CREDESC() {
		return COURSE_CREDESC;
	}
	
	public void setCOURSE_CREDESC(String cOURSE_CREDESC) {
		COURSE_CREDESC = cOURSE_CREDESC;
	}
	
	public Course getCoursePrerquist_ID() {
		return CoursePrerquist_ID;
	}
   	
	public void setCoursePrerquist_ID(Course coursePrerquist_ID) {
		CoursePrerquist_ID = coursePrerquist_ID;
	}
	

	
}
