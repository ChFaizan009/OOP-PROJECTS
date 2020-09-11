package Pratise;

public class Pratice14 extends practice13  {

	public static void main(String [] arys)
	{
		Pratice14[] obj = new Pratice14[5];
		int i;
		for(i=0;i<5;i++)
			obj[i]=new Pratice14();
		for(i=0;i<5;i++)
		{
			System.out.println("Enter The Deatil of"+(i+1)+" Students /n ");
			obj[i].getData();
		}
		
		
			System.out.println("The Detail of Students is");
			for(i=0;i<5;i++)
				obj[i].showData();
	}
}
