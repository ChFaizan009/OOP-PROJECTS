package com.uog;

public class TimeSlot {
	
		private int TIMESLOT_ID;
		private String	WEEKDAY_ID;
		private String	TIMESLOT_START;
		private String	TIMESLOT_END;
		
		
		public TimeSlot(int tIMESLOT_ID, String wEEKDAY_ID, String tIMESLOT_START, String tIMESLOT_END) {
			super();
			TIMESLOT_ID = tIMESLOT_ID;
			WEEKDAY_ID = wEEKDAY_ID;
			TIMESLOT_START = tIMESLOT_START;
			TIMESLOT_END = tIMESLOT_END;
		}
		public int getTIMESLOT_ID() {
			return TIMESLOT_ID;
		}
		public void setTIMESLOT_ID(int tIMESLOT_ID) {
			TIMESLOT_ID = tIMESLOT_ID;
		}
		public String getWEEKDAY_ID() {
			return WEEKDAY_ID;
		}
		public void setWEEKDAY_ID(String wEEKDAY_ID) {
			WEEKDAY_ID = wEEKDAY_ID;
		}
		public String getTIMESLOT_START() {
			return TIMESLOT_START;
		}
		public void setTIMESLOT_START(String tIMESLOT_START) {
			TIMESLOT_START = tIMESLOT_START;
		}
		public String getTIMESLOT_END() {
			return TIMESLOT_END;
		}
		public void setTIMESLOT_END(String tIMESLOT_END) {
			TIMESLOT_END = tIMESLOT_END;
		}
		
}
		