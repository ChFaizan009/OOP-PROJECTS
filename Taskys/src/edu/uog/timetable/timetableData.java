package edu.uog.timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.campus.roomData;
import edu.uog.course.courseData;
import edu.uog.teacher.teachercourseData;
import edu.uog.timetable.SemsterData;

public class timetableData 

{
	public static List<TimeTable> FindAll(){
		List<TimeTable> TimeTables= new ArrayList<TimeTable>();
		String line ;
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(TimeTable.csvFile));
			
			while((line=bufferedReader.readLine()) != null) {
				TimeTable TimeTable = new TimeTable();
				String[] rowtable = line.split(",");
				TimeTable.setTIMETABLE_ID(Integer.parseInt(rowtable[0]));
				TimeTable.setSEMESTER_ID(SemsterData.findOne(Integer.parseInt(rowtable[1])));
				TimeTable.setTEACHERCOURSE_ID(teachercourseData.findOne(Integer.parseInt(rowtable[2])));
				TimeTable.setTIMESLOT_ID(timeslotData.findOne(Integer.parseInt(rowtable[3])));
				TimeTable.setROOM_ID(roomData.findOne(Integer.parseInt(rowtable[4])));
				
				
				TimeTables.add(TimeTable);
			}
			
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return TimeTables;
	}
	
	
	
	public static TimeTable FindOne(int TimeTable_ID){
	
		List<TimeTable> studentsTimeTables = new ArrayList<TimeTable>();	
		String line;
		try {
		@SuppressWarnings("resource")
		BufferedReader bufferreader = new BufferedReader(new FileReader(TimeTable.csvFile));
		
		while((line=bufferreader.readLine())!=null) {
			TimeTable TimeTable = new TimeTable();
			String[] rowtable = line.split(",");
			
			if(Integer.parseInt(rowtable[0]) == TimeTable_ID ) 
			
			{
				TimeTable.setTIMETABLE_ID(Integer.parseInt(rowtable[0]));
				TimeTable.setSEMESTER_ID(SemsterData.findOne(Integer.parseInt(rowtable[1])));
				TimeTable.setTEACHERCOURSE_ID(teachercourseData.findOne(Integer.parseInt(rowtable[2])));
				TimeTable.setTIMESLOT_ID(timeslotData.findOne(Integer.parseInt(rowtable[3])));
				TimeTable.setROOM_ID(roomData.findOne(Integer.parseInt(rowtable[4])));
				
			
			
			
			studentsTimeTables.add(TimeTable);
			
			return TimeTable;
			}
			
			
		}
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return null;
	
	
}
	
	

	public static List<TimeTable> Search(String search){
		List<TimeTable> sCourses= new ArrayList<TimeTable>();
		String line ;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(TimeTable.csvFile));
			
			while((line=bufferedReader.readLine())!=null) {
				TimeTable TimeTable = new TimeTable();
				String[] rowtable = line.split(",");
				TimeTable.setTIMETABLE_ID(Integer.parseInt(rowtable[0]));
				TimeTable.setSEMESTER_ID(SemsterData.findOne(Integer.parseInt(rowtable[1])));
				TimeTable.setTEACHERCOURSE_ID(teachercourseData.findOne(Integer.parseInt(rowtable[2])));
				TimeTable.setTIMESLOT_ID(timeslotData.findOne(Integer.parseInt(rowtable[3])));
				TimeTable.setROOM_ID(roomData.findOne(Integer.parseInt(rowtable[4])));
				
			
				
				
				sCourses.add(TimeTable);
				}
				//return rooms;
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return sCourses;
	}

	public static TimeTable Save(TimeTable student) {
		
		FileWriter fr;
		List<TimeTable> studentsTimeTables = FindAll();
		
		try {
			fr = new FileWriter(TimeTable.csvFile);
			
			for(int i=0;i<studentsTimeTables.size();i++) {
				fr.append(studentsTimeTables.get(i).toString());
				fr.append("\n");
			}
			
			
			if(studentsTimeTables.size()>0) {
				student.setTIMETABLE_ID(studentsTimeTables.get(studentsTimeTables.size()-1).getTIMETABLE_ID()+1);
			}
			else {
				student.setTIMETABLE_ID(1);
			}
			studentsTimeTables.add(student);
				fr.append(student.toString());
				fr.append("\n");
				fr.flush();
				fr.close();
			
			
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return student;
	}


	public static String DeleteAll() {
		
		FileWriter fr;
		List<TimeTable> TimeTables = FindAll();
		try {
			fr = new FileWriter(TimeTable.csvFile);
			
			for(int i=0;i<TimeTables.size();i++) {
				TimeTables.remove(i);
			}
				fr.flush();
				fr.close();
			
	} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Students TimeTable Data Removed Successfully";
		
	}
	
	@SuppressWarnings({ "resource", "static-access" })
	public static TimeTable deleteOne(int TimeTable_ID)  {
		FileWriter filewriter;

		List<TimeTable> TimeTables = FindAll();
		TimeTable TimeTable = FindOne(TimeTable_ID);

		try {
			filewriter = new FileWriter(TimeTable.csvFile);

			for (int i=0; i<TimeTables.size(); i++) {
				if (TimeTables.get(i).getTIMETABLE_ID() != TimeTable_ID) {
					filewriter.append(TimeTables.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TimeTable;
	}
		
	}

