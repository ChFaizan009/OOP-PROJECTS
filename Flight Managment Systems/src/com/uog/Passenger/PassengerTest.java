package com.uog.Passenger;

import com.uog.Airline.Address;

public class PassengerTest {
    public static void main(String[] args) {
        
       
        Passenger passenger1 = new Passenger();
        
        User name1 = new User();
        Address address1 = new Address();
        
        passenger1.setUSER_NAME(name1);
        //passenger1.setAddress(address1);
        passenger1.setTelephoneNumber("011 283 1716");
        System.out.println(passenger1);
        
        User name2 = new User();
        Address address2 = new Address();
 
        Passenger passenger2 = new Passenger(name2, address2, "071 683 6774");
        System.out.println(passenger2);
        
       
        System.out.println(passenger2.getUSER_NAME());
        System.out.println(passenger2.getAddress());
        System.out.println(passenger2.getTelephoneNumber());
    }
    
}
