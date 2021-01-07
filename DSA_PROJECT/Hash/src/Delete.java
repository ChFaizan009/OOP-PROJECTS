import java.util.Hashtable;
import java.util.Map;

public class Delete
{

	public static void main(String args[]) 
    { 
  
	Map<Integer, String> 
    ob = new Hashtable<Integer, String>(); 


ob.put(1, "Pc"); 
ob.put(12, "Laptop"); 
ob.put(15, "Computer"); 
ob.put(3, "Tablet"); 

 
System.out.println("Inital Map"+ob);

ob.remove(2);


System.out.println("Updated Map"+ob);

} 

}
