package edu.uog.timetable;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.campus.Room;


public class weekdayData {


	@SuppressWarnings("resource")
	public static List<WeekDay> findAll()  {
		List<WeekDay> WeekDays = new ArrayList<WeekDay>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(WeekDay.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				WeekDay WeekDay = new WeekDay();
				
				
				String[] WeekDayRow = line.split(",");
				
				WeekDay.setWEEKDAY_ID(Integer.parseInt(WeekDayRow[0]));
				WeekDay.setWEEKDAY_NAME(WeekDayRow[1]);
				
				WeekDays.add(WeekDay);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return WeekDays;
	}

	@SuppressWarnings("resource")
	public static WeekDay findOne(int WeekDay_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(WeekDay.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				WeekDay WeekDay = new WeekDay();
				
				
				String[] WeekDayRow = line.split(",");
				
				if (Integer.parseInt(WeekDayRow[0]) == WeekDay_ID) {
					WeekDay.setWEEKDAY_ID(Integer.parseInt(WeekDayRow[0]));
					WeekDay.setWEEKDAY_NAME(WeekDayRow[1]);
					
					return WeekDay;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static WeekDay findByCode(String WeekDay_CODE)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(WeekDay.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				WeekDay WeekDay = new WeekDay();
				
				
				String[] WeekDayRow = line.split(",");
				
				if (WeekDayRow[1].contains(WeekDay_CODE) == true) {
					WeekDay.setWEEKDAY_ID(Integer.parseInt(WeekDayRow[0]));
					WeekDay.setWEEKDAY_NAME(WeekDayRow[1]);
					
										
					return WeekDay;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static List<WeekDay> search(String search)  {
		List<WeekDay> WeekDays = new ArrayList<WeekDay>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(WeekDay.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				WeekDay WeekDay = new WeekDay();
				
				String[] WeekDayRow = line.split(",");
				
				if (WeekDayRow[1].contains(search) == true) {
					WeekDay.setWEEKDAY_ID(Integer.parseInt(WeekDayRow[0]));
					WeekDay.setWEEKDAY_NAME(WeekDayRow[1]);
						
					WeekDays.add(WeekDay);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return WeekDays;
	}

	@SuppressWarnings("resource")
	public static WeekDay Save(WeekDay WeekDay) {
		FileWriter filewriter;

		List<WeekDay> WeekDays = findAll();

		try {
			filewriter = new FileWriter(WeekDay.csvFile);

			for (int i=0; i<WeekDays.size(); i++) {
				filewriter.append(WeekDays.get(i).toString());
				filewriter.append("\n");
			}
			if (WeekDays.size()>0)
				WeekDay.setWEEKDAY_ID(WeekDays.get(WeekDays.size()-1).getWEEKDAY_ID()+1);
			else
				WeekDay.setWEEKDAY_ID(1);
			filewriter.append(WeekDay.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
e.printStackTrace();
		}
		
		
		
		return WeekDay;
	}
	@SuppressWarnings("resource")
	public static WeekDay deleteOne(int WeekDay_ID)  {
		FileWriter filewriter;

		List<WeekDay> WeekDays = findAll();
		WeekDay WeekDay = findOne(WeekDay_ID);

		try {
			filewriter = new FileWriter(WeekDay.csvFile);

			for (int i=0; i<WeekDays.size(); i++) {
				if (WeekDays.get(i).getWEEKDAY_ID() != WeekDay_ID) {
					filewriter.append(WeekDays.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return WeekDay;
	}
	
public static String DeleteAll() {
		
		FileWriter wr;
		List<WeekDay>WeekDays=findAll();
		try {
			wr=new FileWriter(WeekDay.csvFile);
			for (int i=0;i<WeekDays.size();i++) {
				WeekDays.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("WeekDays Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of WeekDay";
	}
	
	
	
}


