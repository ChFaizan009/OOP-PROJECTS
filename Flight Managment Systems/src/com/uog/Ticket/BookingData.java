package com.uog.Ticket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uog.Flight.FlightData;
import com.uog.Passenger.UserData;

public class BookingData
{

	@SuppressWarnings("resource")
	public static List<Booking> showALLData()  {
		List<Booking> Bookings = new ArrayList<Booking>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Booking.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Booking Booking = new Booking();
				
				
				String[] BookingRow = line.split(",");
				Booking.setBOOKING_ID(Integer.parseInt(BookingRow[0]));
				Booking.setUSER_ID(UserData.findOne(Integer.parseInt(BookingRow[1])));
				Booking.setBOOKING_DATE(BookingRow[2]);
				Booking.setTICKET_PRICE(TicketData.findOneByOneDta(Integer.parseInt(BookingRow[3])));
				Booking.setFLIGHT_ID(FlightData.findOneByOneDta(Integer.parseInt(BookingRow[4])));
				
					Bookings.add(Booking);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Bookings;
	}

	@SuppressWarnings("resource")
	public static Booking findOneByOneDta(int Booking_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Booking.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Booking Booking = new Booking();
				
				String[] BookingRow = line.split(",");
				
				if (Integer.parseInt(BookingRow[0]) == Booking_ID) {
					Booking.setBOOKING_ID(Integer.parseInt(BookingRow[0]));
					Booking.setUSER_ID(UserData.findOne(Integer.parseInt(BookingRow[1])));
					Booking.setBOOKING_DATE(BookingRow[2]);
					Booking.setTICKET_PRICE(TicketData.findOneByOneDta(Integer.parseInt(BookingRow[3])));
					Booking.setFLIGHT_ID(FlightData.findOneByOneDta(Integer.parseInt(BookingRow[4])));
						
					
					return Booking;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	

	@SuppressWarnings("resource")
	public static List<Booking> SearchBookingData(String search)  {
		List<Booking> Bookings = new ArrayList<Booking>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Booking.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Booking Booking = new Booking();
				
				String[] BookingRow = line.split(",");
				
				if (BookingRow[1].contains(search) == true) {
					Booking.setBOOKING_ID(Integer.parseInt(BookingRow[0]));
					Booking.setUSER_ID(UserData.findOne(Integer.parseInt(BookingRow[1])));
					Booking.setBOOKING_DATE(BookingRow[2]);
					Booking.setTICKET_PRICE(TicketData.findOneByOneDta(Integer.parseInt(BookingRow[3])));
					Booking.setFLIGHT_ID(FlightData.findOneByOneDta(Integer.parseInt(BookingRow[4])));
					
					Bookings.add(Booking);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Bookings;
	}

	@SuppressWarnings("resource")
	public static Booking SaveBookingData(Booking Booking) {
		FileWriter filewriter;

		List<Booking> Bookings = showALLData();

		try {
			filewriter = new FileWriter(Booking.csvFile);

			for (int i=0; i<Bookings.size(); i++) {
				filewriter.append(Bookings.get(i).toString());
				filewriter.append("\n");
			}
			if (Bookings.size()>0)
				Booking.setBOOKING_ID(Bookings.get(Bookings.size()-1).getBOOKING_ID()+1);
			else
				Booking.setBOOKING_ID(1);
			filewriter.append(Booking.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
e.printStackTrace();
		}
		
		
		
		return Booking;
	}
	@SuppressWarnings("resource")
	public static Booking deleteOneRowDta(int Booking_ID)  {
		FileWriter filewriter;

		List<Booking> Bookings = showALLData();
		Booking Booking = findOneByOneDta(Booking_ID);

		try {
			filewriter = new FileWriter(Booking.csvFile);

			for (int i=0; i<Bookings.size(); i++) {
				if (Bookings.get(i).getBOOKING_ID() != Booking_ID) {
					filewriter.append(Bookings.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Booking;
	}
	
	
	
	
public static String DeleteAllData() {
		
		FileWriter wr;
		List<Booking>Bookings=showALLData();
		try {
			wr=new FileWriter(Booking.csvFile);
			for (int i=0;i<Bookings.size();i++) {
				Bookings.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("Bookings Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of Bookings ";
	}
	
	
}
