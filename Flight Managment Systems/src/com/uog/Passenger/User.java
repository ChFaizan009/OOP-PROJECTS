package com.uog.Passenger;

public class User {

	
	private int USER_ID;
	private String USER_NAME;
	private String USER_PASSWORD;
	private String USER_NUMBER;
	private String USER_EMAIL;
	private String USER_TYPE;
	
	public static String csvFile = "D:\\OOP Projects\\TimeTableFiles\\User.csv";
	
	
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}
	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}
	public String getUSER_NUMBER() {
		return USER_NUMBER;
	}
	public void setUSER_NUMBER(String uSER_NUMBER) {
		USER_NUMBER = uSER_NUMBER;
	}
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	public String getUSER_TYPE() {
		return USER_TYPE;
	}
	public void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}
	
	
	@Override
	public String toString() {
		return "User [USER_ID=" + USER_ID + ", USER_NAME=" + USER_NAME + ", USER_PASSWORD=" + USER_PASSWORD
				+ ", USER_NUMBER=" + USER_NUMBER + ", USER_EMAIL=" + USER_EMAIL + ", USER_TYPE=" + USER_TYPE + "]";
	}
	
	
	
	

}
