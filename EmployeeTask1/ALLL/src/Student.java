

public class Student {
	String name;
	int roll_number; 
	String phone_number; 
	String  address;
	public static void main(String [] asry)
	{
		Student obj1= new Student();
		obj1.name="John";
		obj1.roll_number=19;
		obj1.phone_number="457888";
		obj1.address="Gujrat";
		
		System.out.println(obj1.name);
		System.out.println(obj1.roll_number);
		System.out.println(obj1.phone_number);
		System.out.println(obj1.address);
		
		
		Student obj2= new Student();
		obj2.name="Sam";
		obj2.roll_number=18;
		obj2.phone_number="9578";
		obj2.address="Kotla";
		
		System.out.println("<<......................>>");

		System.out.println(obj2.name);
		System.out.println(obj2.roll_number);
		System.out.println(obj2.phone_number);
		System.out.println(obj2.address);

		
	}
}
