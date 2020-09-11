package com.uog.pk;

public class paramizzed {
	private String STUDENT_ID;
	private String STUDENT_NAME;
	private String STUDENT_ROLLNO;
	private String STUDENT_PHONENUMBER;
	paramizzed(String sTUDENT_ID, String sTUDENT_NAME, String sTUDENT_ROLLNO, String pHONENUMBER)
		 {
			
		    STUDENT_ID = sTUDENT_ID;
		    STUDENT_NAME = sTUDENT_NAME;
		    STUDENT_ROLLNO = sTUDENT_ROLLNO;
		    STUDENT_PHONENUMBER=pHONENUMBER;
			
		}
	public static void main(String [] arys)
	{
		paramizzed obj =new  paramizzed ("45", " FAIZAN" ," 19011519-000", " 0300-00000000"  );
	}
}
	

