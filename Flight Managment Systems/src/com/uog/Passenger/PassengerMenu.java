package com.uog.Passenger;

import java.util.List;
import java.util.Scanner;

public class PassengerMenu

{


		
		public static void  PassengerInterface()
		{
			@SuppressWarnings("resource")
			Scanner input=new Scanner(System.in);
			
				System.out.println("\n\n\t\tWELCOME TO PASSENGER MENU");
			
							System.out.println("\t\tPress 1 to Display All PASSENGER Data");
							System.out.println("\t\tPress 2 to Add PASSENGERS Data");
							System.out.println("\t\tPress 3 to Delete Row Wize PASSENGERS Data");
							System.out.println("\t\tPress 4 to Search PASSENGERS Data");
							System.out.println("\t\tPress 5 to Delete All PASSENGERS Data");
							System.out.println("\t\tPress 6 to Search Row Wize PASSENGERS Data");
							System.out.println("\t\tPress 7 to Log Out");
							System.out.println("\t\tPress 8 to Exit");
							System.out.print("\n\tPlease Enter Your Choice : ");
							
							int choice = input.nextInt();
							switch (choice) {
							case 1: {
								
								Passenger.ClearingScreen();

								@SuppressWarnings("unused")
								Passenger Passenger = new Passenger();
								
								System.out.println("---------------------------------");
								System.out.println("Show All Passengers Data");
								System.out.println("---------------------------------");
								List<Passenger> Passengers=PassengerData.findAll();
								for(int i=0;i<Passengers.size();i++)
								{
									System.out.println(Passengers.get(i).toString());
								}
								System.out.println("---------------------------------");
								break;
								
							}
							case 2: {
								Passenger.ClearingScreen();

								System.out.println("---------------------------------");
								System.out.println("Add New Passenger Data");
								System.out.println("---------------------------------");
								Passenger Passenger = new Passenger();
								
								System.out.println("Enter NAME of User :");
								int id=input.nextInt();
								Passenger.setPassenger_ID(id);
							
								
								System.out.println("Enter Adress of Passenger :");
								String price=input.nextLine();
								
								//Passenger.setPassenger_ID(price);
								
								
								
								//Passenger = PassengerData.Save(Passenger)(Passenger);
								System.out.println(Passenger.toString());
								System.out.println("---------------------------------");
								
								break;
							}
							case 3: {
								Passenger.ClearingScreen();
								System.out.println("---------------------------------");
								System.out.println("Delete Passenger");
								System.out.println("---------------------------------");
								System.out.println("Enter Passenger ID: ");
								int Passenger_ID=input.nextInt();
								Passenger roomdelete = PassengerData.deleteOne(Passenger_ID);
								System.out.println(roomdelete.toString());
								System.out.println("---------------------------------");
							
								
							}
							case 4: {
								Passenger.ClearingScreen();
								System.out.println("---------------------------------");
								System.out.println("Search Passengers");
								System.out.println("---------------------------------");
				                System.out.println("Enter Passenger Search");
				                String Search=input.nextLine();
				                List<Passenger> roomsearch=PassengerData.SearchPassengerData(Search);
				                
				                for (int i1=0; i1<roomsearch.size(); i1++) {
									System.out.println(roomsearch.get(i1).toString());
								}
								System.out.println("---------------------------------");
								
								break;
							}
			            case 5: {
			            	Passenger.ClearingScreen();

							System.out.println("Trying to delete All records");
							
							String del=PassengerData.DeleteAll();
							System.out.println(del);
							break;				
			            
			            }
			            case 6:
			            {
			            	Passenger.ClearingScreen();
			            	@SuppressWarnings("resource")
							Scanner find=new Scanner(System.in);
							System.out.println("Enter Passenger ID to find:-");
							int sc=find.nextInt();
						System.out.println("\n_________Found the Matching ID  record in row___________\n");
						Passenger fl = PassengerData.deleteOne(sc);
						System.out.println(fl.toString());
						
						break;
			            }
			            case 10:
							
							break;
						default:
							System.out.println("Invalid Choice!");
						
			            
							}}
	}


