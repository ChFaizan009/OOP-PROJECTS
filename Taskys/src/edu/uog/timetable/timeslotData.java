package edu.uog.timetable;






import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class timeslotData {


	@SuppressWarnings("resource")
	public static List<TimeSlot> findAll()  {
		List<TimeSlot> TimeSlots = new ArrayList<TimeSlot>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TimeSlot.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				TimeSlot TimeSlot = new TimeSlot();
				
				String[] TimeSlotRow = line.split(",");
				
				TimeSlot.setTIMESLOT_ID(Integer.parseInt(TimeSlotRow[0]));
				TimeSlot.setTIMESLOT_START(TimeSlotRow[2]);
				TimeSlot.setTIMESLOT_END(TimeSlotRow[3]);
				
				
				TimeSlots.add(TimeSlot);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TimeSlots;
	}
	@SuppressWarnings("resource")
	public static TimeSlot findOne(int TimeSlot_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TimeSlot.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				TimeSlot TimeSlot = new TimeSlot();
				
				String[] TimeSlotRow = line.split(",");
				
				if (Integer.parseInt(TimeSlotRow[0]) == TimeSlot_ID) {
					TimeSlot.setTIMESLOT_ID(Integer.parseInt(TimeSlotRow[0]));
					TimeSlot.setTIMESLOT_START(TimeSlotRow[2]);
					TimeSlot.setTIMESLOT_END(TimeSlotRow[3]);
					
					return TimeSlot;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static TimeSlot deleteOne(int TimeSlot_ID)  {
		FileWriter filewriter;

		List<TimeSlot> TimeSlots = findAll();
		TimeSlot TimeSlot = findOne(TimeSlot_ID);

		try {
			filewriter = new FileWriter(TimeSlot.csvFile);

			for (int i=0; i<TimeSlots.size(); i++) {
				if (TimeSlots.get(i).getTIMESLOT_ID() != TimeSlot_ID) {
					filewriter.append(TimeSlots.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TimeSlot;
	}

	@SuppressWarnings("resource")
	public static List<TimeSlot> search(String search)  {
		List<TimeSlot> TimeSlots = new ArrayList<TimeSlot>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TimeSlot.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				TimeSlot TimeSlot = new TimeSlot();
				
				String[] TimeSlotRow = line.split(",");
				
				if (TimeSlotRow[1].contains(search) == true) {
					TimeSlot.setTIMESLOT_ID(Integer.parseInt(TimeSlotRow[0]));
					TimeSlot.setTIMESLOT_START(TimeSlotRow[2]);
					TimeSlot.setTIMESLOT_END(TimeSlotRow[3]);
					
					TimeSlots.add(TimeSlot);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TimeSlots;
	}

	@SuppressWarnings("resource")
	public static TimeSlot deleteOne1(int TimeSlot_ID)  {
		FileWriter filewriter;

		List<TimeSlot> TimeSlots = findAll();
	TimeSlot TimeSlot = findOne(TimeSlot_ID);

		try {
			filewriter = new FileWriter(TimeSlot.csvFile);

			for (int i=0; i<TimeSlots.size(); i++) {
				if (TimeSlots.get(i).getTIMESLOT_ID() != TimeSlot_ID) {
					filewriter.append(TimeSlots.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TimeSlot;
	}
	
	
	@SuppressWarnings("resource")
	public static TimeSlot Save(TimeSlot TimeSlot) {
		FileWriter filewriter;

		List<TimeSlot> TimeSlots = findAll();

		try {
			filewriter = new FileWriter(TimeSlot.csvFile);

			for (int i=0; i<TimeSlots.size(); i++) {
				filewriter.append(TimeSlots.get(i).toString());
				filewriter.append("\n");
			}
			if (TimeSlots.size()>0)
				TimeSlot.setTIMESLOT_ID(TimeSlots.get(TimeSlots.size()-1).getTIMESLOT_ID()+1);
			else
				TimeSlot.setTIMESLOT_ID(1);
			filewriter.append(TimeSlot.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block

			
			e.printStackTrace();
		}
		
		
		
		return TimeSlot;
	}
	
public static String DeleteAll() {
		
		FileWriter wr;
		List<TimeSlot>TimeSlots=findAll();
		try {
			wr=new FileWriter(TimeSlot.csvFile);
			for (int i=0;i<TimeSlots.size();i++) {
				TimeSlots.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("TimeSlots Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of TimeSlots";
	}
	
}
