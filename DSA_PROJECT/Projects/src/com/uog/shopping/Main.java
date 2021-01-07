package com.uog.shopping;
import com.uog.bucket.MBucket;
import com.uog.costomer.CMethod;
import com.uog.bucket.*;
import com.uog.costomer.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		ProductMethod obj=new ProductMethod();

		MBucket obj1=new MBucket();
		
		CMethod obj2=new CMethod();
		
		for (int i=0;i<60;i++) {
			obj1.push(i);
		}
		
		System.out.println("\t\t--------------------------------------------------");
		System.out.println("\t\t||          Shopping Management System          ||");
		System.out.println("\t\t--------------------------------------------------");
		System.out.println(" ");
		System.out.println("----------------------------------------------------");
		System.out.println("|| ==>>Instructor Name : Ayesha Rashid            ||");
		System.out.println("----------------------------------------------------");
		System.out.println(">>>----  Project Implemented By  -----<<<");
		System.out.println("-------  Bilal  Ahmed 19011519-007     -----");
		System.out.println("-------  Faizan Ahmed 19011519-009     -----");
		System.out.println("------- Saddam Khalid 19011519-029     ------"); 
		System.out.println("-----------------------------------------------------");
		int choice = 0;
		while(choice!=3) {
			System.out.println("--------------------------------------------------");
			System.out.println("\t\t||  *********  Main Menu  *********         ||");
			System.out.println("--------------------------------------------------");
			System.out.println("\t\t|| ==> 1. For Administrator                 ||");
			System.out.println("\t\t|| ==> 2. For Costumer                      ||");
			System.out.println("\t\t|| ==> 3. To Exit                           ||");
			
			System.out.println("---------------------------------------------------");
			System.out.print("Enter Your choice : ");
			choice=scan.nextInt();
			switch(choice) {
			case 1:
				obj.administrator();
				
				break;
			case 2:
				
				System.out.println(" " );
				System.out.println("**********************************************");
				System.out.println("*******        Costumer Portal        ********");
				System.out.println("**********************************************");
				System.out.println(" ");
				obj1.bpop();
				System.out.println("----------------------------------------------");
			
				obj.buy();
				break;
			case 3:
				System.out.println("\t\t ||===***** Thank You for visting us! ******===||");
			}
		}
		
	
	//	obj.Display();
		
		//obj.Modify();
		//obj.addProduct();
	//	obj.addProduct();
	//	obj.addProduct();
		//System.out.print("\033[H\033[2J");  
	//	System.out.flush(); 
		//obj.Display();
		
		
	//	obj.Modify();
	//	obj.Display();
		//obj.DeleteProduct();
		//obj.Display();
		
		//obj1.push(12);
		//obj1.isEmpty();
		//obj1.bpop();
		//obj1.bdisplay();
		
		
		//obj2.Enqueue("Saddam");
	//	obj2.displayQueue();
		
		
		
	}

}
