package test;

import data_access.UserDAO;

public class Test {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		dao.addUser("川田", "password");
	}
}
