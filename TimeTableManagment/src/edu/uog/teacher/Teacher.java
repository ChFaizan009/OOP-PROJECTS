package edu.uog.teacher;

import edu.uog.Person.Person;

public class Teacher extends Person
{

	public static String csvFile="D:\\OOP Projects\\TimeTableFiles\\Teachers.csv";
	
	private int TEACHER_ID;

	public String toString()
	{
		String str= null;
		str=" "+ this.TEACHER_ID;
			
		return str;

	}
	
	public int getTEACHER_ID() {
		return TEACHER_ID;
	}

	public void setTEACHER_ID(int tEACHER_ID) {
		TEACHER_ID = tEACHER_ID;
	}
	
}
