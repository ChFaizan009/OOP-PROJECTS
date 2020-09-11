import java.util.Scanner;
public class Employee

{

	Scanner in = new Scanner(System.in);  
	String EMP_CODE;
	String DEPT_CODE;
	int AGE;
	float BASIC_PAY; 
	public void getData()
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the Name of Employer Code ");
		EMP_CODE=in.nextLine();
		System.out.println("Enter the Name of Department Code ");
		DEPT_CODE=in.nextLine();
		System.out.println("Enter the Age of Employer ");
		AGE=in.nextInt();
		System.out.println("Enter the Name of Employer Code ");
		BASIC_PAY=in.nextFloat();
		
	}
	



	
	
	
}
