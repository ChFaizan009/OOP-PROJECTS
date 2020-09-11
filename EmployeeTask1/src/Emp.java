import java.util.Scanner;
public class Emp {

	String Name;
	int age;
	int rno;

	void show()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Name of Emp : ");
		Name=sc.nextLine();
		System.out.println("Enter The Age of Emp : ");
		age=sc.nextInt();
		System.out.println("Enter The rno of Emp : ");
		rno=sc.nextInt();
	}
}
