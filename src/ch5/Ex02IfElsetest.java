package ch5;

public class Ex02IfElsetest {
	public static void main(String[] args) {
		int lv = 4;
		String mem = "회원님 안녕하세요.";
		if (lv > 3)
			mem = "정회원님 안녕하세요.";
		
		System.out.printf("회원님의 레벨은 %d입니다.%n%s%n", lv, mem);
	}
}
/*
문제 1.
사용자에게 입력 받은 레벨이 3 보다 크다면 "정회원님 안녕하세요."를 출력하고
3보다 작다면 "회원님 안녕하세요."를 출력하는 코드를 작성하세요. 
*/