package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import javabeans.Book;
import javabeans.LendingBook;
import javabeans.LimitOverBooks;

public class BookInfoDAO {

	ConnectionShelf connector;

	/**
	 * HavingBookDAOのaddBook()メソッドからのみ呼び出されるメソッド
	 * 引数で受け取ったbookの情報を書籍情報テーブルに書き加える。
	 * isbnが被る可能性があるのでトランザクション処理は行わない。
	 * @param book
	 */
	public void addBookInfo(Book book) {

		//SQLを設定
		//①ISBN/②本のタイトル/③作者/④出版社/⑤画像ＵＲＬ
		final String SQL = "INSERT INTO book_info(title,authors,publisher,image_url) VALUES(?,?,?,?)";

		connector = new ConnectionAdmin();

		try (Connection connection = connector.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)) {

			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthors());
			statement.setString(3, book.getPublisher());
			statement.setString(4, book.getImgUrl());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public List<LimitOverBooks> getLimitOverBookList(List<LendingBook> dto) {

		return null;
	}

	/**
	 * 引数で受け取ったbookインスタンスに本の詳細をsetする
	 * setする項目:作者・出版社・画像url
	 * @param book
	 */
	public void searchBookInfo(Book book) {
		//SQLの設定
		//引数で受け取ったbookフィールドのisbnを参照し本の情報を受け取る
		//①isbn
		final String SQL = "SELECT authors,publisher,image_url FROM book_info WHERE title = ?";
		connector = new ConnectionUser();

		try (Connection connection = connector.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)) {

			statement.setString(1, book.getTitle());

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				book.setAuthors(rs.getString("authors"));
				book.setPublisher(rs.getString("publisher"));
				book.setImgUrl(rs.getString("image_url"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
