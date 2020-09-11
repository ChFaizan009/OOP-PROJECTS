
public class Pratice2 extends Pratice1 {

	String name;
	int id;
	public Pratice2(String Name,int Id)
	{
		this.name=Name;
		this.id=Id;
	}
	
	public void Method1()
	{
	super.Method1();
	System.out.println("The Name Of Students is : "+ getSTUDENT_NAME());
	System.out.println("The Id Of Students is : "+ getSTUDENT_ID());
	System.out.println("The Age Of Students is : "+ getSTUDENT_AGE());
	}
	
	
	
	
	public static void main(String[] args) {
		Pratice2 pr=new Pratice2("Faizan",12);
		System.out.println("The Name is : "+pr.name);
		System.out.println("The Id is : "+pr.id);
		System.out.println("< < > > > > > > > > > >");
		pr.Method1();
	}

}
