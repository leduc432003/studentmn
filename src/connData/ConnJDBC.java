package connData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnJDBC {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			String url = "jdbc:mySQL://127.0.0.1:3306/studentmn";
			String username = "root";
			String password = "duc432003";
			
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
