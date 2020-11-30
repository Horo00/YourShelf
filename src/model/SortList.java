package model;


import java.util.Comparator;

import javabeans.Book;

public class SortList implements Comparator<Book> {
	String so1;
	String so2;

	@Override
	public int compare(Book o1, Book o2) {
		//作者のあいうえお順
		so1 = o1.getAuthors();
		so2 = o2.getAuthors();

		//昇順ソート
		//return so1.compareTo(so2);

		//降順ソート
		return so2.compareTo(so1);
	}
}

