
import java.util.Scanner;
import java.lang.Math;

import java.io.IOException;
import com.uog.project.costumer.*;
public class ProductMethod {
	
	CMethod costum=new CMethod();
	Scanner scan=new Scanner(System.in);
	Node head;
	@SuppressWarnings("resources")
	
	/////////////////////////////////////////
	////////  Add Product Method  //////////
	///////////////////////////////////////
	public void addProduct() throws Exception{
	
		try {
			Node node=new Node();
			
			int id;
			String name;
			double price;
			int quantity;
			Node temp=head;
			System.out.println("Enter Product Id : ");
			while(!scan.hasNextInt()) {
				System.out.println("Invalid Product Id !");
				System.out.println("Enter the Product Id : ");
				scan.next();
			}
			id=scan.nextInt();
			node.id=id;
			System.out.println("Enter Product Name : ");
			while(!scan.hasNext("[A-Za-z]+")) {
				System.out.println("Invalid Name ");
				System.out.println("Enter Product Name : ");
				scan.next();
			}
			name=scan.next();
			node.name=name;
			System.out.println("Enter Product Price :" );
			while(!scan.hasNextDouble()) {
				System.out.println("Invalid Price : ");
				System.out.println("Enter Product Price");
				scan.next();
				
			}
			price=scan.nextDouble();
			node.price=price;
			System.out.println("Enter the Quantity : ");
			while(!scan.hasNextInt()) {
				System.out.println("Invalid Quantity !");
				System.out.println("Enter the Quantity : ");
				scan.next();
			}
			quantity=scan.nextInt();
			node.quantity=quantity;
			
			node.next=null;
			if(head==null) {
				head=node;
			
			}else {
				temp=head;
				while(temp.next!=null) {
					temp=temp.next;
				}
				temp.next=node;
			}
		
			System.out.println("The product is inserted : ");
			System.out.println("**********************************************");
			
		} catch (Exception e) {
			System.out.println("Sorry! you can't insert a product!");
		
		}
			
		} 

	     //////////////////////////////////////////////
		 ////////  Display Products Method  //////////
		//////////////////////////////////////////////
		
