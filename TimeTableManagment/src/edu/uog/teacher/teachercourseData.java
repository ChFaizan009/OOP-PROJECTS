    package edu.uog.teacher;
    import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.course.courseData;
import edu.uog.student.studentcourseData;

    public class teachercourseData{
	

    	
		@SuppressWarnings("resource")
    	public static List<TeacherCourse> findAll()  {
    		List<TeacherCourse> TeacherCourses = new ArrayList<TeacherCourse>();
    		String line;
    		
    		try {
    			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
    			
    			while ((line = bufferreader.readLine()) != null) {
    				TeacherCourse TeacherCours = new TeacherCourse();
    				
    				String[] TeacherCourseRow = line.split(",");
    				
    				TeacherCours.setTEACHERCOURSE_ID(Integer.parseInt(TeacherCourseRow[0]));
					TeacherCours.setSTUDENTCOURSE_ID(studentcourseData.FindOne(Integer.parseInt(TeacherCourseRow[1])));
					TeacherCours.setCOURSE_ID(courseData.findOne(Integer.parseInt(TeacherCourseRow[2])));
					TeacherCours.setTEACHER_ID(teacherData.findOne(Integer.parseInt(TeacherCourseRow[3])));
					TeacherCours.setSECTION(TeacherCourseRow[4]);
					
					
    				TeacherCourses.add(TeacherCours);
    			}
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		return TeacherCourses;
    	}
    	@SuppressWarnings("resource")
    	public static TeacherCourse findOne(int TeacherCourse_ID)  {
    		String line;
    		
    		try {
    			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
    			
    			while ((line = bufferreader.readLine()) != null) {
    				TeacherCourse TeacherCourses = new TeacherCourse();
    				
    				String[] TeacherCourseRow = line.split(",");
    				
    				if (Integer.parseInt(TeacherCourseRow[0]) == TeacherCourse_ID) {
    					TeacherCourses.setTEACHERCOURSE_ID(Integer.parseInt(TeacherCourseRow[0]));
    					TeacherCourses.setSTUDENTCOURSE_ID(studentcourseData.FindOne(Integer.parseInt(TeacherCourseRow[1])));
    					TeacherCourses.setCOURSE_ID(courseData.findOne(Integer.parseInt(TeacherCourseRow[2])));
    					TeacherCourses.setTEACHER_ID(teacherData.findOne(Integer.parseInt(TeacherCourseRow[3])));
    					TeacherCourses.setSECTION(TeacherCourseRow[4]);
    						
    					
   
    					return TeacherCourses;
    				}
    			}
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		return null;
    	}
    	

    	public static List<TeacherCourse> Search(String search){
    		List<TeacherCourse> sCourses= new ArrayList<TeacherCourse>();
    		String line ;
    		try {
    			@SuppressWarnings("resource")
    			BufferedReader bufferedReader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
    			
    			while((line=bufferedReader.readLine())!=null) {
    				TeacherCourse TeacherCourses = new TeacherCourse();
    				String[] TeacherCourseRow = line.split(",");
    				TeacherCourses.setTEACHERCOURSE_ID(Integer.parseInt(TeacherCourseRow[0]));
					TeacherCourses.setSTUDENTCOURSE_ID(studentcourseData.FindOne(Integer.parseInt(TeacherCourseRow[1])));
					TeacherCourses.setCOURSE_ID(courseData.findOne(Integer.parseInt(TeacherCourseRow[2])));
					TeacherCourses.setTEACHER_ID(teacherData.findOne(Integer.parseInt(TeacherCourseRow[3])));
					TeacherCourses.setSECTION(TeacherCourseRow[4]);
						
    				
    				
    				
    				sCourses.add(TeacherCourses);
    				}
    				//return rooms;
    			
    			
    		} catch (IOException e) {
    			
    			e.printStackTrace();
    		}
    		return sCourses;
    	}

    	public static TeacherCourse Save(TeacherCourse student) {
    		
    		FileWriter fr;
    		List<TeacherCourse> studentsTeacherCourses = findAll();
    		
    		try {
    			fr = new FileWriter(TeacherCourse.csvFile);
    			
    			for(int i=0;i<studentsTeacherCourses.size();i++) {
    				fr.append(studentsTeacherCourses.get(i).toString());
    				fr.append("\n");
    			}
    			
    			
    			if(studentsTeacherCourses.size()>0) {
    				student.setTEACHERCOURSE_ID(studentsTeacherCourses.get(studentsTeacherCourses.size()-1).getTEACHERCOURSE_ID()+1);
    			}
    			else {
    				student.setTEACHERCOURSE_ID(1);
    			}
    			studentsTeacherCourses.add(student);
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
    		List<TeacherCourse> TeacherCourses = findAll();
    		try {
    			fr = new FileWriter(TeacherCourse.csvFile);
    			
    			for(int i=0;i<TeacherCourses.size();i++) {
    				TeacherCourses.remove(i);
    			}
    				fr.flush();
    				fr.close();
    			
    	} catch (IOException e) {
    			
    			e.printStackTrace();
    		}
    		return "Students TeacherCourse Data Removed Successfully";
    		
    	}
    	
    	@SuppressWarnings({ "resource", "static-access" })
    	public static TeacherCourse deleteOne(int TeacherCourse_ID)  {
    		FileWriter filewriter;

    		List<TeacherCourse> TeacherCourses = findAll();
    		TeacherCourse TeacherCourse = findOne(TeacherCourse_ID);

    		try {
    			filewriter = new FileWriter(TeacherCourse.csvFile);

    			for (int i=0; i<TeacherCourses.size(); i++) {
    				if (TeacherCourses.get(i).getTEACHERCOURSE_ID() != TeacherCourse_ID) {
    					filewriter.append(TeacherCourses.get(i).toString());
    					filewriter.append("\n");
    				}
    			}
    			filewriter.flush();
    			filewriter.close();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		return TeacherCourse;
    	}
    		
    
    }
