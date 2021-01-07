package com.assignment.linkedlist;

public class MainClass {
	
	public static void main(String[] args) {
		LinkedListClass list = new LinkedListClass();
		list.add(12);
		list.add(14);
		list.add(16);
		list.add(18);
		list.add(20);
		int get = list.get(3);
		System.out.println("GEt output: " + get);
		list.getAll();
		
		
	}

}
