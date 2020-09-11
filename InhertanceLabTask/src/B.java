import java.util.Scanner;

public class B extends A{
	private String STUDENT_NAME;
	private int STUDENT_ID;
	
	String NAME;
	int ID;
	//Generate Geterer And Seterer
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
	
public static void main(String [] arys)
{
	B obj = new B();
	obj.getData();
	obj.showData();
}

	}
