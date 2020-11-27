package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import javabeans.Book;
import javabeans.LendingBookDTO;
import javabeans.UserDTO;

public class LendingBookDAO {

	ConnectionShelf connector;

	public List<LendingBookDTO> getLendingBookList() {
		return null;
	}

	public boolean lendBook(UserDTO user, Book book) {
		//SQLの設定
		//①userId
		//②isbn
		final String SQL = "INSERT INTO lending_book(lending_book_id,id,isbn,checkedout_date) VALUES(NULL,?,?,date(now()))";

		connector = new ConnectionUser();

		try (Connection connection = connector.getConnection()) {

			//トランザクション処理のためオートコミットをオフにする
			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(SQL)) {

				statement.setInt(1, user.getId());
				statement.setString(2, book.getIsbn());

				statement.executeUpdate();

				//having_bookDBにアップデート処理を行う
				HavingBookDAO dao = new HavingBookDAO();
				boolean isSuccess = dao.lendBook(book);
				if (isSuccess) {
					connection.commit();
					return true;
				} else {
					//失敗時はロールバックを行う
					connection.rollback();
				}
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		return false;
	}
}
