package cha16;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;
public class Ex03LocalDatetest {
	public static void main(String[] args) {
		// 문제1
		LocalDate date1 = LocalDate.of(2000, 12, 1);
		LocalDate date2 = LocalDate.of(2020,5,6);
		System.out.println(DAYS.between(date1, date2));
		Period p = date1.until(date2);
		System.out.println(p.getYears() + "년 " + p.getMonths() + "개월 " + p.getDays() + "일");
		
		// 문제2
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println(pattern.format(time.plusMonths(1)));
	}
}
/*
문제 1.
2000년 12월 1일 
2020년 5월 6일 
두 날짜 간의 차이를 계산하여 n년 n일과 같은 패턴으로 출력하세요. 

문제 2.
yyyy년MM월dd 패턴으로 입력 받아 1개월 뒤의 날짜를 yyyy/MM/dd HH:mm:ss 패턴으로 출력하세요.
*/