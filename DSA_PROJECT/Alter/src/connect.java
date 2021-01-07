import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class connect 
{

	static Connection cn=null;
	static String DatabaseName="";
	static String url="jdbc:mysql://localhost:3306/"+DatabaseName;
	static String username="root";
	static String password="faizan009";
	
	public static void main(String [] ar) throws Exception, IllegalAccessException,ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		cn= DriverManager.getConnection(url,username,password);
		PreparedStatement ps=cn.prepareStatement("INSERT INTO `shopping`.`product` (`Productid`, `ProductName`, `ProductPrice`, `Quantity`) VALUES (2, 'Chezze', '4000', '60');");
	int status =ps.executeUpdate();
	if(status!=0)
	{
		System.out.println("Database Was Connected");
		System.out.println("Records was Inserted");
	}
	
	}
}
