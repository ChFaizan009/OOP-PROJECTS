package com.uog.Flight;

import java.util.List;
import java.util.Scanner;

public class FlightMenu
{
	

	public static void  Interface()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		
			System.out.println("\n\n\t\tWELCOME TO FLIGHT MENU");
		
						System.out.println("\t\tPress 1 to Display All Flights Data");
						System.out.println("\t\tPress 2 to Add Flights Data");
						System.out.println("\t\tPress 3 to Delete Row Wize Flights Data");
						System.out.println("\t\tPress 4 to Search Flights Data");
						System.out.println("\t\tPress 5 to Delete All Flights Data");
						System.out.println("\t\tPress 6 to Search Row Wize Flights Data");
						System.out.println("\t\tPress 7 to Log Out");
						System.out.println("\t\tPress 8 to Exit");
						System.out.print("\n\tPlease Enter Your Choice : ");
						
						int choice = input.nextInt();
						switch (choice) {
						case 1: {
							
							Flight.ClearingScreen();

							@SuppressWarnings("unused")
							Flight flight = new Flight();
							
							System.out.println("---------------------------------");
							System.out.println("Show All Flights Data");
							System.out.println("---------------------------------");
							List<Flight> flights=FlightData.showALLData();
							for(int i=0;i<flights.size();i++)
							{
								System.out.println(flights.get(i).toString());
							}
							System.out.println("---------------------------------");
							break;
							
						}
						case 2: {
							Flight.ClearingScreen();

							System.out.println("---------------------------------");
							System.out.println("Add New Flight Data");
							System.out.println("---------------------------------");
							Flight flight = new Flight();
							
							System.out.println("Enter Id of Flight :");
							int id=input.nextInt();
							flight.setFLIGHT_ID(id);
							
							System.out.println("Enter Seat Id : ");
							int Id = input.nextInt();
							flight.setSEAT_ID(Id);
							
							
							System.out.println("Enter Flight Number :");
							String number=input.nextLine();
							number+=input.nextLine();
							flight.setFLIGHT_NUMBER(number);
							
							System.out.println("Enter Depature Date of flight : ");
							String Date=input.nextLine();
							flight.setDEPATURE_DATE(Date);
							
							System.out.println("Enter Depature Airpot of flight : ");
							String Airpot=input.nextLine();
							flight.setDEPATURE_AIRPOT(Airpot);
							
							System.out.println("Enter Depature Time of flight : ");
							String Time=input.nextLine();
							flight.setDEPATURE_TIME(Time);
							
							System.out.println("Enter Arrival Time of flight : ");
							String Arrival=input.nextLine();
							flight.setARRIVAL_TIME(Arrival);
							
							System.out.println("Enter Source of flight: ");
							String source = input.nextLine();
							flight.setSOURCE(source);
							
							
							
							flight = FlightData.SaveFlightData(flight);
							System.out.println(flight.toString());
							System.out.println("---------------------------------");
							
							break;
						}
						case 3: {
							Flight.ClearingScreen();
							System.out.println("---------------------------------");
							System.out.println("Delete Flight");
							System.out.println("---------------------------------");
							System.out.println("Enter Flight ID: ");
							int Flight_ID=input.nextInt();
							Flight roomdelete = FlightData.deleteOneRowDta(Flight_ID);
							System.out.println(roomdelete.toString());
							System.out.println("---------------------------------");
						
							
						}
						case 4: {
							Flight.ClearingScreen();
							System.out.println("---------------------------------");
							System.out.println("Search Flights");
							System.out.println("---------------------------------");
			                System.out.println("Enter Flight Search");
			                String Search=input.nextLine();
			                List<Flight> roomsearch=FlightData.SearchFlightData(Search);
			                
			                for (int i1=0; i1<roomsearch.size(); i1++) {
								System.out.println(roomsearch.get(i1).toString());
							}
							System.out.println("---------------------------------");
							
							break;
						}
		            case 5: {
		            	Flight.ClearingScreen();

						System.out.println("Trying to delete All records");
						
						String del=FlightData.DeleteAllData();
						System.out.println(del);
						break;				
		            
		            }
		            case 6:
		            {
		            	Flight.ClearingScreen();
		            	@SuppressWarnings("resource")
						Scanner find=new Scanner(System.in);
						System.out.println("Enter Flight ID to find:-");
						int sc=find.nextInt();
					System.out.println("\n_________Found the Matching ID  record in row___________\n");
				    Flight fl = FlightData.deleteOneRowDta(sc);
					System.out.println(fl.toString());
					
					break;
		            }
		            case 10:
						
						break;
					default:
						System.out.println("Invalid Choice!");
					
		            
						}}}


					
				
			
