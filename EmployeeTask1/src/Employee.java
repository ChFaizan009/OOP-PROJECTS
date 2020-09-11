import java.util.Scanner;
public class Employee {

	private int emp_ID;
	private String dep_code;
	private int  age;
	private String basic;
	private String HRA;
	
		


	
		public int getEmp_ID() {
		return emp_ID;
	}


	public void setEmp_ID(int emp_ID) {
		this.emp_ID = emp_ID;
	}


		public String getDep_code() {
		return dep_code;
	}

	
		public void setDep_code(String dep_code) {
		this.dep_code = dep_code;
		}
		
		public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getBasic() {
		return basic;
	}


	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getHRA() {
		return HRA;
	}
	public void setHRA(String hRA) {
		HRA = hRA;
	}
	void GetData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Employee id");
		emp_ID= Integer.parseInt(sc.nextLine());
		System.out.println("Enter The Employee deparmnet code : ");
		dep_code=sc.nextLine();
		System.out.println("Enter The AGE	");
		age=Integer.parseInt(sc.nextLine());
		System.out.println("Enter The Employee Basic");
		basic=sc.nextLine();
		System.out.println("Enter The Employee HRA");
		HRA=sc.nextLine();
		}
	void PutData()
	{
		System.out.println("The Employee Id is :  " + emp_ID);
		System.out.println("The Deparment code is :  " + dep_code);
		System.out.println("The Employee Age is :  " + age);
		System.out.println("The Employee Basic is :  " + basic);
		System.out.println("The Employee HRA is :  " + HRA);
		
	}
	
	
	public static void main(String[] args) {
		Employee[] Emp = new Employee[3];
        int i;

        for(i=0;i<3;i++)
            Emp[i] =  new Employee();   // Allocating memory to each object

        for(i=0;i<3;i++)
        {
            System.out.print("\nEnter details of "+ (i+1) +" Employee\n");
            Emp[i].GetData();
        }

        System.out.print("\nDetails of Employees\n");
        for(i=0;i<3;i++)
            Emp[i].PutData();
	}

}
