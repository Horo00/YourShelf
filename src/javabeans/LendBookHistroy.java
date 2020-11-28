package javabeans;

import java.io.Serializable;
import java.util.Date;

public class LendBookHistroy extends LendingBook implements Serializable{
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
