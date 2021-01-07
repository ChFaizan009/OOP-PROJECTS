package com.system.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.system.connection.DBConnection;

public class AdminSecurityDao {

	private static DBConnection db = new DBConnection();

	public AdminSecurityDao() {}

	public static AdminSecurity addAdmin(AdminSecurity adminSecurity) {
		String queryInsert = "insert into adminsecurity value (?,?,?)";
		try {
			PreparedStatement st = db.con.prepareStatement(queryInsert);
			st.setInt(1, adminSecurity.getAdminId());
			st.setString(2, adminSecurity.getAdminUserName().toLowerCase());
			st.setString(3, adminSecurity.getAdminPassWord().toLowerCase());
			st.execute();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminSecurity;
	}

	public static AdminSecurity getAdmin(Integer adminId) {
		String queryGet = "select * from AdminSecurity WHERE adminId='"+adminId+"'";
		AdminSecurity adminSecurity = new AdminSecurity();
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			if(rs.next()) {
				adminSecurity.setAdminId(rs.getInt(1));
				adminSecurity.setAdminUserName(rs.getString(2));
				adminSecurity.setAdminPassWord(rs.getString(3));
			} else {
				adminSecurity = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminSecurity;
	}

	public static LinkedList<AdminSecurity> getAllAdmins() {
		String queryGet = "select * from AdminSecurity";
		LinkedList<AdminSecurity> admins = new LinkedList<>();
		try {
			Statement s = db.con.createStatement();
			ResultSet rs = s.executeQuery(queryGet);
			while(rs.next()) {
				AdminSecurity adminSecurity = new AdminSecurity();
				adminSecurity.setAdminId(rs.getInt(1));
				adminSecurity.setAdminUserName(rs.getString(2));
				adminSecurity.setAdminPassWord(rs.getString(3));
				admins.add(adminSecurity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}

	public static boolean updateAdmin(AdminSecurity admin){
		boolean success = false;
		String queryUpdate = "UPDATE AdminSecurity SET "
				+" adminUserName='"+admin.getAdminUserName()+"'"
				+", adminPassWord='"+admin.getAdminPassWord()+"'"
				+" WHERE adminId='"+admin.getAdminId()+"'";
		try {
			Statement s = db.con.createStatement();
			int st = s.executeUpdate(queryUpdate);
			success = (st != 0 ? true : false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public static boolean deleteAdmin(Integer adminId){
		boolean success = false;
		String queryDelete = "delete from AdminSecurity where adminId = '"+ adminId +"'";
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
