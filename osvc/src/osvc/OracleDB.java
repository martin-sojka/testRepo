package osvc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;



public class OracleDB {
	
	public static final String dbUrl = "jdbc:oracle:thin:@WMCL263.wmc.local:1521:XE";
	public static String dbUser = null;
	public static char[] dbPass = null;
	public static Connection conn;
		
	private OracleDB() {
				
	}
	
	public static Connection getConn(String user, char[] passwd) throws Exception{
		
		dbUser = user;
		dbPass = passwd;
		String pass = new String(passwd);
				
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn = DriverManager.getConnection(dbUrl, dbUser, pass);
			
		return conn;
	}
	
public static Connection getConn() throws Exception{
		
		System.out.println(dbUser);
		String pass = new String(dbPass);
		System.out.println(pass);
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn = DriverManager.getConnection(dbUrl, dbUser, pass);
			
		return conn;
	}
	
public static void closeConn() {
	
	try {
		conn.close();
	} catch (SQLException e) {
		
	}
}
	
public static void connect(String month, int salary) throws Exception {
	
	try {
				
	final String statement = "insert into salary (month, paid) values (?,?)";
		
	PreparedStatement st = getConn(dbUser, dbPass).prepareStatement(statement);
	
	st.setString(1, month);
	st.setInt(2, salary);
	st.executeUpdate();
	
	st.close();
	closeConn();
		
	} catch(SQLException e) {
		System.out.println(e.getMessage());
		}
	}

public static int connect(String id) throws Exception {
	
	int output = 0;
	
	try {
					
		final String statement = "select paid from salary where month=?";
		PreparedStatement st = getConn(dbUser, dbPass).prepareStatement(statement);
		st.setString(1, id);
				
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			output = rs.getInt("paid");
			
			} 
				
		rs.close(); 
		st.close();
		closeConn();
		
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			}
		return output;
	}


public static void delete(String month) throws Exception {
	
	try {
		
		final String statement = "delete from salary where month=?";
			
		PreparedStatement st = getConn(dbUser, dbPass).prepareStatement(statement);
		st.setString(1, month);
		st.executeUpdate();
		
		st.close();
		closeConn();
		
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			}
		}
}



