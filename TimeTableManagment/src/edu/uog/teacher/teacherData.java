
package edu.uog.teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class teacherData {


	@SuppressWarnings("resource")
	public static List<Teacher> findAll()  {
		List<Teacher> Teachers = new ArrayList<Teacher>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Teacher Teacher = new Teacher();
				
				String[] TeacherRow = line.split(",");
				
				Teacher.setTEACHER_ID(Integer.parseInt(TeacherRow[0]));
				
				
				Teachers.add(Teacher);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Teachers;
	}

	@SuppressWarnings("resource")
	public static Teacher findOne(int Teacher_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Teacher Teacher = new Teacher();
				
				
				String[] TeacherRow = line.split(",");
				
				if (Integer.parseInt(TeacherRow[0]) == Teacher_ID) {
					Teacher.setTEACHER_ID(Integer.parseInt(TeacherRow[0]));
					
										
					return Teacher;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static List<Teacher> search(String search)  {
		List<Teacher> Teachers = new ArrayList<Teacher>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Teacher Teacher = new Teacher();
				
				String[] TeacherRow = line.split(",");
				
				if (TeacherRow[1].contains(search) == true) {
					Teacher.setTEACHER_ID(Integer.parseInt(TeacherRow[0]));
//					
					Teachers.add(Teacher);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Teachers;
	}

	@SuppressWarnings("resource")
	public static Teacher Save(Teacher Teacher) {
		FileWriter filewriter;

		List<Teacher> Teachers = teacherData.findAll();

		try {
			filewriter = new FileWriter(Teacher.csvFile);

			for (int i=0; i<Teachers.size(); i++) {
				filewriter.append(Teachers.get(i).toString());
				filewriter.append("\n");
			}
			if (Teachers.size()>0)
				Teacher.setTEACHER_ID(Teachers.get(Teachers.size()-1).getTEACHER_ID()+1);
			else
				Teacher.setTEACHER_ID(1);
			filewriter.append(Teacher.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Teacher;
	}
		@SuppressWarnings("resource")
		public static Teacher deleteOne(int Teacher_ID)  {
			FileWriter filewriter;

			List<Teacher> Teachers = findAll();
			Teacher Teacher = findOne(Teacher_ID);

			try {
				filewriter = new FileWriter(Teacher.csvFile);

				for (int i=0; i<Teachers.size(); i++) {
					if (Teachers.get(i).getTEACHER_ID() != Teacher_ID) {
						filewriter.append(Teachers.get(i).toString());
						filewriter.append("\n");
					}
				}
				filewriter.flush();
				filewriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return Teacher;
		}
		
		
		public static String DeleteAll() {
			
			FileWriter wr;
			List<Teacher>Teachers=findAll();
			try {
				wr=new FileWriter(Teacher.csvFile);
				for (int i=0;i<Teachers.size();i++) {
					Teachers.remove(i);
				}
				wr.flush();
				wr.close();
				
			} catch (IOException e) {
				System.out.println("Teachers Records were not deleted!"+e);
				e.printStackTrace();
			}
			
			return "Removed all records of Teachers";
		}
	}

	