package edu.uog.timetable;

import edu.uog.campus.Room;
import edu.uog.timetable.Semster;
import edu.uog.teacher.TeacherCourse;

public class TimeTable {

	public static String csvFile="D:\\TimeTable.csv";
	
	
	private int TIMETABLE_ID;
	private Semster SEMSTER_ID;
	private TeacherCourse TEACHERCOURSE_ID;
	private TimeSlot TIMESLOT_ID;
	private Room ROOM_ID;

	private Semster SEMESTER_ID;
	
	public String toString()
	{
		String str= null;
		str=this.TIMETABLE_ID
				+" ,"+ this.SEMESTER_ID.getSEMSTER_ID()
				+" ,"+ this.TEACHERCOURSE_ID.getTEACHER_ID()
		        +" ,"+ this.TIMESLOT_ID.getTIMESLOT_ID()
                +" ,"+ this.ROOM_ID.getROOM_ID();
		return str;

	}	
	
	
	
	
	public int getTIMETABLE_ID() {
		return TIMETABLE_ID;
	}
	public void setTIMETABLE_ID(int tIMETABLE_ID) {
		TIMETABLE_ID = tIMETABLE_ID;
	}
	public TeacherCourse getTEACHERCOURSE_ID() {
		return TEACHERCOURSE_ID;
	}
	public void setTEACHERCOURSE_ID(TeacherCourse tEACHERCOURSE_ID) {
		TEACHERCOURSE_ID = tEACHERCOURSE_ID;
	}
	public TimeSlot getTIMESLOT_ID() {
		return TIMESLOT_ID;
	}
	public void setTIMESLOT_ID(TimeSlot tIMESLOT_ID) {
		TIMESLOT_ID = tIMESLOT_ID;
	}
	public Room getROOM_ID() {
		return ROOM_ID;
	}
	public void setROOM_ID(Room rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}
	public Semster getSEMESTER_ID() {
		return SEMESTER_ID;
	}

	public void setSEMESTER_ID(Semster sEMESTER_ID) {
		SEMESTER_ID = sEMESTER_ID;
	}




	public Semster getSEMSTER_ID() {
		return SEMSTER_ID;
	}




	public void setSEMSTER_ID(Semster sEMSTER_ID) {
		SEMSTER_ID = sEMSTER_ID;
	}
	
	
	
}
