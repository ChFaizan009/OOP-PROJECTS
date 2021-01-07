package com.assignment.linkedlist;

public class LinkedListClass {
	Node head;
	int count;

	public LinkedListClass(Node newHead) {
		head = newHead;
		count = 1;
	}

	public LinkedListClass() {
		head = null;
	}

	public void add(int newData) {
		Node temp = new Node(newData);
		if(head == null) {
			head = temp;
		}else {
			Node current = head;
			while(current.getNext()!=null) {
				current = current.getNext();	
			}
			current.setNext(temp);
		}
		count++;
	}

	public int get(int index) {
		if(index<=0) {
			return -1;
		}
		Node current = head;
		for(int i=1 ; i < index ; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	public void getAll() {
		Node current = head;
		for(int i=1 ; i <= count ; i++) {
			System.out.println("Data is: " + current.getData());
			current = current.getNext();
		}
	}
}
