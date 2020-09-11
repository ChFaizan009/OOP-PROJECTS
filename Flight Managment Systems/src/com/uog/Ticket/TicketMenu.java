package com.uog.Ticket;

import java.util.List;
import java.util.Scanner;

import com.uog.Ticket.Ticket;
import com.uog.Ticket.TicketData;

public class TicketMenu

{

	
	public static void  ticketInterface()
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		
			System.out.println("\n\n\t\tWELCOME TO TICKET MENU");
		
						System.out.println("\t\tPress 1 to Display All TICKETs Data");
						System.out.println("\t\tPress 2 to Add TICKETs Data");
						System.out.println("\t\tPress 3 to Delete Row Wize TICKETs Data");
						System.out.println("\t\tPress 4 to Search TICKETs Data");
						System.out.println("\t\tPress 5 to Delete All TICKETs Data");
						System.out.println("\t\tPress 6 to Search Row Wize TICKETs Data");
						System.out.println("\t\tPress 7 to Log Out");
						System.out.println("\t\tPress 8 to Exit");
						System.out.print("\n\tPlease Enter Your Choice : ");
						
						int choice = input.nextInt();
						switch (choice) {
						case 1: {
							
							Ticket.ClearingScreen();

							@SuppressWarnings("unused")
							Ticket TICKET = new Ticket();
							
							System.out.println("---------------------------------");
							System.out.println("Show All TICKETs Data");
							System.out.println("---------------------------------");
							List<Ticket> TICKETs=TicketData.showALLData();
							for(int i=0;i<TICKETs.size();i++)
							{
								System.out.println(TICKETs.get(i).toString());
							}
							System.out.println("---------------------------------");
							break;
							
						}
						case 2: {
							Ticket.ClearingScreen();

							System.out.println("---------------------------------");
							System.out.println("Add New TICKET Data");
							System.out.println("---------------------------------");
							Ticket TICKET = new Ticket();
							
							System.out.println("Enter Id of TICKET :");
							int id=input.nextInt();
							TICKET.setTICKET_ID(id);
						
							
							System.out.println("Enter TICKET Price :");
							String price=input.nextLine();
							
							TICKET.setTICKET_PRICE(price);
							
							
							
							TICKET = TicketData.SaveTicketData(TICKET);
							System.out.println(TICKET.toString());
							System.out.println("---------------------------------");
							
							break;
						}
						case 3: {
							Ticket.ClearingScreen();
							System.out.println("---------------------------------");
							System.out.println("Delete TICKET");
							System.out.println("---------------------------------");
							System.out.println("Enter TICKET ID: ");
							int TICKET_ID=input.nextInt();
							Ticket roomdelete = TicketData.deleteOneRowDta(TICKET_ID);
							System.out.println(roomdelete.toString());
							System.out.println("---------------------------------");
						
							
						}
						case 4: {
							Ticket.ClearingScreen();
							System.out.println("---------------------------------");
							System.out.println("Search TICKETs");
							System.out.println("---------------------------------");
			                System.out.println("Enter TICKET Search");
			                String Search=input.nextLine();
			                List<Ticket> roomsearch=TicketData.SearchTicketData(Search);
			                
			                for (int i1=0; i1<roomsearch.size(); i1++) {
								System.out.println(roomsearch.get(i1).toString());
							}
							System.out.println("---------------------------------");
							
							break;
						}
		            case 5: {
		            	Ticket.ClearingScreen();

						System.out.println("Trying to delete All records");
						
						String del=TicketData.DeleteAllData();
						System.out.println(del);
						break;				
		            
		            }
		            case 6:
		            {
		            	Ticket.ClearingScreen();
		            	@SuppressWarnings("resource")
						Scanner find=new Scanner(System.in);
						System.out.println("Enter TICKET ID to find:-");
						int sc=find.nextInt();
					System.out.println("\n_________Found the Matching ID  record in row___________\n");
					Ticket fl = TicketData.deleteOneRowDta(sc);
					System.out.println(fl.toString());
					
					break;
		            }
		            case 10:
						
						break;
					default:
						System.out.println("Invalid Choice!");
					
		            
						}}
}
