
 
package admin;

public class Airline {
    private String airlineID;   
    private String airlineName;    
    
    public Airline() {
        this.airlineID = "";
        this.airlineName = "";
    }

    
    public Airline(String airlineID, String name) {
        this.setAirlineID(airlineID);
        this.setAirlineName(name);
        
    }

    public void setAirlineID(String airlineID) {
        
        if(airlineID.matches("[a-zA-Z]+$") && airlineID.length()==2){
            this.airlineID = airlineID.toUpperCase();
        }
        else{
            System.out.println("Invalid Airline ID");
        }
        
    }

    public void setAirlineName(String airlineName) {
     
        if (airlineName.matches("[a-zA-Z ]+$")) {
            this.airlineName = airlineName;
        }
        else{
            System.out.println("Invalid Airline Name");
        }
        
    }

    public String getAirlineID() {
        return airlineID; //returns airlineID in capitals
    }

    public String getAirlineName() {
        return airlineName;
    }
    
    @Override
    public String toString() {
        return this.getAirlineID() + "," + this.getAirlineName();
    }
    
    
    
    
    
}
