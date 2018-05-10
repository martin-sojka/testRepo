package testShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConn {
	
	private final String url = "jdbc:postgresql://172.29.25.83/defaultDS";
	private final String user = "postgres";
	private final String password = "Asus#111";
		
	public Connection connect() {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected succesfully...");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from cwd_user;");
			ResultSetMetaData rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			
			while (rs.next()) {
				
				for (int i = 1; i <= col; i++) {
					System.out.print(i + ": ");
					System.out.println(rs.getString(i));
				} 
			} 
			
						
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	

}
