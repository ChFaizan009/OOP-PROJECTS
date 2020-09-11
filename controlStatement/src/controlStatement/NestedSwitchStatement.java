package controlStatement;
import java.util.Scanner;
public class NestedSwitchStatement {

	
	 public static void main(String args[])  
     {    
       
		char University = 'C';                 
		
		 int College = 4;  
       switch( College )  
       {  
           case 1:  
               System.out.println("Physics, Chemistry, Math");  
               
               break;  
               
           case 2:  
               switch( University )   
               {  
                   case 'C':  
                       System.out.println("OOP,PF, Data Structure");  
                       break;  
                   case 'E':  
                       System.out.println("DATABASE, OPERATING SYSTEM");  
                       break;  
                   case 'M':  
                       System.out.println("WEB DESISING , CALCULUS");  
                       break;  
               }  
               break;  
           case 3:  
               switch( University )   
               {  
                   case 'C':  
                       System.out.println("Fundamentals of Logic Design, MultiMedia, ");  
                       break;  
                   case 'E':  
                       System.out.println("Computer Organization,Internal Combustion Engines ");  
                       break;  
                   case 'M':  
                       System.out.println("Microelectronics, Mechanical Vibration");  
                       break;  
               }  
               break;  
           case 4:  
               switch( University )   
               {  
                   case 'C':  
                       System.out.println("Data Communication and Networks, MultiMedia");  
                       break;  
                   case 'E':  
                       System.out.println("Embedded System, Image Processing");  
                       break;  
                   case 'M':  
                       System.out.println("Production Technology, Thermal Engineering");  
                       break;  
               }  
               break;  
       }  
   }  
}
