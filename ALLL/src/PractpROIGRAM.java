import java.util.Scanner;
public class PractpROIGRAM {

	private  String Name;
	private  String Joining_Year;
	private  String Address;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getJoining_Year() {
		return Joining_Year;
	}
	public void setJoining_Year(String joining_Year) {
		Joining_Year = joining_Year;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	void disp()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Name of Employee : ");
	 Name = sc.nextLine();
	System.out.println("Enter The Joining Year of Employee : ");
	 Joining_Year = sc.nextLine();
	System.out.println("Enter The Address of Employee : ");
	Address = sc.nextLine();
}
	void show()
	{
		System.out.println("The Name of Employee is : " + Name);
		System.out.println("The Joining year of Employee is : " + Joining_Year);
		System.out.println("The Address of Employee is : " + Address);
	}

	
	public static void main(String [] arys)
	{
		
		PractpROIGRAM obj = new PractpROIGRAM();
		PractpROIGRAM obj1 = new PractpROIGRAM();
		PractpROIGRAM obj2 = new PractpROIGRAM();
		obj.disp();
		obj.show();
		
		
		obj1.disp();
		obj1.show();
		
		obj2.disp();
		obj2.show();
		
		}
}
