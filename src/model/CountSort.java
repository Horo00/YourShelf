package model;

import java.util.Comparator;

import javabeans.Book;

public class CountSort implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO 自動生成されたメソッド・スタブ
		return o2.getCount() - o1.getCount();
	}

}
