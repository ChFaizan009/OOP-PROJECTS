package com.uog.Ticket;

import com.uog.Flight.Flight;
import com.uog.Passenger.User;
import com.uog.Passenger.Reservation;

public class Booking
{

	private int BOOKING_ID;
	private User USER_ID;
	private String BOOKING_DATE;
	private Ticket TICKET_PRICE;
	private Flight FLIGHT_ID;
	private Reservation NUMBEROFPASSENGERS;
	
	public static String csvFile = "D:\\OOP Projects\\TimeTableFiles\\Booking.csv";
	
	
	public int getBOOKING_ID() {
		return BOOKING_ID;
	}
	public void setBOOKING_ID(int bOOKING_ID) {
		BOOKING_ID = bOOKING_ID;
	}
	public User getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(User uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getBOOKING_DATE() {
		return BOOKING_DATE;
	}
	public void setBOOKING_DATE(String bOOKING_DATE) {
		BOOKING_DATE = bOOKING_DATE;
	}
	public Ticket getTICKET_PRICE() {
		return TICKET_PRICE;
	}
	public void setTICKET_PRICE(Ticket tICKET_PRICE) {
		TICKET_PRICE = tICKET_PRICE;
	}
	public Flight getFLIGHT_ID() {
		return FLIGHT_ID;
	}
	public void setFLIGHT_ID(Flight fLIGHT_ID) {
		FLIGHT_ID = fLIGHT_ID;
	}
	public Reservation getNUMBEROFPASSENGERS() {
		return NUMBEROFPASSENGERS;
	}
	public void setNUMBEROFPASSENGERS(Reservation nUMBEROFPASSENGERS) {
		NUMBEROFPASSENGERS = nUMBEROFPASSENGERS;
	}
	
	
	
	@Override
	public String toString() {
		return "Booking [BOOKING_ID=" + BOOKING_ID + ", USER_ID=" + USER_ID + ", BOOKING_DATE=" + BOOKING_DATE
				+ ", TICKET_PRICE=" + TICKET_PRICE + ", FLIGHT_ID=" + FLIGHT_ID + ", NUMBEROFPASSENGERS="
				+ NUMBEROFPASSENGERS + "]";
	}
	
	
	public static void ClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tBOOKING AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}	
	
	
}
