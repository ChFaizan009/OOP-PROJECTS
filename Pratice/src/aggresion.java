
public class aggresion {

	int AGGRESION_ID;
	String AGGRESION_NAME;
	String AGGRESION_COMPANY;
	aggresion(int id,String name, String company)
	{
		this.AGGRESION_ID=id;
		this.AGGRESION_NAME=name;
		this.AGGRESION_COMPANY=company;
	}
	public static class finalclass 
	{

		String NAME;
		aggresion agrs;
		finalclass(String n,aggresion asg)
		{
			this.NAME=n;
			this.agrs=asg;
		}
		
		public static void main(String [] arys)
		{
			aggresion ag=new aggresion(12,"Ali","Khan");
			
			finalclass f=new finalclass("Ali",ag);
			  System.out.println("The Name of Person is :"+f.NAME);
			  
		      System.out.println(f.agrs.AGGRESION_ID);
		       System.out.println(f.agrs.AGGRESION_NAME);
		       System.out.println(f.agrs.AGGRESION_COMPANY);
		       	
			
	
			
		}
	}
	}

