package com.uog;

public class Days {
	private int WEEK_ID;
	private String WEEK_NAME;
	
	
	
	public Days(int wEEK_ID, String wEEK_NAME) {
		
		WEEK_ID = wEEK_ID;
		WEEK_NAME = wEEK_NAME;
	}

	public int getWEEK_ID() {
	
		return WEEK_ID;
	}
	
	public void setWEEK_ID(int wEEK_ID) {
	
		WEEK_ID = wEEK_ID;
	}
	
	public String getWEEK_NAME() {
	
		return WEEK_NAME;
	}
	public void setWEEK_NAME(String wEEK_NAME) {
		WEEK_NAME = wEEK_NAME;
		
	}
	
}
