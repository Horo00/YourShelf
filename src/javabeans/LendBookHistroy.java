package javabeans;

import java.util.Date;

public class LendBookHistroy extends LendingBook{
	private Date returnDate;

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public LendBookHistroy returnDate(Date returnDate) {
		this.returnDate = returnDate;
		return this;
	}
}
