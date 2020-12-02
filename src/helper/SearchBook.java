package helper;

import java.util.ArrayList;
import java.util.List;

import javabeans.LendingBook;

public class SearchBook {

	public static List<LendingBook> search(List<LendingBook> book, String keyword) {
		String[] words = keyword.split("[ 　]",0);

		List<LendingBook> searchBook = new ArrayList<LendingBook>();
		for (LendingBook lendingBook : book) {
			int count = 0;

			for (String word : words) {
				boolean isCount = true;
				//タイトルの中にキーワードが含まれていればカウントを上げる
				if(lendingBook.getTitle().contains(word)) {
					count++;
					isCount = false;
				}

				//作者の中にキーワードが含まれていればカウントを上げる
				if(lendingBook.getAuthors().contains(word) && isCount) {
					count++;
				}

				if(count == words.length) {
					searchBook.add(lendingBook);
				}
			}
		}
		return searchBook;

	}
}