	public int Display() throws Exception{
		int count=0;
		try {

			Node temp=head;
		
			if(head==null) {
				System.out.println("Product list is empty!");
			}else {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("------\t\tList of Product :             -------");
		
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Id \t\tProduct Name\t\tPrice\t\tQuantity");
			System.out.println("-------------------------------------------------------------------------\n");
			while(temp!=null) {
				System.out.println(temp.id+"\t\t"+temp.name+"\t\t\t"+temp.price+"\t\t"+temp.quantity);
				temp=temp.next;
				count=count+1;
			}
			
			System.out.println("Total product in store are : "+count);
			System.out.println("-------------------------------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("An error occured while openeing list of products.");
		}
		return count;
	}

	
	
	public void Modify() throws Exception{
		try {
			int old_id;
			int new_id;
			double price;
			int qty;
			int pos=0;
			if(head==null) {
				System.out.println("Product list is empty!");
			}
			else if(head!=null) {
				Node temp=head;
				System.out.println("Enter the old id of product : ");
				while(!scan.hasNextInt()) {
					System.out.println("Invalid Product Id !");
					System.out.println("Enter the Product Id : ");
					scan.next();
				}
				old_id=scan.nextInt();
				
				while(temp!=null) {
					if(temp.id==old_id) {
						System.out.println("Enter the new id of product : ");
						while(!scan.hasNextInt()) {
							System.out.println("Invalid Product Id !");
							System.out.println("Enter the Product Id : ");
							scan.next();
						}
						new_id=scan.nextInt();
						System.out.println("Enter the new price of product : ");
						while(!scan.hasNextDouble()) {
							System.out.println("Invalid Price : ");
							System.out.println("Enter Correct Price");
							scan.next();
							
						}
						price=scan.nextDouble();
						System.out.println("Enter the new quantity for product : ");
						while(!scan.hasNextInt()) {
							System.out.println("Invalid Quantity !");
							System.out.println("Enter the Quantity : ");
							scan.next();
						}
						qty=scan.nextInt();
						temp.id=new_id;
						temp.name=temp.name;
						temp.price=price;
						temp.quantity=qty;
						System.out.println("-------------------------------------------------------------------------");
						System.out.println("---------- \t\tProduct Detail is Modified \t\t--------");
						System.out.println("-------------------------------------------------------------------------");
					}
					
					temp=temp.next;
					pos++;
					if(temp.id!=old_id) {
						System.out.println("No match is found");
						break;
					}
					
				}
			
				
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("");
	
		}
		
	}
	
	
/////////////////////////////////////////////////
///////// Modify Specific ///////////////
/////////////////////////////////////////////////

public void ModifySpecific() throws Exception {
try {
int old_id;
int new_id;
double price;
int qty;
int pos = 0;
if (head == null) {
System.out.println("Product list is empty!");
} else if (head != null) {
Node temp = head;
System.out.println("Enter the old id of product : ");
while (!scan.hasNextInt()) {
System.out.println("Invalid Product Id !");
System.out.println("Enter the Product Id : ");
scan.next();
}
old_id = scan.nextInt();

while (temp != null) {

if (temp.id == old_id) {
System.out.println("What you want to modify : ");
System.out.println("1.Product Id");
System.out.println("2.Product Name");
System.out.println("3.Product Price");
System.out.println("4.Product Quantity");
System.out.println("Enter Your Choice : ");
int choice = scan.nextInt();
if (choice == 1) {
System.out.println("Enter the new id of product : ");
while (!scan.hasNextInt()) {
System.out.println("Invalid Product Id !");
System.out.println("Enter the Product Id : ");
scan.next();
}
new_id = scan.nextInt();
temp.id = new_id;
temp.name = temp.name;
temp.price = temp.price;
temp.quantity = temp.quantity;
System.out.println(
"-------------------------------------------------------------------------");
System.out.println("---------- \t\tProduct Detail is Modified \t\t--------");
System.out.println(
"-------------------------------------------------------------------------");

}
if (choice == 2) {
System.out.println("Enter the new name of the Product : ");
String name = scan.nextLine();
while (!scan.hasNext("[A-Za-z]+")) {
System.out.println("Invalid Name ");
System.out.println("Enter Product Name : ");
scan.next();
}
name = scan.next();
temp.id = temp.id;
temp.name = name;
temp.price = temp.price;
temp.quantity = temp.quantity;
System.out.println(
"-------------------------------------------------------------------------");
System.out.println("---------- \t\tProduct Detail is Modified \t\t--------");
System.out.println(
"-------------------------------------------------------------------------");

}
if (choice == 3) {
System.out.println("Enter the new price of product : ");
while (!scan.hasNextDouble()) {
System.out.println("Invalid Price : ");
System.out.println("Enter Correct Price");
scan.next();

}
price = scan.nextDouble();
temp.id = temp.id;
temp.name = temp.name;
temp.price = price;
temp.quantity = temp.quantity;
System.out.println(
"-------------------------------------------------------------------------");
System.out.println("---------- \t\tProduct Detail is Modified \t\t--------");
System.out.println(
"-------------------------------------------------------------------------");

}
if (choice == 4) {
System.out.println("Enter the new quantity for product : ");
while (!scan.hasNextInt()) {
System.out.println("Invalid Quantity !");
System.out.println("Enter the Quantity : ");
scan.next();
}
qty = scan.nextInt();
temp.id = temp.id;
temp.name = temp.name;
temp.price = temp.price;
temp.quantity = qty;
System.out.println(
"-------------------------------------------------------------------------");
System.out.println("---------- \t\tProduct Detail is Modified \t\t--------");
System.out.println(
"-------------------------------------------------------------------------");

}
}

temp = temp.next;
pos++;
}

}

} catch (Exception e) {
// TODO: handle exception
System.out.println("");

}

}
	
	   
	
	////////////////////////////////////////////
			////////  Delete Product Method  ///////////
			///////////////////////////////////////////
	public void DeleteProduct() throws Exception{
		try {

			int id;
			System.out.println("Enter id of the product to delete from the list : ");
			id=scan.nextInt();
			Node temp=head;
			Node curr=head;
			if(head==null) {
				System.out.println("Product list is empty! ");
			}
			int pos=0;
			int count=Display();
			pos=search(id);
			if(pos<=count) {
				if(temp.id==id) {
					head=temp.next;
					
				}
				while(temp.id!=id) {
					curr=temp;
					temp=temp.next;
				}
				curr.next=temp.next;
				System.out.println("Product is deleted.");
				
			}else {
				System.out.println("Product is not found!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		
			System.out.println("An error occured! You can't delete the Product ! ");
			
		}
	
	}
		/////////////////////////////////////////
		//////// Search Product Method //////////
		///////////////////////////////////////
	public int search(int id) {
	int count=1;
	Node temp=head;
	while(temp!=null) {
		if(temp.id==id)
			break;
		else
			count++;
		temp=temp.next;
	}
	return count;
	}
	
	
		/////////////////////////////////////////
		////////  Buy Product Method  //////////
		///////////////////////////////////////
	public void buy() throws Exception {
		try {
			
			Display();
			String products[]=new String[20];
			int no,c=0,id,i=1;
			double pay = 0,price;
			if(head==null) {
				System.out.println("There is no items to buy!\n");
				
			}else {
				System.out.println("How many item you want to buy ?");
				no=scan.nextInt();
				//To store no of nodes in c variable
				int count=Display();
				while(i<=no) {
					Node current=head;
					 //   quant   for quantity  and cho for choice
					int quant ,cho;  
					
					System.out.println("Enter the id of the item you wanna buy : ");
				    int pos=0;
				    
					id=scan.nextInt();
					
					if(id==-1) {
						return;	
					}
					pos=search(id);
					if(pos<=count) {
						while(current.id!=id) {
							current=current.next;
							
						}
					
						System.out.println("How many quantity you want :  ");
						while(!scan.hasNextInt()) {
							System.out.println("Invalid Quantity !");
							System.out.println("Enter the Quantity : ");
							scan.next();
						}
						quant=scan.nextInt();
						
						label:
						if(current.quantity<quant) {
							System.out.println("\\n\\t\\t\\t----The Quantity You Entered is not available---");
							System.out.println("\\n\\t\\t\\t-----(Press -1 for Back to Main Menu)------");
							break label;
						}
						if(current.quantity==0) {
							System.out.println("Product is Out of Stock!");
						}
						// this will contain the items buy names in array;
						System.out.println("-------------------------------------------------------");
						products[c]=current.name;
						c++;
						pay=pay+(current.price * quant);
						current.quantity=current.quantity-quant;
						if(current.quantity<=0) {
							current.quantity=0;
						}
						i++;
					}else {
						
						System.out.println("\n<<<<<<<<<This item is not available in our store at this time>>>>\\n\\n");
					
					}
				}
				String costumer;
				
				System.out.println("Enter Your Name : ");
				while(!scan.hasNext("[A-Za-z]+")) {
					  System.out.println("Invalid Name!");
					  System.out.println("Enter Your Name : ");
					  scan.next();
				}
				
				costumer=scan.next();
				costum.Enqueue(costumer);
				
				System.out.println("      ");
				
				
				System.out.println("-------------------------------------------");
				System.out.println("-- Bill of : "+costumer+"\t\t\t--");
				 //    show that item you have bought
				for(int j=0;j<no;j++) {
					System.out.println("-- Product Name : "+products[j]+"\t\t\t-- ");
				}
				System.out.println("-- Original price : "+pay+"\t\t\t--");
	             //		  Price with 10% discount
				if(pay>7000) {
					
					price=pay*0.90;
					
					System.out.println("-- Price with 10% discount : "+Math.round(price)+"\t\t-- ");
					}
				System.out.println("---------------------------------------------------");
				
				System.out.println("Thank you!...keep visiting us!");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Sorry an error occured! You can't buy the Product ! ");
		
		}
		
	}
		/////////////////////////////////////////////////
		//////// Administrator Access Method  //////////
		///////////////////////////////////////////////
	
	public void administrator() throws Exception{
		try {
			

			int choice;
			do {
				System.out.println("**********************************************");
				System.out.println("*******       Administator Portal     ********");
				System.out.println("**********************************************");
				System.out.println("1. To ADD  New Product  ");
				System.out.println("2. To Display All Products ");
				System.out.println("3. To Modify Existing Product");
				System.out.println("4. To Delete a Particular Product ");
				System.out.println("5. Display List of Customers");
				System.out.println("6. Dequeue Customer");
				System.out.println("0. Main Menu");
				
				System.out.println("Enter Your Choice :- ");
				choice=scan.nextInt();
				switch(choice) {
				case 1:
					System.out.println("-------------------------------------------");
					System.out.println("------           Add Product         ------");
					System.out.println("-------------------------------------------");
					addProduct();

					System.out.println("\r");
					System.out.println("\f");
				//	System.out.print("\033[H\033[2J");  
				//	System.out.flush();
				//	Runtime.getRuntime().exec("cls");
					
					break;
				case 2:
					System.out.println("-------------------------------------------");
					System.out.println("------        Display Product        ------");
					System.out.println("-------------------------------------------");
					Display();
					System.out.println("\r");
					System.out.println("\f");
				//	Runtime.getRuntime().exec("cls");
				//	System.out.print("\033[H\033[2J");  
				//	System.out.flush();
					break;
				case 3:
					System.out.println("-------------------------------------------");
					System.out.println("------        Modify Product         ------");
					System.out.println("-------------------------------------------");
					System.out.println("What you want to modify : ");
					System.out.println("1. Whole Record");
					System.out.println("2. Specific Attribute");
					System.out.println("Enter Your Choice : ");
					int choi = scan.nextInt();
					if (choi == 1) {
						Modify();
					}
					if (choi == 2) {
						ModifySpecific();
					}				System.out.println("\r");
					System.out.println("\f");
				//	Runtime.getRuntime().exec("cls");
				//	System.out.print("\033[H\033[2J");  
				//	System.out.flush();
					break;
				case 4:
					System.out.println("-------------------------------------------");
					System.out.println("------        Delete Product         ------");
					System.out.println("-------------------------------------------");
					DeleteProduct();
					System.out.println("\r");
					System.out.println("\f");
				//	Runtime.getRuntime().exec("cls");
				//	System.out.print("\033[H\033[2J");  
				//	System.out.flush();
				
					break;
				case 5:
					System.out.println("-------------------------------------------");
					System.out.println("------          Costumer List        ------");
					System.out.println("-------------------------------------------");
					costum.displayQueue();
					System.out.println("\r");
					System.out.println("\f");
				//	Runtime.getRuntime().exec("cls");
				//	System.out.print("\033[H\033[2J");  
				//	System.out.flush();
					break;
				case 6:
					System.out.println("-------------------------------------------");
					System.out.println("------         Delete Costumer       ------");
					System.out.println("-------------------------------------------");
					costum.Dequeue();
					System.out.println("-------------------------------------------");
					System.out.println("------          Costumer List        ------");
					System.out.println("-------------------------------------------");
					costum.displayQueue();
					System.out.println("\r");
					System.out.println("\f");
				//	Runtime.getRuntime().exec("cls");
				//	System.out.print("\033[H\033[2J");  
				//	System.out.flush();
					break;
					
					default:
					System.out.println(" Your choice is invalid!");
					
				}
			}while(choice!=0);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("System is not working properly !");
			
		}
	}
	

}
