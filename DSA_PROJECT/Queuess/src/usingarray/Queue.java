package usingarray;

public class Queue {
	
	     static int front;
	     static int rear;
	     static int size; 
	     static int queue[]; 
	  
	     public Queue(int s) 
	     { 
	         front = rear = 0; 
	         size = s; 
	         queue = new int[size]; 
	     }
	  
	  public  static void EnQueue(int data) 
	    { 
	        
	        if (size == rear) { 
	            System.out.printf("\nQueue is full\n"); 
	            return; 
	        } 
	  
	        
	        else { 
	            queue[rear] = data; 
	            rear++; 
	        } 
	        return; 
	    } 
	  
	    public static int DeQueue() 
	    { 
	         
	        if (front == rear) { 
	            System.out.printf("\nQueue is empty\n"); 
	            return 1; 
	        } 
	  
	        else
	        {
	        	int data = queue[front];
	        front=front+1;
	        size=size-1;
	        return data;
	        }
	        }
	        // shift all the elements from index 2 till rear 
	        // to the right by one 
//	        else { 
//	            for (int i = 0; i < rear - 1; i++) { 
//	                queue[i] = queue[i + 1]; 
//	            } 
//	  
//	            // store 0 at rear indicating there's no element 
//	            if (rear < size) 
//	                queue[rear] = 0; 
//	  
//	            // decrement rear 
//	            rear--; 
//	        } 
//	        return; 
//	    } 
	  
	    
	    public static void Display() 
	    { 
	        int i; 
	        if (front == rear) { 
	            System.out.printf("\nQueue is Empty\n"); 
	            return; 
	        } 
	  
	        
	        for (i = front; i < rear; i++) { 
	            System.out.printf(" %d -- ", queue[i]); 
	        } 
	        return; 
	    } 
	  
	   
	   public static void queueFront() 
	    { 
	        if (front == rear) { 
	            System.out.printf("\nQueue is Empty\n"); 
	            return; 
	        } 
	        System.out.printf("\nFront Element is: %d", queue[front]); 
	        return; 
	    }
	   
	   
	   
	   
	   
	   
	} 

