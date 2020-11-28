package javabeans;

import java.io.Serializable;
import java.util.Date;

public class LendingBook extends Book implements Serializable{
	private int userId;
	private int lendingBookId;
	private Date checkedoutDate;

	public LendingBook() {}



	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLendingBookId() {
		return lendingBookId;
	}
	public void setLendingBookId(int lendingBookId) {
		this.lendingBookId = lendingBookId;
	}
	public Date getCheckedoutDate() {
		return checkedoutDate;
	}

	public void setCheckedoutDate(Date checkedoutDate) {
		this.checkedoutDate = checkedoutDate;
	}

	public LendingBook userId(int userId) {
		this.userId = userId;
		return this;
	}

	public LendingBook checkedoutDate(Date checkedoutDate) {
		this.checkedoutDate = checkedoutDate;
		return this;
	}

}
