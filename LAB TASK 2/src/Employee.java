
public class Employee {

	public static void main(String [] arys)
	{
		Empy obj = new Empy();
		obj.getdata();
	}
}

class Empy
{
	String name;
	int age;
	Empy()
	{
		age=12;
		name="Faizan";
	}
	void getdata()
	{
		System.out.println("The Name Of student is : " +name);

		System.out.println("The Age Of student is : " +age);
	}
}
