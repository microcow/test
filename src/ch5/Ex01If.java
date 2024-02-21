package ch5;

public class Ex01If {
	public static void main(String[] args) { 
		int level = 9;
		String name = "익명";
		
		if (level > 9) {
			name = "관리자";
			System.out.println("Hello");
		}
		//위와 같이 if ()를 통해 조건설정 후 if문 설정 내용이 2개 이상일 경우 {}로 묶어주어야함
		//if () 안에 조건이 아닌 true나 false를 직접 적어도 동작함 예) if (false) {
		System.out.printf("회원님의 레벨은 %d이며 %s입니다.%n", level, name);
		
		
		level = 5;
		if (level >= 5)
			name = "일반회원";
		//위와 같이 설정 내용이 하나뿐일 경우 {}로 감싸지 않아도됨
		
		System.out.printf("회원님의 레벨은 %d이며 %s입니다.%n", level, name);
	}
}
