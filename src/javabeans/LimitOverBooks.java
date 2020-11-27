package javabeans;

public class LimitOverBooks extends Book{
	private String checkedoutDate;

	public LimitOverBooks() {	}

	public String getCheckedoutDate() {
		return checkedoutDate;
	}

	public void setCheckedoutDate(String checkedoutDate) {
		this.checkedoutDate = checkedoutDate;
	}

	public LimitOverBooks checkedoutDate(String checkedoutDate) {
		this.checkedoutDate = checkedoutDate;
		return this;
	}
}