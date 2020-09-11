import java.util.Scanner;
public class ADRESS {
	
	  public static void main(String[] args) 
	  {
	    Scanner input = new Scanner (System.in);
	    System.out.print("Input your Name : ");
	    String fname = input.next();
	    System.out.print("Input your City Name : ");
	    String lname = input.next();
	    System.out.println("Input your Adress ");
	    String adres = input.next(); 
	    System.out.println("Your Name is : " +fname);
	    System.out.println("Your City Name is : " +lname);
	    System.out.println("Your Address is : " +adres);
	  }
	}
	
	

