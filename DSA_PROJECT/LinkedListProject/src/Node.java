
public class Node
{

	private int Data;
	private Node Next;
	public Node() 
	{
		Data=0;
		Next=null;
	}
	
	public Node(int data, Node next) {
		
		Data = data;
		Next = next;
	}

	
	
	public int getData() {
		return Data;
	}

	public void setData(int data) {
		Data = data;
	}

	public Node getNext() {
		return Next;
	}

	public void setNext(Node next) {
		Next = next;
	}
	
	
	
	
	
}
