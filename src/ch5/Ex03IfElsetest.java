package ch5;

public class Ex03IfElsetest {
	public static void main(String[] args) {
		int num = 0;
		String name = "계절";
		if (num == 3) name = "봄";
				else if (num == 4) name = "봄";
				else if (num == 5) name = "봄";
				else if (num >= 6 && num <= 8) name = "여름";
				else if (num == 9) name = "가을";
				else if (num == 10) name = "가을";
				else if (num == 11) name = "가을";
				else if (num == 12) name = "겨울";
				else if (num == 1) name = "겨울";
				else if (num == 2) name = "겨울";
				else if (num > 12) name = "잘 못 입력하였습니다.";
				else if (num < 1) name = "잘 못 입력하였습니다.";
		// 범위를 묶는 방법 (6~8일 경우 여름) == &을 사용하면 된다
		
		if (num < 1) System.out.printf(name);
		 else if (num > 12) System.out.printf(name);
		 else System.out.printf("현재 %d월이며,계절은 %s입니다.%n", num, name);
	}
}
/*
문제 1.
입력 받은 숫자가 3~5이면 "봄", 6~8이면 "여름", 9~11이면 "가을" 12,1,2 를 입력하면 "겨울"을 출력하고 
그 외의 숫자를 입력하면 "잘 못 입력하였습니다"를 출력하는 코드를 작성하세요.  
*/