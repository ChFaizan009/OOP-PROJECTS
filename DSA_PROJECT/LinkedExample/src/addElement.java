import java.util.LinkedList;

public class addElement
{

	public static void main(String [] ar)
	{
		LinkedList<String> list=new LinkedList<String>();
		list.add("Faizan");
		list.add("Ali");
		list.add("Kamran");
		list.add("Ahmed");
		list.removeLast();
		System.out.println("The Name of Student is "+list);
		System.out.println("<><><><><> ");
		
	}
}
