

public class Stack {


	//---------------------------------Stack
	
    
    
   
   	int data; 
      Nodes links; 
      static Nodes top; 
    
   public static void push(int data) 
   {  
   	Nodes temp; 
   	temp = new Nodes(); 

   	if (temp==null) { 
   		System.out.println( "\nHeap Overflow"); 
   		
   	} 

   	temp.data = data; 

   	temp.link = top; 

   	top = temp; 
   } 
    
   public static boolean isEmpty() 
   { 
   	return top == null; 
   } 
    
   public int peek() throws InterruptedException 
   { 
   	 
   	if (!isEmpty()) 
   		return top.data; 
   	else
   		wait(1);
	return ID; 
   } 


   public static void bpop() throws InterruptedException 
   { 
   	Nodes temp; 

   	
   	if (top == null) { 
   		System.out.println("\nStack Underflow"); 
   		
   	} 
   	else { 
   		
   		temp = top; 
   		top = top.links;  
   		temp.links = null; 
   		
   		// release memory of top node 
   		freeMemory(temp); 
   		
   	}
   		System.out.println("Your Trolli No is :"+top.data); 
   		System.out.println("                  ___");
   		System.out.println("                 /  |");
   		System.out.println("  ______________/   --");
   		System.out.println(" |___/__ /___/_|     ");     
   		System.out.println(" |__/___/___/__|     ");     
   		System.out.println(" |_/___/___/___|     ");     
   		System.out.println("    _______/         ");
   		System.out.println("     O   O           ");


   } 

   private static void freeMemory(Nodes temp) {
	// TODO Auto-generated method stub
	
}


public void bdisplay() 
   { 
   	Nodes temp; 

   	 
   	if (top == null) { 
   		System.out.println( "\nStack Underflow"); 
   		try {
			wait(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
   	} 
   	else { 
   		temp = top; 
   		while (temp != null)
    { 
   			System.out.println(  temp.data + " ");  
   			temp = temp.links; 
   		} 
   	} 
   } 

    

}
