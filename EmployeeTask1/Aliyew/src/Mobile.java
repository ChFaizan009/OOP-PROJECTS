import java.util.Scanner;
public abstract class Mobile {

	private String Mobile_Name;
	private String Mobile_RegNo;
	private String Mobile_Model;
	private String Mobile_Colour;
	private String Mobile_BatryCapacity;
	private String Mobile_Storage;
	
	
	
	public String getMobile_Name() {
		return Mobile_Name;
	}
	public void setMobile_Name(String mobile_Name) {
		Mobile_Name = mobile_Name;
	}
	public String getMobile_RegNo() {
		return Mobile_RegNo;
	}
	public void setMobile_RegNo(String mobile_RegNo) {
		Mobile_RegNo = mobile_RegNo;
	}
	public String getMobile_Model() {
		return Mobile_Model;
	}
	public void setMobile_Model(String mobile_Model) {
		Mobile_Model = mobile_Model;
	}
	public String getMobile_Colour() {
		return Mobile_Colour;
	}
	public void setMobile_Colour(String mobile_Colour) {
		Mobile_Colour = mobile_Colour;
	}
	public String getMobile_BatryCapacity() {
		return Mobile_BatryCapacity;
	}
	public void setMobile_BatryCapacity(String mobile_BatryCapacity) {
		Mobile_BatryCapacity = mobile_BatryCapacity;
	}
	public String getMobile_Storage() {
		return Mobile_Storage;
	}
	public void setMobile_Storage(String mobile_Storage) {
		Mobile_Storage = mobile_Storage;
	}

	public void disp()
	{
		System.out.println("<<<......This is Information about Mobile..............>>>>>>");
	}
	
	public void display()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Name of Mobile ");
		Mobile_Name=sc.nextLine();
		System.out.println("Enter The Registration Number of Mobile ");
		Mobile_RegNo=sc.nextLine();
		System.out.println("Enter The Model of Mobile ");
		Mobile_Model=sc.nextLine();
		System.out.println("Enter The Colour of Mobile ");
		Mobile_Colour=sc.nextLine();
		System.out.println("Enter The Batery Capcity of Mobile ");
		Mobile_BatryCapacity=sc.nextLine();
		System.out.println("Enter The Storage of Mobile ");
		Mobile_Storage=sc.nextLine();
	}
	
	public void Show()
	{
		System.out.println("The Name of Mobile is "+Mobile_Name);	
		System.out.println("The Registration Number of Mobile is "+Mobile_RegNo);
		System.out.println("The Model of Mobile is "+Mobile_Model);
		System.out.println("The Colour of Mobile is "+Mobile_Colour);
		System.out.println("The Batery Capcity of Mobile is "+Mobile_BatryCapacity);
		System.out.println("The Storage of Mobile is "+Mobile_Storage);
	}
}
