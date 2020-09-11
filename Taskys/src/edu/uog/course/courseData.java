package edu.uog.course;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class courseData {


	@SuppressWarnings("resource")
	public static List<Course> findAll()  {
		List<Course> courses = new ArrayList<Course>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Course course = new Course();
				
				
				String[] courseRow = line.split(",");
				
				course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
				course.setCOURSE_CODE(courseRow[1]);
				course.setCOURSE_TITLE(courseRow[2]);
				course.setCOURSE_DESC(courseRow[3]);
				course.setCOURSE_CREDITHOUR(Integer.parseInt(courseRow[4]));
				courses.add(course);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courses;
	}

	@SuppressWarnings("resource")
	public static Course findOne(int Course_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Course course = new Course();
				
				String[] courseRow = line.split(",");
				
				if (Integer.parseInt(courseRow[0]) == Course_ID) {
					course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
					course.setCOURSE_CODE(courseRow[1]);
					course.setCOURSE_TITLE(courseRow[2]);
					course.setCOURSE_DESC(courseRow[3]);
					course.setCOURSE_CREDITHOUR(Integer.parseInt(courseRow[4]));
					
					
					return course;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static Course findByCode(String course_CODE)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Course course = new Course();
				
				
				String[] courseRow = line.split(",");
				
				if (courseRow[1].contains(course_CODE) == true) {
					course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
					course.setCOURSE_CODE(courseRow[1]);
					course.setCOURSE_TITLE(courseRow[2]);
					course.setCOURSE_DESC(courseRow[3]);
					course.setCOURSE_CREDITHOUR(Integer.parseInt(courseRow[4]));
					
										
					return course;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static List<Course> search(String search)  {
		List<Course> courses = new ArrayList<Course>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Course course = new Course();
				
				String[] courseRow = line.split(",");
				
				if (courseRow[1].contains(search) == true) {
					course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
					course.setCOURSE_CODE(courseRow[1]);
					course.setCOURSE_TITLE(courseRow[2]);
					course.setCOURSE_DESC(courseRow[3]);
					course.setCOURSE_CREDITHOUR(Integer.parseInt(courseRow[4]));
					
					courses.add(course);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courses;
	}

	@SuppressWarnings("resource")
	public static Course Save(Course course) {
		FileWriter filewriter;

		List<Course> courses = findAll();

		try {
			filewriter = new FileWriter(Course.csvFile);

			for (int i=0; i<courses.size(); i++) {
				filewriter.append(courses.get(i).toString());
				filewriter.append("\n");
			}
			if (courses.size()>0)
				course.setCOURSE_ID(courses.get(courses.size()-1).getCOURSE_ID()+1);
			else
				course.setCOURSE_ID(1);
			filewriter.append(course.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
e.printStackTrace();
		}
		
		
		
		return course;
	}
	@SuppressWarnings("resource")
	public static Course deleteOne(int Course_ID)  {
		FileWriter filewriter;

		List<Course> Courses = findAll();
		Course Course = findOne(Course_ID);

		try {
			filewriter = new FileWriter(Course.csvFile);

			for (int i=0; i<Courses.size(); i++) {
				if (Courses.get(i).getCOURSE_ID() != Course_ID) {
					filewriter.append(Courses.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Course;
	}
	
	
	
	
public static String DeleteAll() {
		
		FileWriter wr;
		List<Course>courses=findAll();
		try {
			wr=new FileWriter(Course.csvFile);
			for (int i=0;i<courses.size();i++) {
				courses.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("Courses Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of Courses ";
	}
	
}


