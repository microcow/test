package cha16;
import java.util.Calendar;
public class Ex01Calendar {
	public static void main(String[] args) {
		//Calendar 클래스와 Date 클래스는 구식방식임
		
		Calendar now = Calendar.getInstance();
		// Calendar.getInstance() 메소드는 현재 날짜(년,월,일,시,분,초)가 저장되어있는 '정돈되지 않은' 시간 정보를 return한다. 
		
		int year = now.get(Calendar.YEAR);
		// Calendar 클래스의 get메소드는 아규먼트로 Calendar클래스와 변수를 보낼 경우 해당 정보를 return한다.(해당코드는 년도 return)
		// Claendar 클래스가 옛날기능이다 보니, 최신 기능인 enum에 final상수들을 저장하고 있지 않음
		System.out.println(year);
		
		int month = now.get(Calendar.MONTH) + 1;
		// 현재 월 return // 0~11까지 반환하기에 +1해줌
		System.out.println(month);
		
		int day = now.get(Calendar.DATE);
		// 현재 날짜 return
		System.out.println(day);
		
		int hour12 = now.get(Calendar.HOUR);
		// 현재 시간 return // 12시간제
		System.out.println(hour12);
		
		int hour24 = now.get(Calendar.HOUR_OF_DAY);
		// 현재 시간 return // 24시간제 
		System.out.println(hour24);
		
		int minute = now.get(Calendar.MINUTE);
		// 현재 분 return
		System.out.println(minute);
		
		int second = now.get(Calendar.SECOND);
		// 현재 초 return
		System.out.println(second);
		
		int millisecond = now.get(Calendar.MILLISECOND);
		// 현재 1/1000초 return
		System.out.println(millisecond);
		
		int ampm = now.get(Calendar.AM_PM);
		// 현재 시각인 AM인지 PM인지 return  // 0: am, 1: pm
		String strAmpm = ampm == 0 ? "AM" : "PM"; 
		//삼항 연산자
		System.out.println(ampm + ", " + strAmpm);	
		
		String[] strDayOfWeek = {"", "일", "월", "화", "수", "목", "금", "토"};
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);	
		// 현재 날짜를 숫자로 return // 1:일, 2:월, 3:화, 4:수, 5:목, 6:금, 7:토
		System.out.println(dayOfWeek + ", " + strDayOfWeek[dayOfWeek]);
		
		String strDateTime = year + "-" + month + "-" + day + " " + hour12 + ":" + minute + ":" + second + "." + millisecond 
				+ " " + strAmpm + " " + strDayOfWeek[dayOfWeek] + "요일";
		
		
		System.out.println(strDateTime);
		System.out.println();
		
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		end.set(2030, 9, 7, 0, 0, 0);
		// set메소드사용 시 아규먼트로(년 월 일 시 분 초) 수정이 가능하다. 
		System.out.println("---");	
		System.out.println(start.getTime());
		// ★ Calendar클래스의 getTime 메소드는 호출자의 정돈되지 않은 시간 정보를 Date 클래스의 타입(예_Mon Mar 18 17:28:32 KST 2024)으로 시간을 시간을 정돈하여 return한다
		System.out.println(end.getTime());
		
		long diffMilli = end.getTimeInMillis() - start.getTimeInMillis();	// 밀리세컨즈
		// Calendar클래스의 getTimeInMillis 메소드는 1970년부터 현재까지 흐른 시간을 밀리세컨즈로 반환한다
		// 둘 간의 시간 차를 밀리세컨즈로 나타내고있다.
		System.out.println(diffMilli + " 밀리초");
		long diffSecond = diffMilli / (1000);	// 초
		System.out.println(diffSecond + " 초");
		long diffMinute = diffMilli / (60 * 1000);	// 분
		System.out.println(diffMinute + " 분");
		long diffHour = diffMilli / (60 * 60 * 1000);	// 시간
		System.out.println(diffHour + " 시간");
		long diffDay = diffMilli / (24 * 60 * 60 * 1000);	// 일
		System.out.println(diffDay + " 일");
		long diffYear = diffMilli / (365 * 24 * 60L * 60 * 1000);	// 년
		// 결과값이 int 타입을 초과할 수 있기에 숫자 중 하나라도 L(long)타입을 가지고 있어야한다 (하나만 있으면 돼서 꼭 60이 가질 필요는 없음) 
		System.out.println(diffYear + " 년");
		System.out.println();
		
		System.out.print(diffDay / 365 + " 년 ");
		System.out.println(diffDay % 365 + " 일 차이");
		// diffDay를 365로 나눈 나머지
		// 이처럼 두 날짜의 차이를 비교하기엔 LocalDate 클래스의 방식보다 상당히 비효율적이다.
		System.out.println();
		
		Calendar today = Calendar.getInstance();
		System.out.println((today.getTime()).toString());
		//Date클래스의 toString메소드는 호출자를 String타입으로 return해준다. 
		/// 그럼 그냥 getInstance만 호출했을 땐 뭐지 → Calendar타입
		
		today.add(Calendar.DATE, 1);
		// 오늘 날짜에서 하루를 더하는 모습
		System.out.println(today.getTime().toString());
		
		today.add(Calendar.DATE, -1);
		System.out.println(today.getTime().toString());
		
		today.set(Calendar.DATE, 22);
		System.out.println(today.getTime().toString());
	}
}
