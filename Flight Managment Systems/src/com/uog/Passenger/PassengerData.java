package com.uog.Passenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PassengerData 
{

	@SuppressWarnings("resource")
	public static List<Passenger> findAll()  {
		List<Passenger> Passengers = new ArrayList<Passenger>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Passenger.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Passenger Passenger = new Passenger();
				
				String[] PassengerRow = line.split(",");
				
				Passenger.setUSER_NAME(UserData.findOne(Integer.parseInt(PassengerRow[0])));
				Passenger.setAddress(UserData.findOne(Integer.parseInt(PassengerRow[0])));
				
				Passenger.setTelephoneNumber(PassengerRow[2]);
				
				Passengers.add(Passenger);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Passengers;
	}
	@SuppressWarnings("resource")
	public static Passenger findOne(int Passenger_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Passenger.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Passenger Passenger = new Passenger();
				
				String[] PassengerRow = line.split(",");
				
				if (Integer.parseInt(PassengerRow[0]) == Passenger_ID) {
					Passenger.setUSER_NAME(UserData.findOne(Integer.parseInt(PassengerRow[0])));
					Passenger.setAddress(UserData.findOne(Integer.parseInt(PassengerRow[0])));
					
					Passenger.setTelephoneNumber(PassengerRow[2]);
					
					return Passenger;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static Passenger deleteOne(int Passenger_ID)  {
		FileWriter filewriter;

		List<Passenger> Passengers = findAll();
		Passenger Passenger = findOne(Passenger_ID);

		try {
			filewriter = new FileWriter(Passenger.csvFile);

			for (int i=0; i<Passengers.size(); i++) {
				if (Passengers.get(i).getPassenger_ID() != Passenger_ID) {
					filewriter.append(Passengers.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Passenger;
	}

	@SuppressWarnings("resource")
	public static List<Passenger> search(String search)  {
		List<Passenger> Passengers = new ArrayList<Passenger>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Passenger.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Passenger Passenger = new Passenger();
				
				String[] PassengerRow = line.split(",");
				
				if (PassengerRow[1].contains(search) == true) {
					Passenger.setUSER_NAME(UserData.findOne(Integer.parseInt(PassengerRow[0])));
					Passenger.setAddress(UserData.findOne(Integer.parseInt(PassengerRow[0])));
					
					Passenger.setTelephoneNumber(PassengerRow[2]);
					Passengers.add(Passenger);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Passengers;
	}

	@SuppressWarnings("resource")
	public static Passenger deleteOne1(int Passenger_ID)  {
		FileWriter filewriter;

		List<Passenger> Passengers = findAll();
	Passenger Passenger = findOne(Passenger_ID);

		try {
			filewriter = new FileWriter(Passenger.csvFile);

			for (int i=0; i<Passengers.size(); i++) {
				if (Passengers.get(i).getPassenger_ID() != Passenger_ID) {
					filewriter.append(Passengers.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Passenger;
	}
	
	
	@SuppressWarnings("resource")
	public static Passenger Save(Passenger Passenger) {
		FileWriter filewriter;

		List<Passenger> Passengers = findAll();

		try {
			filewriter = new FileWriter(Passenger.csvFile);

			for (int i=0; i<Passengers.size(); i++) {
				filewriter.append(Passengers.get(i).toString());
				filewriter.append("\n");
			}
			if (Passengers.size()>0)
				Passenger.setPassenger_ID(Passengers.get(Passengers.size()-1).getPassenger_ID()+1);
			else
				Passenger.setPassenger_ID(1);
			filewriter.append(Passenger.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block

			
			e.printStackTrace();
		}
		
		
		
		return Passenger;
	}
	
	
	
public static String DeleteAll() {
		
		FileWriter wr;
		List<Passenger>Passengers=findAll();
		try {
			wr=new FileWriter(Passenger.csvFile);
			for (int i=0;i<Passengers.size();i++) {
				Passengers.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("Passengers Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of Passengers";
	}
public static List<Passenger> SearchPassengerData(String search) {
	// TODO Auto-generated method stub
	return null;
}
}
