import java.sql.Connection;
import java.sql.DriverManager;

public class newSql
{

	public static void main(String ar)
	{
		Connection cn=null;
		
		try
		{
			cn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens","root","faizan009");
			if(cn!=null)
			{
				System.out.println("Connected to Data base");
			}
		}
		catch(Exception e)
		{
			System.out.println("Not Connected to Data base");
		}
		
	}
}
