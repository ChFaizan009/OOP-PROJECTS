package edu.uog.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class personData {



	@SuppressWarnings("resource")
	public static List<Person> findAll()  {
		List<Person> Persons = new ArrayList<Person>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Person.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Person Person = new Person();
				
				String[] PersonRow = line.split(",");
				
				Person.setPERSON_ID(Integer.parseInt(PersonRow[0]));
				Person.setTITLE(PersonRow[1]);
				Person.setFORE_NAME(PersonRow[2]);
				Person.setSUR_NAME(PersonRow[3]);
				Person.setAGE(Integer.parseInt(PersonRow[4]));
				Person.setGENDER(PersonRow[5]);
				Person.setADDRESS(PersonRow[6]);
				
				
				
				Persons.add(Person);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Persons;
	}
	@SuppressWarnings("resource")
	public static Person findOne(int Person_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Person.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Person Person = new Person();
				
				String[] PersonRow = line.split(",");
				
				if (Integer.parseInt(PersonRow[0]) == Person_ID) {
					Person.setPERSON_ID(Integer.parseInt(PersonRow[0]));
					Person.setTITLE(PersonRow[1]);
					Person.setFORE_NAME(PersonRow[2]);
					Person.setSUR_NAME(PersonRow[3]);
					Person.setAGE(Integer.parseInt(PersonRow[4]));
					Person.setGENDER(PersonRow[5]);
					Person.setADDRESS(PersonRow[6]);
					
					
					
					return Person;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static Person deleteOne(int Person_ID)  {
		FileWriter filewriter;

		List<Person> Persons = findAll();
		Person Person = findOne(Person_ID);

		try {
			filewriter = new FileWriter(Person.csvFile);

			for (int i=0; i<Persons.size(); i++) {
				if (Persons.get(i).getPERSON_ID() != Person_ID) {
					filewriter.append(Persons.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Person;
	}

	@SuppressWarnings("resource")
	public static List<Person> search(String search)  {
		List<Person> Persons = new ArrayList<Person>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Person.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Person Person = new Person();
				
				String[] PersonRow = line.split(",");
				
				if (PersonRow[1].contains(search) == true) {
					Person.setPERSON_ID(Integer.parseInt(PersonRow[0]));
					Person.setTITLE(PersonRow[1]);
					Person.setFORE_NAME(PersonRow[2]);
					Person.setSUR_NAME(PersonRow[3]);
					Person.setAGE(Integer.parseInt(PersonRow[4]));
					Person.setGENDER(PersonRow[5]);
					Person.setADDRESS(PersonRow[6]);
					Persons.add(Person);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Persons;
	}

	@SuppressWarnings("resource")
	public static Person deleteOne1(int Person_ID)  {
		FileWriter filewriter;

		List<Person> Persons = findAll();
	Person Person = findOne(Person_ID);

		try {
			filewriter = new FileWriter(Person.csvFile);

			for (int i=0; i<Persons.size(); i++) {
				if (Persons.get(i).getPERSON_ID() != Person_ID) {
					filewriter.append(Persons.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Person;
	}
	
	
	@SuppressWarnings("resource")
	public static Person Save(Person Person) {
		FileWriter filewriter;

		List<Person> Persons = findAll();

		try {
			filewriter = new FileWriter(Person.csvFile);

			for (int i=0; i<Persons.size(); i++) {
				filewriter.append(Persons.get(i).toString());
				filewriter.append("\n");
			}
			if (Persons.size()>0)
				Person.setPERSON_ID(Persons.get(Persons.size()-1).getPERSON_ID()+1);
			else
				Person.setPERSON_ID(1);
			filewriter.append(Person.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block

			
			e.printStackTrace();
		}
		
		
		
		return Person;
	}
	

public static String DeleteAll() {
		
		FileWriter wr;
		List<Person>Persons=findAll();
		try {
			wr=new FileWriter(Person.csvFile);
			for (int i=0;i<Persons.size();i++) {
				Persons.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("Persons Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of Persons";
	}

}
