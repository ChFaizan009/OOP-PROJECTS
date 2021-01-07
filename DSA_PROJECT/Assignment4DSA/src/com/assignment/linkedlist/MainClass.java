package com.assignment.linkedlist;

import java.util.Scanner;

@SuppressWarnings("unused")
public class MainClass {

	public static void main(String[] args) {
		int ch = 0;
		boolean correctInput = true;
		int data = 0;
		int index = 0;
		Scanner scan = new Scanner(System.in);
		LinkedListClass list = new LinkedListClass();

		do {
			System.out.println("Enter your choice: ");
			System.out.println("1. to add data in list");
			System.out.println("2. to add data at the start of list");
			System.out.println("3. to add at specific index in list");
			System.out.println("4. to Get by index");
			System.out.println("5. to Get All (Traverse)");
			System.out.println("6. to delete At Start");
			System.out.println("7. to delete At End");
			System.out.println("8. to delete At a specific Index");
			System.out.println("9. Return to menu!!!");
			int count = list.getCount();
			while(correctInput) {
				try {
					System.out.print("Choice:->");
					ch = scan.nextInt();
					correctInput = false;
				} catch (Exception e) {
					System.out.println("Invalid Input!!! this is not a number!!!\nRe Enter");
					scan.next();
					correctInput = true;
					continue;
				}
			}
			switch(ch) {
			case 1:
				correctInput = true;
				while(correctInput) {
					try {
						System.out.print("Enter value:->");
						data = scan.nextInt();
						list.add(data);
						correctInput = false;
					} catch (Exception e) {
						System.out.println("Invalid Input!!! this is not a number!!!\nRe Enter");
						scan.next();
						correctInput = true;
						continue;
					}
				}
				break;
			case 2:
				System.out.print("Enter value:->");
				data = scan.nextInt();
				list.add(data);
				break;
			case 3:
				System.out.print("Enter Index:->");
				index = scan.nextInt();
				while(index >= count) {
					System.out.println("Index # exceeds List Limit!!!\nRe Enter");
					index = scan.nextInt();
				}
				System.out.print("Enter value:->");
				data = scan.nextInt();
				list.add(data);
				break;
			case 4:
				System.out.print("Enter Index:->");
				index = scan.nextInt();
				while(index >= count) {
					System.out.println("Index # exceeds List Limit!!!\nRe Enter");
					index = scan.nextInt();
				}
				data = list.get(index);
				System.out.println("Data at index:"+index+" is:"+data );
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			default:
				System.out.println("Invalid Choice!!!\nRe Enter:->");
				correctInput = true;
				break;
			}
		}while(!(ch==1||ch==2||ch==3||ch==4||ch==5||ch==6||ch==7||ch==8||ch==9||ch==10||ch==11||ch==12||ch==13||ch==14));
	}

}
