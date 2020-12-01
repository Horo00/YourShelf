package javabeans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import helper.TimeHelper;

public class LendingBook extends Book implements Serializable{
	private int userId;
	private int lendingBookId;
	private LocalDate checkedoutDate;
	private LocalDate returnScheduleDate;
	private String userName;



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
	public LocalDate getCheckedoutDate() {
		return checkedoutDate;
	}

	public void setCheckedoutDate(Date checkedoutDate) {
		this.checkedoutDate = TimeHelper.dateToLocalDate(checkedoutDate);
		setReturnScheduleDate(this.checkedoutDate);
	}
	public void setReturnScheduleDate(LocalDate returnScheduleDate) {
		this.returnScheduleDate = TimeHelper.LimitCalc(returnScheduleDate);
	}

	public LocalDate getReturnScheduleDate() {
		return returnScheduleDate;
	}

	public void setCheckedoutDate(LocalDate checkedoutDate) {
		this.checkedoutDate = checkedoutDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
