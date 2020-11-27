package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public class ConnectionAdmin implements ConnectionShelf{

	@Override
	public Connection getConnection() throws NamingException, SQLException {
		final String USER = "administrator";
		final String PASS = "password";
		return DriverManager.getConnection(URL, USER, PASS);
	}

}