package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import javabeans.Book;

public class AdminDataDAO {

	ConnectionShelf connector;

	public boolean addBook(Book book) {
		//SQLを設定
		//1:ISBN
		final String SQL =
				"INSERT INTO ADMINDATA(books_id,isbn,boughtdate,count,checkedout_date) VALUES(NULL,?,date(now()),0,NULL)";

		connector = new ConnectionAdmin();

		try (Connection connection = connector.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)) {

			statement.setString(1, book.getIsbn());

			//アップデートできたかのチェック。１なら成功
			int isSuccess = statement.executeUpdate();
			if (isSuccess == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return false;
	}

}
