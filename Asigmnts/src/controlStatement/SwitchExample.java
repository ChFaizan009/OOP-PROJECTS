package controlStatement;
import java.util.Scanner;
public class SwitchExample {

	public static void main(String[] args) {    
		Scanner sc = new Scanner(System.in);
		System.out.println("Select The Month : ");
		int m=sc.nextInt();
	    String month="";  
	  
	    switch(m){    
	      
	    case 1: month="1 -The Month is  January";  
	    break;    
	    case 2: month="2 - The Month is  February";  
	    break;    
	    case 3: month="3 - The Month is  March";  
	    break;    
	    case 4: month="4 - The Month is April";  
	    break;    
	    case 5: month="5 - The Month is May";  
	    break;    
	    case 6: month="6 - The Month is June";  
	    break;    
	    case 7: month="7 - The Month is July";  
	    break;    
	    case 8: month="8 - The Month is August";  
	    break;    
	    case 9: month="9 - The Month is September";  
	    break;    
	    case 10: month="10 - The Month is October";  
	    break;    
	    case 11: month="11 - The Month is November";  
	    break;    
	    case 12: month="12 - The Month is December";  
	    break;    
	    default:System.out.println("Invalid Month!");    
	    }    
	     
	    System.out.println(month);  
	}
	} 