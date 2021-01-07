package com.assignment.linkedlist;

public class Node {
	
	int data;
	Node next;
	Node previous;
	
	public Node() {
	}

	public Node(int data) {
		this.data = data;
		next = null;
		previous = null;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
}
