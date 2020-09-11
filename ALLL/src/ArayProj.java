import java.util.Scanner;
public class ArayProj {

	private String Name;
	private String Id;
	private int  Roll_No;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getRoll_No() {
		return Roll_No;
	}
	public void setRoll_No(int roll_No) {
		Roll_No = roll_No;
	}
	void getData()
	{
		Scanner sc = new Scanner(System.in);
	System.out.println("ENTER THE NAME OF STUDENTS");
	Name=sc.nextLine();
	System.out.println("ENTER THE ID OF STUDENTS");
	Id=sc.nextLine();
	System.out.println("ENTER THE ROLL NO OF STUDENTS");
	Roll_No=sc.nextInt();
	}
	void showData()
	{
	System.out.println("THE NAME OF STUDENTS IS : "+Name);
	System.out.println("THE ID OF STUDENTS IS : "+Id);	
	System.out.println("THE ROLL NO OF STUDENTS IS : "+Roll_No);		
	}
	public static void main(String []ary)
	{
		ArayProj[] ob=new ArayProj[3];
		int i;
		for (i=0;i<3;i++)
		
			ob[i]=new ArayProj();
		
		for(i=0;i<3;i++)
        {
            System.out.print("\nENTER DETAILS OF "+ (i+1) +" STUDENT\n");
            ob[i].getData();
        }
		
		System.out.print("\nDETAILS OF STUDENTS\n");
        for(i=0;i<3;i++)
            ob[i].showData();

        

        	}
	}

}
