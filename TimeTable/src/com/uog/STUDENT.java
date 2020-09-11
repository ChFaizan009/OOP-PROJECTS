package com.uog;

public class STUDENT {
	
	private int STUDENT_ID;
	private String STUDENT_ROLLNO;
    
	
	public STUDENT(int sTUDENT_ID, String sTUDENT_ROLLNO) {
	
		STUDENT_ID = sTUDENT_ID;
		STUDENT_ROLLNO = sTUDENT_ROLLNO;
	}


	public int getSTUDENT_ID() {
		return STUDENT_ID;
	}

	
	public void setSTUDENT_ID(int sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}

	
	public String getSTUDENT_ROLLNO() {
		return STUDENT_ROLLNO;
	}

	
	public void setSTUDENT_ROLLNO(String sTUDENT_ROLLNO) {
		STUDENT_ROLLNO = sTUDENT_ROLLNO;
	}
	

}
