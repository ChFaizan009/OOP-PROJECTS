
public class Queues {

	
	
	 Node front=null;
	 Node rear=null; 
	  int size=0;
	   
	  
	  public boolean isEmpty()
	  {
		  boolean flag=false;
		  if(size==0)
		  {
			  flag=true;
		  }
		  return flag;
	  }
	    public void EnQueue(int data) 
	    { 
	  
	    	Node node = new Node(data); 
	          
	        if (front == null) { 
	             rear = node;
	             front= node;
	             size++;
	            
	        } 
	  
	        else
	        {
	        	rear.setNext(node);
	            rear=node;
	            size++; 
	    } 
	    }
	    
	    // Method to remove an data from queue. 
	   public void DeQueue() 
	    { 
	         
	        if (front == null) 
	            return; 
	  
	        // Store previous front and move front one node ahead 
	        Node temp = front; 
	        front = front.getNext(); 
	  
	        // If front becomes NULL, then change rear also as NULL 
	        if (front == null) 
	            rear = null; 
	    } 
	
	  
	  
}
