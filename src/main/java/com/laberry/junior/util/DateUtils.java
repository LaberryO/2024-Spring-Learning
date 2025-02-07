package com.laberry.junior.util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static String formatDate(LocalDateTime date) {
		DateTimeFormatter formatter;
		if (date == null) {
			return null;
		}
		if (isToday(date)) {
			formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		} else if (isYear(date)) {
			formatter = DateTimeFormatter.ofPattern("MM월 dd일 HH시 mm분 ss초");
		} else {
			formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		}
		return date.format(formatter);
	}
	
	private static Boolean isToday(LocalDateTime date) {
		return date.toLocalDate().isEqual(LocalDate.now());
	}
	
	private static Boolean isYear(LocalDateTime date) {
		return date.getYear() == LocalDateTime.now().getYear();
	}
}
