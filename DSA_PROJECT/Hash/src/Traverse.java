import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class Traverse 
{

	public static void main(String args[]) 
    { 
  
	Hashtable<Integer, String> 
    ob = new Hashtable<Integer, String>(); 


ob.put(1, "Pc"); 
ob.put(12, "Laptop"); 
ob.put(15, "Computer"); 
ob.put(3, "Tablet"); 

for(Entry<Integer, String> e : ob.entrySet())
	System.out.println(e.getKey()+" "+e.getValue());

    }
}
