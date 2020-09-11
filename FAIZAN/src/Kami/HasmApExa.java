package Kami;
import java.util.HashMap;
public class HasmApExa {
	
	public static void main(String args[]) {
		
	
	HashMap<String , String> mobile= new HashMap<String , String>();
	mobile.put("Samsung A30","Samsung J6");
	mobile.put("Iphone i10s","Iphone i11");
	mobile.put("Huweia P5","Huweia P7");
	for (int j=0;j<mobile.size();j++)
	{
	 System.out.println("The Mobile  " + j + " Model: " + mobile.get(j));	
	}
}
	}
