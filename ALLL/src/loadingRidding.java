
public class loadingRidding {
	String Student_Name;
	String Student_rollno;
	int Student_Id;
	String S_Name;
	int S_Id;
	int getdata(int a , int b)
	{
		return a+b;
		
	}
	int getdata(int a, int b, int c)
	{
		return a+b+c;
	}
	public static void main(String [] arys)
	{
	loadingRidding obj1=new loadingRidding();
	obj1.getdata(4,457);
	loadingRidding obj=new loadingRidding();
	obj.getdata(4,4, 457);
	
	}
}
