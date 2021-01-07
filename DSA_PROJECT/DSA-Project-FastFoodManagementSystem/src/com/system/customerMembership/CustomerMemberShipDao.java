package com.system.customerMembership;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.system.connection.DBConnection;

public class CustomerMemberShipDao {

	private static DBConnection db = new DBConnection();

	public CustomerMemberShipDao() {}

	public static CustomerMemberShip addMemberShipCustomer(CustomerMemberShip customerMemberShip){
		String queryInsert = "insert into CUSTOMER_MEMBER_SHIP value (?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = db.con.prepareStatement(queryInsert);
			st.setInt(1, customerMemberShip.getMemberShipID());
			st.setLong(2, customerMemberShip.getMemberShipCode());
			st.setString(3, customerMemberShip.getMemberShipName());
			st.setString(4, customerMemberShip.getMemberShipStartDate());
			st.setString(5, customerMemberShip.getMemberShipEndDate());
			st.setString(6, customerMemberShip.getMemberShipType().toString());
			st.setBoolean(7, customerMemberShip.isActive());
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customerMemberShip;
	}

	public static LinkedList<CustomerMemberShip> getAllMemberShipCustomer(){
		LinkedList<CustomerMemberShip> memberShipCustomers = new LinkedList<>();
		String queryGet = "select * from CUSTOMER_MEMBER_SHIP";
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);

			while (rs.next()) {
				CustomerMemberShip memberShipCustomer = new CustomerMemberShip();
				memberShipCustomer.setMemberShipID(rs.getInt(1));
				memberShipCustomer.setMemberShipCode(rs.getInt(2));
				memberShipCustomer.setMemberShipName(rs.getString(3));
				memberShipCustomer.setMemberShipStartDate(rs.getString(4));
				memberShipCustomer.setMemberShipEndDate(rs.getString(5));
				memberShipCustomer.setMemberShipType(MemberShipType.valueOf(rs.getString(6)));
				memberShipCustomer.setActive(rs.getBoolean(7));
				memberShipCustomers.add(memberShipCustomer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberShipCustomers;
	}

	public static CustomerMemberShip getMemberShipCustomer(Integer memberShipCustomerCode){
		CustomerMemberShip memberShipCustomer = new CustomerMemberShip();
		String queryGet = "select * from CUSTOMER_MEMBER_SHIP WHERE memberShipCode='"+memberShipCustomerCode+"'";
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			if(rs.next()==true) {
				memberShipCustomer.setMemberShipID(rs.getInt(1));
				memberShipCustomer.setMemberShipCode(rs.getInt(2));
				memberShipCustomer.setMemberShipName(rs.getString(3));
				memberShipCustomer.setMemberShipStartDate(rs.getString(4));
				memberShipCustomer.setMemberShipEndDate(rs.getString(5));
				memberShipCustomer.setMemberShipType(MemberShipType.valueOf(rs.getString(6)));
				memberShipCustomer.setActive(rs.getBoolean(7));
				return memberShipCustomer;
			} else {
				memberShipCustomer = null;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberShipCustomer;
	}

	public static boolean updateCustomerMemberShip(CustomerMemberShip customerMemberShip){
		boolean success = false;
		String queryUpdate = "UPDATE CUSTOMER_MEMBER_SHIP SET "
				+" memberShipID='"+customerMemberShip.getMemberShipID()+"'"
				+", memberShipName='"+customerMemberShip.getMemberShipName()+"'"
				+", memberShipStartDate='"+customerMemberShip.getMemberShipStartDate()+"'"
				+", memberShipEndDate='"+customerMemberShip.getMemberShipEndDate()+"'"
				+", memberShipType='"+customerMemberShip.getMemberShipType()+"'"
				+", isActive='"+(customerMemberShip.isActive()==true?1:0)+"'"
				+" where memberShipCode='"+customerMemberShip.getMemberShipCode()+"'";

		try {
			Statement s = db.con.createStatement();
			int st = s.executeUpdate(queryUpdate);
			success = (st != 0 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public static boolean deleteCustomerMemberShip(long memberShipCode){
		boolean success = false;
		String queryDelete = "delete from CUSTOMER_MEMBER_SHIP where memberShipCode = '"+ memberShipCode +"'";
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
