package ch5;

public class Ex02IfElse {
	public static void main(String[] args) {
		int level = 3;
		String name = "익명";
		
		if (level >= 9) {
			name = "관리자";
		} else {
			name = "방문자";
		}
		//if문이 참일 경우 if문의 내용(관리자)가 출력되고, 거짓일 경우 else문의 내용(방문자)이 출력된다
		//if문과 else문이 여러 줄일 경우 {}로 구분지어야함
		
		System.out.printf("회원님의 레벨은 %d이며 %s입니다.%n", level, name);
		
		if (level >= 9)
			name = "관리자";
		else
			name = "방문자";
		//위와 같이 if문과 else문의 내용이 하나뿐일 경우 {}로 감싸지 않아도됨
		
		System.out.printf("회원님의 레벨은 %d이며 %s입니다.%n", level, name);
	}
}
