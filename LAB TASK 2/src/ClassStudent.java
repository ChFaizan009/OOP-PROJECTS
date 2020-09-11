import java.util.Scanner;
public class ClassStudent {
public static void main(String [] arys)
{
	
A obj= new A();

obj.disResult();
obj.show("ali" , 12, 1);
obj.putData();

}}

class A
{
	String name;
	int Branch;
	int Semster;
	int marks[] = new int[6];
    int i;
    float total=0, avg;
	
	

	
	void show(String a, int b, int c)
	
	{
	name=a;
	Branch=b;
	Semster=c;
	
	}
	
	  void putData()
      {
          
          System.out.print("\n\tEmployee Name   : "+name);
          System.out.print("\n\tEmployee Age    : "+Branch);
          System.out.print("\n\tEmployee Salary : "+Semster);
      }
	
	
	void disResult()
	{
		
        Scanner obj = new Scanner(System.in);
		
        
        for(i=0; i<6; i++) { 
           System.out.println("Enter Marks of Subject"+(i+1)+":");
           marks[i] = obj.nextInt();
           total = total + marks[i];
        }
        
        avg = total/6;
        System.out.print("The student Grade is: ");
        if(avg>=80)
        {
            System.out.print("A");
        }
        else if(avg>=60 && avg<80)
        {
           System.out.print("B");
        } 
        else if(avg>=40 && avg<60)
        {
            System.out.print("C");
        }
        else
        {
            System.out.print("D");
        }
	}


	
	
	
}