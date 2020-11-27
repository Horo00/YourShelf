package test;

import data_access.AdminDataDAO;
import data_access.UserDAO;
import javabeans.Book;
import javabeans.UserDTO;

public class Test {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
//		String result = dao.test("川田9", "password");
//		System.out.println(result);
//
//		UserDTO dto = dao.addUser("川田11","pass");
//		System.out.println(dto.getId());

//		List<UserDTO> lists = dao.getUserList();
//		System.out.println(lists);


//		Login login = new Login("川田", "password");
//		UserDTO dto =dao.findByLogin(login);
//
//		System.out.println(dto);

		Book book = new Book();
		book.setIsbn("1234567890124");


		AdminDataDAO adminDao = new AdminDataDAO();
		if(adminDao.addBook(book)) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}
		UserDTO dto = dao.addUser("さわい","pass");
		System.out.println(dto);
	}
}
