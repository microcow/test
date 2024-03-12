package cha11;
import java.util.Scanner;
public class Ex01Enum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("- static final int 사용 -");
		
		System.out.print("월급날의 요일을 숫자로 입력해 주세요 (일:1 ~ 토:7): ");
		int payDay1 = s.nextInt();
		System.out.print("보너스 받는 달을 숫자로 입력해 주세요: ");
		int bonusMonth1 = s.nextInt();
		
		if (payDay1 > bonusMonth1)
			System.out.println("달과 월은 비교할 수 없으므로 잘못된 코드입니다.");
		
		switch (payDay1) { //payday1은 정수이다(인스턴스가 아님)
		case Day1.SUN: // 날짜들의 상수 집합을 Day1 클래스를 생성하여 기입한 후 사용하는 모습 (case 1. 이런식으로 해도되지만 가독성이 떨어짐)
						// Eume은 이런 상수들의 집합을 클래스로 만들었을때 불편한 점을 보완하는 기능
			System.out.println("일요일은 오후 2시에 입금됩니다.");
			break;
		case Day1.MON:
			System.out.println("월요일은 오후 3시에 입금됩니다.");
			break;
		}					 // 여기까지가 static final int 사용하여 출력하는 모습
		
		
		System.out.println();
		System.out.println("- static final 참조변수 사용");
		
		System.out.print("월급날의 요일을 숫자로 입력해 주세요 (일:1 ~ 토:7): ");
		Day2 payDay2 = Day2.valueOf(s.nextInt()); //메소드 파라미터로 입력받고있다
		// Day2클래스의 payDay2 인스턴스 생성
		/// payDay2 인스턴스 생성 시 Day2.valueOf(s.nextInt());가 무슨의미? → valueof 메소드가 클래식메소드이기에 클래스 명으로 호출
		// 예를 들어 위에서 값을 1을 입력할 경우 메소드 에서 -1되어 SUN이라는 인스턴스가 return되는데 SUN의 인스턴스 변수 ordinal의 값은 0이므로 payDay2의 ordinal값도 0으로 저장
		/// 인스턴스 생성 시 빈 생성자가 없는데 생성자를 호출하지 않아도 인스턴스 생성가능? → new Day2라고 선언하지 않아서
		
		System.out.print("보너스 받는 달을 숫자로 입력해 주세요: ");
		Month2 bonusMonth2 = Month2.valueOf(s.nextInt());
		
		/*
		if (payDay2 > bonusDay2)
			System.out.println("달과 월은 비교할 수 없으므로 잘못된 코드입니다."); → 클래스가 서로 다른 인스턴스들이기에 비교불가
		*/
		
		/*
		switch (payDay2) { 					
		case Day2.SUN:
			System.out.println("1일은 오후 2시에 입금됩니다.");
			break;
		case Day2.MON.getOrdinal(): 		
			System.out.println("2일은 오후 3시에 입금됩니다.");
			break;
		}
		*/
		
		switch (payDay2.getOrdinal()) {
		// switch문은 정수나 문자열만 비교할 수 있다 (인스턴스 통째로는 switch의 ()자리에 올 수 없다. 단,enum 타입의 인스턴스는 가능)
		// payDay2는 인스턴스기에 사용할 수 없어, getOrdinal 메소드를 활용해 정수로 정수로 변환하는 모습
		
		case 1:	// → 이와 같이 case에는 상수값이 적혀있어야 한다.
			System.out.println("일요일은 오후 2시에 입금됩니다.");
			break;
		case 2:	
			System.out.println("월요일은 오후 3시에 입금됩니다.");
			break;
		}
		
		System.out.println("\n메소드 사용");
		System.out.println((bonusMonth2.plus(3)).getOrdinal() + "월");	// 코드를 간결하게 만들 수 있다.
				/// 메소드를 2번호출 → bonusMonth2.plus(3)의 return 값이 인스턴스기에 해당 인스턴스로 메소드호출
		
										// 여기까지가 참조변수를 사용하여 출력하는 모습
		
		
		System.out.println();
		System.out.println("- enum 사용");
		
		System.out.print("월급날의 요일을 숫자로 입력해 주세요 (일:1 ~ 토:7): ");
		Day3 payDay3 = Day3.values()[s.nextInt()-1];
		// ★★ eume명.values()를 입력하면 Day3 eume에 생성된 인스턴스 7개의 배열을 생성해 return해준다 (배열은 Day3타입이다.) eume 배열 생성 예시 (Day3[] test = Day3.values();)
		// nextInt에 반환된 숫자에 -1한 값의 Day3배열을 payDay3에 저장 
		Day3 payDay4 = Day3.values()[3];
		// ★ payDay4라는 Day3 인스턴스 생성 후  Day3배열의 [3]을 저장(WED)
		System.out.println(payDay3.name()); //name 메소드 → 해당 인스턴스에 저장된 스트링을 return해준다.
		System.out.println("보너스 받는 달을 숫자로 입력해 주세요: ");
		Month3 bonusMonth3 = Month3.values()[s.nextInt()-1];
		
		/*
		if (payDay3 > bonusDay3)
			System.out.println("달과 월은 비교할 수 없으므로 잘못된 코드입니다.");
		*/
		
		switch (payDay3) { //payDay스트링과 case의 스트링을 대조
		// ★ enum 타입의 인스턴스는 switch문에 괄호 안에 사용 가능하다 ★
		case SUN:
			// 비교 대상인 eume타입의 인스턴스(payDay3)와 동일한 eume(Day3) 내 이넘 멤버들을 case에 적으면 된다.
			System.out.println("일요일은 오후 2시에 입금됩니다.");
			break;
		case MON:
			System.out.println("월요일은 오후 3시에 입금됩니다.");
			break;
		default: // eume멤버 들을 case에 모두 적지 않고 default도 없다면 컴파일에서 경고를 해준다
			System.out.println("오후 1시에 입금됩니다.");
			break;
		}
	}

}

