package cha16;

import java.util.Calendar;

public class Ex01Calendartest {
	public static void main(String[] args) {
	Calendar start = Calendar.getInstance();
	Calendar end = Calendar.getInstance();
	
	start.set(2000, 11, 1, 0, 0, 0);
	end.set(2020, 4, 6, 0, 0, 0);
	
	long diffMilli = end.getTimeInMillis() - start.getTimeInMillis();
	System.out.println(diffMilli);
	
	long diffDay = diffMilli / (24 * 60 * 60 * 1000);
	System.out.println(diffDay + " 일");
	long diffYear = diffMilli / (365 * 24 * 60L * 60 * 1000);
	System.out.println(diffYear + " 년");
	
	System.out.println(diffYear + "년" + diffDay % 365 + "일 차이");
	}
}
/*
문제 1.
2000년 12월 1일 
2020년 5월 6일 
두 날짜 간의 차이를 계산하여 n년 n일과 같은 패턴으로 출력하세요. 
*/