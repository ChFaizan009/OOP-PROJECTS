package com.uog.Airline;




public class AirlineTest {

    public static void main(String[] args) {
        
        
        Airline airline1 = new Airline("12", "Pakistan Airline");
        
        
        airline1.setAIRLINE_ID("2");
        airline1.setAIRLINE_NAME("Pakistan Airlines");
        
        System.out.println(airline1);
        
        
        Airline airline2 = new Airline("M2", "Malasia Airlines");
        System.out.println("\n"+airline2);
        
        
        System.out.println(airline2.getAIRLINE_ID());
        System.out.println(airline2.getAIRLINE_NAME());
    }
    
}
