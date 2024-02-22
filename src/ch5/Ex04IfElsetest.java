package ch5;

public class Ex04IfElsetest {
	public static void main(String[] args) {
		
		
		int mon = 111;
		String name = "계절";
		
		if (mon == 3) name = "봄";
		else if (mon == 4) name = "봄";
		else if (mon == 5) name = "봄";
		else if (mon >= 6 && mon <= 8) { 
			name = "여름";
			if (mon == 8) 
				name = "휴가철";
		}
		// elseif문의 if문이 추가되었음으로 {}로 묶어야함
		else if (mon == 9) name = "가을";
		else if (mon == 10) name = "가을";
		else if (mon == 11) name = "가을";
		else if (mon == 12) name = "겨울";
		else if (mon == 1) name = "겨울";
		else if (mon == 2) name = "겨울";
		else if (mon > 12 || mon < 1) name = "잘 못 입력하였습니다.";
		// ||와 && 구분해서 사용
			
		if (mon > 12 || mon < 1) System.out.printf(name);
			else System.out.printf("현재 %d월이며, %s입니다.", mon, name);
	}

}
/*
문제 1.
사용자가 입력한 숫자에 맞는 계절을 출력하되 8월을 입력하면 "휴가철"도 같이 출력되게 작성하세요.
힌트) 중첩 if문을 사용하세요.  
*/