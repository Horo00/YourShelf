package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import javabeans.Book;
import javabeans.LendBookHistroy;
import javabeans.LendingBook;
import javabeans.LendingBookDTO;
import javabeans.UserDTO;

public class LendingBookDAO {

	ConnectionShelf connector;

	public List<LendingBookDTO> getLendingBookList() {
		return null;
	}

	/**
	 * @param user
	 * @param book
	 * @return 成功->true
	 * 本の貸し出しボタンが押されればユーザー情報と本の情報を貸し出し簿テーブルに登録
	 * 所有本一覧テーブルの該当書籍の貸し出し中カラムを[貸し出し中(1)]に書き換える
	 * 両方のテーブル処理が終わってからコミットを行う(トランザクション処理)
	 */
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

				int successCount = statement.executeUpdate();

				//貸し出し簿への処理成功時
				if (successCount == 1) {
					//having_bookDBにアップデート処理を行う
					HavingBookDAO dao = new HavingBookDAO();
					boolean isSuccess = dao.lendBook(book);
					if (isSuccess) {
						//成功時のみコミットを行う
						connection.commit();
						return true;
					}
				}
				//失敗時はロールバックを行う
				connection.rollback();
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

	/**
	 * @param book
	 * @return 成功->true
	 * 貸し出し簿テーブルのアップデート及び所有書籍テーブルのアップデートを行う
	 * トランザクション処理を行い、両方とも成功で書き換え&trueを返す
	 */
	public boolean returnBook(LendingBook book) {
		//SQLの設定
		//①該当書籍を借りているユーザーID
		final String SQL = "UPDATE lending_book SET return_date = date(now()) WHERE lending_book_id = ?";

		connector = new ConnectionUser();

		try (Connection connection = connector.getConnection()) {

			//トランザクション処理のためオートコミットをオフにする
			connection.setAutoCommit(false);

			try (PreparedStatement statement = connection.prepareStatement(SQL)) {

				statement.setInt(1, book.getUserId());

				int successCount = statement.executeUpdate();

				//貸し出し簿への処理成功時
				if (successCount == 1) {
					//having_bookDBにアップデート処理を行う
					HavingBookDAO dao = new HavingBookDAO();
					boolean isSuccess = dao.returnBook(book);
					if (isSuccess) {
						//成功時のみコミットを行う
						connection.commit();
						return true;
					}
				}
				//失敗時はロールバックを行う
				connection.rollback();
			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param user
	 * @return List<LendBookHistory>
	 * 要素が空、もしくは接続失敗でnullを返す
	 * isbn,貸出日、返却日、タイトル、作者、出版社、画像URLを1オブジェクトに格納する
	 */
	public List<LendBookHistroy> searchLendBookHistory(UserDTO user) {
		//SQLの設定
		//isbnと貸出日、返却日を取得
		//①user_id
		final String SQL = "SELECT isbn,checkedout_date,return_date FROM lending_book WHERE id = ?";
		connector = new ConnectionUser();

		try (Connection connection = connector.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL)) {

			statement.setInt(1, user.getId());

			ResultSet rs = statement.executeQuery();

			List<LendBookHistroy> lists = new ArrayList<>();
			while (rs.next()) {
				LendBookHistroy book = new LendBookHistroy();
				//bookインスタンスにISBN、貸出日、返却日の情報をセット
				book.setIsbn(rs.getString("isbn"));
				book.setCheckedoutDate(rs.getDate("checkedout_date"));
				book.setReturnDate(rs.getDate("return_date"));

				BookInfoDAO dao = new BookInfoDAO();
				//ISBNから本の細かい情報を取得
				dao.searchBookInfo(book);

				lists.add(book);
			}
			//要素が空でなければListを返す
			if (!lists.isEmpty()) {
				return lists;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
