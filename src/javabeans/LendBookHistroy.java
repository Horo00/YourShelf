package javabeans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import helper.TimeHelper;

public class LendBookHistroy extends LendingBook implements Serializable {

	private LocalDate returnDate;

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		if (returnDate != null) {
			this.returnDate = TimeHelper.dateToLocalDate(returnDate);
		}
	}
}
