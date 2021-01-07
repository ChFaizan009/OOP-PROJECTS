package com.uog.bucket;

public class MBucket {

	///We are using stack
	Bucket top;
	
	@SuppressWarnings("unused")
	public void push(int data) {
		Bucket temp = new Bucket();
		if(temp==null) {
			System.out.println("Heap underflow");
			System.exit(1);
		 }
		temp.data=data;
		temp.next=top;
		top=temp;
		
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println(top.data);
		}else
			System.exit(1);
	}
	
	public void bpop() {
		Bucket temp;
		if(top==null) {
			System.out.println("Stack underflow!...");
			System.exit(1);
		}else {
			temp=top;
			top=top.next;
			temp.next=null;
			temp=null;
			
		}
		System.out.println("Your Trolli No is : "+top.data);
		System.out.println("                  ___ ");
		System.out.println("                 /  |");
		System.out.println("  ______________/   --");
		System.out.println(" |___/__ /___/_|     ");
		System.out.println(" |__/___/___/__|     ");
		System.out.println(" |_/___/___/___|     ");
		System.out.println("    _______/         ");
		System.out.println("     O   O           ");
	}
	public void bdisplay() {
		Bucket temp;
		if(top==null) {
			System.out.println("Stack Underflow!..");
		}
		else {
			temp=top;
			while(temp!=null) {
				System.out.println(temp.data+" ");
				temp=temp.next;
			}
		}
	}
}

