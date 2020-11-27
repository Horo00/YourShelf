package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import javabeans.Book;
import javabeans.LendingBookDTO;
import javabeans.LimitOverBooks;

public class AllBooksDAO {

	ConnectionShelf connector;

	public void addBookInfo(Book book) {

		//SQLを設定
		//①ISBN/②本のタイトル/③作者/④出版社/⑤画像ＵＲＬ
		final String SQL = "INSERT INTO all_books(isbn,title,authors,publisher,image_url) VALUES(?,?,?,?,?)";

		connector = new ConnectionAdmin();

		try (Connection connection = connector.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)) {

			statement.setString(1,book.getIsbn() );
			statement.setString(2,book.getTitle() );
			statement.setString(3,book.getAuthors() );
			statement.setString(4,book.getPublisher() );
			statement.setString(5,book.getImgUrl() );

			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NamingException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
	}

	public List<LimitOverBooks> getLimitOverBookList(List<LendingBookDTO> dto) {

		return null;
	}

	public void searchBookInfo(Book book) {

	}
}
