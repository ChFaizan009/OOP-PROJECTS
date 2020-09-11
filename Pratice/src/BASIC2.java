import java.util.Scanner;
public class BASIC2 extends basic 
{

	public void getData()
	{
		Scanner in = new Scanner(System.in);  
		System.out.println("Enter The ID of Product : ");
		PRODUCT_ID=in.nextInt();
		System.out.println("Enter The NAME of Product : ");
		PRODUCT_NAME=in.nextLine();
		PRODUCT_NAME+=in.nextLine();
		System.out.println("Enter The Qulaity of Product : ");
		PRODUCT_QUALITY=in.nextLine();
		System.out.println("Enter The Price of Product : ");
		PRODUCT_PRICE=in.nextLine();
		System.out.println("Enter The ID of Product EXPERIEDDATE: ");
		PRODUCT_EXPERIEDDATE=in.nextLine();
	
	}
	public void showData()
	{
	System.out.println("The ID Of Product is : "+PRODUCT_ID);		
	System.out.println("The Name Of Product is : "+PRODUCT_NAME);
	System.out.println("The Quality Of Product is : "+PRODUCT_QUALITY);
	System.out.println("The Price Of Product is : "+PRODUCT_PRICE);
	System.out.println("The EXPERIEDDATE Of Product is : "+PRODUCT_EXPERIEDDATE);
	}
	
		public static void main(String [] ar)
		{
			BASIC2 obj1=new BASIC2();
			obj1.getData();
		System.out.println("<<<<<----------------->>>>");
		
		obj1.showData();
					
		}
	
		
	
	
}
