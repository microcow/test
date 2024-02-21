package ch5;

public class Ex05Switchtest {
	public static void main(String[] args) {
		int mon = 111;
		String name = "계절";
		
		switch (mon) {
			case 3:
			case 4:
			case 5:
				name = "봄";
				break;
			case 6:
			case 7:
			case 8:
				name = "여름";
				break;
			case 9:
			case 10:
			case 11:
				name = "가을";
				break;
			case 12:
			case 1:
			case 2:
				name = "겨울";
				break;
			default:
				name = "잘 못 입력하였습니다.";
//case (mon < 1 || mon > 2): ☞오류 switch 타입은 elseif타입과 달리 boolean타입 사용 불가(참 거짓)
			

		}
		if (mon < 1 || mon > 12)
			System.out.printf("잘 못 입력하였습니다.%n");			
		else System.out.printf("현재 %d월이며, 계절은 %s입니다.", mon, name);
	}

}
/*
문제 1.
입력 받은 숫자가 3~5이면 "봄", 6~8이면 "여름", 9~11이면 "가을" 12,1,2 를 입력하면 "겨울"을 출력하고 
그 외의 숫자를 입력하면 "잘 못 입력하였습니다"를 출력하는 코드를 switch문으로 작성하세요. 
*/