package cha16;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.Duration;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.YEARS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;
import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.NANOS;
public class Ex03LocalDate {
	public static void main(String[] args) {
		// LocalDate클래스가 신식임
		
		// 메소드의 클래스 / 파라미터 타입 / 리턴 타입 잘 확인하기
		
		// 년,월,일 을 비교하려면 호출자를 Period클래스로, 시,분,초를 비교하려면 호출자를 Duration클래스로
			
		System.out.println("java.time.LocalDate");
		LocalDate date1 = LocalDate.of(2020, 5, 6);
		// LocalDate클래스는 년,월,일만 저장되는 클래스이다.
		LocalDate date2 = LocalDate.now();
		// now메소드는 현재 날짜를 return해준다.
		System.out.println(date1.toString());
		// LocalDate의 toString메소드는 호출자의 값을 String타입으로 return해준다.
		System.out.println(date2);
		System.out.println();
		
		System.out.println("long java.time.temporal.ChronoUnit.between(Temporal t1, Temporal t2)");
		System.out.println(ChronoUnit.YEARS.between(date1, date2));
		// ChronoUnit이넘의 between메소드는 두 아규먼트가 몇년(YEARS) 차이 나는지 return해준다.
		System.out.println(MONTHS.between(date1, date2));
		// import static java.time.temporal.ChronoUnit.MONTHS;을 해주었기에 해당 이넘멤버는 이넘.이넘멤버 형태가 아닌 바로 이넘멤버로 쓸 수 있다.
		System.out.println(DAYS.between(date1, date2));
		System.out.println();
		
		System.out.println("long java.time.LocalDate.until(Temporal t, TemporalUnit u)");
		System.out.println(date1.until(date2, YEARS));
		// until메소드를 통해서도 호출자와 아규먼트1이 몇년 차이가 나는지 알 수 있다.
		// 이처럼 Calendar클래스보다 훨씬 같편하게 날짜의 차이를 계산할 수 있다.
		System.out.println(date1.until(date2, MONTHS));
		System.out.println(date1.until(date2, DAYS));
		System.out.println();
		
		System.out.println("Period java.time.LocalDate.until(ChronoLocalDate d)");
		Period p = date1.until(date2);
		// LocalDate 클래스의 인스턴스가 until메소드를 아규먼트 하나로 호출할 경우, 호출자와 아규먼트가 몇년 몇월 며칠 차이나는지 값을 Period클래스 타입의 인스턴스로 return한다
		System.out.println(p.getYears() + "년 " + p.getMonths() + "개월 " + p.getDays() + "일");
		// get~~~ 메소드는 각각 호출자의 년,월,일의 값을 return해준다.
		// 단, 위 메소드들은 나머지 값을 return한다. (예_p2의 값이 3년 10개월이라면, getMonths는 10개월이라는 값만 return한다.) 
		System.out.println();
		
		System.out.println("Period java.time.Period.between(LocalDate d1, LocalDate d2)");
		Period p2 = Period.between(date1, date2);
		// Period 클래스의 between클래스를 통해서도 두 아규먼트간 날짜의 차이를 알 수 있다. (두 아규먼트의 날짜 차이를 인스턴스에 저장)
		// 년,월,일 을 비교하려면 호출자를 Period클래스로, 시,분,초를 비교하려면 호출자를 Duration클래스로 해야한다.
		System.out.println(p2.getYears() + "년 " + p2.getMonths() + "개월 " + p2.getDays() + "일");
		System.out.println();
		
		System.out.println(date1.plus(Period.of(1, 3, 5)));
		// plus 메소드를 통해 호출자의 년 월 일 에 1년 3개월 5일을 더하는 모습 (아규먼트로 of메소드를 통해 Period 타입의 인스턴스를 생성하며 던지고 있음)
		// 메소드의 파라미터 타입이 인터페이스 타입이라면, 해당 인터페이스를 구현하고 있는 인스턴스만 아규먼트로 던질 수 있음(그래야 업캐스팅 가능)
		// plus와 minus 메소드는 Period클래스와 Duration 클래스로만 아규먼트 가능
		System.out.println(date1.minus(Period.ofMonths(5)));
		// minus 메소드를 통해 날짜를 뺄수도 있다
		// of메소드나 ofmonths ofyears ofWeeks등 아무거나 사용
		System.out.println();
		
		System.out.println("java.time.LocalDateTime");
		LocalDateTime datetime1 = LocalDateTime.of(2021, 8, 7, 19, 55, 22);
		// LocalDateTime 클래스는 년, 월, 일, 시, 분, 초까지 저장이 가능하다.
		LocalDateTime datetime2 = LocalDateTime.now();
		System.out.println(datetime1);
		System.out.println(datetime2);
		System.out.println();
		
		System.out.println("long java.time.temporal.ChronoUnit.between(Temporal t1, Temporal t2)");
		System.out.println(YEARS.between(datetime1, datetime2));
		System.out.println(MONTHS.between(datetime1, datetime2));
		System.out.println(DAYS.between(datetime1, datetime2));
		System.out.println(HOURS.between(datetime1, datetime2));
		System.out.println(MINUTES.between(datetime1, datetime2));
		System.out.println();
		
		System.out.println("long java.time.LocalDateTime.until(Temporal t, TemporalUnit u)");
		System.out.println(datetime1.until(datetime2, YEARS));
		System.out.println(datetime1.until(datetime2, MONTHS));
		System.out.println(datetime1.until(datetime2, DAYS));
		System.out.println(datetime1.until(datetime2, HOURS));
		System.out.println(datetime1.until(datetime2, MINUTES));
		System.out.println();
		
		System.out.println(datetime1.plusYears(1));
		System.out.println(datetime1.minusDays(2));
		System.out.println(datetime1.withYear(2019));
		// 년도 설정 메소드
		System.out.println(datetime1.with(TemporalAdjusters.firstDayOfMonth()));
		// 날짜 설정 메소드 with를 통해 firstDayOfMonth 그 달의 첫번째 날짜로 설정 가능
		System.out.println(datetime1.with(TemporalAdjusters.lastDayOfMonth()));
		LocalDateTime datetime3 = datetime1.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
		// 날짜 설정 메소드 with를 통해 lastInMonth 그 달의 마지막 일요일 날짜로 설정 가능
		System.out.println(datetime3.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
		// 날짜 설정 메소드 with를 통해 next 그 달의 다음주 금요일 날짜로 설정 가능
		System.out.println();
		
		
		System.out.println("java.time.LocalTime");
		LocalTime time1 = LocalTime.of(1, 10, 20);
		// LocalTime 클래스는 시, 분, 초 만 저장 가능하다.
		LocalTime time2 = LocalTime.of(2, 11, 50, 999123456); //999123456은 나노 세컨드(10억분의 1초)
		LocalTime time3 = LocalTime.now();

		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
		System.out.println();
		
		System.out.println("long java.time.temporal.ChronoUnit.between(Temporal t1, Temporal t2)");
		System.out.println(HOURS.between(time1, time2));
		System.out.println(MINUTES.between(time1, time2));
		System.out.println(SECONDS.between(time1, time2));
		System.out.println(MILLIS.between(time1, time2));
		System.out.println(NANOS.between(time1, time2));
		System.out.println();

		System.out.println("long java.time.LocalTime.until(Temporal t1, TemporalUnit t2)");
		System.out.println(time1.until(time2, HOURS));
		System.out.println(time1.until(time2, MINUTES));
		System.out.println(time1.until(time2, SECONDS));
		System.out.println(time1.until(time2, MILLIS));
		System.out.println(time1.until(time2, NANOS));
		System.out.println();
		// LocalTime 클래스는 아규먼트가 하나인 until메소드가 없다
		
		System.out.println("Duration java.time.Duration.between(Temporal t1, Temporal t2)");
		Duration d = Duration.between(time1, time2);
		System.out.println(d.getSeconds());
		System.out.println(d.getNano());
		System.out.println();
		
		Duration d2 = Duration.of(55, SECONDS);
		System.out.println(time1.minus(d2));
		System.out.println(time1.plus(30, SECONDS));
		System.out.println();
		
		System.out.println("DateTimeFormatter");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// DateTimeFormatter 클래스의 ofPattern 메소드를 이용해서 날짜 출력 패턴을 바꿀 수 있다
		System.out.println("----");
		System.out.println(datetime1.format(df));
		// (앞서 Ex02 Date챕터)에서 사용된 format 메소드와는 다르게 호출자의 값이 아규먼트 형태로 변경되어 return되고 있으나,
		// 아규먼트와 호출자가 바뀌어도 해당 클래스 들에서 똑같이 기능하도록 구현하고 있기에 누가 호출하고 누가 아규먼트이고는 크게 상관이 없다 (단, DateFormat 클래스의 format은 아님)
		System.out.println(datetime2.format(df));
		System.out.println();
		
		DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
		Scanner s = new Scanner(System.in);
		System.out.print("yyyy년MM월dd일 패턴으로 날짜를 입력해 주세요: ");
		String inputDate = s.nextLine();
		
		LocalDate date3 = LocalDate.parse(inputDate, df2);
		// ★★ LocalDate클래스의 parse메소드는 String 타입의 아규먼트1을 아규먼트2 포맷(날짜타입)으로 변형시켜 LocalDate타입으로 return해준다.
		LocalDateTime datetime4 = date3.atStartOfDay();
		// LocalDateTime클래스의 atStartOfDay메소드는 년 월 일의 값만 있는 LocalDate클래스 인스턴스를 년,월,일에 0시,0분,0초가 있는 LocalDateTime으로 변형시켜 return한다.
		System.out.println(datetime4);
		datetime4 = date3.atTime(1, 15, 55);
		// LocalDateTime클래스의 atStartOfDay메소드는 년 월 일의 값만 있는 LocalDate클래스 인스턴스를 년,월,일에 아규먼트로 설정한 시, 분 ,초도 출력될 수 있게 LocalDateTime으로 return한다.
		System.out.println(datetime4);
		System.out.println(df.format(datetime4));

		
	}

}
