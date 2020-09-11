package Pratise;

public class Selectionsort {


	public static void main(String [] arys)
	{
		  int a[]= {3,4,7,-1,9,5};
		  int n=a.length;
		  int minInd = 0;
		  for(int i=0;i<n-1;i++)
			{
			  
				for(int j=i;j<n;j++)
				{
					if(a[j]<a[minInd])
					{
						minInd=j;
					}
				}		
					{
						
						int temp=a[i];
						a[i]=a[minInd];
						a[minInd]=temp;
					
					}			
			
			}
		  
		  
		  for(int w: a)
		  {
			  System.out.print(w+"  ");
		  }
		  
			
			
			}}