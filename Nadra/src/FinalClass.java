import java.util.Scanner;
public class FinalClass extends STUDENT{

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		FinalClass [] obj1=new FinalClass[2];
		
		int i;
		for(i=0;i<2;i++)
			obj1[i]=new FinalClass();
			for(i=0;i<2;i++)	
		{
		System.out.println("Enter The Detail Of " +(i+1)+" Person is : ");
			 obj1[i].getData();
			
		}
			for(i=0;i<2;i++)
			{
						obj1[i].showData(4,12);
			}
			
	
	FinalClass [] obj2=new FinalClass[3];
	int j;
	for( j=0;j<3;j++)
	obj2[j]=new FinalClass();
		
	for( j=0;j<3;j++)
		{
	System.out.println("Enter The Detail Of " +(j+1)+" Student is : ");
	obj2[j].getData();
					}
	for(j=0;j<3;j++) {
	 System.out.println("The Detail Of " +(j+1)+" Person is : ");
	obj2[j].showData();				
			}		
		}

	}


