package com.uog.Passenger;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import com.uog.Flight.Flight;


public class Reservation {
    private int RESERVATION_NUMBER;
    private int NUMBEROFPASSENGERS;
    private Passenger PASSENGER; 
    private Flight FLIGHT_NUMBER;
    private Flight DEPATUREDATE;
    

    public Reservation(){}


	public int getRESERVATION_NUMBER() {
		return RESERVATION_NUMBER;
	}


	public void setRESERVATION_NUMBER(int rESERVATION_NUMBER) {
		RESERVATION_NUMBER = rESERVATION_NUMBER;
	}


	public int getNUMBEROFPASSENGERS() {
		return NUMBEROFPASSENGERS;
	}


	public void setNUMBEROFPASSENGERS(int nUMBEROFPASSENGERS) {
		NUMBEROFPASSENGERS = nUMBEROFPASSENGERS;
	}


	public Passenger getPASSENGER() {
		return PASSENGER;
	}


	public void setPASSENGER(Passenger pASSENGER) {
		PASSENGER = pASSENGER;
	}


	public Flight getFLIGHT_NUMBER() {
		return FLIGHT_NUMBER;
	}


	public void setFLIGHT_NUMBER(Flight fLIGHT_NUMBER) {
		FLIGHT_NUMBER = fLIGHT_NUMBER;
	}


	public Flight getDEPATUREDATE() {
		return DEPATUREDATE;
	}


	public void setDEPATUREDATE(Flight dEPATUREDATE) {
		DEPATUREDATE = dEPATUREDATE;
	}


	public Reservation(int rESERVATION_NUMBER, int nUMBEROFPASSENGERS, Passenger pASSENGER, Flight fLIGHT_NUMBER,
			Flight dEPATUREDATE) {
		super();
		RESERVATION_NUMBER = rESERVATION_NUMBER;
		NUMBEROFPASSENGERS = nUMBEROFPASSENGERS;
		PASSENGER = pASSENGER;
		FLIGHT_NUMBER = fLIGHT_NUMBER;
		DEPATUREDATE = dEPATUREDATE;
	}


	@Override
	public String toString() {
		return "Reservation [RESERVATION_NUMBER=" + RESERVATION_NUMBER + ", NUMBEROFPASSENGERS=" + NUMBEROFPASSENGERS
				+ ", PASSENGER=" + PASSENGER + ", FLIGHT_NUMBER=" + FLIGHT_NUMBER + ", DEPATUREDATE=" + DEPATUREDATE
				+ "]";
	}
    
    

        
    
}
