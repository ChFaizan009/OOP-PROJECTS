import java.util.Scanner;
public class Pizza {
	
public static void main(String [] arus)
{
	 

	
	C obj= new C();
	obj.getFood();
}
}
 class Shop
{
	 String food;
	 
	 int a;
	 int choice= a ;
	 String order;
	 
}
 class C extends Shop
 {
	 //a=choice;
     void getFood()
     {
    	
    	 Scanner in=new Scanner(System.in);
    	 a=in.nextInt();
     System.out.println("Enter The Choice  you want to " );
    	 switch(choice)
    	 {
    	 
    	 case 1 : 
    		 order = "Pizza";
    		 break;
    	 case 2 : 
    		 order = "Burger";
    		 break;
    	 case 3 : 
    		 order = "Shawarma";
    		 break;
    	 case 4 : 
    		 order = "Nugests";
    		 break;
    	 default: 
             order = "Invalid Order";
             break;
    		     }
    	 System.out.println(order);
}
}