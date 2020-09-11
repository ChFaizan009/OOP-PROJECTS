import java.util.Scanner;
public class Pratice1 {

	
	private String STUDENT_NAME;
	private int STUDENT_ID;
	private int STUDENT_AGE;
	
	
	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}
	public void setSTUDENT_NAME(String sTUDENT_NAME) {
		STUDENT_NAME = sTUDENT_NAME;
	}
	public int getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(int sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public int getSTUDENT_AGE() {
		return STUDENT_AGE;
	}
	public void setSTUDENT_AGE(int sTUDENT_AGE) {
		STUDENT_AGE = sTUDENT_AGE;
	}
	
	
	public void Method1()
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter The Name Of Students : ");
		STUDENT_NAME=sc.nextLine();
		
		System.out.println("Enter The Id Of Students : ");
		STUDENT_ID=sc.nextInt();
		
		System.out.println("Enter The Age Of Students : ");
		STUDENT_AGE=sc.nextInt();
		System.out.println("<< .................... >> ");
	}
	
}
