pack
age Kami;

public class ali {
public static void main(String [] arys)

{
	C obj=new C();
obj.dispa();
obj.dispb();
}
}

interface A
{
	int rno=101;
	void dispa();
	
}
interface B
{
	void dispb();
}
class C implements A,B
{
	public void dispa()
	{
		System.out.println("The Roll No is : " +rno);
	}
	
	public void dispb()
	{
		System.out.println("The Ans is : ");
	}
}
