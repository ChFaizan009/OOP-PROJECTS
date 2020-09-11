import java.util.Scanner;

public class EmployeTest extends Employe {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter the First Name of Employee : ");
	String f=sc.next();
	System.out.println("Enter The Last Name of Employee : ");
	String l=sc.next();
	System.out.println("Enter The Salary of Employee : ");
	String s=sc.next();	
	EmployeTest sc1 = new EmployeTest();
	
	System.out.println("the yearly salary of "+sc1.getFIRSTNAME()+" "
			 +sc1.getLASTNAME()+" :");
			 System.out.println(sc1.getSALARY()*12);
			double newsalary= 
			sc1.getSALARY()*0.1+sc1.getSALARY();
			 sc1.setSALARY(newsalary);
			 System.out.println("the new yearly salary of "+
			sc1.getFIRSTNAME()+" "+sc1.getLASTNAME()+" :");
			 System.out.println(sc1.getSALARY()*12);
			 sc1.getSALARY();
	}


}
