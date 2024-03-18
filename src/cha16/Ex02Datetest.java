package cha16;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Ex02Datetest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy/MM/dd");
		System.out.print("yyyy/MM/dd 패턴으로 날짜를 입력해 주세요");
		String date = scan.nextLine(); // 입력 값 = 2020/11/11
		Date today = null;
		try {
			today = fomat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar nextmonth = Calendar.getInstance();
		nextmonth.setTime(today);
		nextmonth.add(Calendar.MONTH, 1);
		
		System.out.println(fomat.format(nextmonth.getTime()));
		// 아규먼트에 저장된 Date클래스 타입의 날짜(예_Mon Mar 18 17:28:32 KST 2024)를 format메소드를 통해 호출자의 방식대로 변환
		// 아규먼트로 nextmonth.getTime() 입력
		
		System.out.println(nextmonth.getTime());
		//format을 메소드를 쓰지않을 경우 Date클래스 타입의 날짜(Mon Mar 18 17:28:32 KST 2024)로 출력될 것임
	}
}
/*
문제1.
yyyy년MM월dd 패턴으로 입력 받아 1개월 뒤의 날짜를 yyyy/MM/dd 패턴으로 출력하세요.
*/