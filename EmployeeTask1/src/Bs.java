
public class Bs extends As {

	void disp()
	{
		System.out.println("Value a is "+ a +"Value c is"+ c);
		
	}
	void sum()
	{
		System.out.println("Value b is "+ b);
		super.disp();
		super.sum();
	}
}
