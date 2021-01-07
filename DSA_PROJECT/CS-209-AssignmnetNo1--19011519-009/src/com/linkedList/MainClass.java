package com.linkedList;



public class MainClass {
	

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(15);
		list.add(25);
		list.add(35);
		list.add(45);
		list.add(55);
		int get = list.get(4);
		System.out.println("The output is : " + get);
		list.getAll();
		
		
	}

}