class Day1 {
	public static final int SUN = 1;
	public static final int MON = 2;
	public static final int TUE = 3;
	public static final int WED = 4;
	public static final int THU = 5;
	public static final int FRI = 6;
	public static final int SAT = 7;
}

class Month1 {
	public static final int JAN = 1;
	public static final int FEB = 2;
	public static final int MAR = 3;
	public static final int APR = 4;
	public static final int MAY = 5;
	public static final int JUN = 6;
	public static final int JUL = 7;
	public static final int AUG = 8;
	public static final int SEP = 9;
	public static final int OCT = 10;
	public static final int NOV = 11;
	public static final int DEC = 12;
}

class Day2 {
	public static final Day2 SUN = new Day2(1); // Day2 클래스의 인스턴스를 생성 후 ordinal 인스턴스 변수 값을 생성자를 통해 저장하는 과정
	public static final Day2 MON = new Day2(2);
	public static final Day2 TUE = new Day2(3);
	public static final Day2 WED = new Day2(4);
	public static final Day2 THU = new Day2(5);
	public static final Day2 FRI = new Day2(6);
	public static final Day2 SAT = new Day2(7);
	
	private static final Day2[] values = {SUN, MON, TUE, WED, THU, FRI, SAT};
	private final int ordinal;
	
	private Day2(int ordinal) {
		this.ordinal = ordinal;
		
	}
	
	public static Day2 valueOf(int ordinal) { /// 리턴타입에 클래스 이름이 오는 이유 → 인스턴스를 반환할 때 사용
		return values[ordinal-1]; 
		//배열은 0부터 시작이기에 -1을 해주는 것
	}
	
	public int getOrdinal() {
		return ordinal;
	}
}

class Month2 {
	public static final Month2 JAN = new Month2(1);
	public static final Month2 FEB = new Month2(2);
	public static final Month2 MAR = new Month2(3);
	public static final Month2 APR = new Month2(4);
	public static final Month2 MAY = new Month2(5);
	public static final Month2 JUN = new Month2(6);
	public static final Month2 JUL = new Month2(7);
	public static final Month2 AUG = new Month2(8);
	public static final Month2 SEP = new Month2(9);
	public static final Month2 OCT = new Month2(10);
	public static final Month2 NOV = new Month2(11);
	public static final Month2 DEC = new Month2(12);
	
	private static final Month2[] values = {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
	private final int ordinal;
	
	private Month2(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public static Month2 valueOf(int ordinal) {
		return values[ordinal-1];
	}
	
	public int getOrdinal() {
		return ordinal;
	}
	
	public Month2 plus(int n) {
		int ordinal = this.ordinal + n;
		int tmp = ordinal % 12; // 12로 나눈 나머지
		ordinal = tmp <= 0 ? ordinal : tmp; //(* ch03 Ex07)
											 
		
		return values[ordinal-1];
	}
}
// ★ eume 생성 방법 enum은 '상수'들의 집합을 만들어주는 기능이다 ★
enum Day3 { 
	SUN, MON, TUE, WED, THU, FRI, SAT;
	// ★ enum을 통해 인스턴스 생성 (상수 처럼 사용 가능) 이넘 멤버라고 부른다.★
}

enum Month3 {
	JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;

}
