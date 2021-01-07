
public class LinkedList
{

	private int Size;
	private Node Start;
	
	public LinkedList()
	{
	Size=0;
	Start=null;
	}

	

	public boolean IsEmpty()
	{
		if(Start==null)
			return(true);
		else
			return (false);
	}

	
	
	public int getListSize() {
		return (Size);
	}

    public void viewList()
    {
    	Node n;
    	if(IsEmpty())
    		System.out.println("List is Empty");
    	else
    	{
    	n=Start;	
    	for(int i=1;i<=Size;i++)
    	{
    		System.out.println(" "+n.getData());
    		n=n.getNext();	
    	}
    	
    }}

    public void insertAtFirst(int val)
    {
    	Node n;
    	n=new Node();
    	n.setData(val);
    	n.setNext(Start);
    	Start=n;
    	Size++;
    }

public void insertAtLast(int val)
{
	Node n,t;
	n=new Node();
	n.setData(val);
     t=Start;
	if(t==null)
		Start=n;
	else
		while(t.getNext()!=null)
		{
			t=t.getNext();
			t.setNext(n);
		}
	Size++;
}

 public void insertAtPos(int val,int pos)
 {
	 if(pos==1)
		 insertAtFirst(val);
	 else if
		 (pos==Size+1)
		 insertAtLast(val);
	 else if(pos>1 && pos<=Size)
	 {
		 Node n,t;
		 n=new Node();
		 t=Start;
		 for(int i=1;i<pos-1;i++)
		 {
			 t.getNext();
			 t.setNext(t.getNext());
			 t.setNext(n);
			 Size++;
			 }
	 }
	 else
		 System.out.println("Invalid Position ");
 }

 
   public void deleteFirst()
   {
	   if(Start==null)
	   {
		   System.out.println("List is Empty");
	   }
	   else
	   {
		   Start=Start.getNext();
		   Size--;
	   }
   }
   
   public void deleteLast()
   {
	   if(Start==null)
	   {
		   System.out.println("List is Empty");
		   
	   }
	   else if (Size==1)
	   {
		   Start=null;
		   Size--;
	   }
	   else
	   {
		   Node t;
		   t=Start;
		   for(int i=1;i<Size-1;i++)
		   {
			   t=t.getNext();
			   t.setNext(null);
			   Size--;
		   }
	   }
   }
   
   public void DeletePos(int Pos)
   {
	    
	    if(Pos<1 || Pos>Size)
	   System.out.println("Invalid Post");
	   else if(Pos==1)
		   deleteFirst();
	   else if(Pos==Size)
		   deleteLast();
	   else
	   {
		   Node t,v;
		   t=Start;
		   for(int i=1;i<Pos-1;i++)
		   {
			   t=t.getNext();
			   v=t.getNext();
			   t.setNext(t.getNext());
			   Size--;
		   }
	   }
	   
   }
   
   
   
}
	
    