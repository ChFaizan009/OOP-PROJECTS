package controlStatement;

import java.util.Scanner;

public class WrapperSwitch {

	 public static void main(String args[])  
     {         
		 Scanner sc = new Scanner(System.in);
			System.out.println("Enter The CHOICE : ");
			int Age=sc.nextInt();   
		   
          switch (Age)  
          {  
              case (1):            
                  System.out.println("THE STUDENT IS UNDER 18");  
              
              break;  
              case (2):                
                  System.out.println("THE STUDENTS ARE  ELIGIBLE FOR VOTE. ");  
              
              break;  
              case (3):                
                  System.out.println("THESE STUDENTS ARE SENIOR CITIZEN.");  
                  
              break;  
              default:  
                  System.out.println("PLEASE GIVE THE VALID AGE.");  
                  
                  break;  
          }             
      }  
}
