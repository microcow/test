package Ch3;

public class Ex07ConditionalOperatorstest {
	public static void main(String[] args) {
		int pri = 0;
		String A = pri == 0 ? "0" : "양수";
		System.out.printf("입력 받은 값 = %d = %s%n", pri , pri >= 0 ? A : "음수");
	}
}
/*
문제 1.
삼항연산자를 사용하여 사용자로 부터 입력 받은 값이 음수인지 양수인지 0인지를 출력하는 코드를 작성하세요. 
*/ 