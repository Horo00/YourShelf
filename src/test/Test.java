package test;

import data_access.UserDAO;
import javabeans.Login;
import javabeans.UserDTO;

public class Test {
	public static void main(String[] args) {
		//		List<Book> listsBooks = new ArrayList<Book>();
		//		if (listsBooks == null) {
		//			System.out.println("空");
		//		}
		//		if(listsBooks.isEmpty()) {
		//			System.out.println("enpty");
		//		}
		UserDAO dao = new UserDAO();

//				UserDTO dto = dao.addUser("川田", "pass");
//				System.out.println(dto.getId());

//		java.util.List<UserDTO> lists = dao.getUserList();
//		System.out.println(lists);
		
		

				Login login = new Login("川田", "pass");
				UserDTO dto2 =dao.findByLogin(login);
				System.out.println(dto2.getId());
				
		//		System.out.println(dto);
		//		Test2 test = new Test2();
		//
		//		Book book = new Book();
		//		book.setIsbn("1234567890124");
		//		test.addBook(book);
		//		System.out.println(book.getTitle());
		//
		//		Book book2 = new LendBookHistroy();
		//		test.addBook(book2);
		//		System.out.println(book2.getTitle());
		//
		//		LendBookHistroy book3 = new LendBookHistroy();
		//		test.addBook(book3);
		//		System.out.println(book3.getTitle());

		//		HavingBookDAO adminDao = new HavingBookDAO();
		//		if(adminDao.addBook(book)) {
		//			System.out.println("成功");
		//		} else {
		//			System.out.println("失敗");
		//		}
		//		UserDTO dto2 = dao.addUser("さわい","pass");
		//		System.out.println(dto2);
	}
}
