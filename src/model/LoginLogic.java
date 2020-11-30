package model;

import data_access.UserDAO;
import javabeans.Login;
import javabeans.UserDTO;

public class LoginLogic {
	public static UserDTO execute(Login login) {
		//ログインbeansのパスワードをハッシュ化された数値に変換しセット
		login.setPassword(Hash.getHash(login.getPassword()));

		UserDAO dao=new UserDAO();
		UserDTO account=dao.findByLogin(login);

		return account;
	}

}
