package javabeans;

import java.io.Serializable;

public class LendingBookDTO implements Serializable{
	private int booksId;
	private int id;
	private int isbn;
	private boolean isLending;
	private String checkedoutDate;
	private String retrunDate;

	public LendingBookDTO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getBooksId() {
		return booksId;
	}

	public void setBooksId(int booksId) {
		this.booksId = booksId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public boolean isLending() {
		return isLending;
	}

	public void setLending(boolean isLending) {
		this.isLending = isLending;
	}

	public String getCheckedoutDate() {
		return checkedoutDate;
	}

	public void setCheckedoutDate(String checkedoutDate) {
		this.checkedoutDate = checkedoutDate;
	}

	public String getRetrunDate() {
		return retrunDate;
	}

	public void setRetrunDate(String retrunDate) {
		this.retrunDate = retrunDate;
	}


}
