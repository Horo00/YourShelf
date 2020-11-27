package model;

import dao.UserDAO;
import javabeans.UserDTO;

public class LoginLogic {
	public boolean execute(Login login) {
		UserDAO dao=new UserDAO();
		UserDTO account=dao.findByLogin(login);
		return account;
	}

}
