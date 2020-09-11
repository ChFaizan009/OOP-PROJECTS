
public class Open {

	public static void main (String [] arys)
	{
		ParnetClass obj=new ParnetClass();
		obj.ParnetMethod();
		Child obj1= new Child();
		obj1.Adult();
		obj1.ParnetMethod();
}

}
class ParnetClass
{

	void ParnetMethod()
	{
		System.out.println("Hello Parnets : ");
	}
}
class Child extends ParnetClass
{
	void Adult()
	{
		System.out.println("Hello Adult : ");
	}
	void ParnetMethod()
	{
		//System.out.println("Hello Parnets : ");
		System.out.println("Hello Parnets : ");
	}
}