package com.uog.Flight;

import java.util.Scanner;

import com.uog.Passenger.PassengerMenu;
import com.uog.Ticket.BookingMenu;
import com.uog.Ticket.TicketMenu;

public class FunctionClass
{
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while(choice!=5)
		{
			System.out.println("=====================================================");
			System.out.println("Main Menu");
			System.out.println("=====================================================");
			System.out.println("1. Press  1 for  Flights Data");
			System.out.println("2. Press  2 for  Tickets Data");
			System.out.println("3. Press  3 for  Passenger Data");
			System.out.println("4. Press  4 for Booking Data");
			choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				FlightMenu.Interface();
			
				break;
        
			case 2:
				TicketMenu.ticketInterface();
			case 3:
				PassengerMenu.PassengerInterface();
				break;
			case 4:
				BookingMenu.Interface();
				break;
			
			
			
			case 5:
				
				
				break;
			default:
				System.out.println("Invalid Choice!");
			}
}}} 