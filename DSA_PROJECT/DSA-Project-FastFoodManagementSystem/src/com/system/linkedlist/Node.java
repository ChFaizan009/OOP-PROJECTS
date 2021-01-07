package com.system.linkedlist;

public class Node {
	
	int id;
	int amount;
	int price;
	int totalPrice;
	String itemName;
	Node next;
	
	public Node() {
	}
	
	public Node(int id, int amount, int price, int totalPrice, String itemName) {
		this.id = id;
		this.amount = amount;
		this.price = price;
		this.totalPrice = totalPrice;
		this.itemName = itemName;
		this.next = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
}
