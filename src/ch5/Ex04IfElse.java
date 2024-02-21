package ch5;

public class Ex04IfElse {
	public static void main(String[] args) {
		int level = 8;
		int point = 600; 
		String name = "익명";		
		
		if (level >= 9) {
			name = "관리자";
			if (point > 500) {
				name = "슈퍼" + name;
			}
		} else if (level >= 8) {
			name = "중간관리자";
			if (point > 400) {
				name = "슈퍼" + name;
			//else if문에도 중첩if문 사용가능
			}
		} else if (level >= 7) {
			name = "우수회원";
		} else if (level >= 6) {
			name = "일반회원";
		} else if (level == -1) {
			name = "탈퇴한회원";
		} else {
			name = "방문자";
		}
		
		System.out.printf("회원님의 레벨은 %d이며 %s 입니다.%n", level, name);
	}
}
