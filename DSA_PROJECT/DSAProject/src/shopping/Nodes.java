package shopping;

import Stacks.Stack;
import Stacks.Main;
import java.util.Scanner;

import cust.CustomerMenu;

import java.util.HashMap;

public class Nodes {

	
	int ID;
	
	String Pro_Name;
	
	double Pro_Price;
	
	int Quantity;
    
	Nodes next;
    
	static Nodes head=null;


	static Scanner sc= new Scanner(System.in);
	

	public static void ClearingScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println( 
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tSHOPPING MANAGEMENT SYSTEM\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}
	
	
	
	
 public static void beg()
{

	 int id,quant;           
		String name;
	    double price;           
	    Nodes t=new Nodes();
	    Nodes p=head;
        System.out.println("\t\t\tEnter Product ID:-");  
        id=sc.nextInt();
        t.ID=id;
        
        System.out.println("\t\t\tEnter Product Name:-");  
        name=sc.nextLine();
        name+=sc.nextLine();
        t.Pro_Name=name;
	
        System.out.println("\t\t\tEnter Product Price:-");  
        price=sc.nextDouble();
        t.Pro_Price=price;
	
        System.out.println("\t\t\tEnter Product Quantity:-");  
        quant=sc.nextInt();
        t.Quantity=quant;
	
	if(head==null)
	{
	t.next=head;
	head=t;
	}
	else
	{
		while(p.next!=null)
    {
		p=p.next;
                        }
        p.next=t;
        t.next=null;
		
	}	
	
    System.out.println("\n\n\t\t\t\tThis product is Inserted!\n\n\n");

	}
 
 
 public static int search(int id)                     //    for search item in list
 {
 	int count=1;
 	 Nodes p=head;
 	while(p!=null)
 	{
 		if(p.ID==id)
 			break;
 		else
 			count++;
 			p=p.next;
	}
 	return count;
 }
 
 public static int hash(int x, int mod)
{
	return x % mod;

}

 
 public static void deletePro()
	{
		
		display();
		int id;
		Nodes cur=head;
		Nodes pre=head;
		System.out.println("\n\nEnter ID to delete that product:\n\n");
		id=sc.nextInt();
		
		 if (head == null)
 {
 	
			 System.out.println("List is empty");
 }
	int pos=0;
	int count=display();               //   for load no of Nodess
	pos=search(id);                        //   for check weather desire Nodes is exist or not
	if(pos<=count){

		while(cur.ID!=id){                //  for delete middle area products
			pre=cur;
			cur=cur.next;
}
		pre.next=cur.next;
		
		System.out.println("\n<<item is deleted>>\n");
	}
	else
	{
		System.out.println("\n<<<Not found>>\n\n");
	}
	}

//////////////////////////////////////////////////////////////////////////////////


