package com.uog.Airline;

public class Airpot {

	
   private String AIRPOT_NAME;
   private String AIRPOT_CODE;
   private String AIRPOT_LOCATION;

   
   
   
   
   public String getAIRPOT_NAME() {
	return AIRPOT_NAME;
}
public void setAIRPOT_NAME(String aIRPOT_NAME) {
	AIRPOT_NAME = aIRPOT_NAME;
}
public String getAIRPOT_CODE() {
	return AIRPOT_CODE;
}
public void setAIRPOT_CODE(String aIRPOT_CODE) {
	AIRPOT_CODE = aIRPOT_CODE;
}
public String getAIRPOT_LOCATION() {
	return AIRPOT_LOCATION;
}
public void setAIRPOT_LOCATION(String aIRPOT_LOCATION) {
	AIRPOT_LOCATION = aIRPOT_LOCATION;
}


  @Override
public String toString() {
	return "Airpot [AIRPOT_NAME=" + AIRPOT_NAME + ", AIRPOT_CODE=" + AIRPOT_CODE + ", AIRPOT_LOCATION="
			+ AIRPOT_LOCATION + "]";
}
   
   
    

}
