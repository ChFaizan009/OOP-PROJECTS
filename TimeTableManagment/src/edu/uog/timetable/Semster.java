package edu.uog.timetable;

public class Semster {

	public static String csvFile = "D:\\OOP Projects\\TimeTableFiles\\Semsters.csv";

	private  int SEMSTER_ID;

	private String SEMSTER_CODE;
	
	private String SEMSTER_NAME;
	
	private String SEMSTER_STARTDATE;
	
	private String SEMSTER_ENDDATE;

	public int getSEMSTER_ID() {
		return SEMSTER_ID;
	}

	public  void setSEMSTER_ID(int sEMSTER_ID) {
		SEMSTER_ID = sEMSTER_ID;
	}

	public String getSEMSTER_CODE() {
		return SEMSTER_CODE;
	}

	public void setSEMSTER_CODE(String sEMSTER_CODE) {
		SEMSTER_CODE = sEMSTER_CODE;
	}

	public String getSEMSTER_NAME() {
		return SEMSTER_NAME;
	}

	public void setSEMSTER_NAME(String sEMSTER_NAME) {
		SEMSTER_NAME = sEMSTER_NAME;
	}

	public String getSEMSTER_STARTDATE() {
		return SEMSTER_STARTDATE;
	}

	public void setSEMSTER_STARTDATE(String sEMSTER_STARTDATE) {
		SEMSTER_STARTDATE = sEMSTER_STARTDATE;
	}

	public String getSEMSTER_ENDDATE() {
		return SEMSTER_ENDDATE;
	}

	public void setSEMSTER_ENDDATE(String sEMSTER_ENDDATE) {
		SEMSTER_ENDDATE = sEMSTER_ENDDATE;
	}

	public String toString() {
		String str = null;
		
		str = this.SEMSTER_ID
				+ "," + this.SEMSTER_CODE
				+ "," + this.SEMSTER_NAME
				+ "," + this.SEMSTER_STARTDATE
				+ "," + this.SEMSTER_ENDDATE
				;
		
		return str;
	}
	

}
