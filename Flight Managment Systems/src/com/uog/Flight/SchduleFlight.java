package com.uog.Flight;

public class SchduleFlight


{

	private Flight FLIGHT_ID;
    private	int Available_SEAT;
    private String Schdule;
    public static String csvFile = "D:\\OOP Projects\\TimeTableFiles\\Flight.csv";
    
    
    
    public Flight getFLIGHT_ID() {
		return FLIGHT_ID;
	}
	public void setFLIGHT_ID(Flight fLIGHT_ID) {
		FLIGHT_ID = fLIGHT_ID;
	}
	public int getAvailable_SEAT() {
		return Available_SEAT;
	}
	public void setAvailable_SEAT(int available_SEAT) {
		Available_SEAT = available_SEAT;
	}
	public String getSchdule() {
		return Schdule;
	}
	public void setSchdule(String schdule) {
		Schdule = schdule;
	}
	
	
	
	@Override
	public String toString() {
		return "SchduleFlight [FLIGHT_ID=" + FLIGHT_ID + ", Available_SEAT=" + Available_SEAT + ", Schdule=" + Schdule
				+ "]";
	}
    
    
	
    
}
