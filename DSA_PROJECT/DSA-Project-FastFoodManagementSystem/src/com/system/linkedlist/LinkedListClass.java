package com.system.linkedlist;

public class LinkedListClass {
	Node head;
	Node tail; 
	int count;

	public LinkedListClass(Node newHead) {
		head = newHead;
		count = 0;
	}

	public LinkedListClass() {
		head = null;
	}

	
	public void add(int id, int amount, int price, int totalPrice, String itemName) {
		Node temp = new Node(id, amount, price, totalPrice, itemName);
		if(head == null) {
			head = temp;
		}else {
			Node current = head;
			while(current.getNext()!=null) {
				current = current.getNext();	
			}
			current.setNext(temp);
			tail = temp;
		}
		count++;
	}


	public Node get(int Id) {
		Node current = head;
		Node node = null;
		if(Id<0) {
			return null;
		}
		while(current.getNext() != null) {
			if(current.getId() != Id) {
				current = current.getNext();
			}else if(current.getId() == Id) {
				return current;
			}
		}
		return node;
	}

	public Integer getBill() {
		Node current = head;
		Integer bill = 0;
		while(current != null) {
			bill += current.getTotalPrice();
			current = current.getNext();
		}
		return bill;
	}
	
	public String getIds() {
		Node current = head;
		String ids = "";
		while(current != null) {
			ids += current.getId()+",";
			current = current.getNext();
		}
		return ids.substring(0, ids.length()-1);
	}
	
	public String getNames() {
		Node current = head;
		String names = "";
		while(current != null) {
			names += current.getItemName()+", ";
			current = current.getNext();
		}
		return names.substring(0, names.length()-2);
	}
	
	public void searchByData(int data) {
		int counter = 0;
		if(head == null) {
			System.out.println("List is empty");
			return ;
		}else {
			Node current = head;
			while(current != null) {
				if(current.getId() == data) {
					System.out.println("Same Data:"+data+" Has been found at location " +counter);
				}
				current = current.getNext();
				counter++;
			}
		}
	}

	public void getAll() {
		if(head == null) {
			System.out.println("no value ");
			return ;
		}
		Node current = head;
		while(current != null) {
			System.out.println(current.getId()+ " "+current.getItemName()+" "+current.getAmount()+" "+current.getPrice()+" "+current.getTotalPrice());
			current = current.getNext();
		}
		System.out.println();
	}
	
	public int getCount() {
		return count++;
	}
}

/*
 * 
	public void delAtIndex(int index) {
		Node current = head;
		Node prev = null;
		if(head == null) {
			System.out.println("List is empty");  
			return;
		}else if(index == 0){
		}else if(index > count) {
			System.out.println("index exceeds Linked list size enter again ");
			return ;
		} else {
			for(int i=0 ; i<index ; i++) {
				prev = current;
				current = current.getNext();
			}		
			prev.next = current.next;
		}
		count--;
	}
 * 
 *
 *		public void valueUpdateAtIndex(int index, int data) {
		Node current = head;
		if(head == null) {
			System.out.println("List is empty");
			return ;
		} else if(index == 0){
			head.setId(data);
		}else {
			for(int i=0 ; i<index ; i++) {
				current = current.getNext();
			}
			current.setId(data);			
		}
	}

	public void valueUpdateByData(int dataValue , int newValue) {
		if(head == null) {
			System.out.println("List is empty");
			return ;
		}else {
			Node current = head;
			while(current != null) {
				if(current.getId() == dataValue) {
					current.setId(newValue);
				}
				current = current.getNext();
			}
		}
	}

 */