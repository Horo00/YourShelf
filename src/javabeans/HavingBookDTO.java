package javabeans;

import java.io.Serializable;

public class HavingBookDTO implements Serializable{
	private int booksId;			//主キー(オートインクリメント)
	private String isbn; 				//13桁の書籍コード
	private String boughtDate; 		//日付データ
	private int count; 				//貸出された回数
	private String checkedOutDate;	//貸出日

	public HavingBookDTO() {
		//デフォルトコンストラクタ
	}

	public int getBooksId() {
		return booksId;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getBoughtDate() {
		return boughtDate;
	}
	public int getCount() {
		return count;
	}
	public String getCheckedOutDate() {
		return checkedOutDate;
	}

	public void setBooksId(int booksId) {
		this.booksId = booksId;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setBoughtDate(String boughtDate) {
		this.boughtDate = boughtDate;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setCheckedOutDate(String checkedOutDate) {
		this.checkedOutDate = checkedOutDate;
	}



}
