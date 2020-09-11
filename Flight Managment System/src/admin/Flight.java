package admin;


public class Flight
{
    private int FLIGHT_ID;
    private int SEAT_ID;
    private String FLIGHT_NUMBER;
	private String DEPATURE_DATE;
	private String DEPATURE_AIRPOT;
	private String DEPATURE_TIME;
	private String ARRIVAL_TIME;
	private String SOURCE;
	
	public static String csvFile = "D:\\OOP Projects\\TimeTableFiles\\Flight.csv";
	
	
	public String getFLIGHT_NUMBER() {
		return FLIGHT_NUMBER;
	}
	public void setFLIGHT_NUMBER(String fLIGHT_NUMBER) {
		FLIGHT_NUMBER = fLIGHT_NUMBER;
	}
	
	public String getDEPATURE_DATE() {
		return DEPATURE_DATE;
	}
	public void setDEPATURE_DATE(String dEPATURE_DATE) {
		DEPATURE_DATE = dEPATURE_DATE;
	}
	public String getDEPATURE_AIRPOT() {
		return DEPATURE_AIRPOT;
	}
	public void setDEPATURE_AIRPOT(String dEPATURE_AIRPOT) {
		DEPATURE_AIRPOT = dEPATURE_AIRPOT;
	}
	
	public String getDEPATURE_TIME() {
		return DEPATURE_TIME;
	}
	public void setDEPATURE_TIME(String dEPATURE_TIME) {
		DEPATURE_TIME = dEPATURE_TIME;
	}
	public String getARRIVAL_TIME() {
		return ARRIVAL_TIME;
	}
	public void setARRIVAL_TIME(String aRRIVAL_TIME) {
		ARRIVAL_TIME = aRRIVAL_TIME;
	}
	public String getSOURCE() {
		return SOURCE;
	}
	public void setSOURCE(String sOURCE) {
		SOURCE = sOURCE;
	}
	
	public int getFLIGHT_ID() {
		return FLIGHT_ID;
	}
	public void setFLIGHT_ID(int fLIGHT_ID) {
		FLIGHT_ID = fLIGHT_ID;
	}
	
	public int getSEAT_ID() {
		return SEAT_ID;
	}
	public void setSEAT_ID(int sEAT_ID) {
		SEAT_ID = sEAT_ID;
	}
	public static String getCsvFile() {
		return csvFile;
	}
	public static void setCsvFile(String csvFile) {
		Flight.csvFile = csvFile;
	}

	
	
		public static void ClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tFLIGHT AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}
		
		public String toString() {
			String str = null;
			
			str = this.FLIGHT_ID
					+ "," + this.SEAT_ID
					+ "," + this.FLIGHT_NUMBER
					+ "," + this.DEPATURE_DATE
					+ "," + this.DEPATURE_AIRPOT
					+ "," + this.DEPATURE_DATE
					+ "," + this.DEPATURE_TIME
					+ "," + this.ARRIVAL_TIME
					+ "," + this.SOURCE;
			
			return str;
		}
	

}
