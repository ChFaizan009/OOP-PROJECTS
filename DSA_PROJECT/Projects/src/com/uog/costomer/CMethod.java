package com.uog.costomer;

public class CMethod {
	
	CNode  front=null;
	CNode rear=null;
	
	
	public void Enqueue(String name) {
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
	}
	
	
	public void Dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty!");
		}else {
			if(front==rear) {

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
			System.out.println("List is empty! ");
		}else {
			temp=front;
			System.out.println("Costumers are : ");
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
			System.out.println("Element at front is "+front.cname);
		}
	}

	public boolean isEmpty() {
	   return	front==null && rear==null;
			
	
	}

}
