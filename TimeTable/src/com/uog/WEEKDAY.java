package com.uog;

public class WEEKDAY {
	
	private int  WEEKDAY_ID;
	private String WEEKDAY_NAME;
	
	
	 WEEKDAY(int wEEKDAY_ID, String wEEKDAY_NAME) {
		
		WEEKDAY_ID = wEEKDAY_ID;
		WEEKDAY_NAME = wEEKDAY_NAME;
	}


	public int getWEEKDAY_ID() {
		return WEEKDAY_ID;
	}
	
		
	public void setWEEKDAY_ID(int wEEKDAY_ID) {
		WEEKDAY_ID = wEEKDAY_ID;
	}
	
	
	public String getWEEKDAY_NAME() {
		return WEEKDAY_NAME;
	}
	
	
	
	public void setWEEKDAY_NAME(String wEEKDAY_NAME) {
		WEEKDAY_NAME = wEEKDAY_NAME;
	}
	
}
