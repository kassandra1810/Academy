package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=academy;";
		String user = "academy_user";
		String pass = "academy_user";
		
		try {
			System.out.println("Connecting to database: "+ jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
		
			System.out.println("Connection successful!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
