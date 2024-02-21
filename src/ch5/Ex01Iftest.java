package ch5;

public class Ex01Iftest {
	public static void main(String[] args) {
		String mem = "회원님 안녕하세요";
		int LV = 6;
		if (LV > 5) {
			mem = "VIP회원님 안녕하세요";
			}
		System.out.printf("회원님의 레벨은%d입니다. %s.", LV,mem);
				
	}

}
/*
문제 1.
로그인한 회원의 레벨이 5 이상이면 "VIP회원님 안녕하세요"를 출력하는 코드를 작성하세요. 
*/