	public static void modify()
	{
		int id;
		double pre;        //    pre for price
		String pName;
		int N_Id; int N_Quan;     //   pName for new name
		if (head == null)
 {
 	
			System.out.println("Product list is empty!");
 }
      else
	{    
	    display();
	    System.out.println("\n\nEnter ID to modify Product Name and its Price:\n");
	    id=sc.nextInt();
		Nodes cur=head;
		int pos=0;
		int count=display();               //   for load no of Nodess
	    pos=search(id);
	                            //   for check weather desire Nodes is exist or not
	    if(pos<=count)
 {
		while(cur.ID!=id)
     {
			cur=cur.next;
		}
		System.out.println("\nOld ID : "+cur.ID);
		System.out.println("\nOld Name : "+cur.Pro_Name);
		System.out.println("\nOld Price : "+cur.Pro_Price);
		System.out.println("\nOld Quantity : "+cur.Quantity);
		
		
		System.out.println("Enter New ID :");
		N_Id=sc.nextInt();
	    cur.ID=N_Id;
		
	    System.out.println("Enter New Name :");
		pName=sc.nextLine();
		pName+=sc.nextLine();
	    cur.Pro_Name=pName;
		
		System.out.println("Enter New Price :");
		pre=sc.nextDouble();
	    cur.Pro_Price=pre;
	    
		
		System.out.println("Enter New Quantity :");
		N_Quan=sc.nextInt();
	    cur.Quantity=N_Quan;
	    
		}

	    else
 {
	    	System.out.println(id+" is <<<Not found>>\n\n");
	}
	    
	}
		
}
	
//////////////////////////////////////////////////////////////////////////////////////

public static int display()
{

int c=0;             //   c for count products
   Nodes p=head;
   System.out.println("Existing products are:\n");
   System.out.println("ID\t\t Product Name\t\t  Price\t\t Quantity");
 
   System.out.println("=================================================================|\n");
   
   
while(p!=null)
{
	System.out.println(p.ID+"\t\t"+p.Pro_Name+"\t\t\t"+p.Pro_Price+"\t\t\t"+p.Quantity); //    call   check func and pass quantity
    
	// Real Value System.out.println(p.ID+"\t\t"+p.Pro_Name+"\t\t\t"+p.Pro_Price+"\t\t\t"+check(p.Quantity)); //    call   check func and pass quantity
    
	p=p.next;
    c=c+1;
}
System.out.println("\nTotal products in our store is : "+c+"\n\n\n");
return c;
}
////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////
 public static void buy()
{
		display();
		
		String products[]=new String[20];
		int no,c=0,id,i=1;
		double pay = 0,price;
		if(head==null) {
			System.out.println("There is no items to buy!\n");
			
		}else {
			System.out.println("How many item you want to buy ?");
			no=sc.nextInt();
			//To store no of nodes in c variable
			int count=display();
			while(i<=no) {
				Nodes current=head;
				 //   quant   for quantity  and cho for choice
				int quant,cho;  
				label:
				System.out.println("Enter the id of the item you wanna buy : ");
				 int pos=0;
				id=sc.nextInt();
				if(id==-1) {
					return;
					
				}
				pos=search(id);
				if(pos<=count) {
					while(current.ID!=id) {
						current=current.next;
						
					}
					System.out.println("How many quantity you want :  ");
					quant=sc.nextInt();
					
					if(current.Quantity<quant) {
						System.out.println("\\n\\t\\t\\t----The Quantity You Entered is not available---");
						System.out.println("\\n\\t\\t\\t-----(Press -1 for Back to Main Menu)------");
						break
						;
					}
					// this will conatin the items buy names in array; 
					products[c]=current.Pro_Name;
					c++;
					pay=pay+(current.Pro_Price * quant);
					current.Quantity=current.Quantity-quant;
					i++;
				}else {
					
					System.out.println("\n<<<<<<<<<This item is not available in our store at this time>>>>\\n\\n");
				
				}
			}
			String costumer;
			System.out.println("Enter your name : ");
			costumer=sc.next();
			enqueue(costumer);
			System.out.println("      ");
			System.out.println(" ||=============================================|| ");
			
			System.out.println("      ");
			 //    show that item you have bought
			for(int j=0;j<no;j++) {
				System.out.println("Product Name : "+products[j]);
				
			}
			
			 //    with 10% discount
			price=pay*0.90;
			System.out.println("Original price : "+pay);
			System.out.println("With 10% discount : "+price);
			System.out.println("Thank you! for shopping  keep visiting us");
		}

	 
	 
	 
	 

}
 
 
	public static void administator()
	{
			int ch;

			Scanner sc=new Scanner(System.in);

	do {

           //            choice for below message



	System.out.println("\t\t============================================");
	System.out.println("\t\t|          Administator Portal              |");
	System.out.println("\t\t============================================");

	System.out.println("\t\t     Enter 1 for ADD a new product    ");
	System.out.println("\t\t     Enter 2 to display all products   ");
	System.out.println("\t\t     Enter 3 for MODIFY Existing product");
	System.out.println("\t\t     Enter 4 for Delete a particular product item");
	System.out.println("\t\t     Enter 5 for Customers List ");
	System.out.println("\t\t     Enter 6 for Dequeue customer");
	System.out.println("\t\t     Enter 7 for Generate hash");
	System.out.println("\t\t     Enter 0 for Main Menu");


	System.out.println("\nEnter Your choice >>>");
	ch=sc.nextInt();
	ClearingScreen();
	switch(ch){
	case 1:
		ClearingScreen();
		beg();
	
	break;
case 2:
	ClearingScreen();
display();

break;
case 3:
	ClearingScreen();
	modify();
	
	break;
case 4:
	ClearingScreen();
	deletePro();
	System.out.println("\n-------Product is Deleted-------\n");
	break;
case 5:
	  
	System.out.println("|============CUSTOMERS NAMES LIST==============|");
	ClearingScreen();
	displayQueue();
	   break;
case 6:
	   
	System.out.println("|============CUSTOMERS NAMES LIST==============|");
	ClearingScreen();
	dequeue();
	  displayQueue();
     
	 break;
case 7:
       int x,n;
       System.out.println("Enter element to generate hash = ");
		x=sc.nextInt(); 
       System.out.println("Of total list number : ");
       n=sc.nextInt();
    System.out.println("Hash of "+ x + " is = " + hash(x,n));
    break;




	}
}
while(ch!=0)	;
}
	
	












public static void main(String [] args) throws Exception {
	{

 for(int i=0;i<=51;i++)
	     {
	     
	     	//push(i);
		 }


			
		gotoxy(17,5);
        System.out.println("--------------------------------------------------");
		gotoxy(17,7);
		System.out.println("||            Shopping Club System                ||");
		gotoxy(17,9);
		System.out.println("--------------------------------------------------");
	   	gotoxy(17,11);
	   	System.out.println("|Subject Teacher ->> Mam Ayesha <<-- |\n");
	   	gotoxy(17,13);
	   	System.out.println(">>>----Project Implemented By-----<<<");
	    gotoxy(22,15);
	    System.out.println("Faizan Ahmed (19011519-009)");
	   	gotoxy(22,16);
	   	System.out.println("Bilal Ahmed  (19011519-007)");
	   	gotoxy(22,17);
	   	System.out.println("Saddam Khalid (19011519-029)");
	   	
	    int ch = 0;
		while(ch!=3){
		
		                     //            choice for below message

			System.out.println("\n\t\t|--------<Main Menu>-----------|");
			System.out.println("\n\n");
			System.out.println("\t\t 1)Administator of Market\n");
			System.out.println("\t\t 2)Customer               \n");
			System.out.println("\t\t 3)Exit                    \n");


			System.out.println("\nEnter Your choice >>>");
		ch=sc.nextInt();
		ClearingScreen();
		switch(ch){
		case 1:


			administator();
			ClearingScreen();
			break;
			
		case 2:
			
			
//				bpop();
			
			System.out.println("----------------------");
		    buy();
		    ClearingScreen();
		    break;
		   
	    case 3:
	    	System.out.println("\n\n\t\t\t\t\tThank You\t\t\t\t");
	    	ClearingScreen();
	    	break;
	    	
		}}}	
// TODO Auto-generated method stub
	
	}

//-------------------------------------ENQEUE AND QUEUE



 
	String C_Name;

