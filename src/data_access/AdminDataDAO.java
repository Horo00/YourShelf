package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import javabeans.Book;

public class AdminDataDAO {

	ConnectionShelf connector;

	public boolean addBook(Book book) {
		//SQLを設定
		//1:ISBN
		final String SQL =
				"INSERT INTO admindata(books_id,isbn,boughtdate,count,checkedout_date) VALUES(NULL,?,date(now()),0,NULL)";

		connector = new ConnectionAdmin();

		try (Connection connection = connector.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)) {

			statement.setString(1, book.getIsbn());

			//アップデートできたかのチェック。１なら成功
			int isSuccess = statement.executeUpdate();
			if (isSuccess == 1) {
				AllBooksDAO dao = new AllBooksDAO();
				dao.addBookInfo(book);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Book> searchBook() {
		final String SQL ="SELECT books_id,admindata.isbn,count,title,authors,publisher,image_url  FROM admindata JOIN all_books ON admindata.isbn = all_books.isbn";
		connector = new ConnectionUser();

		try(Connection connection = connector.getConnection();
				Statement statement = connection.createStatement()){

			List<Book> lists = new ArrayList<>();

			ResultSet rs = statement.executeQuery(SQL);
			while (rs.next()) {
				Book book = new Book();
				book.setBooksId	(rs.getInt("books_id"));
				book.setIsbn	(rs.getString("isbn"));
				book.setCount	(rs.getInt("count"));
				book.setTitle	(rs.getString("title"));
				book.setAuthors	(rs.getString("authors"));
				book.setPublisher(rs.getString("publisher"));
				book.setImgUrl	(rs.getString("image_url"));

				lists.add(book);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}