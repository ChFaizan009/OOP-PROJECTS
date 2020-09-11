import java.util.Scanner;
public class ConvertnuM {

	public static void main(String [] arys)
	{
		Process obj1=new Process();
		obj1.getData();
		obj1.convert();
	}
}

 class Process
{
	 int no;
	void getData()
	{
		System.out.println("Decimal to HexaDecimal,Octal and Binary");
        Scanner obj = new Scanner(System.in);
        System.out.println("\nEnter the number :");
         no = Integer.parseInt(obj.nextLine());
        
        
	}
	void convert()
	{
		 String hexa=Integer.toHexString(no);
		 System.out.println("HexaDecimal Value is : " + hexa);
		 String octal = Integer.toOctalString(no);
		 System.out.println("Octal Value is : " + octal);
         String binary = Integer.toBinaryString(no);
         System.out.println("Binary Value is : " + binary);
		 
	}
}