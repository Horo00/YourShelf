package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public class ConnectionUser {
	static Connection getConnection() throws NamingException, SQLException {
//		InitialContext context = new InitialContext();
//		DataSource source = null;
//
//		source = (DataSource) context.lookup("java:/comp/env/jdbc:db");
//		return source.getConnection();

		final String URL = "jdbc:mysql://localhost:3306/your_shelf?serverTimezone=JST";
		final String USER = "administrator";
		final String PASS = "password";
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
