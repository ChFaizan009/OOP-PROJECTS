package com.uog.Flight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@SuppressWarnings("unused")
public class FlightData {

	@SuppressWarnings("resource")
	public static List<Flight> showALLData()  {
		List<Flight> flights = new ArrayList<Flight>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Flight.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Flight flight = new Flight();
				
				
				String[] flightRow = line.split(",");
				flight.setFLIGHT_ID(Integer.parseInt(flightRow[0]));
				flight.setSEAT_ID(Integer.parseInt(flightRow[1]));
				flight.setFLIGHT_NUMBER(flightRow[2]);
				flight.setDEPATURE_DATE(flightRow[3]);
				flight.setDEPATURE_AIRPOT(flightRow[4]);
				flight.setDEPATURE_TIME(flightRow[5]);
				flight.setARRIVAL_TIME(flightRow[6]);
				flight.setSOURCE(flightRow[7]);
				
					flights.add(flight);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flights;
	}

	@SuppressWarnings("resource")
	public static Flight findOneByOneDta(int Flight_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Flight.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Flight flight = new Flight();
				
				String[] flightRow = line.split(",");
				
				if (Integer.parseInt(flightRow[0]) == Flight_ID) {
					flight.setFLIGHT_ID(Integer.parseInt(flightRow[0]));
					flight.setSEAT_ID(Integer.parseInt(flightRow[1]));
					flight.setFLIGHT_NUMBER(flightRow[2]);
					flight.setDEPATURE_DATE(flightRow[3]);
					flight.setDEPATURE_AIRPOT(flightRow[4]);
					flight.setDEPATURE_TIME(flightRow[5]);
					flight.setARRIVAL_TIME(flightRow[6]);
					flight.setSOURCE(flightRow[7]);
					
					
					return flight;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	

	@SuppressWarnings("resource")
	public static List<Flight> SearchFlightData(String search)  {
		List<Flight> flights = new ArrayList<Flight>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Flight.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Flight flight = new Flight();
				
				String[] flightRow = line.split(",");
				
				if (flightRow[1].contains(search) == true) {
					flight.setFLIGHT_ID(Integer.parseInt(flightRow[0]));
					flight.setSEAT_ID(Integer.parseInt(flightRow[1]));
					flight.setFLIGHT_NUMBER(flightRow[2]);
					flight.setDEPATURE_DATE(flightRow[3]);
					flight.setDEPATURE_AIRPOT(flightRow[4]);
					flight.setDEPATURE_TIME(flightRow[5]);
					flight.setARRIVAL_TIME(flightRow[6]);
					flight.setSOURCE(flightRow[7]);
					
					flights.add(flight);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flights;
	}

	@SuppressWarnings("resource")
	public static Flight SaveFlightData(Flight flight) {
		FileWriter filewriter;

		List<Flight> flights = showALLData();

		try {
			filewriter = new FileWriter(Flight.csvFile);

			for (int i=0; i<flights.size(); i++) {
				filewriter.append(flights.get(i).toString());
				filewriter.append("\n");
			}
			if (flights.size()>0)
				flight.setFLIGHT_ID(flights.get(flights.size()-1).getFLIGHT_ID()+1);
			else
				flight.setFLIGHT_ID(1);
			filewriter.append(flight.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
e.printStackTrace();
		}
		
		
		
		return flight;
	}
	@SuppressWarnings("resource")
	public static Flight deleteOneRowDta(int Flight_ID)  {
		FileWriter filewriter;

		List<Flight> Flights = showALLData();
		Flight Flight = findOneByOneDta(Flight_ID);

		try {
			filewriter = new FileWriter(Flight.csvFile);

			for (int i=0; i<Flights.size(); i++) {
				if (Flights.get(i).getFLIGHT_ID() != Flight_ID) {
					filewriter.append(Flights.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Flight;
	}
	
	
	
	
public static String DeleteAllData() {
		
		FileWriter wr;
		List<Flight>flights=showALLData();
		try {
			wr=new FileWriter(Flight.csvFile);
			for (int i=0;i<flights.size();i++) {
				flights.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("Flights Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of Flights ";
	}
	
}
