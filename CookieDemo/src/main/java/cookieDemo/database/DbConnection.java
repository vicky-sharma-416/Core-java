package cookieDemo.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection implements DbConfig {
	
	public static Connection getConnection() {
		Connection conn = null;

		try {

			Class.forName(Driver);
			conn = DriverManager.getConnection(connectionString, username, password);

		} catch(Exception err) {
			System.out.println(err);
		}
		
		return conn;
	}

}
