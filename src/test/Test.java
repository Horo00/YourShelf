package test;

import java.util.ArrayList;
import java.util.List;

import data_access.HavingBookDAO;
import data_access.UserDAO;
import javabeans.Book;
import javabeans.LendingBook;
import javabeans.UserDTO;

public class Test {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		UserDTO dto = new UserDTO(1, "川", "pass");
		Book book = new Book();
//		LendingBook book = new LendingBook();
		book.isbn("1234567890125")
			.title("sample")
			.authors("川田!");
		HavingBookDAO dao2 = new HavingBookDAO();
		dao2.addBook(book);
		
		List<LendingBook> list = new ArrayList<>();
		list = dao2.searchBook();
//		book.setBooksId(1);
//		book.setLendingBookId(6);
//		LendingBookDAO dao2 = new LendingBookDAO();
//		if(dao2.returnBook((LendingBook)book)) {
//			System.out.println("成功");
//		}else {
//			System.out.println("失敗");
//		}

//
//		List<LendBookHistroy> lists = new ArrayList<>();
//		LendingBookDAO dao2 = new LendingBookDAO();
//		lists = dao2.getBookHistroy();
//
		for (LendingBook lendingBook : list) {
			System.out.println(lendingBook.getIsbn());
		}

//				UserDTO dto = dao.addUser("川田", "pass");
//				System.out.println(dto.getId());

//		java.util.List<UserDTO> lists = dao.getUserList();
//		System.out.println(lists);

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
