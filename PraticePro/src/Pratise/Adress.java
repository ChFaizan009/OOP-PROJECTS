package Pratise;

public class Adress {

	String Country_Name;
	String State_Name;
	String District_Name;
	public Adress(String country_Name, String state_Name, String district_Name) {
		super();
		this.Country_Name = country_Name;
		this.State_Name = state_Name;
		this.District_Name = district_Name;
	}
	public static void main(String [] ary)
	{
		Adress ob= new Adress("Pakistan", "Pakistani","Gujrat");
	}
	
}
