import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Hod extends Person
{

	String HOD_NAME;
    int HOD_ID;
	 String HODDEP_NAME;
	
	public void MainFunction()


	{
		List<Teacher> dd=new ArrayList<Teacher>();
		Teacher.displayTeacher1(dd);
		Scanner input=new Scanner(System.in);
		System.out.println("Enter The Id of Teacher that HOD Allote the course");
		int id = input.nextInt();
		

			boolean flag = false;
		for (int i = 0; i < dd.size(); i++) {
			if (dd.get(i).getTEACHER_ID().equals(id)) {
				flag = true;
				System.out.println("\n\n\t\t\tCourse Allot To Teacher ...!");
				
	}
			else
			{
			System.out.println("The Teacher Id Does no Matched");
			}	
		}
			}
	public static void main(String[] ar)
	{
		Hod hod=new Hod();
		hod.MainFunction();
	}

	
	
}
