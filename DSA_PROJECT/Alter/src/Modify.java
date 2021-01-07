
public class Modify
{
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
			else {
				Node temp=head;
				System.out.println("Enter the old id of product : ");
				while(!scan.hasNextInt()) {
					System.out.println("Invalid Product Id !");
					System.out.println("Enter the Product Id : ");
					scan.next();
				}
				old_id=scan.nextInt();
				
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
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("---------- \t\tProduct Detail is Modified \t\t--------");
				System.out.println("-------------------------------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Sorry an error occured! You can't Modify Product.");
	
		}
		
	}

	

	
	
	public void Modify() throws Exception{
		try {
			int old_id;
			int new_id = 0;
			double price = 0;
			int qty;
			int pos=0;
			if(head==null) {
				System.out.println("Product list is empty!");
			}
			
			else  {
				
				Node temp=head;
				System.out.println("Enter the old id of product : ");
				while(!scan.hasNextInt()) {
					System.out.println("Invalid Product Id !");
					System.out.println("Enter the Product Id : ");
					scan.next();
				}
				old_id=scan.nextInt();
				if (old_id==temp.id)
				{
				
				
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
				}
				
					else
					 {
						    	System.out.println(" The Given Id is Not found. Please Enter Again\n\n");
						Modify();
						administrator();
				}
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
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("---------- \t\tProduct Detail is Modified \t\t--------");
				System.out.println("-------------------------------------------------------------------------");
			
			}
			
			
			
		}
		catch (Exception e) {
			
			// TODO: handle exception
			System.out.println("Sorry an error occured! You can't Modify Product.");
	
		}
		
	}
	
	
	
}
