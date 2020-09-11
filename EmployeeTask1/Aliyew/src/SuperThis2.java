
public class SuperThis2 extends SuperThis{

	void disp()
	{
		System.out.println("This is not Super class");
	}
	void show()
	{
		System.out.println("This is not Sub class");
	}
	void display()
	{
		this.disp();
		super.disp();
		this.show();
		super.show();
	}
	public static void main(String [] ar)
	{
		SuperThis2 ob = new SuperThis2();
		ob.display();
		 
	}
}
