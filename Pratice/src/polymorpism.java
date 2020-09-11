
public class polymorpism {

	String name;
	public void walk()
	{
		System.out.println("i am waliking");
		
	}
	
	public void walk(String n)
	{
		this.name=n;
		
		System.out.println("i am Talking");
	}
	public static void main(String[] arys)
	{
		polymorpism pol=new polymorpism();
		pol.walk();
		pol.walk("Faizan");
	}
}
