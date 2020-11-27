package test;

import data_access.UserDAO;
import javabeans.UserDTO;

public class Test {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
//		String result = dao.test("川田9", "password");
//		System.out.println(result);

		UserDTO dto = dao.addUser("さわい","pass");
		System.out.println(dto);
	}
}
