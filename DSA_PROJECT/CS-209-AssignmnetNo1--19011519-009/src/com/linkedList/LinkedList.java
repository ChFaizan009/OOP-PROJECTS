package com.linkedList;

public class LinkedList 
{

	Node HEAD;
	int COUNT;

	public LinkedList(Node newHEAD) {
		HEAD = newHEAD;
		COUNT = 1;
	}

	public LinkedList() {
		HEAD = null;
	}

	public void add(int newData) {
		Node temp = new Node(newData);
		if(HEAD == null) {
			HEAD = temp;
		}else {
			Node current = HEAD;
			while(current.getNEXT()!=null) {
				current = current.getNEXT();	
			}
			current.setNEXT(temp);
		}
		COUNT++;
	}

	public int get(int index) {
		if(index<=0) {
			return -1;
		}
		Node current = HEAD;
		for(int i=1 ; i < index ; i++) {
			current = current.getNEXT();
		}
		return current.getDATA();
	}

	public void getAll() {
		Node current = HEAD;
		for(int i=1 ; i <= COUNT ; i++) {
			System.out.println("The Data are : " + current.getDATA());
			current = current.getNEXT();
		}
	}

}
