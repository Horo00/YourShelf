package helper;

import java.util.ArrayList;
import java.util.List;

import javabeans.LendingBook;

public class SearchBook {

	public static List<LendingBook> search(List<LendingBook> book, String keyword) {
		List<LendingBook> selectBook = new ArrayList<LendingBook>();
		for (LendingBook lendingBook : book) {
			//タイトルの中にキーワードが含まれていればselectBookに格納する
			if(lendingBook.getTitle().contains(keyword)) {
				selectBook.add(lendingBook);
				continue;
			}

			//作者名の中にキーワードが含まれていればselectBookに格納する
			if(lendingBook.getAuthors().contains(keyword)) {
				selectBook.add(lendingBook);
			}
		}
		return selectBook;

	}
}
