package edu.uog.Student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student extends Course
{
	public static String csvFile="D:\\OOP Projects\\TimeTableFiles\\Students.csv";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long STUDENT_ROLLNO;
	
	@Column(name = "STUDENT_NAME")
	private String STUDENT_NAME;
	
	@Column(name = "STUDENT_ADDRESS")
	private String STUDENT_ADDRESS;
	
	@Column(name = "STUDENT_GENDER")
	private String STUDENT_GENDER;
	
	@Column(name = "STUDENT_DOB")
	private String STUDENT_DOB;
	

	@Column(name = "ISACTIVE")
	private String ISACTIVE;

	@JsonIgnore
	@Column(name = "MODIFIED_BY")
	 private Long MODIFIED_BY;

	@JsonIgnore
	@Column(name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;

	@JsonIgnore
	@Column(name = "MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;

	public long getSTUDENT_ROLLNO() {
		return STUDENT_ROLLNO;
	}

	public void setSTUDENT_ROLLNO(long sTUDENT_ROLLNO) {
		STUDENT_ROLLNO = sTUDENT_ROLLNO;
	}

	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}

	public void setSTUDENT_NAME(String sTUDENT_NAME) {
		STUDENT_NAME = sTUDENT_NAME;
	}

	public String getSTUDENT_ADDRESS() {
		return STUDENT_ADDRESS;
	}

	public void setSTUDENT_ADDRESS(String sTUDENT_ADDRESS) {
		STUDENT_ADDRESS = sTUDENT_ADDRESS;
	}

	public String getSTUDENT_GENDER() {
		return STUDENT_GENDER;
	}

	public void setSTUDENT_GENDER(String sTUDENT_GENDER) {
		STUDENT_GENDER = sTUDENT_GENDER;
	}

	public String getSTUDENT_DOB() {
		return STUDENT_DOB;
	}

	public void setSTUDENT_DOB(String sTUDENT_DOB) {
		STUDENT_DOB = sTUDENT_DOB;
	}

	public String getISACTIVE() {
		return ISACTIVE;
	}

	public void setISACTIVE(String iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}

	public Long getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(Long mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	public String getMODIFIED_WHEN() {
		return MODIFIED_WHEN;
	}

	public void setMODIFIED_WHEN(String mODIFIED_WHEN) {
		MODIFIED_WHEN = mODIFIED_WHEN;
	}

	public String getMODIFIED_WORKSTATION() {
		return MODIFIED_WORKSTATION;
	}

	public void setMODIFIED_WORKSTATION(String mODIFIED_WORKSTATION) {
		MODIFIED_WORKSTATION = mODIFIED_WORKSTATION;
	}

	@Override
	public String toString() {
		return "Student [STUDENT_ROLLNO=" + STUDENT_ROLLNO + ", STUDENT_NAME=" + STUDENT_NAME + ", STUDENT_ADDRESS="
				+ STUDENT_ADDRESS + ", STUDENT_GENDER=" + STUDENT_GENDER + ", STUDENT_DOB=" + STUDENT_DOB
				+ ", ISACTIVE=" + ISACTIVE + ", MODIFIED_BY=" + MODIFIED_BY + ", MODIFIED_WHEN=" + MODIFIED_WHEN
				+ ", MODIFIED_WORKSTATION=" + MODIFIED_WORKSTATION + "]";
	}
	
}
