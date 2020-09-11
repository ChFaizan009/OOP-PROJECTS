import java.util.Scanner;

public class Person {

	private String PERSON_NAME;
	private int PERSON_ID;
	private String PERSON_ADRESS;
	private String PERSON_NATIONALITY;
	String Name;
	int Id;
	String nATIONALITY;
	
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
	public String getPERSON_NATIONALITY() {
		return PERSON_NATIONALITY;
	}
	public void setPERSON_NATIONALITY(String pERSON_NATIONALITY) {
		PERSON_NATIONALITY = pERSON_NATIONALITY;
	}
	
	
	
	void getData()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter The Name of Person : ");
		Name=scan.nextLine();
		System.out.println(" The Name of Person is : "+ Name);
				
		System.out.println("Enter The ID of Person : ");
		Id=Integer.parseInt(scan.nextLine());
		System.out.println(" The ID of Person is : "+ Id);
		
		System.out.println("Enter The NATIONALITY of PERSON : ");
		nATIONALITY=scan.nextLine();
		System.out.println("The NATIONALITY of Person is: "+nATIONALITY);
	}
	
	int showData(int a, int b)
	{
		
	
		return a+b;
	}
	

	
}
