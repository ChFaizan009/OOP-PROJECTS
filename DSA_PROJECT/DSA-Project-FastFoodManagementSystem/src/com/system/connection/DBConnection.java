package com.system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static String url = "jdbc:mysql://localhost/fastFood?useSSL=false";
	static String username = "student";
	static String password = "student";
	public Connection con = null;
	
	public DBConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
