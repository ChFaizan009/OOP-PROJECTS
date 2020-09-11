package com.uog.Ticket;

import java.util.List;
import java.util.Scanner;

public class BookingMenu
{



	public static void  Interface()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		
			System.out.println("\n\n\t\tWELCOME TO Booking MENU");
		
						System.out.println("\t\tPress 1 to Display All Booking Data");
						System.out.println("\t\tPress 2 to Add Booking Data");
						System.out.println("\t\tPress 3 to Delete Row Wize Booking Data");
						System.out.println("\t\tPress 4 to Search Booking Data");
						System.out.println("\t\tPress 5 to Delete All Booking Data");
						System.out.println("\t\tPress 6 to Search Row Wize Booking Data");
						System.out.println("\t\tPress 7 to Log Out");
						System.out.println("\t\tPress 8 to Exit");
						System.out.print("\n\tPlease Enter Your Choice : ");
						
						int choice = input.nextInt();
						switch (choice) {
						case 1: {
							
							Booking.ClearingScreen();

							@SuppressWarnings("unused")
							Booking Booking = new Booking();
							
							System.out.println("---------------------------------");
							System.out.println("Show All Booking Data");
							System.out.println("---------------------------------");
							List<Booking> Bookings=BookingData.showALLData();
							for(int i=0;i<Bookings.size();i++)
							{
								System.out.println(Bookings.get(i).toString());
							}
							System.out.println("---------------------------------");
							break;
							
						}
						case 2: {
							Booking.ClearingScreen();

							System.out.println("---------------------------------");
							System.out.println("Add New Booking Data");
							System.out.println("---------------------------------");
							Booking Booking = new Booking();
							
							System.out.println("Enter Id of Booking :");
							int id=input.nextInt();
							Booking.setBOOKING_ID(id);
							
							System.out.println("Enter User Id : ");
							int Id = input.nextInt();
							//Booking.setUSER_ID(Id);
							
							
							System.out.println("Enter Booking Date :");
							String number=input.nextLine();
							
							Booking.setBOOKING_DATE(number);
							
							System.out.println("Enter TICKET PRICE of Booking : ");
							String Date=input.nextLine();
							//Booking.setTICKET_PRICE(Date);
							
								
							Booking = BookingData.SaveBookingData(Booking);
							System.out.println(Booking.toString());
							System.out.println("---------------------------------");
							
							break;
						}
						case 3: {
							Booking.ClearingScreen();
							System.out.println("---------------------------------");
							System.out.println("Delete Booking");
							System.out.println("---------------------------------");
							System.out.println("Enter Booking ID: ");
							int Booking_ID=input.nextInt();
							Booking roomdelete = BookingData.deleteOneRowDta(Booking_ID);
							System.out.println(roomdelete.toString());
							System.out.println("---------------------------------");
						
							
						}
						case 4: {
							Booking.ClearingScreen();
							System.out.println("---------------------------------");
							System.out.println("Search Booking");
							System.out.println("---------------------------------");
			                System.out.println("Enter Booking Search");
			                String Search=input.nextLine();
			                List<Booking> roomsearch=BookingData.SearchBookingData(Search);
			                
			                for (int i1=0; i1<roomsearch.size(); i1++) {
								System.out.println(roomsearch.get(i1).toString());
							}
							System.out.println("---------------------------------");
							
							break;
						}
		            case 5: {
		            	Booking.ClearingScreen();

						System.out.println("Trying to delete All records");
						
						String del=BookingData.DeleteAllData();
						System.out.println(del);
						break;				
		            
		            }
		            case 6:
		            {
		            	Booking.ClearingScreen();
		            	@SuppressWarnings("resource")
						Scanner find=new Scanner(System.in);
						System.out.println("Enter Booking ID to find:-");
						int sc=find.nextInt();
					System.out.println("\n_________Found the Matching ID  record in row___________\n");
				    Booking fl = BookingData.deleteOneRowDta(sc);
					System.out.println(fl.toString());
					
					break;
		            }
		            case 10:
						
						break;
					default:
						System.out.println("Invalid Choice!");
					
		            
						}}
}
