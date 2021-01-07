package com.uog.project.costumer;

public class CMethod {
	
	CNode  front=null;
	CNode rear=null;
	
	
	public void Enqueue(String name) {
		try {
			CNode node=new CNode();
			node.cname=name;
			node.link=null;
			if(front==null) {
				front=rear=node;
				
			}
			else {
				
				rear.link=node;
				rear=node;
			}
			System.out.println("||======================================================||");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No Costumer");
		}

	}
	
	
	public void Dequeue() {
		if(isEmpty()) {
			System.out.println("Costumer list is empty!");
		}else {
			if(front==rear) {
				front=null;
				front=rear=null;
				
			}else {
				CNode temp=front;
				front=front.link;
				temp=null;
			}
		}
	}
	public void displayQueue() {
		CNode temp;
		if(isEmpty()) {
			System.out.println("Costumer List is empty! ");
		}else {
			temp=front;
			System.out.println("List of Costumers : ");
			while(temp!=null) {
				
				System.out.println(temp.cname+"\t");
				temp=temp.link;
			}
		}
	}
	
	public void showFront() {
		if(isEmpty()) {
			System.out.println("Queue is empty!");
		}else {
			System.out.println("1st costumer is : "+front.cname);
		}
	}

	public boolean isEmpty() {
	   return	front==null && rear==null;
			
	
	}

}
