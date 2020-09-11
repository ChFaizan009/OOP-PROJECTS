package Ali;

public class Main {
	
public static void main(String [] n)
{
	C obj = new C(15,10);
	
	
	System.out.println(obj.j);
	
	
	
}
}
class A
{
	int j;
	
}
class C extends A
{
	int j;
	C(int m, int n)
	{
		super.j=m;
		j=n;
	}
} 