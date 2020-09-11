package TestClasses;

import Classes.FlightSection;
import Classes.SeatClass;

public class FlightSectionTest {

    public static void main(String[] args) {
        
       
       FlightSection flightSection1 = new FlightSection();
        
        
        
        flightSection1.setSeatClass(SeatClass.ECONOMY);
        System.out.println(flightSection1);
        
        
       FlightSection flightSection2 = new FlightSection(SeatClass.ECONOMY);
       System.out.println(flightSection2);
       
      
        System.out.println(flightSection2.getSeatClass());
       

    }
    
}
