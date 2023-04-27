package cookie.DAO;

import cookie.DTO.LoginForm;
import cookieDemo.database.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class CRUDoperations {
	
	public static HashMap getUsers(LoginForm formValue) throws SQLException {
		
		Connection dbCon = DbConnection.getConnection();
		HashMap<String, String> usersMapping = new HashMap<>();
		PreparedStatement queryStm = dbCon.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");

		queryStm.setString(1, formValue.getUsername());
		queryStm.setString(2, formValue.getPassword());

		System.out.println(queryStm);

		ResultSet output = queryStm.executeQuery();

		while(output.next()) {
			usersMapping.put(output.getString(2), output.getString(3));
			// usersMapping.put(output.getString(3), output.getString(3));
		}

		return usersMapping;
	}

	public static int insert(LoginForm formValue) throws SQLException {

		Connection dbCon = DbConnection.getConnection();

		PreparedStatement queryStm = dbCon.prepareStatement("INSERT INTO users (username, password) VALUES(?, ?)");

		queryStm.setString(1, formValue.getUsername());
		queryStm.setString(2, formValue.getPassword());

		System.out.println(queryStm);

		int output = queryStm.executeUpdate();

		return output;
	}
	
}
