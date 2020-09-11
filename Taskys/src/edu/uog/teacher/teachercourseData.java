    package edu.uog.teacher;
    import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.course.courseData;
import edu.uog.student.StudentCourse;
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
    	}}
