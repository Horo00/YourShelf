package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionUser {
	Connection getConnection() {
		InitialContext context;
		DataSource source = null;

		try {
			context = new InitialContext();
			source = (DataSource) context.lookup("java:/comp/env/jdbc:db");
			try(Connection connection = source.getConnection()){
				return connection;
			}catch (SQLException e) {
				// TODO: 何か
				return null; //とりあえず
			}
		} catch (Exception e) {
			// TODO: 何か
			return null; //とりあえず
		}
	}
}
