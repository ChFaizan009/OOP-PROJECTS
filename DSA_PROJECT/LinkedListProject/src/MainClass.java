import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
	LinkedList list=new LinkedList();
	boolean flag=true;
	while(flag) {
	System.out.println("1. Add Item to list at Start");
	System.out.println("2. Add Item to list at Last");
	System.out.println("3. Add Item to list at Specific Position");
	System.out.println("4. Delete Item to list at Start");
	System.out.println("5. Delete Item to list at Last");
	System.out.println("6. Delete Item to list at Specific Position");
	System.out.println("7. View List");
	System.out.println("8. Exist");
	System.out.println("Enter Your Choice");
	int pos,val;
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1 :
		System.out.println("Enter The Value of list item");
		val=sc.nextInt();
		list.insertAtFirst(val);
		break;
	case 2 :
		System.out.println("Enter The Value of list item");
		val=sc.nextInt();
		list.insertAtLast(val);
		break;
	case 3 :
		System.out.println("Enter Position ");
		pos=sc.nextInt();
		System.out.println("Enter The Value of list item");
		val=sc.nextInt();
		list.insertAtPos(val,pos);
		break;
		
	case 4 :
		System.out.println("Enter The Value of list item");
		val=sc.nextInt();
		list.deleteFirst();
		break;
	case 5 :
		System.out.println("Enter The Value of list item");
		val=sc.nextInt();
		list.deleteLast();
		break;
	case 6 :
		System.out.println("Enter Position ");
		pos=sc.nextInt();
		
		list.DeletePos(pos);
		break;
		
	case 7 :
		list.viewList();
		break;
	case 8 :
		flag=false;
		break;
		default :
		System.out.println("Invalid Choice");
	}
	}}

}
