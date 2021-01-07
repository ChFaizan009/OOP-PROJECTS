package com.system.foodItem;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.system.input.Input;
import com.system.menu.AdministratorPanel;

public class FoodItemMenu {

	public FoodItemMenu() {}

	public static void foodItemMenu() {
		List<FoodItem> foodItems = null;
		Input input = new Input();
		FoodItem foodItem = null;
		int i = 1;
		try(Scanner scan = new Scanner(System.in)){
			while (true) {
				int ch = -1;
				do {
					System.out.println("\n\n\n\nEnter Your Choice.\n ");
					System.out.println("1. Add a new Food Item");
					System.out.println("2. Get a Food Item");
					System.out.println("3. View All Food Items");
					System.out.println("4. Update a Food Item");
					System.out.println("5. Delete a Food Item");
					System.out.println("6. Return to menu");
					System.out.print("Choice:->");
					ch =  input.inputInt();
					foodItems = null;
					foodItem = null;

					switch (ch) {
					case 1:
						foodItem = new FoodItem();
						foodItem.setFoodItemId(FoodItemDao.getAllFoodItems().getLast().getFoodItemId()+1);

						System.out.print("\nEnter Food item Name:->");
						foodItem.setFoodItemName(input.inputString());

						System.out.print("\nEnter Food item Price:->");
						foodItem.setFoodItemPrice(input.inputInt());

						System.out.println("Select Food Item Size.");
						i=1;
						for(Size s : Size.values()) {
							System.out.println(i +". "+s.toString());
							i++;
						}
						do {
							System.out.print("\nEnter Choice:->");
							i = input.inputInt();
							if(i==1) {
								foodItem.setFoodItemSize(Size.SMALL);
							} else if(i==2) {
								foodItem.setFoodItemSize(Size.MEDIUM);
							} else if(i==3) {
								foodItem.setFoodItemSize(Size.REGULAR);
							} else if(i==4) {
								foodItem.setFoodItemSize(Size.LARGE);
							} else if(i==5) {
								foodItem.setFoodItemSize(Size.X_LARGE);
							} else {
								System.out.println("Invalid Input!!!");
							}
						}while(!(i==1||i==2||i==3||i==4||i==5));
						System.out.println("Selected Choice:->" + foodItem.getFoodItemSize().name());

						System.out.println("Select Food Item Category.");
						i=1;
						for(FoodItemCategory f : FoodItemCategory.values()) {
							System.out.println(i +". "+f.toString());
							i++;
						}
						do {
							System.out.print("\nEnter Choice:->");
							i = input.inputInt();
							if(i==1) {
								foodItem.setFoodItemCategory(FoodItemCategory.FastFood);
							} else if(i==2) {
								foodItem.setFoodItemCategory(FoodItemCategory.Dessert);
							} else if(i==3) {
								foodItem.setFoodItemCategory(FoodItemCategory.Drink);
							} else {
								System.out.println("Invalid Input!!!");
							}
						}while(!(i==1||i==2||i==3));
						System.out.println("Selected Choice:->" + foodItem.getFoodItemCategory().name());

						System.out.println("Is Food Item Available? \nEnter '1' for Yes. \nAny Number for No. ");
						int aval = scan.nextInt();
						foodItem.setAvailable((aval==1 ? true : false));

						FoodItemDao.addFoodItem(foodItem);
						System.out.println("Item Added:\n "+foodItem.toString());
						break;
					case 2:
						foodItem = new FoodItem();

						System.out.print("\nEnter Food Item Id:->");
						foodItem = FoodItemDao.getFoodItem(input.inputInt());

						if (foodItem == null) {
							System.out.println("No Food Item with the Requested ID Found :(");
						} else {
							System.out.println(foodItem.toString());
						}
						break;
					case 3:
						foodItems = new LinkedList<>();
						foodItems = FoodItemDao.getAllFoodItems();

						if (foodItems != null) {
							foodItems.forEach(System.out::println);
						} else {
							System.out.println("No Record Found!");
						}
						break;
					case 4:
						char k ='0';
						System.out.print("\nEnter Food Item Id:->");
						foodItem = FoodItemDao.getFoodItem(input.inputInt());

						if (foodItem != null) {
							System.out.println("\nOld Details:\n" + foodItem.toString()+"\n");

							foodItem.setFoodItemId(foodItem.getFoodItemId());

							System.out.println("\nEnter '1' to Update Food item Name.\nEnter 'Any Number' to Skip Food item Name Update.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("\nEnter Food item Name:->");
								foodItem.setFoodItemName(input.inputString());
							} else {
								foodItem.setFoodItemName(foodItem.getFoodItemName());
							}

							System.out.println("\nEnter '1' to Update Food item Price.\nEnter 'Any Number' to Skip Food item Price Update.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.print("\nEnter Food item Price:->");
								foodItem.setFoodItemPrice(input.inputInt());
							} else {
								foodItem.setFoodItemPrice(foodItem.getFoodItemPrice());
							}

							System.out.println("\nEnter '1' to Update Food Item Size.\nEnter 'Any Number' to Skip Food Item Size.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.println("\nSelect Food Item Size.");
								int j=1;
								for(Size s : Size.values()) {
									System.out.println(j +". "+s.toString());
									j++;
								}
								do {
									System.out.print("\nEnter Choice:->");
									i = input.inputInt();
									if(i==1) {
										foodItem.setFoodItemSize(Size.SMALL);
									} else if(i==2) {
										foodItem.setFoodItemSize(Size.MEDIUM);
									} else if(i==3) {
										foodItem.setFoodItemSize(Size.REGULAR);
									} else if(i==4) {
										foodItem.setFoodItemSize(Size.LARGE);
									} else if(i==5) {
										foodItem.setFoodItemSize(Size.X_LARGE);
									} else {
										System.out.println("Invalid Input!!!");
									}
								}while(!(i==1||i==2||i==3||i==4||i==5));
								System.out.println("Selected Choice:->" + foodItem.getFoodItemSize().name());
							} else {
								foodItem.setFoodItemSize(foodItem.getFoodItemSize());
							}

							System.out.println("\nEnter '1' to Update Food Item Category.\nEnter 'Any Number' to Skip Food Item Category Update.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.println("\nSelect Food Item Category.");
								i=1;
								for(FoodItemCategory f : FoodItemCategory.values()) {
									System.out.println(i +". "+f.toString());
									i++;
								}
								do {
									System.out.print("\nEnter Choice:->");
									i = input.inputInt();
									if(i==1) {
										foodItem.setFoodItemCategory(FoodItemCategory.FastFood);
									} else if(i==2) {
										foodItem.setFoodItemCategory(FoodItemCategory.Dessert);
									} else if(i==3) {
										foodItem.setFoodItemCategory(FoodItemCategory.Drink);
									} else {
										System.out.println("Invalid Input!!!");
									}
								}while(!(i==1||i==2||i==3));
								System.out.println("Selected Choice:->" + foodItem.getFoodItemCategory().name());
							} else {
								foodItem.setFoodItemCategory(foodItem.getFoodItemCategory());
							}

							System.out.println("\nEnter '1' to Update Employee Address.\nEnter 'Any Number' to Skip Employee Address Update.");
							System.out.print("Enter Choice:->");
							k = input.inputChar();
							if (k=='1') {
								System.out.println("\nIs Food Item Available? \n1 for Yes. \nAny Number for No. ");
								int avl = input.inputInt();
								foodItem.setAvailable((avl==1 ? true : false));
							} else {
								foodItem.setAvailable(foodItem.isAvailable());
							}

							boolean isUpdated = FoodItemDao.updateFoodItem(foodItem);
							System.out.println((isUpdated==true) ? "Food Item Updated\nNew Data:->"+foodItem.toString() : "Food Item Not Updated");
						} else {
							System.out.println("No Food Item With Requested Id Found!!!");
						}
						break;
					case 5:
						System.out.print("\nEnter Food Item Id:");
						boolean isDeleted = FoodItemDao.deleteFoodItem(input.inputInt());
						System.out.println((isDeleted==true) ? "Food Item Deleted" : "Food Item Not Deleted");
						break;
					case 6:
						AdministratorPanel.administratorPanel();
						break;
					default:
						System.out.println("\nInvalid Input!!!");
						break;
					}
				} while (!(ch==1||ch==2||ch==3||ch==4||ch==5||ch==6));
			}
		} catch(Exception e) {

		}
	}

}
