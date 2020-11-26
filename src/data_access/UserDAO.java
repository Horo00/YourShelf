package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import javabeans.UserDTO;

public class UserDAO {

	public UserDTO addUser(String userName,String password) {
		final String SQL ="insert into user values(null,?,?)";

		try(Connection connection = ConnectionUser.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)){

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;
	}
}
