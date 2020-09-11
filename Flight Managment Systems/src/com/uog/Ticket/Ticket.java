package com.uog.Ticket;

public class Ticket
{

	private int TICKET_ID;
	private String TICKET_PRICE;
	
	public static String csvFile = "D:\\OOP Projects\\TimeTableFiles\\Ticket.csv";
	
	
	public int getTICKET_ID() {
		return TICKET_ID;
	}
	public void setTICKET_ID(int tICKET_ID) {
		TICKET_ID = tICKET_ID;
	}
	public String getTICKET_PRICE() {
		return TICKET_PRICE;
	}
	public void setTICKET_PRICE(String tICKET_PRICE) {
		TICKET_PRICE = tICKET_PRICE;
	}
	
	
	@Override
	public String toString() {
		return "Ticket [TICKET_ID=" + TICKET_ID + ", TICKET_PRICE=" + TICKET_PRICE + "]";
	}
	public static void ClearingScreen() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

		System.out.println("\t\t\t\tTICKET AREA\n");
		System.out.println(
				"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n\n");

	}
	
	
}
