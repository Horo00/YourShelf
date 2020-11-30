package javabeans;

import java.io.Serializable;
import java.time.LocalDate;

//使わないかも？
public class HavingBookDTO implements Serializable{
	private int booksId;			//主キー(オートインクリメント)
	private String title;
	private LocalDate boughtDate; 		//日付データ
	private int count; 				//貸出された回数
	private LocalDate checkedOutDate;	//貸出日

	public HavingBookDTO() {
		//デフォルトコンストラクタ
	}

	public int getBooksId() {
		return booksId;
	}

	public void setBooksId(int booksId) {
		this.booksId = booksId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getBoughtDate() {
		return boughtDate;
	}

	public void setBoughtDate(LocalDate boughtDate) {
		this.boughtDate = boughtDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LocalDate getCheckedOutDate() {
		return checkedOutDate;
	}

	public void setCheckedOutDate(LocalDate checkedOutDate) {
		this.checkedOutDate = checkedOutDate;
	}


}
