package model;

import data_access.UserDAO;
import javabeans.Login;
import javabeans.UserDTO;

public class LoginLogic {
	public UserDTO execute(Login login) {
		UserDAO dao=new UserDAO();
		UserDTO account=dao.findByLogin(login);
		return account;
	}

}
