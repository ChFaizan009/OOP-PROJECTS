package com.uog.Ticket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketData 

{


	@SuppressWarnings("resource")
	public static List<Ticket> showALLData()  {
		List<Ticket> Tickets = new ArrayList<Ticket>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Ticket.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Ticket Ticket = new Ticket();
				
				
				String[] TicketRow = line.split(",");
				Ticket.setTICKET_ID(Integer.parseInt(TicketRow[0]));
				Ticket.setTICKET_PRICE(TicketRow[1]);
					
					Tickets.add(Ticket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Tickets;
	}

	@SuppressWarnings("resource")
	public static Ticket findOneByOneDta(int Ticket_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Ticket.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Ticket Ticket = new Ticket();
				
				String[] TicketRow = line.split(",");
				
				if (Integer.parseInt(TicketRow[0]) == Ticket_ID) {
					Ticket.setTICKET_ID(Integer.parseInt(TicketRow[0]));
					Ticket.setTICKET_PRICE(TicketRow[1]);
						
					
					return Ticket;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	

	@SuppressWarnings("resource")
	public static List<Ticket> SearchTicketData(String search)  {
		List<Ticket> Tickets = new ArrayList<Ticket>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Ticket.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Ticket Ticket = new Ticket();
				
				String[] TicketRow = line.split(",");
				
				if (TicketRow[1].contains(search) == true) {
					Ticket.setTICKET_ID(Integer.parseInt(TicketRow[0]));
					Ticket.setTICKET_PRICE(TicketRow[1]);
					
					Tickets.add(Ticket);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Tickets;
	}

	@SuppressWarnings("resource")
	public static Ticket SaveTicketData(Ticket Ticket) {
		FileWriter filewriter;

		List<Ticket> Tickets = showALLData();

		try {
			filewriter = new FileWriter(Ticket.csvFile);

			for (int i=0; i<Tickets.size(); i++) {
				filewriter.append(Tickets.get(i).toString());
				filewriter.append("\n");
			}
			if (Tickets.size()>0)
				Ticket.setTICKET_ID(Tickets.get(Tickets.size()-1).getTICKET_ID()+1);
			else
				Ticket.setTICKET_ID(1);
			filewriter.append(Ticket.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
e.printStackTrace();
		}
		
		
		
		return Ticket;
	}
	@SuppressWarnings("resource")
	public static Ticket deleteOneRowDta(int Ticket_ID)  {
		FileWriter filewriter;

		List<Ticket> Tickets = showALLData();
		Ticket Ticket = findOneByOneDta(Ticket_ID);

		try {
			filewriter = new FileWriter(Ticket.csvFile);

			for (int i=0; i<Tickets.size(); i++) {
				if (Tickets.get(i).getTICKET_ID() != Ticket_ID) {
					filewriter.append(Tickets.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Ticket;
	}
	
	
	
	
public static String DeleteAllData() {
		
		FileWriter wr;
		List<Ticket>Tickets=showALLData();
		try {
			wr=new FileWriter(Ticket.csvFile);
			for (int i=0;i<Tickets.size();i++) {
				Tickets.remove(i);
			}
			wr.flush();
			wr.close();
			
		} catch (IOException e) {
			System.out.println("Tickets Records were not deleted!"+e);
			e.printStackTrace();
		}
		
		return "Removed all records of Tickets ";
	}
	

}
