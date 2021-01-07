
public class Node {
	

 
	int id;
	String name;
	double price;
	int quantity;
	Node next;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", next=" + next
				+ "]";
	}
	
	
	
}