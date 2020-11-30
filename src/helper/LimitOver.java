package helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javabeans.LendingBook;

public class LimitOver {
	
	public static List<LendingBook> sorting(List<LendingBook> books){
		List<LendingBook> overBooks = new ArrayList<LendingBook>();
		
		for (LendingBook lendingBook : books) {
			//返却期限の日にちを取得
			LocalDate returnSchedule = lendingBook.getReturnScheduleDate();
			//現在日にちを取得
			LocalDate now = LocalDate.now();
			
			//返却期限が現在日にちよりも前（返却期限が切れていれば）trueを返す
			boolean isOver = returnSchedule.isBefore(now);
			if(isOver) {
				overBooks.add(lendingBook);
			}
		}
		//返却期限切れ一覧を返す
		return overBooks;
	}

}
