package Kami;
import java.util.ArrayList;
public class araylistexa {
	
		public static void main(String args[])
		{
	ArrayList <String > cars= new ArrayList<String>();
	cars.add("Alto");
	cars.add("Cultus");
	cars.add("Honda city");
	cars.add("Honda civic");
	cars.add("Corola");
	cars.add("Prado");
	for(int i=0;i<cars.size();i++)
	{
	      System.out.println(cars.get(i));
	}
}
}