     Nodes link;


    static Nodes front = null;
    static Nodes rear = null;

//Function to check if queue is empty or not
       public static boolean isempty()

       {

    	   if(front == null && rear == null)

    		   return true;
 
    	   else
    		   
 
    		   return false;
}

//function to enter elements in queue
       public static void enqueue (String name )
{
 Nodes ptr = new Nodes();
 ptr.C_Name= name;
 ptr.link = null;

 //If inserting the first element/Nodes
 if( front == null )
 {
  front = ptr;
  rear = ptr;
 }
 else
 {
  rear.link = ptr;
  rear = ptr;
 }
}

//function to delete/remove element from queue
    public static void dequeue( )
{
 if( isempty() )
 System.out.println("Queue is empty\n");
 else
 //only one element/Nodes in queue.
 if( front == rear)
 {
	 freeMemory(front);
  front = rear = null;
 }
 else
 {
  Nodes ptr = front;
  front = front.link;
  freeMemory(ptr);
 }
}




//function to show the element at front

    private static void freeMemory(Nodes ptr) {
		// TODO Auto-generated method stub
		
	}


	public static void showfront( )
{
 if( isempty())
	 System.out.println("Queue is empty\n");
 else
	 System.out.println("Element at front is:"+front.C_Name+"\n");
}

//function to display queue

    private static void displayQueue()
{  
 if (isempty())
	 System.out.println("Queue is empty\n");
 else
 {
  Nodes ptr = front;
  while( ptr !=null)
  {
	  System.out.println("\t"+ptr.C_Name+"\t  ");
   ptr= ptr.link;
  
  }
 }
}

		
   //--------------------Animation
   
   
   
   
   
   

int[] coord = {0, 0};
public static void gotoxy(int x, int y)
{
//	 class COORD
//	 {
//		 int X;
//	     int Y;	 
//	 }
//	 
//	COORD coord =null;
// coord.X = x;
// coord.Y = y;
//
 

}
/////////////////////////////////////////////////////////////////////////////////
void animation() throws InterruptedException
{
	for (int i=45; i>=1; i--)
	{
		Thread.sleep(30);
		gotoxy(1,i);
		//clreol();
	}
	for (int i=1; i<=20; i++)
	{
		//clreol();
		Thread.sleep(40);
		gotoxy(1,i);
	}
   

   
	
 }}