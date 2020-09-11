import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class myConnection {
	public static Connection getConnection() 
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javacontactsapp","root","system");
			
			
		}
		catch(Exception ex)
		{
			System.out.print(ex);
		}
		return con;
		
	}
}
