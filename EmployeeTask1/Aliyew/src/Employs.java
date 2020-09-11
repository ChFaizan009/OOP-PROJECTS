import java.util.Scanner;

public class Employs {

	private float Salary=0;
	private float no_hours=0;
	

	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	
	public float getNo_hours() {
		return no_hours;
	}
	public void setNo_hours(float no_hours) {
		this.no_hours = no_hours;
	}
	void getInfo(float s,float h )
	{
		Salary=s;
		 no_hours=h;
	}
	public float AddSal()
	{
		if(Salary<500)
		{
			Salary=Salary+10;
		}
	return Salary;
	}
	public float  AddWork()
	{
		if(no_hours<6) {
			Salary = Salary + 5;
		}
		return Salary;
	}
	
	class TestEmployee {
		float salary;
		
		public TestEmployee(float sal) {
			salary = sal;
		}
		
		public void printSal() {
			System.out.println("Salary : " + salary);
		}
	}
	
	
	public static void main(String [] arys)
	{
		Employs obj = new Employs();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name");
		String name = sc.nextLine();
		System.out.println("Enter salary");
		float salary = sc.nextFloat();
		System.out.println("Enter no. of hours of work");
		float hours = sc.nextFloat();
		
		obj.AddSal();
		obj.AddWork();
		
		
		TestEmployee test = new TestEmployee(Salary);  
		test.printSal();
	}
}
