package com.linkedList;


public class Node
{

	int DATA;
	Node NEXT;
	
	public Node() {
	}

	public Node(int DATA) {
		this.DATA = DATA;
		NEXT = null;
	}
	
	public Node(int DATA, Node NEXT) {
		this.DATA = DATA;
		this.NEXT = NEXT;
	}

	public int getDATA() {
		return DATA;
	}

	public void setDATA(int DATA) {
		this.DATA = DATA;
	}

	public Node getNEXT() {
		return NEXT;
	}

	public void setNEXT(Node NEXT) {
		this.NEXT = NEXT;
	}
	
}
