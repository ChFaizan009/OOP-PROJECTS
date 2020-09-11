import java.util.Scanner;
public class STUDENT extends  Person {


	private String STUDENT_NAME;
	private int STUDENT_ID;
	private String STUDENT_ADRESS;
	private String STUDENT_NATIONALITY;
	String name;
	int id;
	String adress;
	String NATIONALITY;
	
	public String getsTUDENT_NAME()
	{
		return STUDENT_NAME;
	}
	public void setsTUDENT_NAME( String sTUDENT_NAME)
	{
		STUDENT_NAME=sTUDENT_NAME;
	}
	public int getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(int sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public String getSTUDENT_ADRESS() {
		return STUDENT_ADRESS;
	}
	public void setSTUDENT_ADRESS(String sTUDENT_ADRESS) {
		STUDENT_ADRESS = sTUDENT_ADRESS;
	}
	public String getSTUDENT_NATIONALITY() {
		return STUDENT_NATIONALITY;
	}
	public void setSTUDENT_NATIONALITY(String sTUDENT_NATIONALITY) {
		STUDENT_NATIONALITY = sTUDENT_NATIONALITY;
	}
	
	
	void getData()
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter The Name of Student : ");
		name=obj.nextLine();
		
		System.out.println("Enter The ID of Student : ");
		id=Integer.parseInt(obj.nextLine());
		
		System.out.println("Enter The Adress of Student : ");
		adress=obj.nextLine();
		
		System.out.println("Enter The NATIONALITY of Student : ");
		NATIONALITY=obj.nextLine();
		
	}
	void showData()
	{
		System.out.println(" The Name of Student is : "+ name);
		System.out.println(" The ID of Student is : "+ id);
		System.out.println(" The adress of Student is : "+ adress);
		System.out.println("The NATIONALITY of Student is: "+NATIONALITY);
	}
	
}
