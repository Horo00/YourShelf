package data_access;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUser {
	static Connection getConnection() throws NamingException, SQLException {
		InitialContext context;
		DataSource source = null;
			context = new InitialContext();
			source = (DataSource) context.lookup("java:/comp/env/jdbc:db");
			return source.getConnection();
	}
}
