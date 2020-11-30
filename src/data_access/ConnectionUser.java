package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public class ConnectionUser implements ConnectionShelf{
	public Connection getConnection() throws NamingException, SQLException {
//		InitialContext context = new InitialContext();
//		DataSource source = null;
//
//		source = (DataSource) context.lookup("java:/comp/env/jdbc:db");
//		return source.getConnection();

		final String USER = "user";
		final String PASS = "password";
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
