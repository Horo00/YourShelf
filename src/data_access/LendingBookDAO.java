package data_access;

import java.util.List;

import javabeans.Book;
import javabeans.LendingBookDTO;
import javabeans.UserDTO;

public class LendingBookDAO {

	ConnectionShelf connector;

	public List<LendingBookDTO> getLendingBookList(){
		return null;
	}

	public boolean lendBook(UserDTO user,Book book) {
		final String SQL = "INSERT INTO lending_book(lending_book_id,book)";
		return false;
	}
}
