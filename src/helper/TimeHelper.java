package helper;

import java.sql.Date;
import java.time.LocalDate;

public class TimeHelper {

	public static LocalDate LimitCalc(LocalDate date) {
		if (date != null) {
			return date.plusDays(14);
		}
		return null;
	}

	/**
	 * sql.Date->LocalDateに変換
	 * @param date
	 * @return LocalDate
	 */
	public static LocalDate dateToLocalDate(Date date) {
		if (date != null) {
			return date.toLocalDate();
		}
		return null;
	}
}
