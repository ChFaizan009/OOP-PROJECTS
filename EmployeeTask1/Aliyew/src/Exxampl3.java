
public class Exxampl3 implements Exxamp2,Exxample1 {


	

	public void disp()
	{
		System.out.println("The Value of a is "+ a );
		System.out.println("The Value of b is "+  b);
		
		System.out.println("The Value of c is "+ c );
	
	}
	
	
	public void Show() {
		System.out.println("The Name  is :"+Name);
		System.out.println("The RollNo  is :"+r_no);
		System.out.println("The Class Name  is :"+Class_Name);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exxampl3 ob=new Exxampl3();
	
		ob.disp();
		ob.Show();
	}
		

}
