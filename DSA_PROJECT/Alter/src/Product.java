import shopping.Nodes;


public class Product {

	
	CMethod costum=new CMethod();
	Scanner scan=new Scanner(System.in);
	Node head;
	public void addProduct() {
		Node node=new Node();
		int id;
		String name;
		double price;
		int quantity;
		Node temp=head;
		System.out.println("Enter product Id : ");
		id=scan.nextInt();
		node.id=id;
		System.out.println("Enter product Name : ");
		name=scan.next();
		node.name=name;
		System.out.println("Enter product Price :" );
		price=scan.nextDouble();
		node.price=price;
		System.out.println("Enter the Quantity : ");
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
		System.out.println("****************");
		
	}
	public int Display() {
		Node temp=head;
		int count=0;
		if(head==null) {
			System.out.println("No product is in the shop!");
		}else {
		System.out.println("List of Product : ");
	
		System.out.println("Id \t\tProduct Name\t\tPrice\t\tQuantity\n");
		while(temp!=null) {
			System.out.println(temp.id+"\t\t"+temp.name+"\t\t\t"+temp.price+"\t\t"+temp.quantity);
			temp=temp.next;
			count=count+1;
		}
		
		System.out.println("Total product in store are : "+count);
		}
		return count;
	}
	public void Modify() {
		int old_id;
		int new_id;
		double price;
		int qty;
		int pos=0;
		if(head==null) {
			System.out.println("Product list is empty!");
		}
		else {
			Node temp=head;
			System.out.println("Enter the old id of product : ");
			old_id=scan.nextInt();
			System.out.println("Enter the new id of product : ");
			new_id=scan.nextInt();
			System.out.println("Enter the new price of product : ");
			price=scan.nextDouble();
			System.out.println("Enter the new quantity for product : ");
			qty=scan.nextInt();
			while(temp!=null) {
				if(temp.id==old_id) {
					temp.id=new_id;
					temp.name=temp.name;
					temp.price=price;
					temp.quantity=qty;
				}
				temp=temp.next;
				pos++;
				
			}
		}
	}
	public void DeleteProduct() {
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
			while(temp.id!=id) {
				curr=temp;
				temp=temp.next;
			}
			curr.next=temp.next;
			System.out.println("Product is deleted.");
			
		}else {
			System.out.println("Product is not found!");
		}
		
	
	}
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
	public int hash(int x,int mod) {
		return x % mod;
	}
	
	public void buy() {
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
				int quant,cho;  
				label:
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
					quant=scan.nextInt();
					
					if(current.quantity<quant) {
						System.out.println("\\n\\t\\t\\t----The Quantity You Entered is not available---");
						System.out.println("\\n\\t\\t\\t-----(Press -1 for Back to Main Menu)------");
						break label;
					}
					// this will conatin the items buy names in array; 
					products[c]=current.name;
					c++;
					pay=pay+(current.price * quant);
					current.quantity=current.quantity-quant;
					i++;
				}else {
					
					System.out.println("\n<<<<<<<<<This item is not available in our store at this time>>>>\\n\\n");
				
				}
			}
			String costumer;
			System.out.println("Enter your name : ");
			costumer=scan.next();
			costum.Enqueue(costumer);
			System.out.println("      ");
			System.out.println("      ");
			System.out.println("      ");
			 //    show that item you have bought
			for(int j=0;j<no;j++) {
				System.out.println(products[i]+" ");
				
			}
			
			 //    with 10% discount
			price=pay*0.90;
			System.out.println("Original price : "+pay);
			System.out.println("With 10% discount : "+price);
			System.out.println("Thank you! for shopping  keep visiting us");
		}
	}
	
	public void administrator() {
		int choice;
		do {
			System.out.println("****************");
			System.out.println("***       Administator Portal     ****");
			System.out.println("****************");
			System.out.println("1. To ADD  New Product  ");
			System.out.println("2. To Display All Products ");
			System.out.println("3. To Modify Existing Product");
			System.out.println("4. To Delete a Particular Product ");
			System.out.println("5. Display List of Customers");
			System.out.println("6. Dequeue Customer");
			System.out.println("7. Generate Hash");
			
			System.out.println("Enter Your Choice :- ");
			choice=scan.nextInt();
			switch(choice) {
			case 1:
				addProduct();
				break;
			case 2:
				Display();
				break;
			case 3:
				Modify();
				break;
			case 4:
				DeleteProduct();
				System.out.println("Product is Deleted!");
				break;
			case 5:
				System.out.println("**** Costumers Name List ***");
				costum.displayQueue();
				break;
			case 6:
				System.out.println("**** Costumers Name List ***");
				costum.Dequeue();
				costum.displayQueue();
			case 7:
				int n,x;
				System.out.println("Enter element to generate hash : ");
				x=scan.nextInt();
				System.out.println("Total list number : ");
				n=scan.nextInt();
				System.out.println("Hash of "+ x+" is = "+hash(x,n));
				break;
				
				default:
					System.out.println("Sorry!");
				
			}
		}while(choice!=0);
	}
	

}















////////////////////////




display();
//String product[20];
String products[]= {"20"};
double pay=0;
// for display sold items
int no,c=0,id,i=1;
double price;

if(head==null)
{
System.out.println("\n<<<<There is no items to buy>>>>\n\n");
}
else
{
	System.out.println("How many items you wanna to buy!\n");
   no=sc.nextInt(); 

   
   int count=display();           //   for store no of Nodess  in c
    while (i<=no)
  {
  Nodes cur=head;
  int quant,cho; //   quant   for quantity  and cho for choice 
outer:          
  	System.out.println("Enter id of item that you want to buy : ");
      int Id,pos=0;
      Id=sc.nextInt(); 

   if(Id==-1){
	   return;
	 }
   pos=search(Id);
  if(pos<=count)
{
//   item is available in store

  	
  	while(cur.ID!=Id)

  	{
        cur=cur.next;
}
  	System.out.println("How many quantities you want :");
  	quant=sc.nextInt();
  	
if(cur.Quantity<quant)
{
	System.out.println("\n\n\t\t\t----The Quantity You Entered is not available---");
	System.out.println("\n\t\t\t-----(Press -1 for Back to Main Menu)------");
 
	 break;	
}

products[c]=cur.Pro_Name;   // this will conatin the items buy names in array; 
c++;   

pay=pay+(cur.Pro_Price*quant);         //     calculate Bill
cur.Quantity=cur.Quantity-quant;           //    change quantity
i++;

}
else
{    

System.out.println("\n<<<<<<<<<This item is not available in our store at this time>>>>\n\n");

}
}
  String Customer;
  System.out.println("\n\t\t Enter Your Name :");
  Customer=sc.nextLine();
  enqueue(Customer);

System.out.println("\n\n\n\n\t\t\tYou have bought : ");
for(int j=0;j<no;j++)
{              //    show that item you have bought
	System.out.println(products[j]+",");
}

price=pay*(0.90);           //    with 5% discount
System.out.println("\n\nOriginal price : "+pay);
System.out.println("\n with 10% discount: "+price+"\nThank you! for the shopping\n\n");




}
