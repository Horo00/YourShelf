package model;

import data_access.UserDAO;
import javabeans.Login;
import javabeans.UserDTO;

public class LoginLogic {

	public boolean loginAdmin(Login login) {
		String name = login.getName();
		String password = login.getPassword();

		return (name.equals("admin") && password.equals("password"));
	}

	public UserDTO execute(Login login) {

		String name = login.getName();
		String password = login.getPassword();

		//管理者ログインであれば管理者データとして返す
		if(name.equals("admin") && password.equals("password")) {
			UserDTO account = new UserDTO(0, name, password);
			return account;
		}

		//ユーザーログインの場合
		//ログインbeansのパスワードをハッシュ化された数値に変換しセット
		login.setPassword(Hash.getHash(login.getPassword()));

		UserDAO dao=new UserDAO();
		UserDTO account=dao.findByLogin(login);

		return account;
	}

}
