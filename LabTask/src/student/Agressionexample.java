package student;

public class Agressionexample {
	int id;
	String Name;
	Address address; 
	public Agressionexample(int id, String name,Address address)
	{
		 this.id = id;  
		    this.Name = name;  
		    this.address=address;
	}
	
	void display()

	{
		System.out.println("The NAME IS : "+Name + id );
		System.out.println(address.city+"" + address.state+"" + address.country+"");
		

	}
	
	public static void main(String [ ] arys)
	{
		Address obj1 = new Address("PAKISTAN", " GUJRAT" , " iNDIA");
		Agressionexample obj = new Agressionexample(12, " Faizan" , obj1 );
		
	}
}
