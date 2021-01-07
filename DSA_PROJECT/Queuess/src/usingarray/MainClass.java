package usingarray;

public class MainClass {

	public static void main(String[] args)
	{
	
		Queue q = new Queue(4); 
		  
        
        q.Display(); 
  
       
        q.EnQueue(10); 
        q.EnQueue(200); 
        q.EnQueue(3000); 
        q.EnQueue(40000); 
  
       
        q.Display(); 
  
        
        q.EnQueue(500000); 
  
       
        q.Display(); 
  
        q.DeQueue(); 
        q.DeQueue(); 
        System.out.printf("\n\nAfter deletion of two elements\n\n"); 
  
        
        q.Display(); 
  
        
        q.queueFront(); 
        
    } 

	}

