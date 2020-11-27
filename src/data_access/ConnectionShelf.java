package data_access;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

interface ConnectionShelf {
	String URL = "jdbc:mysql://localhost:3306/your_shelf?serverTimezone=JST";

	Connection getConnection() throws NamingException, SQLException;
}
