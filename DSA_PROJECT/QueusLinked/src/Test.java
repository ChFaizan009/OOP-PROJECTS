
public class Test
{

	 public static void main(String[] args) 
	    { 
	        Queues q = new Queues(); 
	        q.EnQueue(10); 
	        q.EnQueue(20); 
	        q.DeQueue();
	        q.EnQueue(50); 
	        q.DeQueue(); 
	        q.EnQueue(30); 
	        q.EnQueue(40); 
	        q.EnQueue(50); 
	        q.DeQueue(); 
	        System.out.println("Queue Front : " + q.front.getData()); 
	        System.out.println("Queue Rear : " + q.rear.getData()); 
	    } 
}
