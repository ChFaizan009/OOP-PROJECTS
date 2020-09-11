package controlStatement;
import java.io.InputStream;
import java.util.Scanner;

public class ifelseif {
	public static void main(String[] args) {  
	    Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Numbers : ");
		int numbers=sc.nextInt();  
	      
	    if(numbers<50){  
	        System.out.println("fail");  
	    }  
	    
	    else if(numbers>=50 && numbers<60){  
	        System.out.println("D grade");  
	    }  
	    
	    else if(numbers>=60 && numbers<70){  
	        System.out.println("C grade");  
	    }  
	    
	    else if(numbers>=70 && numbers<80){  
	        System.out.println("B grade");  
	    }  
	    
	    else if(numbers>=80 && numbers<90){  
	        System.out.println("A grade");  
	    
	    }   
	 else if(numbers>=90 && numbers<100){  
	        System.out.println("A+ grade");  
	    }
	 else
	 {  
	        System.out.println("Invalid!");  
	    }  
	}

	private static void Scanner(InputStream in) {
		// TODO Auto-generated method stub
		
	}  
}
