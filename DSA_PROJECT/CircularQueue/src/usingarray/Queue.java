package usingarray;

public class Queue
{
	 
	 Node front;
	 Node rear;
	
	public static void EnQueue(Queue q, int value) 
	    { 
	        Node temp = new Node(); 
	        temp.data = value; 
	        if (q.front == null) 
	            q.front = temp; 
	        else
	            q.rear.link = temp; 
	  
	        q.rear = temp; 
	        q.rear.link = q.front; 
	    } 
	  
	     
	    public static int deQueue(Queue q) 
	    { 
	        if (q.front == null) { 
	            System.out.printf("Queue is empty"); 
	            return Integer.MIN_VALUE; 
	        } 
	  
	        
	        int value;  
	        if (q.front == q.rear) { 
	            value = q.front.data; 
	            q.front = null; 
	            q.rear = null; 
	        } 
	        else  
	        { 
	            Node temp = q.front; 
	            value = temp.data; 
	            q.front = q.front.link; 
	            q.rear.link = q.front; 
	        } 
	  
	        return value; 
	    } 
	  
	    
	   public static void display(Queue q) 
	    { 
	        Node temp = q.front; 
	        System.out.printf("\nElements are: "); 
	        while (temp.link != q.front) { 
	            System.out.printf("%d ", temp.data); 
	            temp = temp.link; 
	        } 
	        System.out.printf("%d", temp.data); 
	    } 
	  
		public static void main(String args[]) 
	    { 
	        
	        Queue q = new Queue(); 
	        q.front = q.rear = null; 
	  
	         
	        EnQueue(q, 14); 
	        EnQueue(q, 22); 
	        EnQueue(q, 6); 
	  
	         
	        display(q); 
	  
	        
	        System.out.printf("\nDeleted value = %d", deQueue(q)); 
	        System.out.printf("\nDeleted value = %d", deQueue(q)); 
	  
	         
	        display(q); 
	  
	        EnQueue(q, 9); 
	        EnQueue(q, 20); 
	        display(q); 
	    }
	 
}
