package javabeans;

public class LendingBook extends Book{
	private int userId;
	private String checkedoutDate;

	public LendingBook() {}



	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCheckedoutDate() {
		return checkedoutDate;
	}

	public void setCheckedoutDate(String checkedoutDate) {
		this.checkedoutDate = checkedoutDate;
	}

	public LendingBook userId(int userId) {
		this.userId = userId;
		return this;
	}

	public LendingBook checkedoutDate(String checkedoutDate) {
		this.checkedoutDate = checkedoutDate;
		return this;
	}

}
