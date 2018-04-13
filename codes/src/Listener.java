

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Listener {
	
	private final String url = "jdbc:postgresql://localhost/defaultDS";
	private final String user = "postgres";
	private final String password = "pass";
	
		
		
public Connection connect() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Successfuly connected");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listener ls = new Listener();
		ls.connect();
		
		
		
		
	}

}
