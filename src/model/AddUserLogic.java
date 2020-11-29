package model;

import data_access.UserDAO;

public class AddUserLogic {

	public static void add(String name,String password) {
		String hashPassword = Hash.getHash(password);
		
		UserDAO dao = new UserDAO();
		dao.addUser(name, hashPassword);
	}

}
