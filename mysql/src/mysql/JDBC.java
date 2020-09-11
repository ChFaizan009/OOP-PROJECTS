package mysql;
import java.sql.*;
public class JDBC {
	public static void main(String [] ar) throws ClassNotFoundException, SQLException 
	{
	
		Class.forName("com.myql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample","root","faizan123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select *from data where ID=3");
		rs.next();
		int id=rs.getInt("ID");
		String name=rs.getString("Name");
		String city=rs.getString("City");
		
		System.out.println(id+" "+name+" "+city);
		
		st.close();
		con.close();
		
	
	}

}
