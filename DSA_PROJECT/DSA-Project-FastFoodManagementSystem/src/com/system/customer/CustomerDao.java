package com.system.customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import com.system.connection.DBConnection;

public class CustomerDao {

	private static DBConnection db = new DBConnection();

	public CustomerDao() {
	}

	public static Customer addRecord(Customer customer) {
		String queryInsert = "insert into customer value (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = db.con.prepareStatement(queryInsert);
			st.setInt(1, customer.getCustomerEntryNumber());
			st.setString(2, customer.getCustomerName());
			st.setLong(3, customer.getCustomerBill());
			st.setString(4, customer.getCustomerFoodItemIds());
			st.setString(5, customer.getCustomerFoodPurchaseTime());
			st.setString(6, customer.getCustomerFoodItemNames());
			st.setLong(7, (customer.getCustomerMemberShip()));
			st.setInt(8, (customer.getOrderId()==null ? 0 : customer.getOrderId()));
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	public static Customer getCustomer(Integer customerEntryNumber){
		String queryGet = "select * from customer WHERE customerEntryNumber='"+customerEntryNumber+"'";
		Customer customer = new Customer();
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			if(rs.next()) {
				customer.setCustomerEntryNumber(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerBill(rs.getInt(3));
				customer.setCustomerFoodItemIds(rs.getString(4));
				customer.setCustomerFoodPurchaseTime(rs.getString(5));
				customer.setCustomerFoodItemNames(rs.getString(6));
				customer.setCustomerMemberShip(rs.getInt(7));
				customer.setOrderId(rs.getInt(8));
			} else {
				customer = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	public static Customer getCustomerDetailsbyOrderId(Integer customerEntryNumber) {
		return CustomerDao.getCustomer(customerEntryNumber);
	}

	public static LinkedList<Customer> getAllHistory(){
		LinkedList<Customer> customers = new LinkedList<>();
		String queryGet = "select * from customer";
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerEntryNumber(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerBill(rs.getInt(3));
				customer.setCustomerFoodItemIds(rs.getString(4));
				customer.setCustomerFoodPurchaseTime(rs.getString(5));
				customer.setCustomerFoodItemNames(rs.getString(6));
				customer.setCustomerMemberShip(rs.getInt(7));
				customer.setOrderId(rs.getInt(8));

				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public static List<Customer> getTodayHistory(){
		List<Customer> customers = new LinkedList<>();
		String queryGet = "select * from customer";
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while (rs.next()) {
				Customer customer = new Customer();

				customer.setCustomerEntryNumber(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerBill(rs.getInt(3));
				customer.setCustomerFoodItemIds(rs.getString(4));
				customer.setCustomerFoodPurchaseTime(rs.getString(5));
				customer.setCustomerFoodItemNames(rs.getString(6));
				customer.setCustomerMemberShip(rs.getInt(7));
				customer.setOrderId(rs.getInt(8));

				String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				String[] timeSplit = time.split("-");

				String[] foodTimeSplit = customer.getCustomerFoodPurchaseTime().split(" ");
				String[] foodTime = foodTimeSplit[1].split("-");

				if(foodTime[0].equals(timeSplit[0])) {
					customers.add(customer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public static List<Customer> getPresentMonthHistory(){
		List<Customer> customers = new LinkedList<>();
		String queryGet = "select * from customer";
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerEntryNumber(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerBill(rs.getInt(3));
				customer.setCustomerFoodItemIds(rs.getString(4));
				customer.setCustomerFoodPurchaseTime(rs.getString(5));
				customer.setCustomerFoodItemNames(rs.getString(6));
				customer.setCustomerMemberShip(rs.getInt(7));
				customer.setOrderId(rs.getInt(8));

				String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				String[] timeSplit = time.split("-");

				String[] foodTimeSplit = customer.getCustomerFoodPurchaseTime().split(" ");
				String[] foodTime = foodTimeSplit[1].split("-");

				if(foodTime[1].equals(timeSplit[1])) {
					customers.add(customer);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public static boolean updateCustomer(Customer customer){
		boolean success = false;
		String queryUpdate = "UPDATE CUSTOMER SET "
				+" customerName='"+customer.getCustomerName()+"'"
				+", customerBill='"+customer.getCustomerBill()+"'"
				+", customerFoodItemIds='"+customer.getCustomerFoodItemIds()+"'"
				+", customerFoodPurchaseTime='"+customer.getCustomerFoodPurchaseTime()+"'"
				+" WHERE customerEntryNumber='"+customer.getCustomerEntryNumber()+"'";

		try {
			Statement s = db.con.createStatement();
			int st = s.executeUpdate(queryUpdate);
			success = (st != 0 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public static boolean deleteCustomer(Integer customerEntryNumber){
		boolean success = false;
		String queryDelete = "delete from CUSTOMER where customerEntryNumber = '"+ customerEntryNumber +"'";
		try {
			Statement s = db.con.createStatement();
			int st = s.executeUpdate(queryDelete);
			success = (st != 0 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
}
