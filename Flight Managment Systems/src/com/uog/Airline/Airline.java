
 
package com.uog.Airline;

public class Airline {
    private String AIRLINE_ID;   
    private String AIRLINE_NAME;    
    
   

    
    public Airline(String airlineID, String name) {
        this.setAIRLINE_ID(airlineID);
        this.setAIRLINE_NAME(name);
        
    }

    public void setAIRLINE_ID(String airlineID) {
        
        if(airlineID.matches("[a-zA-Z]+$") && airlineID.length()==2){
            this.AIRLINE_ID = airlineID.toUpperCase();
        }
        else{
            System.out.println("Invalid Airline ID");
        }
        
    }

    public void setAIRLINE_NAME(String airlineName) {
     
        if (AIRLINE_NAME.matches("[a-zA-Z ]+$")) {
            this.AIRLINE_NAME = airlineName;
        }
        else{
            System.out.println("Invalid Airline Name");
        }
        
    }

	public String getAIRLINE_ID() {
		return AIRLINE_ID;
	}

	

	public String getAIRLINE_NAME() {
		return AIRLINE_NAME;
	}


    
    
    
    
}
