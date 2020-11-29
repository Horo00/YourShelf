package helper;

import java.sql.Date;
import java.time.LocalDate;

public class TimeHelper {

	public static LocalDate LimitCalc(LocalDate date) {
		return date.plusDays(14);
	}

	/**
	 * sql.Date->LocalDateに変換
	 * @param date
	 * @return LocalDate
	 */
	public static LocalDate dateToLocalDate(Date date) {
		return date.toLocalDate();
	}
}
