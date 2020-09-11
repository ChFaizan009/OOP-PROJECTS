package edu.uog.timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SemsterData
{

	@SuppressWarnings("resource")
	public static List<Semster> findAll()  {
		List<Semster> Semsters = new ArrayList<Semster>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Semster.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Semster Semster = new Semster();
				
				
				String[] SemsterRow = line.split(",");
				
				Semster.setSEMSTER_ID(Integer.parseInt(SemsterRow[0]));
				Semster.setSEMSTER_CODE(SemsterRow[1]);
				Semster.setSEMSTER_NAME(SemsterRow[2]);
				Semster.setSEMSTER_STARTDATE(SemsterRow[3]);
				Semster.setSEMSTER_ENDDATE(SemsterRow[4]);
				Semsters.add(Semster);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Semsters;
	}

	@SuppressWarnings("resource")
	public static Semster findOne(int Semster_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Semster.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Semster Semster = new Semster();
				
				
				String[] SemsterRow = line.split(",");
				
				if (Integer.parseInt(SemsterRow[0]) == Semster_ID) {
					Semster.setSEMSTER_ID(Integer.parseInt(SemsterRow[0]));
					Semster.setSEMSTER_CODE(SemsterRow[1]);
					Semster.setSEMSTER_NAME(SemsterRow[2]);
					Semster.setSEMSTER_STARTDATE(SemsterRow[3]);
					Semster.setSEMSTER_ENDDATE(SemsterRow[4]);
					
					return Semster;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static Semster findByCode(String Semster_CODE)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Semster.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Semster Semster = new Semster();
				
				
				String[] SemsterRow = line.split(",");
				
				if (SemsterRow[1].contains(Semster_CODE) == true) {
					Semster.setSEMSTER_ID(Integer.parseInt(SemsterRow[0]));
					Semster.setSEMSTER_CODE(SemsterRow[1]);
					Semster.setSEMSTER_NAME(SemsterRow[2]);
					Semster.setSEMSTER_STARTDATE(SemsterRow[3]);
					Semster.setSEMSTER_ENDDATE(SemsterRow[4]);
										
					return Semster;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static List<Semster> search(String search)  {
		List<Semster> Semsters = new ArrayList<Semster>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Semster.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Semster Semster = new Semster();
				
				String[] SemsterRow = line.split(",");
				
				if (SemsterRow[1].contains(search) == true) {
					Semster.setSEMSTER_ID(Integer.parseInt(SemsterRow[0]));
					Semster.setSEMSTER_CODE(SemsterRow[1]);
					Semster.setSEMSTER_NAME(SemsterRow[2]);
					Semster.setSEMSTER_STARTDATE(SemsterRow[3]);
					Semster.setSEMSTER_ENDDATE(SemsterRow[4]);
					
					Semsters.add(Semster);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Semsters;
	}

	@SuppressWarnings("resource")
	public static Semster Save(Semster Semster) {
		FileWriter filewriter;

		List<Semster> Semsters = findAll();

		try {
			filewriter = new FileWriter(Semster.csvFile);

			for (int i=0; i<Semsters.size(); i++) {
				filewriter.append(Semsters.get(i).toString());
				filewriter.append("\n");
			}
			if (Semsters.size()>0)
				Semster.setSEMSTER_ID(Semsters.get(Semsters.size()-1).getSEMSTER_ID()+1);
			else
				Semster.setSEMSTER_ID(1);
			filewriter.append(Semster.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
e.printStackTrace();
		}
		
		
		
		return Semster;
	}
	@SuppressWarnings("resource")
	public static Semster deleteOne(int Semster_ID)  {
		FileWriter filewriter;

		List<Semster> Semsters = findAll();
		Semster Semster = findOne(Semster_ID);

		try {
			filewriter = new FileWriter(Semster.csvFile);

			for (int i=0; i<Semsters.size(); i++) {
				if (Semsters.get(i).getSEMSTER_ID() != Semster_ID) {
					filewriter.append(Semsters.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Semster;
	}
public static String DeleteAll() {
		
		FileWriter wr;
		List<Semster>Semsters=findAll();
		try {
			wr=new FileWriter(Semster.csvFile);
			for (int i=0;i<Semsters.size();i++) {
				Semsters.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("Semsters Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of Semsters";
	}
}


