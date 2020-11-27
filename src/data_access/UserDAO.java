package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import javabeans.Login;
import javabeans.UserDTO;

public class UserDAO {
	/**
	 * @param userName
	 * @param password
	 * @return UserDTO
	 * 新規登録時のユーザー登録(INSERT)メソッド
	 */
	public UserDTO addUser(String userName, String password) {
		//idはオートインクリメントなためデフォルト入力値はnull
		final String SQL = "INSERT INTO USER(id,name,password) VALUES(NULL,?,?)";

		try (Connection connection = ConnectionUser.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)) {

			statement.setString(1, userName);
			statement.setString(2, password);

			//アップデートできたかのチェック。１なら成功
			int isSuccess = statement.executeUpdate();
			if (isSuccess == 1) {
				//アップデート成功の場合UserDTOを作成し、リターンする
				UserDTO dto = new UserDTO(userName, password);
				//dtoにID値をセット
				setUserId(dto);
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		//何かしらアップデートができなければnullを返す
		return null;
	}

	/**
	 * @param dto
	 * UserDTOのnameとpasswordの値からDBに保管されているid値を取得、セットする
	 */
	private void setUserId(UserDTO dto) {
		final String SQL = "SELECT id FROM USER WHERE name = ? AND password = ?";
		try(Connection connection = ConnectionUser.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)){

			statement.setString(1, dto.getName());
			statement.setString(2, dto.getPassword());

			ResultSet rs = statement.executeQuery();

			if(rs.next()) {
				dto.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param login
	 * @return UserDTO
	 * ログイン時に入力されたパラメータから該当するユーザーを抽出
	 * 抽出されたユーザーでUserDTOのインスタンスを作成し、リターンする
	 * 該当するユーザーがいなければnullを返す
	 */
	public UserDTO findByLogin(Login login) {
		final String SQL = "SELECT id,name,password FROM USER WHERE name = ? AND password = ?";
		try(Connection connection = ConnectionUser.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)){

			statement.setString(1, login.getName());
			statement.setString(2, login.getPassword());

			ResultSet rs = statement.executeQuery();

			if(rs.next()) {
				int		id		= rs.getInt		("id");
				String	name	= rs.getString	("name");
				String	password = rs.getString	("password");

				return new UserDTO(id,name,password);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
