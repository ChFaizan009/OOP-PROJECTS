import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SqlServer 
{
	public static void main(String [] args)  throws Exception, SQLException
	{
		spring.datasource.url="jdbc:sqlserver://DESKTOP-AKEU2GB;databaseName=Shopping";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String cr ="jdbc:sqlserver://DESKTOP-AKEU2GB:1433IntegratedSecurity=true";
		JOptionPane.showMessageDialog(null, "Connected");
		try(Connection cn=DriverManager.getConnection(cr);Statement stmt=cn.createStatement();)
		{
			String Sql="Select * from Products";
		ResultSet rs=stmt.executeQuery(Sql);
		
		
		while(rs.next())
		{
			System.out.println(rs.getString("Product_Name")+ " "+rs.getString("Price"));
		}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
}
}