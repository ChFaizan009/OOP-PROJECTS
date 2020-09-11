package com.uog;

public class TEACHER {
	
	private int TEACHER_ID;
	private String TEACHER_TITLE;
	private String TEACHER_NAME;
     
	
	public TEACHER(int tEACHER_ID, String tEACHER_TITLE, String tEACHER_NAME) {
		
		TEACHER_ID = tEACHER_ID;
		TEACHER_TITLE = tEACHER_TITLE;
		TEACHER_NAME = tEACHER_NAME;
	}


	public int getTEACHER_ID() {
		return TEACHER_ID;
	}

	
	public void setTEACHER_ID(int tEACHER_ID) {
		TEACHER_ID = tEACHER_ID;
	}

	
	public String getTEACHER_TITLE() {
		return TEACHER_TITLE;
	}

	
	public void setTEACHER_TITLE(String tEACHER_TITLE) {
		TEACHER_TITLE = tEACHER_TITLE;
	}

	
	public String getTEACHER_NAME() {
		return TEACHER_NAME;
	}

	
	public void setTEACHER_NAME(String tEACHER_NAME) {
		TEACHER_NAME = tEACHER_NAME;
	}
	
}
