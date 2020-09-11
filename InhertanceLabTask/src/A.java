import java.util.Scanner;
public class A {
	
	private String PERSON_NAME;
	private int PERSON_ID;
	private String PERSON_ADRESS;
	private String PERSON_NUMBER;
	String name;
	int Id;
	String Adress;
	String Number;
	//Generate Geterer And Seterer
	public String getPERSON_NAME() {
		return PERSON_NAME;
	}
	public void setPERSON_NAME(String pERSON_NAME) {
		PERSON_NAME = pERSON_NAME;
	}
	public int getPERSON_ID() {
		return PERSON_ID;
	}
	public void setPERSON_ID(int pERSON_ID) {
		PERSON_ID = pERSON_ID;
	}
	public String getPERSON_ADRESS() {
		return PERSON_ADRESS;
	}
	public void setPERSON_ADRESS(String pERSON_ADRESS) {
		PERSON_ADRESS = pERSON_ADRESS;
	}
	public String getPERSON_NUMBER() {
		return PERSON_NUMBER;
	}
	public void setPERSON_NUMBER(String pERSON_NUMBER) {
		PERSON_NUMBER = pERSON_NUMBER;
	}
	//Function
	void getData()
	{
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter The Name Of Person");
		name=sc.nextLine();
		System.out.println("Enter The ID Of Person");
		Id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter The Adress Of Person");
		Adress=sc.nextLine();
		System.out.println("Enter The Number Of Person");
		Number=sc.nextLine();
	}
	void showData()
	{
		System.out.println(" The Name Of Person is : " +name);
		System.out.println(" The Id Of Person : " +Id);
		System.out.println(" The Adress Of Person : "  +Adress);
		System.out.println(" The Number Of Person : " +Number);
	}
	
}
