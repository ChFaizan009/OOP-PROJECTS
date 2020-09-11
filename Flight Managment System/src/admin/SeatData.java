//package admin;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class SeatData 
//{
//	@SuppressWarnings("resource")
//	public static Seat findOne(int room_ID)  {
//		String line;
//		
//		try {
//			BufferedReader bufferreader = new BufferedReader(new FileReader(Seat.csvFile));
//			
//			while ((line = bufferreader.readLine()) != null) {
//				Seat seat = new Seat();
//				
//				String[] seatRow = line.split(",");
//				
//				if (Integer.parseInt(seatRow[0]) == room_ID) {
//					seat.setSEAT_ID(Integer.parseInt(seatRow[0]));
//					seat.setSTATUS(seatRow[1]);
//					
//					
//					return seat;
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//
//}
