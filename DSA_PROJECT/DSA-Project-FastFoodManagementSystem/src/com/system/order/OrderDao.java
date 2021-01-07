package com.system.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import com.system.connection.DBConnection;

public class OrderDao {

	private static DBConnection db = new DBConnection();

	public static boolean addOrder(Order order) {
		String queryInsert = "insert into orders value (?,?,?,?,?,?)";
		try {
			PreparedStatement st = db.con.prepareStatement(queryInsert);
			st.setInt(1, order.getOrderId());
			st.setString(2, order.getOrderStartTime());
			st.setString(3, order.getOrderEndTime());
			st.setString(4, order.getOrderDileveryTime());
			st.setInt(5, order.getCustomerEntryNumber());
			st.setInt(6, order.getCustomerMemberShipCode());
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static LinkedList<Order> getAllOrders(){
		LinkedList<Order> orders = new LinkedList<>();
		String queryGet = "select * from orders";
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setOrderStartTime(rs.getString(2));
				order.setOrderEndTime(rs.getString(3));
				order.setOrderDileveryTime(rs.getString(4));
				order.setCustomerEntryNumber(rs.getInt(5));
				order.setCustomerMemberShipCode(rs.getInt(6));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public static Order getOrder(Integer orderId){
		String queryGet = "select * from orders where orderId='"+orderId+"'";
		Order order = new Order();
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			if (rs.next()) {
				order.setOrderId(rs.getInt(1));
				order.setOrderStartTime(rs.getString(2));
				order.setOrderEndTime(rs.getString(3));
				order.setOrderDileveryTime(rs.getString(4));
				order.setCustomerEntryNumber(rs.getInt(5));
				order.setCustomerMemberShipCode(rs.getInt(6));
			} else {
				order = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	public static Integer getOrderDeliveryRemainigTime(Integer orderId) {
		String queryGet = "select * from orders where orderId='"+orderId+"'";
		Order order = new Order();
		Integer remainigTime = 0;
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			if (rs.next()) {
				order.setOrderId(rs.getInt(1));
				order.setOrderStartTime(rs.getString(2));
				order.setOrderEndTime(rs.getString(3));
				order.setOrderDileveryTime(rs.getString(4));
				order.setCustomerEntryNumber(rs.getInt(5));
				order.setCustomerMemberShipCode(rs.getInt(6));

				String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"));
				String[] presentTime = time.split(":");
				String presentTimeH = presentTime[0];
				String presentTimeM = presentTime[1];

				String[] dileveryTime = order.getOrderDileveryTime().split(":");
				String dileveryTimeH = dileveryTime[0];
				String dileveryTimeM = dileveryTime[1];


				if(Integer.parseInt(presentTimeH) > Integer.parseInt(dileveryTimeH)) {
					if (Integer.parseInt(presentTimeM) > Integer.parseInt(dileveryTimeM)) {
						System.out.println("We Are Sorry For The Delay. Your Order Will Be Arriving Shortly!");
					} else if (Integer.parseInt(presentTimeM) <= Integer.parseInt(dileveryTimeM)) {
						remainigTime = 	Integer.parseInt(dileveryTimeM) - Integer.parseInt(presentTimeM);
					}
				} else if (Integer.parseInt(presentTimeH) < Integer.parseInt(dileveryTimeH)) {
					if (Integer.parseInt(presentTimeM) > Integer.parseInt(dileveryTimeM)) {
						remainigTime = (60-Integer.parseInt(presentTimeM)) + Integer.parseInt(dileveryTimeM);
					} else if (Integer.parseInt(presentTimeM) <= Integer.parseInt(dileveryTimeM)) {
						remainigTime = 	Integer.parseInt(dileveryTimeM) - Integer.parseInt(presentTimeM);
					}
				} else if (Integer.parseInt(presentTimeH) == Integer.parseInt(dileveryTimeH)) {
					if (Integer.parseInt(presentTimeM) > Integer.parseInt(dileveryTimeM)) {
						remainigTime = (60-Integer.parseInt(presentTimeM)) + Integer.parseInt(dileveryTimeM);
					} else if (Integer.parseInt(presentTimeM) <= Integer.parseInt(dileveryTimeM)) {
						remainigTime = 	Integer.parseInt(dileveryTimeM) - Integer.parseInt(presentTimeM);
					}
				}
			} else {
				remainigTime = 5;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return remainigTime;
	}
}
