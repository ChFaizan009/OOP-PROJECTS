package com.uog.Passenger;

import com.uog.Airline.Address;

public class Passenger {
    private User USER_NAME;
    private Address ADDRESS;
    private String TELEPHINE_NUMBER;

    public static String csvFile = "D:\\OOP Projects\\TimeTableFiles\\Passenger.csv";
    
    public Passenger() {
        
    	USER_NAME = new User();
    	ADDRESS = new Address();
        this.TELEPHINE_NUMBER = "";
    }

    
    
    public Passenger(User name, Address address, String telephoneNumber) {
        this.USER_NAME = name;
        this.ADDRESS = address;
        this.TELEPHINE_NUMBER = telephoneNumber;
    }

	public User getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(User uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public Address getAddress() {
		return ADDRESS;
	}

	public void setAddress(User user) {
		//this.ADDRESS = user;
	}

	public String getTelephoneNumber() {
		return TELEPHINE_NUMBER;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.TELEPHINE_NUMBER = telephoneNumber;
	}

	
	
	@Override
	public String toString() {
		return "Passenger [USER_NAME=" + USER_NAME + ", address=" + ADDRESS + ", telephoneNumber=" + TELEPHINE_NUMBER
				+ "]";
	}



	public void setAddress1(User findOne) {
		// TODO Auto-generated method stub
		
	}



	public int getPassenger_ID() {
		// TODO Auto-generated method stub
		return 0;
	}



	public void setPassenger_ID(int i) {
		// TODO Auto-generated method stub
		
	}

   
	public static void ClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tPASSENGER AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}    
    
	
}
