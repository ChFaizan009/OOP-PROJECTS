package com.uog.Airline;

public class Address {
    
	
	
	private String STREET;
    private String CITY;
    public static String csvFile = "D:\\OOP Projects\\TimeTableFiles\\Address.csv";
    
    
    
    public String getSTREET() {
		return STREET;
	}
	public void setSTREET(String sTREET) {
		STREET = sTREET;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	
	
	
	@Override
	public String toString() {
		
		return "Address [STREET=" + STREET + ", CITY=" + CITY + "]";
	}

    
    
}
