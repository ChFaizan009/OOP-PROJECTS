import java.util.Scanner;

public class Stack
{

	Scanner sc=new Scanner(System.in);
	   int top;   
	    int maxsize = 10;  
	    int[] arr = new int[maxsize];  
	      
	      
	    public boolean isEmpty()  
	    {  
	        return (top < 0);  
	    }  
	    Stack()  
	    {  
	        top = -1;  
	    }  
	    public boolean push (Scanner sc)  
	    {  
	        if(top == maxsize-1)  
	        {  
	            System.out.println("Overflow !!");  
	            return false;  
	        }  
	        else   
	        {  
	            System.out.println("Enter Value");  
	            int val = sc.nextInt();  
	            top++;  
	            arr[top]=val;  
	            System.out.println("Item pushed");  
	            return true;  
	        }  
	    }  
	    public boolean pop ()  
	    {  
	        if (top == -1)  
	        {  
	            System.out.println("Underflow !!");  
	            return false;  
	        }  
	        else   
	        {  
	            top --;   
	            System.out.println("Item popped");  
	            return true;  
	        }  
	    }  
	   public void display ()  
	    {  
	        System.out.println("Printing Stack Elements .....");  
	        for(int i = top; i>=0;i--)  
	        {  
	            System.out.println(arr[i]);  
	        }  
	    }  
	}
